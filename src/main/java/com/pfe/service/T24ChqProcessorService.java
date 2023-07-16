package com.pfe.service;


import java.util.List;
import java.util.UUID;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pfe.common.T24Cheque;
import com.pfe.common.TransactionResponse;
import com.pfe.model.T24ChequeProcessor;

import com.pfe.repository.T24ChqProcessorRepo;
import com.pfe.serviceInterface.T24ChequeInterface;
import com.pfe.serviceInterface.T24ChqProcessorSInterface;

@Service
public class T24ChqProcessorService implements T24ChqProcessorSInterface {
	
	@Autowired
	private T24ChqProcessorRepo processorRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private T24ChequeInterface T24ChqueServiceI;
	
	
	
	
	
	@Override
	@Transactional
	public TransactionResponse ProcessingCheque(T24ChequeProcessor processor, String id) {
	    String response = "";
	    String URL = "http://t24-data-retrieval-service:8085/api/cheques/add";
	    T24Cheque cheque = retrieveOneChqFromDb1(id);
	    
	    if (cheque.getStatut() == 1) {
	        processor.setProcessStatus("UP");
	        processor.setTransactionId(UUID.randomUUID().toString());
	        processor.setId(id);
	        cheque.setStatut(2);

	     
	           
	   
	        

	        // Save the cheque
	        T24Cheque chequeResponse = restTemplate.postForObject(URL,cheque,T24Cheque.class);

	        response = processor.getProcessStatus().equals("UP") ? "Check Processing Active" : "Check Processing Blocked";
	        
	        // Get keys from visDeForme
            List<Integer> visDeFormeKeys = processor.getVisDeForme();
            List<Integer> inexploitableKeys = processor.getInexploitable();

            // Set these keys to the cheque
            cheque.setVisDeForme(visDeFormeKeys);
            cheque.setInexploitable(inexploitableKeys);
	        
	        processorRepo.save(processor);
	        T24ChqueServiceI.saveone(cheque);
	        
	        return new TransactionResponse(chequeResponse, processor.getTransactionId(), response);    
	    }
	    
	    return new TransactionResponse();    
	}


	
	@Override
	public T24Cheque retrieveOneChqFromDb1(String id) {
//		String URL = "http://t24-data-retrieval-service:8080/api/cheques/findone/" + id;
//		On kubeCluster
		String URL = "http://t24-data-retrieval-service:8085/api/cheques/findone/"+id;
		T24Cheque t24ChequeResponse = restTemplate.getForObject(URL,T24Cheque.class);
		
		return t24ChequeResponse;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	



}

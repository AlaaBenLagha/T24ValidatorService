package com.pfe.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pfe.common.T24Cheque;
import com.pfe.common.TransactionResponse;
import com.pfe.model.T24ChequeProcessor;
import com.pfe.serviceInterface.T24ChequeInterface;
import com.pfe.serviceInterface.T24ChqProcessorSInterface;

@RestController
@RequestMapping("/api/process")
@CrossOrigin(origins = "*")
public class T24ChqProcessorController {
	
	
	@Autowired
	private T24ChqProcessorSInterface processingService;
	
	
	@Autowired
	private T24ChequeInterface t24chequeservice;
	
	
	
	
	@GetMapping("/getonechk/{id}")
	public T24Cheque retrieveOneChqFromDb(@PathVariable String id) {
		return t24chequeservice.getOne(id);
		
	}
	
	
	
	@GetMapping("/getone/{id}")
	public T24Cheque retrieveOneChqFromS1Db(@PathVariable String id) {
		return processingService.retrieveOneChqFromDb1(id);
		
	}
	
	
	
	
	
	
	@PostMapping("/doProcess/{id}")
	public TransactionResponse ProcessingCheque(@RequestBody T24ChequeProcessor processor,@PathVariable String id) {
		return processingService.ProcessingCheque(processor, id);
		
	}
	
	

	
	
	
	
	
	
	

}

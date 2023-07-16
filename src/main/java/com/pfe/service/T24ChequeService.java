package com.pfe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.common.T24Cheque;
import com.pfe.repository.T24ChequeRepo;
import com.pfe.serviceInterface.T24ChequeInterface;


@Service
public class T24ChequeService implements T24ChequeInterface{
	
	
	@Autowired
	private T24ChequeRepo t24ChequeRepository;
	
	
	
	public T24Cheque saveone(T24Cheque cheque) {
		return t24ChequeRepository.save(cheque);
	}
	
	public T24Cheque getOne(String id) {
		return t24ChequeRepository.findById(id).orElse(null);
	}


}

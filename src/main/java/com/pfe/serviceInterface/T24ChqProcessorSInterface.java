package com.pfe.serviceInterface;

import com.pfe.common.T24Cheque;
import com.pfe.common.TransactionResponse;
import com.pfe.model.T24ChequeProcessor;

public interface T24ChqProcessorSInterface {
	
	public TransactionResponse ProcessingCheque(T24ChequeProcessor processor, String id);
	public T24Cheque retrieveOneChqFromDb1(String id);
	


}

package com.pfe.common;



import com.pfe.model.T24ChequeProcessor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionRequest {
	
	
	private T24Cheque cheque;
	private T24ChequeProcessor processor;

}

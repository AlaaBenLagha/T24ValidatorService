package com.pfe.common;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {
	
	
	private T24Cheque cheque;
	private String transactionId;
	private String message;
	

}
 
package com.pfe.common;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChequeProcessorRequest {
	
	
	private String processorId;
    private String updatedChequeId;

}

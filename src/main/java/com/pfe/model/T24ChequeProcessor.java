package com.pfe.model;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name ="T24CHKPROCESSOR")
public class T24ChequeProcessor {
	
	@Id
	@GeneratedValue
	private int processId;
	private String processStatus;
	private String transactionId;
	
	@Column(name="visDeForme")
    private String visDeFormeString;

    @Column(name="inexploitable")
    private String inexploitableString;

    @Transient
    private List<Integer> visDeForme;

    @Transient
    private List<Integer> inexploitable;
		
	private String id;

	 
	    

	    
	    public void setVisDeForme(List<Integer> visDeForme) {
	        this.visDeForme = visDeForme;
	        this.visDeFormeString = visDeForme.stream()
	                .map(Object::toString)
	                .collect(Collectors.joining(","));
	    }

	    public List<Integer> getVisDeForme() {
	        if (visDeForme == null && visDeFormeString != null) {
	            visDeForme = Arrays.stream(visDeFormeString.split(","))
	                    .map(Integer::parseInt)
	                    .collect(Collectors.toList());
	        }
	        return visDeForme;
	    }
	    
	    
	    public void setInexploitable(List<Integer> inexploitable) {
	        this.inexploitable = inexploitable;
	        this.inexploitableString = inexploitable.stream()
	                .map(Object::toString)
	                .collect(Collectors.joining(","));
	    }

	    public List<Integer> getInexploitable() {
	        if (inexploitable == null && inexploitableString != null) {
	        	inexploitable = Arrays.stream(inexploitableString.split(","))
	                    .map(Integer::parseInt)
	                    .collect(Collectors.toList());
	        }
	        return inexploitable;
	    }
	    
	    
	    
	    
	    

		
	    
	    
	    
	    
	    

	
}

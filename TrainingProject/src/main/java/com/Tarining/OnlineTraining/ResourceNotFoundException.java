package com.Tarining.OnlineTraining;

import lombok.Data;

@Data
public class ResourceNotFoundException  extends RuntimeException{

	private String eror;
	private String message;
	
	
	private static final long serialVersionUID = 1L;
	
	

}

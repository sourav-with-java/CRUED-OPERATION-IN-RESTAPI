package com.Tarining.utills;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class MyResponseHandler {
	


	private static  HashMap<String, Object>map;

	public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus,boolean isError,String msg, Object responseBody) {
		{
			
			HashMap<String, Object> hashMap=new HashMap<String, Object>();
			try {
				hashMap.put("status", httpStatus);
				hashMap.put("isSuccess",isError);
				hashMap.put("message",msg);
				hashMap.put("data",responseBody);
				return new ResponseEntity<Object>(map,httpStatus);
				
			} catch (Exception e) {
				
				hashMap.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
				hashMap.put("isSuccess",false);
				hashMap.put("message",e.getMessage());
				hashMap.put("data",null);
				return new ResponseEntity<Object>(map,httpStatus);
				
			}
			
		}
		
}
	}
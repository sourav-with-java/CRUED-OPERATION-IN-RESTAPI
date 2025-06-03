package com.Tarining.OnlineTraining;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tarining.utills.MyResponseHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/javatrainig")
public class JavaTrainingController {
	
	
	JavaTrainingService Service;
	private MultiValueMap<String, String> registerTrainee;
	private Object updatTraining;
	
	JavaTrainingController(JavaTrainingService service)
	{
		this.Service=service;	
	}
	
	
	@PostMapping(value="/register")
	public ResponseEntity<Object> registerJavaTraining( @Valid @RequestBody JavaTrainingDto dto )
	{
		
			
		
		JavaTrainingDto rergisterTraine =Service.registerTrainee(dto);
		if(registerTrainee!=null)
		{
		ResponseEntity<Object> responseEntity=MyResponseHandler.generateResponse(HttpStatus.OK, true, "Java Trainee Register", rergisterTraine);	
		 return responseEntity ;	
		}
		else
		{
			ResponseEntity<Object> responseEntity=MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Something Went Wrong",rergisterTraine);	
			 return responseEntity ;	
		}	
	}
	
	@PostMapping(value="/registerall")
	public ResponseEntity<List<JavaTrainingDto>> registerAllJavaTraining(@RequestBody List<JavaTrainingDto> dto)
	{
	List<JavaTrainingDto> registerAllTrainee=	Service.registerAllTrainee(dto);
	ResponseEntity<List<JavaTrainingDto>> responseEntity = ResponseEntity
			.status(HttpStatus.OK)
			.body(registerAllTrainee);
	
      return responseEntity;
	}
	
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<Object> updateJavaTraining(@RequestBody JavaTrainingDto dto,@PathVariable String id)
	{
		JavaTrainingDto  updateTraining = Service.updateTraining(dto, id);
		return ResponseEntity.ok(updatTraining);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteJavaTraining(@PathVariable String id)
	{
	String deleteTrainee=	Service.deleteTraining(id);
		return deleteTrainee;	
	}
	
	
	
	@GetMapping(value="/findjavatraining/{id}")
	public JavaTrainingDto findJavaTraining(@PathVariable String id)
	{
		
	JavaTrainingDto ByJavaTraining=	Service.findByIdJavaTraining(id);
		return  ByJavaTraining;
		
	}
	
	@GetMapping(value="/findalljavatraining")
	public ResponseEntity<List<JavaTrainingDto>> findAllJavaTraing()
	{
	List<JavaTrainingDto> allTraine =Service.findAllJavaTraing();
		return ResponseEntity.ok(allTraine);
	}
   
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> exceptionhandle()
	{
	return	MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Id Not Found", null);
		
	}
	
	
}

package com.Tarining.OnlineTraining;

import java.util.List;

public interface JavaTrainingService {
	
	public JavaTrainingDto registerTrainee(JavaTrainingDto dto);
	
	public List<JavaTrainingDto>  registerAllTrainee(List<JavaTrainingDto> list);
	
	public List<JavaTrainingDto> findAllJavaTraing();
	
	public JavaTrainingDto findByIdJavaTraining(String id);
	
	public JavaTrainingDto updateTraining(JavaTrainingDto dto,String id );
	
	public String deleteTraining (String id);
	
	
	
	
	
	

}

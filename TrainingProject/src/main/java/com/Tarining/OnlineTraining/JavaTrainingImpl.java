package com.Tarining.OnlineTraining;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JavaTrainingImpl implements JavaTrainingService {

	
	 private JavaTrainingRepoitory javaTrainingRepoitory;
	 private ObjectMapper mapper;
	
	
	JavaTrainingImpl(JavaTrainingRepoitory javaTrainingRepoitory,ObjectMapper mapper)
	{
		
		this.javaTrainingRepoitory=javaTrainingRepoitory;
		this.mapper=mapper;
	}
	

	@Override
	public JavaTrainingDto registerTrainee(JavaTrainingDto dto) {
		
		JavaTrainingEntity convertValue	= mapper.convertValue(dto, JavaTrainingEntity.class);
	    JavaTrainingEntity javaTrainingEntity = javaTrainingRepoitory.save(convertValue);
        JavaTrainingDto javaTrainingDto	=mapper.convertValue(javaTrainingEntity,JavaTrainingDto.class );
		return javaTrainingDto;
		
	}

	@Override
	public List<JavaTrainingDto> registerAllTrainee(List<JavaTrainingDto> list) {
		
		
	List<JavaTrainingEntity >javaTrainingEntities =  Arrays.asList(mapper.convertValue(list, JavaTrainingEntity[].class));
	List<JavaTrainingEntity> saveAll = javaTrainingRepoitory.saveAll(javaTrainingEntities);
	List<JavaTrainingDto >javaTrainingDto =  Arrays.asList(mapper.convertValue(saveAll, JavaTrainingDto[].class));
		return javaTrainingDto;
		
	}

	@Override
	public List<JavaTrainingDto> findAllJavaTraing() {
		
		List<JavaTrainingEntity> all = javaTrainingRepoitory.findAll();
		List<JavaTrainingDto >javaTrainingEntities =  Arrays.asList(mapper.convertValue(all, JavaTrainingDto[].class));
		
		
		return javaTrainingEntities;
	}

	@Override
	public JavaTrainingDto findByIdJavaTraining(String id) {
		
	JavaTrainingEntity entity = javaTrainingRepoitory.findById(id).orElseThrow(ResourceNotFoundException::new);
	 JavaTrainingDto tainingDto = mapper.convertValue(entity, JavaTrainingDto.class);
		return tainingDto;
	}

	@Override
	public JavaTrainingDto updateTraining(JavaTrainingDto dto, String id) {
		
	Optional<JavaTrainingEntity> eOptional = javaTrainingRepoitory.findById(id);
     System.out.println("Trainee Info=="+eOptional);
	
		
		JavaTrainingEntity convertValue	= mapper.convertValue(dto, JavaTrainingEntity.class);
		
		convertValue.setId(id);
		
	    JavaTrainingEntity javaTrainingEntity	=javaTrainingRepoitory.save(convertValue);
	    JavaTrainingDto javaTrainingDto=mapper.convertValue(javaTrainingEntity, JavaTrainingDto.class);
		return javaTrainingDto;	
	}

	
	@Override
	public String deleteTraining(String id) {
		javaTrainingRepoitory.deleteById(id);
		return "Trainee Deleted";
	}
	
}

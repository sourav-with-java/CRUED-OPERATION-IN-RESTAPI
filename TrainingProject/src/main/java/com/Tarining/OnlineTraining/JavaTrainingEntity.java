package com.Tarining.OnlineTraining;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="golu")
public class JavaTrainingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@JsonIgnore
	private String id;
	
	private String name,email,mobile;
	
	
	private int fees;
}

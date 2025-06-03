package com.Tarining.OnlineTraining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaTrainingRepoitory extends JpaRepository<JavaTrainingEntity, String> {

}

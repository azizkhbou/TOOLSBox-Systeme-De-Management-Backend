package com.altran.TOOLSBox_Systeme_De_Management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altran.TOOLSBox_Systeme_De_Management.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Integer>{
	Page<Training> findAll(Pageable pageable);

}

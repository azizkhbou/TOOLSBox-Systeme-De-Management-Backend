package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.altran.TOOLSBox_Systeme_De_Management.model.Training;

public interface TrainingService {

	boolean addTraining(Training training);

	boolean updateTraining(Training training);

	boolean deleteTraining(int idTraining);

	boolean validateTraining(String validation, int id);
	
	Training getTrainingById(int idTraining);

	Page<Training> getTrainingsByPage(Pageable pageable);

	List<Training> getAllTrainings();

}

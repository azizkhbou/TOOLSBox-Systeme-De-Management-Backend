package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.altran.TOOLSBox_Systeme_De_Management.model.Training;

public interface TrainingService {

	List<Training> getAllTrainings();

	Page<Training> getTrainingsByPage(Pageable pageable);

	Training getTrainingById(int idTraining);

	boolean addTraining(Training training);

	boolean updateTraining(int id, Training training);

}

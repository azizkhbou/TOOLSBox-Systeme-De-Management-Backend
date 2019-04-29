package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;
import com.altran.TOOLSBox_Systeme_De_Management.model.Training;
import com.altran.TOOLSBox_Systeme_De_Management.repository.TrainingRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.TrainingService;

@Service
public class TrainingServiceImp implements TrainingService {

	private TrainingRepository trainingRepository;

	private ParticipantServiceImp participantServiceImp;

	@Autowired
	public void setParticipantServiceImp(ParticipantServiceImp participantServiceImp) {
		this.participantServiceImp = participantServiceImp;
	}

	@Autowired
	public void setTrainingRepository(TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	@Override
	public boolean addTraining(Training training) {

		try {

			Set<Participant> participants = training.getParticipants();
			training.setParticipants(null);
			Training training1 = trainingRepository.save(training);
			participants.forEach((participant) -> {
				participant.setTraining(training1);
				participantServiceImp.addParticipant(participant);
			});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTraining(Training training) {
		try {

			trainingRepository.save(training);

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean deleteTraining(int idTraining) {
		try {
			trainingRepository.deleteById(idTraining);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public Training getTrainingById(int idTraining) {
		return trainingRepository.findById(idTraining).orElse(null);

	}

	@Override
	public List<Training> getAllTrainings() {
		return trainingRepository.findAll();
	}

	@Override
	public Page<Training> getTrainingsByPage(Pageable pageable) {
		return trainingRepository.findAll(pageable);
	}

	@Override
	public boolean validateTraining(String validation, int id) {
		try {
			Training training = getTrainingById(id);

			training.setValidationActivityManager(validation);

			trainingRepository.save(training);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

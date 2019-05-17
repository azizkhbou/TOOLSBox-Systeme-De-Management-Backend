package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Organism;
import com.altran.TOOLSBox_Systeme_De_Management.model.Training;
import com.altran.TOOLSBox_Systeme_De_Management.repository.TrainingRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.TrainingService;

@Service
public class TrainingServiceImp implements TrainingService {

	private TrainingRepository trainingRepository;

	private OrganismServiceImp organismServiceImp;

	@Autowired
	public void setOrganismServiceImp(OrganismServiceImp organismServiceImp) {
		this.organismServiceImp = organismServiceImp;
	}

	@Autowired
	public void setTrainingRepository(TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
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
	public Training getTrainingById(int idTraining) {
		return trainingRepository.findById(idTraining).orElse(null);

	}

	@Override
	public boolean addTraining(Training training) {

		try {

			/*Set<Organism> organisms = training.getOrganisms();
			training.setOrganisms(null);
			Training training1 = trainingRepository.save(training);
			organisms.forEach((organism) -> {
				organism.setTraining(training1);
				organismServiceImp.addOrganism(organism);
			});*/
			trainingRepository.save(training);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateTraining(int id,  Training training) {
		try {
			training.setId(id);
			trainingRepository.save(training);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

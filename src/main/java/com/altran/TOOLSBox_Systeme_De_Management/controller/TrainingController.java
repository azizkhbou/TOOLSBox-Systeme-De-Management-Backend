package com.altran.TOOLSBox_Systeme_De_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Training;
import com.altran.TOOLSBox_Systeme_De_Management.service.TrainingService;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.TrainingServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/training")

public class TrainingController {
	private TrainingService trainingService;

	@Autowired
	public void setTrainingServiceImp(TrainingServiceImp trainingServiceImp) {
		this.trainingService = trainingServiceImp;
	}
	
    @PostMapping(value = "/create")
	public boolean addTraining(@RequestBody Training training) {

		return trainingService.addTraining(training);

	}

	@PutMapping(value = "/update")
	public boolean updateTraining(@RequestBody Training training) {

		return trainingService.updateTraining(training);

	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteTraining(@PathVariable int id) {

		return trainingService.deleteTraining(id);

	}
	
    @GetMapping(value = "/all")
	public MappingJacksonValue getAllTrainings() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.TRAINING_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.IDTRAINING));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.IDPARTICIPANT, Constants.TRAINING));
		MappingJacksonValue trainingsMapping = new MappingJacksonValue(trainingService.getAllTrainings());
		trainingsMapping.setFilters(filterProvider);
		return trainingsMapping;

	}

	@GetMapping(value = "/all/{page}")
	public MappingJacksonValue getTrainingsByPage(@PathVariable int page) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.TRAINING_FILTER, SimpleBeanPropertyFilter
				.serializeAllExcept(Constants.CATEGORY, Constants.PARTICIPANTS, Constants.OBJECTIF));

		Pageable p = PageRequest.of(page, 6, Sort.by("idTraining").ascending().and(Sort.by("object")));
		MappingJacksonValue trainingsMapping = new MappingJacksonValue(trainingService.getTrainingsByPage(p));
		trainingsMapping.setFilters(filterProvider);
		return trainingsMapping;
	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getTrainingById(@PathVariable int id) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.TRAINING_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.IDTRAINING));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.IDPARTICIPANT, Constants.TRAINING));
		MappingJacksonValue trainingMapping = new MappingJacksonValue(trainingService.getTrainingById(id));
		trainingMapping.setFilters(filterProvider);
		return trainingMapping;
	}

	@GetMapping(value = "/validate/{id}/{validation}")
	public boolean validateTraining(@PathVariable int id,
			@PathVariable String validation) {
		return trainingService.validateTraining(validation, id);
	}

}

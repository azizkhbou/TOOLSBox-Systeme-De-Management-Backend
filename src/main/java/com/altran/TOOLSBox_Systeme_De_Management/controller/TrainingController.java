package com.altran.TOOLSBox_Systeme_De_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Training;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.TrainingServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/training")

public class TrainingController {

	private TrainingServiceImp trainingService;

	@GetMapping(value = "/all")
	public MappingJacksonValue getAllTrainings() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.TRAINING_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.OBJECTIF,
				Constants.CATEGORY, Constants.VALIDATION, Constants.TRAINING));
		filterProvider.addFilter(Constants.ORGANISM_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.TRAINER,Constants.TRAINING));
		filterProvider.addFilter(Constants.TRAINER_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ORGANISM));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.NEED));
		MappingJacksonValue trainingsMapping = new MappingJacksonValue(trainingService.getAllTrainings());
		trainingsMapping.setFilters(filterProvider);
		return trainingsMapping;
	}

	@GetMapping(value = "/all/{page}")
	public MappingJacksonValue getTrainingsByPage(@PathVariable int page) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();

		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.OBJECTIF,
				Constants.CATEGORY, Constants.VALIDATION, Constants.TRAINING));
		filterProvider.addFilter(Constants.ORGANISM_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.TRAINER));
		Pageable p = PageRequest.of(page, 6, Sort.by("id").ascending().and(Sort.by("activity")));

		MappingJacksonValue trainingsMapping = new MappingJacksonValue(trainingService.getTrainingsByPage(p));
		trainingsMapping.setFilters(filterProvider);
		return trainingsMapping;
	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getTrainingById(@PathVariable int id) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
          
		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.OBJECTIF,
				Constants.CATEGORY, Constants.VALIDATION, Constants.TRAINING));
		filterProvider.addFilter(Constants.ORGANISM_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.TRAINER));

		MappingJacksonValue trainingMapping = new MappingJacksonValue(trainingService.getTrainingById(id));
		trainingMapping.setFilters(filterProvider);
		return trainingMapping;
	}

	@Autowired
	public void setTrainingServiceImp(TrainingServiceImp trainingServiceImp) {
		this.trainingService = trainingServiceImp;
	}

	@PostMapping(value = "/create")
	public boolean addTraining(@RequestBody Training training) {

		return trainingService.addTraining(training);

	}

	@PutMapping(value = "/update/{id}")
	public boolean updateTraining(@PathVariable int id, @RequestBody Training training) {

		return trainingService.updateTraining(id, training);

	}

}

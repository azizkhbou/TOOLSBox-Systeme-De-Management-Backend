package com.altran.TOOLSBox_Systeme_De_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;
import com.altran.TOOLSBox_Systeme_De_Management.service.ParticipantService;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.ParticipantServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/participant")
public class ParticipantController {

	private ParticipantService participantService;

	@Autowired
	public void setParticipantServiceImp(ParticipantServiceImp participantServiceImp) {
		this.participantService = participantServiceImp;
	}

	@PostMapping(value = "/create")
	public MappingJacksonValue addParticipant(@RequestBody Participant participant) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));
		MappingJacksonValue participantMapping = new MappingJacksonValue(participantService.addParticipant(participant));
		participantMapping.setFilters(filterProvider);
		return participantMapping;

	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteParticipant(@PathVariable int id) {

		return participantService.deleteParticipant(id);

	}

	@GetMapping(value = "/all")
	public MappingJacksonValue getAllParticipants() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.NEED_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));

		MappingJacksonValue participantsMapping = new MappingJacksonValue(participantService.getAllParticipants());
		participantsMapping.setFilters(filterProvider);
		return participantsMapping;
	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getParticipantById(@PathVariable int id) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));
		MappingJacksonValue participantMapping = new MappingJacksonValue(participantService.getParticipantById(id));
		participantMapping.setFilters(filterProvider);
		return participantMapping;
	}

}

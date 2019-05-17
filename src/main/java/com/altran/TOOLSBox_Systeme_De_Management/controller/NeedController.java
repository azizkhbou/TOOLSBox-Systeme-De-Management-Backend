package com.altran.TOOLSBox_Systeme_De_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Need;
import com.altran.TOOLSBox_Systeme_De_Management.service.NeedService;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.NeedServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/need")

public class NeedController {
	private NeedService needService;

	@Autowired
	public void setNeedServiceImp(NeedServiceImp needServiceImp) {
		this.needService = needServiceImp;
	}

	@PostMapping(value = "/create")
	public boolean addNeed(@RequestBody Need need) {

		return needService.addNeed(need);

	}

	@PutMapping(value = "/update/{id}")
	public boolean updateNeed(@PathVariable int id, @RequestBody Need need) {

		return needService.updateNeed(id, need);

	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteNeed(@PathVariable int id) {
		return needService.deleteNeed(id);
	}

	@GetMapping(value = "/all")
	public MappingJacksonValue getAllNeeds() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.TRAINING));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));
		MappingJacksonValue needsMapping = new MappingJacksonValue(needService.getAllNeeds());
		needsMapping.setFilters(filterProvider);
		return needsMapping;

	}

	@GetMapping(value = "/all/{page}")
	public MappingJacksonValue getNeedsByPage(@PathVariable int page) {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.CATEGORY,
				Constants.PARTICIPANTS, Constants.OBJECTIF));

		Pageable p = PageRequest.of(page, 6, Sort.by("id").ascending().and(Sort.by("object")));
		MappingJacksonValue needsMapping = new MappingJacksonValue(needService.getNeedsByPage(p));
		needsMapping.setFilters(filterProvider);
		return needsMapping;
	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getNeedById(@PathVariable int id) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter(Constants.NEED_FILTER, SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID));
		filterProvider.addFilter(Constants.PARTICIPANT_FILTER,
				SimpleBeanPropertyFilter.serializeAllExcept(Constants.ID, Constants.NEED));
		MappingJacksonValue needMapping = new MappingJacksonValue(needService.getNeedById(id));
		needMapping.setFilters(filterProvider);
		return needMapping;
	}

	@GetMapping(value = "/validate/{id}/{validation}")
	public boolean validateNeed(@PathVariable int id, @PathVariable String validation) {
		return needService.validateNeed(validation, id);
	}

}

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

import com.altran.TOOLSBox_Systeme_De_Management.model.Organism;
import com.altran.TOOLSBox_Systeme_De_Management.service.OrganismService;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.OrganismServiceImp;
import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(value = "/organism")
public class OrganismController {

	private OrganismService organismService;

	@Autowired
	public void setOrganismServiceImp(OrganismServiceImp organismServiceImp) {
		this.organismService = organismServiceImp;
	}

	@GetMapping(value = "/all")
	public MappingJacksonValue getAllOrganisms() {

		SimpleFilterProvider filterProvider = new SimpleFilterProvider();

		filterProvider.addFilter(Constants.ORGANISM_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.TRAINING_FILTER, SimpleBeanPropertyFilter.serializeAllExcept("organism"));
		filterProvider.addFilter(Constants.TRAINER_FILTER, SimpleBeanPropertyFilter.serializeAllExcept("organism"));

		MappingJacksonValue organismsMapping = new MappingJacksonValue(organismService.getAllOrganisms());
		organismsMapping.setFilters(filterProvider);
		return organismsMapping;

	}

	@GetMapping(value = "/id/{id}")
	public MappingJacksonValue getOrganismById(@PathVariable int id) {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();

		filterProvider.addFilter(Constants.ORGANISM_FILTER, SimpleBeanPropertyFilter.serializeAllExcept());
		filterProvider.addFilter(Constants.TRAINING_FILTER, SimpleBeanPropertyFilter.serializeAllExcept("organism"));
		filterProvider.addFilter(Constants.TRAINER_FILTER, SimpleBeanPropertyFilter.serializeAllExcept("organism"));

		MappingJacksonValue organismsMapping = new MappingJacksonValue(organismService.getOrganismById(id));
		organismsMapping.setFilters(filterProvider);
		return organismsMapping;
	}

	@PostMapping(value = "/create")
	public boolean addOrganism(@RequestBody Organism organism) {

		return organismService.addOrganism(organism);
	}

	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteOrganism(@PathVariable int id) {

		return organismService.deleteOrganism(id);
	}

}

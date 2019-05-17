package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Organism;
import com.altran.TOOLSBox_Systeme_De_Management.repository.OrganismRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.OrganismService;

@Service
public class OrganismServiceImp implements OrganismService {

	private OrganismRepository organismRepository;

	@Autowired
	public void setOrganismRepository(OrganismRepository organismRepository) {
		this.organismRepository = organismRepository;
	}

	@Override
	public List<Organism> getAllOrganisms() {
		return organismRepository.findAll();
	}

	@Override
	public Organism getOrganismById(int id) {
		return organismRepository.findById(id).orElse(null);
	}

	@Override
	public boolean addOrganism(Organism organism) {
		try {
			organismRepository.save(organism);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateOrganism(int id, Organism organism) {
		try {
			organism.setId(id);
			organismRepository.save(organism);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteOrganism(int idOrganism) {
		try {
			organismRepository.deleteById(idOrganism);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

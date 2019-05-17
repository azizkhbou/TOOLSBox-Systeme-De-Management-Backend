package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Organism;

public interface OrganismService {

	List<Organism> getAllOrganisms();

	Organism getOrganismById(int id);

	boolean addOrganism(Organism organism);

	boolean updateOrganism(int id, Organism organism);

	boolean deleteOrganism(int idOrganism);

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.altran.TOOLSBox_Systeme_De_Management.model.Need;
import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;

public interface NeedService {

	List<Need> getAllNeeds();

	Page<Need> getNeedsByPage(Pageable pageable);

	Need getNeedById(int idNeed);


	boolean updateNeed(int id, Need need);

	boolean deleteNeed(int idNeed);

	boolean validateNeed(String validation, int id);

	boolean addNeed(Need need);

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;

public interface ParticipantService {

	
	boolean addParticipant(Participant participant);
	
	boolean deleteParticipant(int idParticipant);
	
	Participant getParticipantById(int id);
     
	List<Participant> getAllParticipants();

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;
import java.util.Set;

import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;

public interface ParticipantService {

	List<Participant> getAllParticipants();

	Participant getParticipantById(int id);

	Participant addParticipant(Participant participant);

	boolean deleteParticipant(int idParticipant);

	Set<Participant> create(Participant p);

}

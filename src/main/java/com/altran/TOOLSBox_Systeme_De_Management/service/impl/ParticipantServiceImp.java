package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;
import com.altran.TOOLSBox_Systeme_De_Management.repository.ParticipantRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.ParticipantService;

@Service
public class ParticipantServiceImp implements ParticipantService {

	private ParticipantRepository participantRepository;

	@Autowired
	public void setParticipantRepository(ParticipantRepository participantRepository) {
		this.participantRepository = participantRepository;
	}

	@Override
	public List<Participant> getAllParticipants() {
		return participantRepository.findAll();
	}

	@Override
	public Participant getParticipantById(int id) {
		return participantRepository.findById(id).orElse(null);
	}

	@Override
	public Participant addParticipant(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public boolean deleteParticipant(int idParticipant) {
		try {
			participantRepository.deleteById(idParticipant);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Set<Participant> create(Participant p) {

		participantRepository.save(p);
		return null;
	}

}

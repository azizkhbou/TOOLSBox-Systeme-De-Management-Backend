package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;

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
	public boolean addParticipant(Participant participant) {

		try {

			participantRepository.save(participant);

		} catch (Exception e) {
			return false;
		}
		return true;
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
	public Participant getParticipantById(int id) {
		return participantRepository.findById(id).orElse(null);
	}

	@Override
	public List<Participant> getAllParticipants() {
		return  participantRepository.findAll();
	}

}

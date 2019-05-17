package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Need;
import com.altran.TOOLSBox_Systeme_De_Management.model.Participant;
import com.altran.TOOLSBox_Systeme_De_Management.repository.NeedRepository;
import com.altran.TOOLSBox_Systeme_De_Management.repository.ParticipantRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.NeedService;
import com.altran.TOOLSBox_Systeme_De_Management.service.ParticipantService;

@Service
public class NeedServiceImp implements NeedService {

	private NeedRepository needRepository;

	private ParticipantRepository participantRepository;

	private ParticipantService participantService;

	public Participant getParticipantById(int id) {
		return participantRepository.findById(id).orElse(null);
	}

	@Autowired
	public void setNeedRepository(NeedRepository needRepository) {
		this.needRepository = needRepository;
	}

	@Autowired
	public void setNeedRepository(ParticipantService participantService) {
		this.participantService = participantService;
	}

	@Override
	public Need getNeedById(int idNeed) {
		return needRepository.findById(idNeed).orElse(null);

	}

	@Override
	public List<Need> getAllNeeds() {
		return needRepository.findAll();
	}

	@Override
	public Page<Need> getNeedsByPage(Pageable pageable) {
		return needRepository.findAll(pageable);
	}

	@Override
	public boolean addNeed(Need need) {
		Set<Participant> participantsfinal = new HashSet<Participant>();
		Participant createdParticipant;
		try {
			Set<Participant> participants = need.getParticipants();
			for (Participant participant : participants) {
				if (participant.getId() == 0) {
					createdParticipant = participantService.addParticipant(participant);
					participantsfinal.add(createdParticipant);
				} else {
					participantsfinal.add(participant);
				}
			}
			need.setParticipants(participantsfinal);
			needRepository.save(need);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	public boolean updateNeed(int id, Need need) {
		try {
			need.setId(id);
			needRepository.save(need);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteNeed(int idNeed) {
		try {
			needRepository.deleteById(idNeed);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean validateNeed(String validation, int id) {
		try {
			Need need = getNeedById(id);
			need.setValidation(validation);
			needRepository.save(need);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

package com.altran.TOOLSBox_Systeme_De_Management.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.annotation.JsonFilter;


@Entity
@Table(name = "PARTICIPANTS")
@JsonFilter(Constants.PARTICIPANT_FILTER)

public class Participant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParticipant;

	private String participantName;

	@ManyToOne
	@JoinColumn(name = "idTraining")
	private Training training;

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public int getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}

	public Participant(Training training, String participantName) {
		super();
		this.training = training;
		this.participantName = participantName;
	}

	public Participant() {
		super();
	}

}

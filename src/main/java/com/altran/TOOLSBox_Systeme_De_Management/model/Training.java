package com.altran.TOOLSBox_Systeme_De_Management.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "TRAININGS")
@JsonFilter(Constants.TRAINING_FILTER)
public class Training implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTraining;

	@Column(nullable = false)
	private String object;

	@Column(nullable = false)
	private String type;

	private String required;

	private String objectif;

	private int nbrOfParticipants;

	private String status;

	private String category;

	@OneToMany(mappedBy = "training",cascade = CascadeType.ALL)
	Set<Participant> participants;

	private String validationActivityManager;

	private String validationCEO;

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public int getNbrOfParticipants() {
		return nbrOfParticipants;
	}

	public void setNbrOfParticipants(int nbrOfParticipants) {
		this.nbrOfParticipants = nbrOfParticipants;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidationActivityManager() {
		return validationActivityManager;
	}

	public void setValidationActivityManager(String validationActivityManager) {
		this.validationActivityManager = validationActivityManager;
	}

	public String getValidationCEO() {
		return validationCEO;
	}

	public void setValidationCEO(String validationCEO) {
		this.validationCEO = validationCEO;
	}

	public Training(String object, String type, String required, String objectif, int nbrOfParticipants, String status,
			String category, Set<Participant> participants, String validationActivityManager, String validationCEO) {
		super();
		this.object = object;
		this.type = type;
		this.required = required;
		this.objectif = objectif;
		this.nbrOfParticipants = nbrOfParticipants;
		this.status = status;
		this.category = category;
		this.participants = participants;
		this.validationActivityManager = validationActivityManager;
		this.validationCEO = validationCEO;
	}

	public Training() {
		super();
	}
}

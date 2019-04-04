package com.altran.TOOLSBox_Systeme_De_Management.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRIVILEGES")
public class Privilege implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrivilege;

	private String titre;

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Privilege(String titre) {
		super();
		this.titre = titre;
	}

	public int getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(int idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}

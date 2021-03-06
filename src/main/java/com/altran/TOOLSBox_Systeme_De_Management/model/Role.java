package com.altran.TOOLSBox_Systeme_De_Management.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.altran.TOOLSBox_Systeme_De_Management.util.Constants;
import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "ROLES")
@JsonFilter(Constants.ROLE_FILTER)
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPrivilege")
	private Set<Privilege> privileges;

	public Role() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Privilege;

public interface PrivilegeService {

	List<Privilege> getAllPrivileges();

	Privilege getPrivilegeById(int idPrivilege);

	boolean addPrivilege(Privilege privilege);

	boolean updatePrivilege(int id, Privilege privilege);

	boolean deletePrivilege(int idPrivilege);

}

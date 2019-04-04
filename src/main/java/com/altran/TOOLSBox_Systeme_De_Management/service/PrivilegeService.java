package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Privilege;

public interface PrivilegeService {

	boolean addPrivilege(Privilege privilege);

	boolean updatePrivilege(Privilege privilege);

	boolean deletePrivilege(int idPrivilege);

	Privilege getPrivilegeById(int idPrivilege);

	List<Privilege> getAllPrivileges();
}

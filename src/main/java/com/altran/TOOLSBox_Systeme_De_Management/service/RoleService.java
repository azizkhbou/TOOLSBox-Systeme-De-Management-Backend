package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Role;

public interface RoleService {
	boolean addRole(Role role);

	boolean updateRole(Role role);

	boolean deleteRole(int idRole);

	Role getRoleById(int idRole);

	List<Role> getAllRoles();

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Role;

public interface RoleService {

	List<Role> getAllRoles();

	Role getRoleById(int idRole);

	boolean addRole(Role role);

	boolean updateRole(int id, Role role);

	boolean deleteRole(int idRole);

}

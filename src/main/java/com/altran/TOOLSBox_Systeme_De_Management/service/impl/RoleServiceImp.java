package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Role;
import com.altran.TOOLSBox_Systeme_De_Management.repository.RoleRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public void setUserRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleById(int idRole) {
		return roleRepository.findById(idRole).orElse(null);
	}

	@Override
	public boolean addRole(Role role) {
		try {
			roleRepository.save(role);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updateRole(int id,  Role role) {
		try {
			role.setId(id);
			roleRepository.save(role);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteRole(int idRole) {
		try {
			roleRepository.deleteById(idRole);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

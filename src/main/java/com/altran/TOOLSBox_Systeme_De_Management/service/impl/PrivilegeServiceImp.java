package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Privilege;
import com.altran.TOOLSBox_Systeme_De_Management.repository.PrivilegeRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.PrivilegeService;

@Service
public class PrivilegeServiceImp implements PrivilegeService {

	private PrivilegeRepository privilegeRepository;

	@Autowired
	public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
		this.privilegeRepository = privilegeRepository;
	}

	@Override
	public List<Privilege> getAllPrivileges() {
		return privilegeRepository.findAll();
	}

	@Override
	public Privilege getPrivilegeById(int idPrivilege) {
		return privilegeRepository.findById(idPrivilege).orElse(null);
	}

	@Override
	public boolean addPrivilege(Privilege privilege) {
		try {
			privilegeRepository.save(privilege);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean updatePrivilege(int id, Privilege privilege) {
		try {
			privilege.setId(id);
			privilegeRepository.save(privilege);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deletePrivilege(int idPrivilege) {
		try {
			privilegeRepository.deleteById(idPrivilege);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

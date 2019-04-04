package com.altran.TOOLSBox_Systeme_De_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altran.TOOLSBox_Systeme_De_Management.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {

}

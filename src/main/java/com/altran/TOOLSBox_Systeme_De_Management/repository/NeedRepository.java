package com.altran.TOOLSBox_Systeme_De_Management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.altran.TOOLSBox_Systeme_De_Management.model.Need;

@Repository
public interface NeedRepository extends JpaRepository<Need, Integer> {
	Page<Need> findAll(Pageable pageable);


}

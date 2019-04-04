package com.altran.TOOLSBox_Systeme_De_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.TOOLSBox_Systeme_De_Management.model.Activity;
import com.altran.TOOLSBox_Systeme_De_Management.service.impl.ActivityServiceImp;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {
	
	private ActivityServiceImp activityServiceImp;

	@Autowired
	public void setActivityServiceImp(ActivityServiceImp activityServiceImp) {
		this.activityServiceImp = activityServiceImp;
	}
	
	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PostMapping(value = "/create")
	public boolean createUser(@RequestBody Activity activity) {

		return activityServiceImp.addActivity(activity);

	}
	
	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@PutMapping(value = "/update")
	public boolean updateActivity(@RequestBody Activity activity) {

		return activityServiceImp.updateActivity(activity);

	}

	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@DeleteMapping(value = "/delete/{id}")
	public boolean deleteActivity(@PathVariable int id) {

		return activityServiceImp.deleteActivity(id);

	}
	@PreAuthorize("hasAuthority('Gestion des utilisateurs')")
	@GetMapping(value = "/all")
	public List<Activity> getAllActivities() {

		return activityServiceImp.getAllActivities();

	}
	@GetMapping(value = "/id/{id}")
	public Activity getActivityById(@PathVariable int id) {
		return activityServiceImp.getActivityById(id);
	}
	

}

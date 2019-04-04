package com.altran.TOOLSBox_Systeme_De_Management.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.TOOLSBox_Systeme_De_Management.model.Activity;
import com.altran.TOOLSBox_Systeme_De_Management.repository.ActivityRepository;
import com.altran.TOOLSBox_Systeme_De_Management.service.ActivityService;

@Service
public class ActivityServiceImp implements ActivityService {

	private ActivityRepository activityRepository;

	@Autowired
	public void setActivityRepository(ActivityRepository activityRepository) {
		this.activityRepository = activityRepository;
	}

	

	@Override
	public boolean addActivity(Activity activity) {
		try {
			activityRepository.save(activity);
		} catch (Exception e) {
			return false;
		}
		return true;	}

	@Override
	public boolean updateActivity(Activity activity) {
		try {
			activityRepository.save(activity);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteActivity(int idActivity) {
		try {
			activityRepository.deleteById(idActivity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Activity getActivityById(int idActivity) {
		return activityRepository.findById(idActivity).orElse(null);
		
	}
	@Override
	public List<Activity> getAllActivities() {

		return activityRepository.findAll();
	}

}

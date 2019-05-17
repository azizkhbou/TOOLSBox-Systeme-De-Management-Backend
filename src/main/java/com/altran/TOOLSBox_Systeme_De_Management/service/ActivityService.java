package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Activity;

public interface ActivityService {

	List<Activity> getAllActivities();

	Activity getActivityById(int idActivity);

	boolean addActivity(Activity activity);

	boolean updateActivity(int id, Activity activity);

	boolean deleteActivity(int idActivity);

}

package com.altran.TOOLSBox_Systeme_De_Management.service;

import java.util.List;

import com.altran.TOOLSBox_Systeme_De_Management.model.Activity;
import com.altran.TOOLSBox_Systeme_De_Management.model.Role;

public interface ActivityService {
	boolean addActivity(Activity activity);

	boolean updateActivity(Activity activity);

	boolean deleteActivity(int idActivity);

	Activity getActivityById(int idActivity);

	List<Activity> getAllActivities();
}

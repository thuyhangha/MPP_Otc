package com.mpp.lab2;

import java.util.Date;
import java.util.HashMap;

public class Features {
	private Integer estimateEfforts;
	
	private HashMap<Date, Integer> remainingWork;
	
	private HashMap<Date, Integer> completeWork;
	
	private ProjectManager projectManager;
	
	private Developer developer;
	
	

	public Integer getEstimateEfforts() {
		return estimateEfforts;
	}

	public void setEstimateEfforts(Integer estimateEfforts) {
		this.estimateEfforts = estimateEfforts;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public HashMap<Date, Integer> getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(HashMap<Date, Integer> remainingWork) {
		this.remainingWork = remainingWork;
	}

	public HashMap<Date, Integer> getCompleteWork() {
		return completeWork;
	}

	public void setCompleteWork(HashMap<Date, Integer> completeWork) {
		this.completeWork = completeWork;
	}
	
	public void putCompleteWork(Date key){
		Integer completeWorkValue = this.estimateEfforts - this.remainingWork.get(key);
		completeWork.put(key, completeWorkValue);
	}
	
}

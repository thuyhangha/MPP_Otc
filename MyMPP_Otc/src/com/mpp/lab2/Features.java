package com.mpp.lab2;

import java.util.Date;
import java.util.HashMap;

public class Features {
	private Integer estimateEfforts;
	
	private Integer remainingWork;
	
	private Integer completeWork;
	
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

	public Integer getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(Integer remainingWork) {
		this.remainingWork = remainingWork;
	}

	public Integer getCompleteWork() {
		return this.estimateEfforts - this.remainingWork;
	}

	public void setCompleteWork(Integer completeWork) {
		this.completeWork = completeWork;
	}
	
}

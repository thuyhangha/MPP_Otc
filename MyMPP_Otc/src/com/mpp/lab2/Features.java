package com.mpp.lab2;

public class Features {
	private Integer estimateEfforts;
	
	private String remainingWork;
	
	private ProjectManager projectManager;
	
	private Developer developer;

	public Integer getEstimateEfforts() {
		return estimateEfforts;
	}

	public void setEstimateEfforts(Integer estimateEfforts) {
		this.estimateEfforts = estimateEfforts;
	}

	public String getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(String remainingWork) {
		this.remainingWork = remainingWork;
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
}

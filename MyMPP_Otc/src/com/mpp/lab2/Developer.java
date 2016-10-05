package com.mpp.lab2;

import java.util.List;

public class Developer {
	private List<Features> assignedFeatures;

	public Developer() {
		// TODO Auto-generated constructor stub
	}

	public List<Features> getAssignedFeatures() {
		return assignedFeatures;
	}

	public void setAssignedFeatures(List<Features> assignedFeatures) {
		this.assignedFeatures = assignedFeatures;
	}

	public void addAssignedFeatures(Features f) {
		assignedFeatures.add(f);
	}
}

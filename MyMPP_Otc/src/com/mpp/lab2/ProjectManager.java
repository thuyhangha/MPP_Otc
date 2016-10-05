package com.mpp.lab2;

import java.util.List;

public class ProjectManager{
	private List<Features> features;
	
	public ProjectManager() {
	
		// TODO Auto-generated constructor stub
	}

	public List<Features> getFeatures() {
		return features;
	}

	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	
	/*void addProductBacklogFeaturesToRelease(List<Features> lstFeatures, Release r){
		for(Features f: lstFeatures){
			r.setLstFeatures(lstFeatures);
		}
	}*/
}

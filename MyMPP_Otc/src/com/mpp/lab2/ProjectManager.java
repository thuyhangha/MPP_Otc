package com.mpp.lab2;

import java.util.Date;
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
	
	void addProductBacklogFeaturesToRelease(Features feature, Release release){
		release.addReleasesFeatures(feature);
	}
	
	public void assignedFeaturesToDev(Features feature, Developer dev){
			dev.addAssignedFeatures(feature);
	}
	
	public Integer reportCompletedWork(Date d, Sprints sprints){
		int completeWork = 0;
		for(Features f: sprints.getLstSubsetFeatures()){
			if(f.getCompleteWork() == 0)
				completeWork++;
		}
		return completeWork;
	}
	
	public Integer reportRemaingingWork(Date d, Sprints sprints){
		int remainingWork = 0;
		for(Features f: sprints.getLstSubsetFeatures()){
			if(f.getRemainingWork() > 0)
				remainingWork++;
		}
		return remainingWork;
	}
}

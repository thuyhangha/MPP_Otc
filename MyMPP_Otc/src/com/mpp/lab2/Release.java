package com.mpp.lab2;

import java.util.Date;
import java.util.List;

public class Release {
	private Date releaseDate;
	
	private List<Features> lstFeatures;
	
	private List<Sprints> lstSprints;

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Sprints> getLstSprints() {
		return lstSprints;
	}

	public void setLstSprints(List<Sprints> lstSprints) {
		this.lstSprints = lstSprints;
	}

	public List<Features> getLstFeatures() {
		return lstFeatures;
	}

	public void setLstFeatures(List<Features> lstFeatures) {
		this.lstFeatures = lstFeatures;
	}
	
	public void addReleasesFeatures(Features feature){
		lstFeatures.add(feature);
	}
}

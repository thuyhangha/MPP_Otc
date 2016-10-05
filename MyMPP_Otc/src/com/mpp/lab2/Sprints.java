package com.mpp.lab2;

import java.util.Date;
import java.util.List;

public class Sprints {
	private Date dueDate;
	
	private List<Features> lstSubsetFeatures;

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<Features> getLstSubsetFeatures() {
		return lstSubsetFeatures;
	}

	public void setLstSubsetFeatures(List<Features> lstSubsetFeatures) {
		this.lstSubsetFeatures = lstSubsetFeatures;
	}
}

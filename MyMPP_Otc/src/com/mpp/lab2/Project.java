package com.mpp.lab2;

import java.util.List;

public class Project {
	private ProductBacklog productBacklog;
	private List<Release> lstRelease;
	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}
	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}
	public List<Release> getLstRelease() {
		return lstRelease;
	}
	public void setLstRelease(List<Release> lstRelease) {
		this.lstRelease = lstRelease;
	}
}

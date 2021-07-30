package com.ss.cfsd.utopia.domain;

public class Route {

	private Integer id = null;
	private String originId = null;
	private String destinationId = null;
	
	public Integer getId() {
		return id;
	}
	
	public String getOriginId() {
		return originId;
	}
	
	public String getDestinationId() {
		return destinationId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setOriginId(Airport airport) {
		originId = airport.getIataId();
	}
	
	public void setDestinationId(Airport airport) {
		destinationId = airport.getIataId();
	}
}

package com.ss.cfsd.utopia.domain;

public class Airplane {

	private Integer id = null;
	private Integer typeId = null;
	
	public Integer getId() {
		return id;
	}
	
	public Integer getTypeId() {
		return typeId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	public void setTypeId(AirplaneType airplaneType) {
		typeId = airplaneType.getId();
	}
}

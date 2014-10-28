package com.epam.employeesdb.model;

public class OfficePosition extends AbstractEntity {
	private Office office;
	private Position position;
	
	public Office getOffice() {
		return office;
	}
	
	public void setOffice(Office office) {
		this.office = office;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public String toString() {
		return office + "," + position;
	}
}

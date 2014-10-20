package com.epam.employeesdb.model;

public class Address extends AbstractEntity {
	private City city;
	private String street;
	private Integer house;
	private Integer apartment;

	public Address() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getHouse() {
		return house;
	}

	public void setHouse(Integer house) {
		this.house = house;
	}

	public Integer getApartment() {
		return apartment;
	}

	public void setApartment(Integer apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return city + "," + street + ","
				+ house + ", " + apartment;
	}
}

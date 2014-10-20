package com.epam.employeesdb.dao;

import java.util.List;

public interface EntityDAO<T> {
	T get(Integer id);
	List<T> getPaginated(int offset, int size);
	void create(T entity);
	void create(List<T> entityList);
	void delete(Integer id);
	void update(T entity);	
	
	
	
	
	
	
	
	
	/*Country getCountry();
	City getCity();
	Address getAddress(Integer id);
	Employee getEmployee();
	void addCountry(Country country);
	void addCountriesList (List<Country> countries);
	void addAddressList(List<Address> addresses);
	void addCitiesList (List<City> cities);
	List<Object[]> getPortionOfAddresses();
	void addCompany(Company company);*/
}

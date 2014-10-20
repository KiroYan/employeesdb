/*package com.epam.employeesdb.util;

import java.util.ArrayList;
import java.util.List;

import com.epam.employeesdb.dao.EntityDAO;
import com.epam.employeesdb.dao.DAOImpl;
import com.epam.employeesdb.model.Address;
import com.epam.employeesdb.model.City;
import com.epam.employeesdb.model.Country;

public class TempHelpAdderToDB {

	private static String nameOfSwitzerland = "Switzerland";
	private static List<Country> countries;
	private static String Fanipol = "Fanipol";
	private static List<City> cities;
	private static List<Address> addresses;
	private static String street = "Wonderfull streer";
	private static EntityDAO dao = new DAOImpl();

	public static void addCounries() {
		countries = new ArrayList<Country>();
		for (int numberOfSwitzerland = 0; numberOfSwitzerland < 1000; numberOfSwitzerland++) {
			Country switzerland = new Country();
			switzerland.setName(nameOfSwitzerland + numberOfSwitzerland);
			countries.add(switzerland);
		}
		dao.addCountriesList(countries);
	}

	public static void addCities() {
		cities = new ArrayList<City>();
		for (int numberOfFanipol = 0; numberOfFanipol < 1000; numberOfFanipol++) {
			City city = new City();
			city.setName(Fanipol + numberOfFanipol);
			city.setCountry(countries.get(numberOfFanipol));
			cities.add(city);
		}
		dao.addCitiesList(cities);
	}

	public static void addAddresses() {
		addresses = new ArrayList<Address>();
		int house = 1;
		int unit = 1;
		int apartment = 1;

		for (int numberOfAddress = 0; numberOfAddress < 1000; numberOfAddress++) {
			Address address = new Address();
			address.setCity(cities.get(numberOfAddress));
			address.setStreet(street + numberOfAddress);
			address.setHouse(house);
			address.setApartment(apartment);
			addresses.add(address);
			house++;
			unit++;
			apartment++;
		}
		dao.addAddressList(addresses);
	}

}
*/
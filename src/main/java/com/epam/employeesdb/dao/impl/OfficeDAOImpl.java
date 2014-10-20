package com.epam.employeesdb.dao.impl;

import java.util.Collections;
import java.util.List;

import com.epam.employeesdb.dao.OfficeDAO;
import com.epam.employeesdb.model.Office;

public class OfficeDAOImpl extends AbstractEntityDAO<Office> implements OfficeDAO {

	public OfficeDAOImpl(Class<?> entityClass) {
		super(Office.class);
	}

	@Override
	public List<Office> getPaginated(int offset, int size) {
		return Collections.emptyList();
	}
	
}

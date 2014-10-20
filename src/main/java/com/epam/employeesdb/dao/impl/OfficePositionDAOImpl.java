package com.epam.employeesdb.dao.impl;

import java.util.Collections;
import java.util.List;

import com.epam.employeesdb.dao.OfficePositionDAO;
import com.epam.employeesdb.model.OfficePosition;

public class OfficePositionDAOImpl extends AbstractEntityDAO<OfficePosition> implements OfficePositionDAO {

	public OfficePositionDAOImpl() {
		super(OfficePosition.class);
	}

	@Override
	public List<OfficePosition> getPaginated(int offset, int size) {
		return Collections.emptyList();
	}

}

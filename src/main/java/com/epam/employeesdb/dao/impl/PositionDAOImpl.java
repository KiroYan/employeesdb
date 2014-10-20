package com.epam.employeesdb.dao.impl;

import java.util.List;

import com.epam.employeesdb.dao.PositionDAO;
import com.epam.employeesdb.model.Position;



public class PositionDAOImpl extends AbstractEntityDAO<Position> implements PositionDAO {
	
	public PositionDAOImpl() {
		super(Position.class);
	}

	@Override
	public List<Position> getPaginated(int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.epam.employeesdb.tests;

import org.junit.Assert;
import org.junit.Test;

import com.epam.employeesdb.dao.PositionDAO;
import com.epam.employeesdb.dao.impl.PositionDAOImpl;
import com.epam.employeesdb.model.Position;

public class PositionDAOTest {
	private PositionDAO positionDAO = new PositionDAOImpl();
	
	//@Test
	public void testCreate() {
		Position position = TestsUtils.createSamplePosition();
		positionDAO.create(position);

		Assert.assertNotNull(position.getId());
	}
}

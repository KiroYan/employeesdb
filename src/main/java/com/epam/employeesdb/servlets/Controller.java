
package com.epam.employeesdb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.employeesdb.dao.EmployeeDAO;
import com.epam.employeesdb.dao.impl.EmployeeDAOImpl;
import com.epam.employeesdb.model.Employee;

@WebServlet(urlPatterns = { "/employee" })
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		List<Employee> employees = empDAO.getPaginated(0, 100);
		
		System.out.println(employees);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		request.setAttribute("employees", employees);
		rd.forward(request, response);
	}
}

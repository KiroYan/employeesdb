
package com.epam.employeesdb.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.employeesdb.constants.Constants;
import com.epam.employeesdb.dao.EmployeeDAO;
import com.epam.employeesdb.dao.impl.EmployeeDAOImpl;
import com.epam.employeesdb.model.Employee;
import com.epam.employeesdb.model.EmployeeRepresentation;
import com.epam.employeesdb.model.OfficePosition;
import com.epam.employeesdb.services.EmployeeService;
import com.epam.employeesdb.services.EmployeeServiceImpl;
import com.epam.employeesdb.util.ModelToJspConvertor;

@WebServlet(urlPatterns = { "/employees" })
public class Controller extends HttpServlet {
	private EmployeeService employeeService = new EmployeeServiceImpl();
	
	
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
		int page = Integer.parseInt(request.getParameter(Constants.PAGE_PARAMETER));
		int numberOfAllEmployees = employeeService.getNumberOfEmployees();
		int numberOfEmployeesOnPage = page * Constants.EMPLOYEES_PER_PAGE <= numberOfAllEmployees ? Constants.EMPLOYEES_PER_PAGE
				: page * Constants.EMPLOYEES_PER_PAGE - numberOfAllEmployees; 
		
		boolean isNextPage = numberOfAllEmployees > page * Constants.EMPLOYEES_PER_PAGE;
		
		List<Employee> employees = employeeService.getPaginated(page, numberOfEmployeesOnPage);
		List<EmployeeRepresentation> employeeRepresentations = ModelToJspConvertor.convertEmployeeListToJspBean(employees);
		
		Map<Integer,Integer> numberOfEmployeesInOffice = employeeService.getNumberOfEmployeesPerOffice(employeeRepresentations);

		RequestDispatcher rd = request.getRequestDispatcher(Constants.EMPLOYEES_VIEW);
		request.setAttribute(Constants.PAGE_PARAMETER, page);
		request.setAttribute(Constants.NEXT_PAGE_PARAMETER, isNextPage);
		request.setAttribute(Constants.EMPLOYEES_LIST_PARAMETER, employeeRepresentations);
		request.setAttribute(Constants.NUMBER_OF_EMPLOYEES_PARAMETER, numberOfEmployeesInOffice);
		rd.forward(request, response);
	}
}

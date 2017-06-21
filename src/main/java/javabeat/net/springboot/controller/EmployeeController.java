package javabeat.net.springboot.controller;

import java.util.List;

import javabeat.net.springboot.domain.Employee;
import javabeat.net.springboot.service.EmployeeService;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

	@Inject
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeService.getList();
		return employees;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addEmployee(
			@RequestParam(value = "employeeName", required = false) String employeeName,
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "employeeCity", required = false) String employeeCity) {
		Employee employee = new Employee(employeeId, employeeName, employeeCity);
		employeeService.save(employee);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployeeForm(Employee employee, Model model) {
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}
}

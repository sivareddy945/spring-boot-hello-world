package javabeat.net.springboot.service;

import java.util.List;

import javabeat.net.springboot.domain.Employee;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> getList();

}

package javabeat.net.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javabeat.net.springboot.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

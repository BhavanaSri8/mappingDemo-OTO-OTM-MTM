package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

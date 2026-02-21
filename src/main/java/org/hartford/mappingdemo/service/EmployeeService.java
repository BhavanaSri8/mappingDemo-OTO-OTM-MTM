package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Employee;
import org.hartford.mappingdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    
    public Employee getById(Long id){
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }
    
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
    
    public Employee updateEmployee(Long id, Employee employee){
        Employee existing = getById(id);
        existing.setName(employee.getName());
        return employeeRepository.save(existing);
    }
}

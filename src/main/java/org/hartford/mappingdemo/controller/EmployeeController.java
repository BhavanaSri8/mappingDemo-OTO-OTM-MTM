package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Employee;
import org.hartford.mappingdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.getById(id);
    }
    
    @GetMapping
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        employeeService.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
}

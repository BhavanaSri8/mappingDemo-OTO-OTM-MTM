package org.hartford.mappingdemo.service;

import org.hartford.mappingdemo.model.Employee;
import org.hartford.mappingdemo.model.Project;
import org.hartford.mappingdemo.repository.EmployeeRepository;
import org.hartford.mappingdemo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    
    public Project addProject(Project project){
        return projectRepository.save(project);
    }
    
    public Project getById(Long id){
        return projectRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
    }
    
    public List<Project> findAll(){
        return projectRepository.findAll();
    }
    
    public void deleteById(Long id){
        projectRepository.deleteById(id);
    }
    
    public Project updateProject(Long id, Project project){
        Project existing = getById(id);
        existing.setName(project.getName());
        return projectRepository.save(existing);
    }
    
    public Project assignEmployeeToProject(Long projectId, Long employeeId){
        Project project = projectRepository.findById(projectId).orElseThrow(()->new RuntimeException("Invalid project id"));
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new RuntimeException("Invalid employee id"));
        project.getEmployees().add(employee);
        return projectRepository.save(project);
    }
}

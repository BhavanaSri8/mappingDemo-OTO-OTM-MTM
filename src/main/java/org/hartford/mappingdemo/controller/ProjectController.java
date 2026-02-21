package org.hartford.mappingdemo.controller;

import org.hartford.mappingdemo.model.Project;
import org.hartford.mappingdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id){
        return projectService.getById(id);
    }
    
    @GetMapping
    public List<Project> findAll(){
        return projectService.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        projectService.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }
    
    @PutMapping("/assign/{projectId}/{employeeId}")
    public Project assignEmployeeToProject(@PathVariable Long projectId, @PathVariable Long employeeId){
        return projectService.assignEmployeeToProject(projectId, employeeId);
    }
}

package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

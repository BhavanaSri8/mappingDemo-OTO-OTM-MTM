package org.hartford.mappingdemo.repository;

import org.hartford.mappingdemo.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {

}

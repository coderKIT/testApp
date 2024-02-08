package com.testApp.demo.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDTO extends CrudRepository<CourseModel, Long> {
}

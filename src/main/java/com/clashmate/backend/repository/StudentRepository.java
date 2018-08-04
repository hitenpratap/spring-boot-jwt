package com.clashmate.backend.repository;

import com.clashmate.backend.model.student.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {
}

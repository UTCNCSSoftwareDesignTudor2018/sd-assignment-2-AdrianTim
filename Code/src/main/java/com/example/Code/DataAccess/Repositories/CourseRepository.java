package com.example.Code.DataAccess.Repositories;

import com.example.Code.DataAccess.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findAllByStudentsNot(int fk_student);

}

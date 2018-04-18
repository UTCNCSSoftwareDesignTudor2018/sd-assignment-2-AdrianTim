package com.example.Code.DataAccess.Repositories;

import com.example.Code.DataAccess.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByNameOrderByName(String name);

}

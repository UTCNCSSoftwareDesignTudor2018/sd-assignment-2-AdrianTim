package com.example.Code.DataAccess.Repositories;

import com.example.Code.DataAccess.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByNameOrderByName(String name);

}

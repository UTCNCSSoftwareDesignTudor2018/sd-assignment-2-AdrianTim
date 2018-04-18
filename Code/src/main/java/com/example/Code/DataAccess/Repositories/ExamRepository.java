package com.example.Code.DataAccess.Repositories;

import com.example.Code.DataAccess.Entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

}

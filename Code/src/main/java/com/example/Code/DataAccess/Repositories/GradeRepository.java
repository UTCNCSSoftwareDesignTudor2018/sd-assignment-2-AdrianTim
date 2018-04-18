package com.example.Code.DataAccess.Repositories;

import com.example.Code.DataAccess.Entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}

package com.example.Code.BusinessLogic;

import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;

import java.util.List;

public interface ICourseLogic {

    void enrolStudent(int studentId, int courseId);
    void unEnrolStudent(int studentId, int courseId);
    void addCourse(String subject, int teacherId);
    List<CourseDTO> getStudentCourses(int studentId);
    List<CourseDTO> getAvailableCourses(int studentId);

}

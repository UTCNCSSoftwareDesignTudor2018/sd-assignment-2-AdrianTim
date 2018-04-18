package com.example.Code.BusinessLogic;

import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;

import java.util.Date;
import java.util.List;

public interface ITeacherLogic {

    void createTeacher(String name, String surname);
    void updateTeacher(int teacherId, String newName, String newSurname);
    TeacherDTO getTeacher(int teacherId);
    List<TeacherDTO> getTeachersByName(String name);
    void gradeStudent(int studentId, int mark, int examId);
    void generateAndSaveReport(int studentId);

}

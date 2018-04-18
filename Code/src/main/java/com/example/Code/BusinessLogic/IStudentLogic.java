package com.example.Code.BusinessLogic;

import com.example.Code.BusinessLogic.DataTransferObjects.StudentDTO;

import java.util.List;

public interface IStudentLogic {

    StudentDTO getStudent(int studentId);
    List<StudentDTO> findStudentsByName(String name);
    void createStudent(String name, String surname, String address, String personalNumber);
    void updateStudent(int studentId, String newName, String newSurname, String newAddress, String newPersonalNumber);

}

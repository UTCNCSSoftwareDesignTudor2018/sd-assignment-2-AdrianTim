package com.example.Code.BusinessLogic.DataTransferObjects;

import java.util.List;

public class TeacherDTO {

    private int id;
    private String name;
    private String surname;
    private List<CourseDTO> courses;

    public TeacherDTO(){};

    public TeacherDTO(int id, String name, String surname, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}

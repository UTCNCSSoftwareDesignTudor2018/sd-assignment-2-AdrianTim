package com.example.Code.BusinessLogic.DataTransferObjects;

import java.util.List;

public class StudentDTO {

    private int id;
    private String name;
    private String surname;
    private String address;
    private String personalNumber;
    private List<CourseDTO> courses;

    public StudentDTO(){}

    public StudentDTO(int id, String name, String surname, String address, String personalNumber, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.personalNumber = personalNumber;
        this.courses = courses;
    }

    public void addCourse(CourseDTO course){

        this.courses.add(course);

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

}

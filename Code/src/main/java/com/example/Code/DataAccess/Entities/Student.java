package com.example.Code.DataAccess.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String surname;
    private String address;
    private String personalNumber;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course){

        this.courses.add(course);
        course.getStudents().add(this);

    }

    public void removeCourse(Course course){

        this.courses.remove(course);
        course.getStudents().remove(this);

    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addGrade(Grade grade){

        this.grades.add(grade);
        grade.setStudent(this);

    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}

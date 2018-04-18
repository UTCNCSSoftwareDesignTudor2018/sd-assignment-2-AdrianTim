package com.example.Code.DataAccess.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "fk_teacher")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Exam> exams = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "course_student",
                joinColumns = {@JoinColumn(name = "fk_student")},
                inverseJoinColumns = {@JoinColumn(name = "fk_course")})
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){

        this.students.add(student);
        student.getCourses().add(this);

    }

    public void removeStudent(Student student){

        this.students.remove(student);
        student.getCourses().remove(this);

    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addExam(Exam exam){

        this.exams.add(exam);
        exam.setCourse(this);

    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

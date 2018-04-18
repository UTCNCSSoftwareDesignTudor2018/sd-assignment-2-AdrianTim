package com.example.Code.BusinessLogic.DataTransferObjects;

public class CourseDTO {

    private int id;
    private String subject;
    private String teacherName;

    public CourseDTO(){}

    public CourseDTO(int id, String subject, String teacherName) {
        this.id = id;
        this.subject = subject;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}

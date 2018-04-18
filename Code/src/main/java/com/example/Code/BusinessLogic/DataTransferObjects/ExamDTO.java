package com.example.Code.BusinessLogic.DataTransferObjects;

import java.util.Date;

public class ExamDTO {

    private int id;
    private Date date;
    private String room;
    private String subject;
    private String teacherName;

    public ExamDTO(){}

    public ExamDTO(int id, Date date, String room, String subject, String teacherName) {
        this.id = id;
        this.date = date;
        this.room = room;
        this.subject = subject;
        this.teacherName = teacherName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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

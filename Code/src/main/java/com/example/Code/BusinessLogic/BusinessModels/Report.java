package com.example.Code.BusinessLogic.BusinessModels;

public class Report {

    private String studentName;
    private String studentSurname;
    private double gradeAverage;

    public Report(){}

    public Report(String studentName, String studentSurname, double gradeAverage) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.gradeAverage = gradeAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }
}

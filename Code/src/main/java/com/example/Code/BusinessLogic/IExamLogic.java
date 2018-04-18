package com.example.Code.BusinessLogic;

import com.example.Code.BusinessLogic.DataTransferObjects.ExamDTO;

import java.util.Date;
import java.util.List;

public interface IExamLogic {

    void addExam(int courseId, Date date, String room);
    List<ExamDTO> getStudentExams(int studentId);
    List<ExamDTO> getCourseExams(int courseId);


}

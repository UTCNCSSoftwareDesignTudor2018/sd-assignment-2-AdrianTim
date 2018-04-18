package com.example.Code.BusinessLogic.Implementations;

import com.example.Code.BusinessLogic.DataTransferObjects.ExamDTO;
import com.example.Code.BusinessLogic.IExamLogic;
import com.example.Code.DataAccess.Entities.Course;
import com.example.Code.DataAccess.Entities.Exam;
import com.example.Code.DataAccess.Repositories.CourseRepository;
import com.example.Code.DataAccess.Repositories.ExamRepository;
import com.example.Code.DataAccess.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class ExamLogic implements IExamLogic {

    private ExamRepository examRepository;
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private DTOFactory dtoFactory;

    @Autowired
    public ExamLogic(ExamRepository examRepository, CourseRepository courseRepository, StudentRepository studentRepository, DTOFactory dtoFactory){

        this.dtoFactory = dtoFactory;
        this.examRepository = examRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;

    }

    @Override
    public void addExam(int courseId, Date date, String room) {

        Course examCourse = courseRepository.getOne(courseId);

        Exam exam = new Exam();
        exam.setDate(date);
        exam.setRoom(room);
        exam.setCourse(examCourse);

        examRepository.save(exam);

    }

    @Override
    public List<ExamDTO> getStudentExams(int studentId) {

        List<ExamDTO> examDTOS = new LinkedList<>();

        studentRepository.getOne(studentId).getCourses().forEach(c -> c.getExams().forEach(e -> examDTOS.add(dtoFactory.createExamDTO(e))));

        return examDTOS;
    }

    @Override
    public List<ExamDTO> getCourseExams(int courseId) {
        return null;
    }


}

package com.example.Code.BusinessLogic.Implementations;

import com.example.Code.BusinessLogic.BusinessModels.Report;
import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;
import com.example.Code.BusinessLogic.ITeacherLogic;
import com.example.Code.DataAccess.Entities.*;
import com.example.Code.DataAccess.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherLogic implements ITeacherLogic {

    private TeacherRepository teacherRepository;
    private GradeRepository gradeRepository;
    private ExamRepository examRepository;
    private StudentRepository studentRepository;
    private IMongoRepository mongoRepository;

    @Autowired
    public TeacherLogic(TeacherRepository teacherRepository, GradeRepository gradeRepository, ExamRepository examRepository, StudentRepository studentRepository, IMongoRepository mongoRepository){

        this.teacherRepository = teacherRepository;
        this.gradeRepository = gradeRepository;
        this.examRepository = examRepository;
        this.studentRepository = studentRepository;
        this.mongoRepository = mongoRepository;

    }

    @Override
    public void createTeacher(String name, String surname) {

        Teacher t = new Teacher();
        t.setName(name);
        t.setSurname(surname);

        teacherRepository.save(t);

    }

    @Override
    public void updateTeacher(int teacherId, String newName, String newSurname) {

        Teacher t = teacherRepository.getOne(teacherId);

        t.setName(newName);
        t.setSurname(newSurname);

        teacherRepository.save(t);

    }

    @Override
    public TeacherDTO getTeacher(int teacherId) {

        TeacherDTO teacherDTO = new TeacherDTO();

        Teacher dbTeacher = teacherRepository.findById(teacherId).orElse(null);
        if(dbTeacher != null){
            teacherDTO.setId(dbTeacher.getId());
            teacherDTO.setName(dbTeacher.getName());
            teacherDTO.setSurname(dbTeacher.getSurname());
        }

        return teacherDTO;
    }

    @Override
    public List<TeacherDTO> getTeachersByName(String name) {

        List<TeacherDTO> teacherDTOS = new LinkedList<>();

        teacherRepository.findByNameOrderByName(name).forEach(t -> teacherDTOS.add(new TeacherDTO(t.getId(), t.getName(), t.getSurname(), createCourseDTOList(t.getCourses()))));

        return teacherDTOS;

    }

    @Override
    public void gradeStudent(int studentId, int mark, int examId) {

        Exam exam = examRepository.getOne(examId);
        Student student = studentRepository.getOne(studentId);
        Grade grade = new Grade();

        grade.setMark(mark);
        student.addGrade(grade);
        exam.addGrade(grade);

        gradeRepository.save(grade);

    }

    @Override
    public void generateAndSaveReport(int studentId) {

        Report report = new Report();
        Student student = studentRepository.getOne(studentId);

        report.setStudentName(student.getName());
        report.setStudentSurname(student.getSurname());

        double average = 0.0;
        for(Grade grade : student.getGrades()){
            average += grade.getMark();
        }

        report.setGradeAverage((1.0 * average) / student.getGrades().size());

    }

    private List<CourseDTO> createCourseDTOList(List<Course> courses){

        List<CourseDTO> courseDTOS = new LinkedList<>();

        courses.forEach(c -> courseDTOS.add(new CourseDTO(c.getId(), c.getSubject(), c.getTeacher().getName())));

        return courseDTOS;

    }
}

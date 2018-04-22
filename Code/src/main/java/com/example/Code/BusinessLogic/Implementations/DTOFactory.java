package com.example.Code.BusinessLogic.Implementations;

import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.ExamDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.StudentDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;
import com.example.Code.DataAccess.Entities.Course;
import com.example.Code.DataAccess.Entities.Exam;
import com.example.Code.DataAccess.Entities.Student;
import com.example.Code.DataAccess.Entities.Teacher;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class DTOFactory {

    public StudentDTO createDTO(Student student){

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setSurname(student.getSurname());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setPersonalNumber(student.getPersonalNumber());

        studentDTO.setCourses(new LinkedList<>());
        student.getCourses().forEach(c -> studentDTO.addCourse(new CourseDTO(c.getId(), c.getSubject(), c.getTeacher().getName())));

        return studentDTO;

    }

    public CourseDTO createDTO(Course course){

        return new CourseDTO(course.getId(), course.getSubject(), course.getTeacher().getName());

    }

    public ExamDTO createExamDTO(Exam exam){

        ExamDTO examDTO = new ExamDTO();
        examDTO.setId(exam.getId());
        examDTO.setDate(exam.getDate());
        examDTO.setRoom(exam.getRoom());
        examDTO.setSubject(exam.getCourse().getSubject());
        examDTO.setTeacherName(exam.getCourse().getTeacher().getName());

        return examDTO;

    }

    public TeacherDTO createDTO(Teacher teacher){

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId(teacher.getId());
        teacherDTO.setName(teacher.getName());
        teacherDTO.setSurname(teacher.getSurname());
        teacherDTO.setCourses(new LinkedList<>());

        teacher.getCourses().forEach(c -> teacherDTO.getCourses().add(createDTO(c)));

        return teacherDTO;

    }

}

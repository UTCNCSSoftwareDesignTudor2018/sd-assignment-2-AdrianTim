package com.example.Code.BusinessLogic.Implementations;

import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;
import com.example.Code.BusinessLogic.ICourseLogic;
import com.example.Code.DataAccess.Entities.Course;
import com.example.Code.DataAccess.Entities.Student;
import com.example.Code.DataAccess.Repositories.CourseRepository;
import com.example.Code.DataAccess.Repositories.StudentRepository;
import com.example.Code.DataAccess.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CourseLogic implements ICourseLogic {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private DTOFactory dtoFactory;

    @Autowired
    public CourseLogic(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, DTOFactory dtoFactory){

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.dtoFactory = dtoFactory;

    }

    @Override
    public void enrolStudent(int studentId, int courseId) {

        Student dbStudent = studentRepository.getOne(studentId);
        Course dbCourse = courseRepository.getOne(courseId);

        dbCourse.addStudent(dbStudent);

        courseRepository.save(dbCourse);

    }

    @Override
    public void unEnrolStudent(int studentId, int courseId) {

        Student dbStudent = studentRepository.getOne(studentId);
        Course dbCourse = courseRepository.getOne(courseId);

        dbCourse.removeStudent(dbStudent);

        courseRepository.save(dbCourse);

    }

    @Override
    public void addCourse(String subject, int teacherId) {

        Course course = new Course();

        course.setSubject(subject);
        course.setTeacher(teacherRepository.getOne(teacherId));

        courseRepository.save(course);

    }

    @Override
    public List<CourseDTO> getStudentCourses(int studentId) {

        List<CourseDTO> courseDTOS = new LinkedList<>();

        studentRepository.getOne(studentId).getCourses().forEach(c -> courseDTOS.add(dtoFactory.createDTO(c)));

        return courseDTOS;
    }

    @Override
    public List<CourseDTO> getAvailableCourses(int studentId) {

        List<Course> allCourses = courseRepository.findAll();
        Student student = studentRepository.getOne(studentId);
        List<CourseDTO> courseDTOS = new LinkedList<>();

        allCourses.stream().filter(c -> !c.getStudents().contains(student)).forEach(c -> courseDTOS.add(dtoFactory.createDTO(c)));

        return courseDTOS;

    }
}

package com.example.Code.BusinessLogic.Implementations;

import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.StudentDTO;
import com.example.Code.BusinessLogic.IStudentLogic;
import com.example.Code.DataAccess.Entities.Course;
import com.example.Code.DataAccess.Entities.Student;
import com.example.Code.DataAccess.Repositories.CourseRepository;
import com.example.Code.DataAccess.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class StudentLogic implements IStudentLogic {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private DTOFactory dtoFactory;

    @Autowired
    public StudentLogic(StudentRepository studentRepository, DTOFactory dtoFactory, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.dtoFactory = dtoFactory;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentDTO getStudent(int studentId) {

        StudentDTO studentDTO = new StudentDTO();
        Student dbStudent = studentRepository.findById(studentId).orElse(null);

        if(dbStudent != null){

            studentDTO = dtoFactory.createDTO(dbStudent);

        }

        return studentDTO;
    }

    @Override
    public List<StudentDTO> findStudentsByName(String name) {

        List<StudentDTO> studentDTOS = new LinkedList<>();

        List<Student> dbStudents = studentRepository.findAllByNameOrderByName(name);
        dbStudents.forEach(s -> studentDTOS.add(new StudentDTO(s.getId(), s.getName(), s.getSurname(), s.getAddress(), s.getPersonalNumber(), createCourseDTOList(s.getCourses()))));

        return studentDTOS;

    }

    private List<CourseDTO> createCourseDTOList(Set<Course> courses){

        List<CourseDTO> courseDTOS = new LinkedList<>();

        courses.forEach(c -> courseDTOS.add(new CourseDTO(c.getId(), c.getSubject(), c.getTeacher().getName())));

        return courseDTOS;

    }

    @Override
    public void createStudent(String name, String surname, String address, String personalNumber) {

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAddress(address);
        student.setPersonalNumber(personalNumber);

        studentRepository.save(student);

    }

    @Override
    public void updateStudent(int studentId, String newName, String newSurname, String newAddress, String newPersonalNumber) {

        Student student = studentRepository.getOne(studentId);

        student.setName(newName);
        student.setSurname(newSurname);
        student.setAddress(newAddress);
        student.setPersonalNumber(newPersonalNumber);

        studentRepository.save(student);

    }

    @Override
    public List<StudentDTO> getAll() {

        List<StudentDTO> studentDTOS = new LinkedList<>();

        studentRepository.findAll().forEach(s -> studentDTOS.add(dtoFactory.createDTO(s)));

        return studentDTOS;

    }

    @Override
    public List<StudentDTO> getEnrolled(int courseId) {

        List<StudentDTO> studentDTOS = new LinkedList<>();

        courseRepository.getOne(courseId).getStudents().forEach(s -> studentDTOS.add(dtoFactory.createDTO(s)));

        return studentDTOS;

    }
}

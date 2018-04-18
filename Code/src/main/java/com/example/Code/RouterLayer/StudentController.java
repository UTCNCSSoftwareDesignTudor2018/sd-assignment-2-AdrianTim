package com.example.Code.RouterLayer;

import com.example.Code.BusinessLogic.DataTransferObjects.CourseDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.ExamDTO;
import com.example.Code.BusinessLogic.DataTransferObjects.StudentDTO;
import com.example.Code.BusinessLogic.ICourseLogic;
import com.example.Code.BusinessLogic.IExamLogic;
import com.example.Code.BusinessLogic.IStudentLogic;
import com.example.Code.BusinessLogic.ITeacherLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private IStudentLogic studentLogic;
    private ICourseLogic courseLogic;
    private IExamLogic examLogic;

    @Autowired
    public StudentController(IStudentLogic studentLogic, ICourseLogic courseLogic, IExamLogic examLogic) {
        this.studentLogic = studentLogic;
        this.courseLogic = courseLogic;
        this.examLogic = examLogic;
    }

    @GetMapping(path = "/get")
    public @ResponseBody StudentDTO getStudent(@RequestParam int id){
        return studentLogic.getStudent(id);
    }

   @GetMapping(path = "/create")
    public void createStudent(@RequestParam String name, @RequestParam String surname, @RequestParam String personalNumber, @RequestParam String address){
        studentLogic.createStudent(name, surname, personalNumber, address);
   }

   @GetMapping(path = "/update")
    public void updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String surname, @RequestParam String personalNumber, @RequestParam String address){
        studentLogic.updateStudent(id, name, surname, personalNumber, address);
   }

   @GetMapping(path = "/enrol")
    public void enrolStudent(@RequestParam int studentId, @RequestParam int courseId){
        courseLogic.enrolStudent(studentId, courseId);
   }

   @GetMapping(path = "/getAvailableCourses")
    public @ResponseBody List<CourseDTO> getAvailableCourses(@RequestParam int studentId){
        return courseLogic.getAvailableCourses(studentId);
   }

   @GetMapping(path = "/getExams")
    public @ResponseBody List<ExamDTO> getExams(@RequestParam int studentId){
        return examLogic.getStudentExams(studentId);
   }

}

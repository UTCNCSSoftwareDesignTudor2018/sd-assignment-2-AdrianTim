package com.example.Code.RouterLayer;

import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;
import com.example.Code.BusinessLogic.ICourseLogic;
import com.example.Code.BusinessLogic.IExamLogic;
import com.example.Code.BusinessLogic.ITeacherLogic;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/teacher")
public class TeacherController {

    private ITeacherLogic teacherLogic;
    private ICourseLogic courseLogic;
    private IExamLogic examLogic;

    @Autowired
    public TeacherController(ITeacherLogic teacherLogic, ICourseLogic courseLogic, IExamLogic examLogic) {
        this.teacherLogic = teacherLogic;
        this.courseLogic = courseLogic;
        this.examLogic = examLogic;
    }

    @GetMapping(path = "/getAll")
    public @ResponseBody
    List<TeacherDTO> getAll(){
        return teacherLogic.getAll();
    }

    @GetMapping(path = "/get")
    public @ResponseBody
    TeacherDTO getTeacher(@RequestParam int teacherId){
        return teacherLogic.getTeacher(teacherId);
    }

    @GetMapping(path = "/create")
    public @ResponseBody void createTeacher(@RequestParam String name, @RequestParam String surname){
        teacherLogic.createTeacher(name, surname);
    }

    @GetMapping(path = "/update")
    public @ResponseBody void updateTeacher(@RequestParam int id, @RequestParam String name, @RequestParam String surname){
        teacherLogic.updateTeacher(id, name, surname);
    }

    @GetMapping(path = "/giveGrade")
    public @ResponseBody void giveGrade(@RequestParam int studentId, @RequestParam int mark, @RequestParam int examId){
        teacherLogic.gradeStudent(studentId, mark, examId);
    }

    @GetMapping(path = "/generateReport")
    public @ResponseBody void generateReport(@RequestParam int studentId){
        teacherLogic.generateAndSaveReport(studentId);
    }

    @GetMapping(path = "/getReport")
    public @ResponseBody
    DBObject findReport(){
        return teacherLogic.findDocuments();
    }

    @GetMapping(path = "/generateTestReport")
    public @ResponseBody void generateTestReport(){
        teacherLogic.generateTestRepository();
    }

}

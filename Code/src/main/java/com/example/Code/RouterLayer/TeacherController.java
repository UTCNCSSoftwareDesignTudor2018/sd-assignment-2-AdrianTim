package com.example.Code.RouterLayer;

import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;
import com.example.Code.BusinessLogic.ICourseLogic;
import com.example.Code.BusinessLogic.IExamLogic;
import com.example.Code.BusinessLogic.ITeacherLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping(path = "/get")
    public @ResponseBody
    TeacherDTO getTeacher(@RequestParam int teacherId){
        return teacherLogic.getTeacher(teacherId);
    }

    @GetMapping(path = "/create")
    public void createTeacher(@RequestParam String name, @RequestParam String surname){
        teacherLogic.createTeacher(name, surname);
    }

    @GetMapping(path = "/update")
    public void updateTeacher(@RequestParam int id, @RequestParam String name, @RequestParam String surname){
        teacherLogic.updateTeacher(id, name, surname);
    }

    @GetMapping(path = "/giveGrade")
    public void giveGrade(@RequestParam int studentId, @RequestParam int mark, @RequestParam int examId){
        teacherLogic.gradeStudent(studentId, mark, examId);
    }

    @GetMapping(path = "/generateReport")
    public void generateReport(@RequestParam int studentId){

    }

}

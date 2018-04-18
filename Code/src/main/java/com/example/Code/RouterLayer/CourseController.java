package com.example.Code.RouterLayer;

import com.example.Code.BusinessLogic.ICourseLogic;
import com.example.Code.BusinessLogic.IExamLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping(path = "/course")
public class CourseController {

    private ICourseLogic courseLogic;
    private IExamLogic examLogic;

    @Autowired
    public CourseController(ICourseLogic courseLogic, IExamLogic examLogic) {
        this.courseLogic = courseLogic;
        this.examLogic = examLogic;
    }

    @GetMapping(path = "/create")
    public void createCourse(@RequestParam String subject, @RequestParam int teacherId){
        courseLogic.addCourse(subject, teacherId);
    }

    @GetMapping(path = "/addExam")
    public void addExam(@RequestParam int courseId, @RequestParam String room, @RequestParam Date date){
        examLogic.addExam(courseId, date, room);
    }
}

package com.example.Code.RouterLayer;

import com.example.Code.BusinessLogic.DataTransferObjects.TeacherDTO;
import com.example.Code.BusinessLogic.ITeacherLogic;
import com.example.Code.DataAccess.Entities.Teacher;
import com.example.Code.DataAccess.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/test")
public class TestController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ITeacherLogic teacherLogic;

    @GetMapping(path="/hello")
    public @ResponseBody String hello(){
        return "Hello";
    }

    @GetMapping(path = "/createTestTeacher")
    public @ResponseBody String createTeacher(){

        Teacher t = new Teacher();

        t.setName("Test");
        t.setSurname("TestSurname");

        teacherRepository.save(t);

        return "Created";

    }

    @GetMapping(path = "/testGetTeacher")
    public @ResponseBody TeacherDTO getTeacher(@RequestParam int id){
        return teacherLogic.getTeacher(id);
    }

}

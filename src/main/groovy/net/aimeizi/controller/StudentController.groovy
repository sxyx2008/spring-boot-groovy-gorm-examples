package net.aimeizi.controller

import net.aimeizi.domain.Student
import net.aimeizi.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Administrator on 2015/3/17 0017.
 */
@RestController
class StudentController {

    @Autowired
    StudentService studentService

    @RequestMapping(value = "/student/hello",method = RequestMethod.GET)
    String hello(String name){
        studentService.name(name)
    }


    @RequestMapping(value = "/student/save",method = RequestMethod.GET)
    @ResponseBody
    Student save(){
        Student student = new Student(name: "aimeizi",age: 18)
        studentService.save(student)
        return student
    }
}

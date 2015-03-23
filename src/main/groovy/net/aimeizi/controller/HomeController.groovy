package net.aimeizi.controller

import net.aimeizi.domain.Student
import net.aimeizi.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * Created by Administrator on 2015/3/22 0022.
 */
@Controller
class HomeController {

    @Autowired
    StudentService studentService

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    ModelAndView home(){
        List<Student> studentList = studentService.all()
        ModelAndView modelAndView = new ModelAndView("home")
        modelAndView.addObject("studentList",studentList)
        return modelAndView
    }

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    String welcome(){
        return "welcome"
    }
}

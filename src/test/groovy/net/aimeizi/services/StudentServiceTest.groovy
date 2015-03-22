package net.aimeizi.services

import net.aimeizi.Application
import net.aimeizi.domain.Student
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

/**
 * Created by Administrator on 2015/3/17 0017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
class StudentServiceTest extends GroovyTestCase{

    @Autowired
    StudentService studentService

    @Test
    public void save(){
        Student student = new Student(name: "scott",age: 18)
        boolean  b = studentService.save(student)
        println(b)
    }

    @Test
    public void findByName(){
        def name = studentService.name("aimeizi")
        println(name)
    }
}

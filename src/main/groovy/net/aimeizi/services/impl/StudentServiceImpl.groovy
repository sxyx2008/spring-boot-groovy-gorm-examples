package net.aimeizi.services.impl

import net.aimeizi.domain.Student
import net.aimeizi.services.StudentService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Administrator on 2015/3/22 0022.
 */
@Service
@Transactional
class StudentServiceImpl implements StudentService{

    @Override
    String name(String name) {
        def student = Student.findByName(name)
        student.getName()
    }

    @Override
    boolean save(Student student) {
        Student.withTransaction {
            def stu = student.save()
            return stu?true:false
        }
    }

    @Override
    List<Student> all() {
        return Student.findAll()
    }
}

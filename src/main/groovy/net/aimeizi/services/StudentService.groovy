package net.aimeizi.services

import net.aimeizi.domain.Student
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Created by Administrator on 2015/3/17 0017.
 */

interface StudentService {

    String name(String name)

    boolean save(Student student)

    List<Student> all()
}

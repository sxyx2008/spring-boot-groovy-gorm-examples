package net.aimeizi.domain

import grails.persistence.Entity

/**
 * Created by Administrator on 2015/3/17 0017.
 */

@Entity
class Student implements Serializable{

    Long id
    String name
    Integer age

    static constraints = {
        id unique: true
        name blank: false,nullable: false
    }

}

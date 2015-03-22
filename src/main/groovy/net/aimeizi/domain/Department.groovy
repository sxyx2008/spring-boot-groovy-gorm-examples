package net.aimeizi.domain

import grails.persistence.Entity

/**
 * Created by Administrator on 2015/3/22 0022.
 */
@Entity
class Department implements Serializable{
    String deptname
    static hasMany = [employees: Employee]

    static constraints = {
        deptname blank: false,nullable: false,unique: true
    }

}

package net.aimeizi.domain

import grails.persistence.Entity

/**
 * Created by Administrator on 2015/3/22 0022.
 */
@Entity
class Employee implements Serializable{
    String empname
    Integer age
    String address
    static hasOne = [department:Department]

    static constraints = {
        empname blank: false,nullable: false,unique: true
        age min: 1,max: 100
        address blank: false,nullable: false
    }
}

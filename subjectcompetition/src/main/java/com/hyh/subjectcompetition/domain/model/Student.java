package com.hyh.subjectcompetition.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Student {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "jpa-uuid")
    //@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
     //       String id;

    String schoolnumber;
    String teamnumber;
    String name;
    String grade;
    String profession;
    String class1;
    String idnumber;
    String bankcardnumber;
}

package com.hyh.subjectcompetition.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Teacher {

    @Id
    String jobnumber;
    String teamnumber;
    String name;
    String telephone;
    String email;
}

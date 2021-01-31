package com.hyh.subjectcompetition.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Enroll {
    //List<TeacherRecord> teacherRecords= (List<TeacherRecord>) new TeacherRecord();

    @Id
    String teamnumber;
    String teamname;


}

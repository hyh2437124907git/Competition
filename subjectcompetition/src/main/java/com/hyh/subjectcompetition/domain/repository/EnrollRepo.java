package com.hyh.subjectcompetition.domain.repository;

import com.hyh.subjectcompetition.domain.model.Competition;
import com.hyh.subjectcompetition.domain.model.Enroll;
import com.hyh.subjectcompetition.domain.model.Student;
import com.hyh.subjectcompetition.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnrollRepo extends JpaRepository<Enroll,String>{

    @Query(value = "select s from Student  as s where s.teamnumber=?1")
    public List<Student> getStudent(String teamnumber);

    @Query(value = "select t from Teacher  as t where t.teamnumber=?1")
    public List<Teacher> getTeacher(String teamnumber);

    @Query(value = "select c from Competition  as c where c.teamnumber=?1")
    public Competition getCompetition(String teamnumber);

    @Query(value = "select e.teamnumber from Enroll  as e where e.teamname=?1")
    public List<String> getEnrollByTeamnumber(String teamname);
}

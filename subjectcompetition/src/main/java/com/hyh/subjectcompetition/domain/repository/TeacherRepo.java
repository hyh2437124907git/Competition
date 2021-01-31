package com.hyh.subjectcompetition.domain.repository;

import com.hyh.subjectcompetition.domain.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,String> {
}

package com.hyh.subjectcompetition.application.service.impls;

import com.hyh.subjectcompetition.application.dto.input.StudentInputDTO;
import com.hyh.subjectcompetition.application.service.IStudentService;
import com.hyh.subjectcompetition.domain.model.Student;
import com.hyh.subjectcompetition.domain.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Object create(StudentInputDTO model) {
        Student entity = new Student();
        entity.setSchoolnumber(model.getSchoolnumber());
        entity.setTeamnumber(model.getTeamnumber());
        entity.setName(model.getName());
        entity.setGrade(model.getGrade());
        entity.setProfession(model.getProfession());
        entity.setClass1(model.getClass1());
        entity.setIdnumber(model.getIdnumber());
        entity.setBankcardnumber(model.getBankcardnumber());
        return studentRepo.save(entity);
    }
}
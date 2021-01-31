package com.hyh.subjectcompetition.application.service.impls;

import com.hyh.subjectcompetition.application.dto.input.TeacherInputDTO;
import com.hyh.subjectcompetition.application.service.ITeacherService;
import com.hyh.subjectcompetition.domain.model.Teacher;
import com.hyh.subjectcompetition.domain.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Object create(TeacherInputDTO model) {
        Teacher entity = new Teacher();
        entity.setJobnumber(model.getJobnumber());
        entity.setTeamnumber(model.getTeamnumber());
        entity.setName(model.getName());
        entity.setTelephone(model.getTelephone());
        entity.setEmail(model.getEmail());
        return teacherRepo.save(entity);
    }
}

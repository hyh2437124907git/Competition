package com.hyh.subjectcompetition.application.service.impls;

import com.hyh.subjectcompetition.application.dto.input.EnrollInputDTO;
import com.hyh.subjectcompetition.application.service.IEnrollService;
import com.hyh.subjectcompetition.domain.model.Enroll;
import com.hyh.subjectcompetition.domain.repository.EnrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollServiceImpl implements IEnrollService {
    @Autowired
    private EnrollRepo enrollRepo;

    @Override
    public Object create(EnrollInputDTO model) {
        Enroll entity = new Enroll();
        entity.setTeamnumber(model.getTeamnumber());
        entity.setTeamname(model.getTeamname());

        return enrollRepo.save(entity);
    }
}

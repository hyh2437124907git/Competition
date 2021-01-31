package com.hyh.subjectcompetition.application.service.impls;

import com.hyh.subjectcompetition.application.dto.input.CompetitionInputDTO;
import com.hyh.subjectcompetition.application.service.ICompetitionService;
import com.hyh.subjectcompetition.domain.model.Competition;
import com.hyh.subjectcompetition.domain.repository.CompetitionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author hyh
 * @date 2021-01-27 10:35
 */
@Service
public class CompetitionServiceImpl implements ICompetitionService {
    @Autowired
    private CompetitionRepo repo;

    @Override
    public Object create(CompetitionInputDTO model) {
        Competition entity = new Competition();
        entity.setTeamnumber(model.getTeamnumber());
        entity.setYear(model.getYear());
        entity.setName(model.getName());
        entity.setProfession(model.getProfession());
        entity.setOrganizer(model.getOrganizer());
        entity.setLevel(model.getLevel());
        entity.setCategory(model.getCategory());
        return repo.save(entity);
    }
}

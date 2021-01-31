package com.hyh.subjectcompetition.application.service;

import com.hyh.subjectcompetition.application.dto.input.CompetitionInputDTO;

public interface ICompetitionService {
    Object create(CompetitionInputDTO model);
}

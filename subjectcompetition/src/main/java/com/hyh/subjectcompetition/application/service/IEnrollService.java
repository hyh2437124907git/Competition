package com.hyh.subjectcompetition.application.service;

import com.hyh.subjectcompetition.application.dto.input.EnrollInputDTO;

public interface IEnrollService {
    Object create(EnrollInputDTO model);
}

package com.hyh.subjectcompetition.application.service;

import com.hyh.subjectcompetition.application.dto.input.TeacherInputDTO;

public interface ITeacherService {
    Object create(TeacherInputDTO model);
}

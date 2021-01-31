package com.hyh.subjectcompetition.application.service;

import com.hyh.subjectcompetition.application.dto.input.StudentInputDTO;

public interface IStudentService {
    Object create(StudentInputDTO model);
}

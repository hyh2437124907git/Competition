package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.TeacherInputDTO;
import com.hyh.subjectcompetition.application.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherApi {
    @Autowired
    private ITeacherService teacherService;

    @PostMapping
    public Object create(@RequestBody TeacherInputDTO model){
        return teacherService.create(model);
    }
}

package com.hyh.subjectcompetition.api;


import com.hyh.subjectcompetition.application.dto.input.StudentInputDTO;
import com.hyh.subjectcompetition.application.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
public class StudentApi {

    @Autowired
    private IStudentService studentService;

    @PostMapping
    public Object create(@RequestBody StudentInputDTO model){
        return studentService.create(model);
    }
}
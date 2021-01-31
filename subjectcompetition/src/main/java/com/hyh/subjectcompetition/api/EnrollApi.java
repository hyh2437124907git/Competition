package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.EnrollInputDTO;
import com.hyh.subjectcompetition.application.service.IEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enrolls")
public class EnrollApi {
    @Autowired
    private IEnrollService enrollService;

    @PostMapping
    public Object create(@RequestBody EnrollInputDTO model){
        return enrollService.create(model);
    }
}

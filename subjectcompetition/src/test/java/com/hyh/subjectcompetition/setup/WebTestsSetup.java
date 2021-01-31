package com.hyh.subjectcompetition.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyh.subjectcompetition.SubjectcompetitionApplicationTests;
import com.hyh.subjectcompetition.domain.repository.CompetitionRepo;
import com.hyh.subjectcompetition.domain.repository.EnrollRepo;
import com.hyh.subjectcompetition.domain.repository.StudentRepo;
import com.hyh.subjectcompetition.domain.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author hyh
 * @date
 *
 */
@AutoConfigureMockMvc
public class WebTestsSetup extends SubjectcompetitionApplicationTests {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper mapper;

    @Autowired
    public CompetitionRepo competitionRepo;

    @Autowired
    protected ObjectMapper studentMapper;
    @Autowired
    public StudentRepo studentRepo;

    @Autowired
    protected ObjectMapper teacherMapper;
    @Autowired
    public TeacherRepo teacherRepo;

    @Autowired
    protected ObjectMapper enrollMapper;
    @Autowired
    public EnrollRepo enrollRepo;
}

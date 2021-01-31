package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.EnrollInputDTO;
import com.hyh.subjectcompetition.domain.model.Competition;
import com.hyh.subjectcompetition.domain.model.Enroll;
import com.hyh.subjectcompetition.domain.model.Student;
import com.hyh.subjectcompetition.domain.model.Teacher;
import com.hyh.subjectcompetition.setup.WebTestsSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EnrollApiTests extends WebTestsSetup {

    private static final String URL = "/enrolls";

    private static final String teamnumber= "20210129";
    private static final String teamname = "竞赛名字";


    @Test
    @DisplayName("报名信息")
    void create() throws Exception {
        // given
        EnrollInputDTO model = new EnrollInputDTO();
        model.setTeamnumber(teamnumber);
        model.setTeamname(teamname);


        String content = enrollMapper.writeValueAsString(model);

        System.out.println("创建新赛事中的内容：" + content);


        // when
        //将数据写入数据库
        ResultActions actions = mockMvc.perform(
                post(URL).content(content)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        );
        // then 断言接口返回内容
        System.out.println("断言接口返回内容");
        actions.andDo(print())
                .andExpect(status().isOk())
                // JSON Path
                .andExpect(jsonPath("$.teamnumber").isNotEmpty())
                // 对比JSON
                .andExpect(content().json(content));


        // then 断言数据库
        System.out.println("断言数据库");
        List<Enroll> entities = enrollRepo.findAll();
        Enroll entity = entities.get(0);
        System.out.println(entity.toString());
        assertAll(
                () -> assertEquals(1, entities.size()),
                () -> {
                    assertAll(
                            () -> assertEquals(teamnumber, entity.getTeamnumber()),
                            () -> assertEquals(teamname, entity.getTeamname())
                    );
                }
        );
        System.out.println("------------Id:" + entity.getTeamnumber());
        // System.out.println("------------Id:" + entity.getId());
        System.out.println(entity.toString());
    }

    @Test
    @DisplayName("查找信息")
    void find() throws Exception{
        List<String> findteamnumbers=enrollRepo.getEnrollByTeamnumber(teamname);
        for(int i=0;i<findteamnumbers.size();i++){
            String findteamnumber=findteamnumbers.get(i);
            System.out.println("--------------"+findteamnumber);
            List<Student> findStudents=enrollRepo.getStudent(findteamnumber);
            List<Teacher> findTeachers=enrollRepo.getTeacher(findteamnumber);
            Competition findCompetition=enrollRepo.getCompetition(findteamnumber);

            System.out.print("赛事名称为“"+teamname+"”的赛事对应的赛事编号为“"+findCompetition.getTeamnumber()+"”\n");
            System.out.println("该赛事的参与成员信息如下：");
            System.out.println("老师信息：");
            for(int j=0;j<findTeachers.size();j++){
                Teacher findTeacher=findTeachers.get(j);
                System.out.println("老师姓名："+findTeacher.getName()+"  工号："+findTeacher.getJobnumber()+"  电话："+findTeacher.getTelephone());
            }
            System.out.println("学生信息：");
            for(int j=0;j<findStudents.size();j++){
                Student findStudent=findStudents.get(j);
                System.out.println("学生姓名："+findStudent.getName()+"  学号："+findStudent.getSchoolnumber()+"  年级："+findStudent.getGrade()+"  专业："+findStudent.getClass1());
            }
        }
    }
}

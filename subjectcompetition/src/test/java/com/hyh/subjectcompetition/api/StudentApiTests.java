package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.StudentInputDTO;
import com.hyh.subjectcompetition.domain.model.Student;
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

public class StudentApiTests extends WebTestsSetup {
    private static final String URL = "/students";

    private static final String schoolNumber="201914060205";
    private static final String teamnumber = "20210129";
    private static final String name="hyh";
    private static final String grade="大二";
    private static final String profession="老师名字";
    private static final String class1="软件工程";
    private static final String idNumber="4305212000";
    private static final String bankCardNumber="123456789";

    @Test
    @DisplayName("学生信息")
    void create() throws Exception {
        // given
        StudentInputDTO model = new StudentInputDTO();
        model.setSchoolnumber(schoolNumber);
        model.setTeamnumber(teamnumber);
        model.setName(name);
        model.setGrade(grade);
        model.setProfession(profession);
        model.setClass1(class1);
        model.setIdnumber(idNumber);
        model.setBankcardnumber(bankCardNumber);

        //删除数据库中赛事名称和举办年度相同的元组
        // StudentRepo.DeleteCompetition(model.getName(), model.getYear());

        String content = studentMapper.writeValueAsString(model);

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
                .andExpect(jsonPath("$.schoolnumber").isNotEmpty())
                // 对比JSON
                .andExpect(content().json(content));


        // then 断言数据库
        System.out.println("断言数据库");
        List<Student> entities = studentRepo.findAll();
        Student entity = entities.get(0);
        System.out.println(entity.toString());
        assertAll(
                //() -> assertEquals(1, entities.size()),
                () -> {
                    assertAll(
                            () -> assertEquals(schoolNumber, entity.getSchoolnumber()),
                            () -> assertEquals(teamnumber, entity.getTeamnumber()),
                            () -> assertEquals(name, entity.getName()),
                            () -> assertEquals(grade, entity.getGrade()),
                            () -> assertEquals(profession, entity.getProfession()),
                            () -> assertEquals(class1, entity.getClass1()),
                            () -> assertEquals(idNumber, entity.getIdnumber()),
                            () -> assertEquals(bankCardNumber, entity.getBankcardnumber())
                    );
                }
        );
        System.out.println("------------Id:" + entity.getSchoolnumber());
       // System.out.println("------------Id:" + entity.getId());
        System.out.println(entity.toString());
    }
}

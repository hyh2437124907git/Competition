package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.TeacherInputDTO;
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

public class TeacherApiTests extends WebTestsSetup {

    private static final String URL = "/teachers";

    private static final String jobnumber="1234567";
    private static final String teamnumber = "20210129";
    private static final String name="老师名字";
    private static final String telephone="12345678900";
    private static final String email="142353@qq.com";
    //private static final int rank1=2;

    @Test
    @DisplayName("老师信息")
    void create() throws Exception {
        // given
        TeacherInputDTO model = new TeacherInputDTO();
        model.setJobnumber(jobnumber);
        model.setTeamnumber(teamnumber);
        model.setName(name);
        model.setTelephone(telephone);
        model.setEmail(email);



        String content = teacherMapper.writeValueAsString(model);

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
                .andExpect(jsonPath("$.jobnumber").isNotEmpty())
                // 对比JSON
                .andExpect(content().json(content));


        // then 断言数据库
        System.out.println("断言数据库");
        List<Teacher> entities = teacherRepo.findAll();
        Teacher entity = entities.get(0);
        System.out.println(entity.toString());
        assertAll(
                () -> assertEquals(1, entities.size()),
                () -> {
                    assertAll(
                            () -> assertEquals(jobnumber, entity.getJobnumber()),
                            () -> assertEquals(teamnumber, entity.getTeamnumber()),
                            () -> assertEquals(name, entity.getName()),
                            () -> assertEquals(telephone, entity.getTelephone()),
                            () -> assertEquals(email, entity.getEmail())
                    );
                }
        );
        System.out.println("------------Id:" + entity.getJobnumber());
        System.out.println(entity.toString());
    }
}

package com.hyh.subjectcompetition.api;

import com.hyh.subjectcompetition.application.dto.input.CompetitionInputDTO;
import com.hyh.subjectcompetition.domain.model.Competition;
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

/**
 * @author hyh
 * @date 2021-01-28 16:17
 *public class CompetitionApiTests {
 */
    public class CompetitionApiTests extends WebTestsSetup {
    private static final String URL = "/competitions";

    private static final String teamnumber = "20210129";
    private static final Integer year = 2021;
    private static final String name = "赛事名称";
    private static final String profession = "所属专业";
    private static final String organizer = "主办单位";
    private static final String level = "级别";
    private static final String category = "类别";


    @Test
    @DisplayName("创建新的赛事")
    void create() throws Exception {
        // given
        CompetitionInputDTO model = new CompetitionInputDTO();
        model.setTeamnumber(teamnumber);
        model.setYear(year);
        model.setName(name);
        model.setProfession(profession);
        model.setOrganizer(organizer);
        model.setLevel(level);
        model.setCategory(category);

        //删除数据库中赛事名称和举办年度相同的元组
        competitionRepo.DeleteCompetition(model.getName(), model.getYear());

        String content = mapper.writeValueAsString(model);

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
        List<Competition> entities = competitionRepo.findAll();
        Competition entity = entities.get(0);
        assertAll(
                () -> assertEquals(1, entities.size()),
                () -> {
                    assertAll(
                            () -> assertEquals(teamnumber, entity.getTeamnumber()),
                            () -> assertEquals(year, entity.getYear()),
                            () -> assertEquals(name, entity.getName()),
                            () -> assertEquals(profession, entity.getProfession()),
                            () -> assertEquals(organizer, entity.getOrganizer()),
                            () -> assertEquals(level, entity.getLevel()),
                            () -> assertEquals(category, entity.getCategory())

                    );
                }
        );
        System.out.println("------------Id:" + entity.getTeamnumber());
        System.out.println(entity.toString());
    }


    //    // 嵌套测试
//    class CompetitionRudTests{
//
//    }
//
    @Test
    @DisplayName("删除现有赛事")
    void delete() {
        List<Competition> entities = competitionRepo.findAll();
        Competition entity;
        for (int i = 0; i < entities.size(); i++) {
            entity = entities.get(i);
            competitionRepo.DeleteCompetition(entity.getName(), entity.getYear());
        }

    }

    //
    @Test
    @DisplayName("根据条件查询赛事")
    void getBy() {
        //根据年份查询赛事信息

        List<Competition> Find = competitionRepo.findAll();
        System.out.println(year + "年的赛事信息：");
        for (int i = 0; i < Find.size(); i++) {
            if (year.equals(Find.get(i).getYear())) {
                System.out.println(Find.get(i).toString());
            }
        }

    }

    //
    @Test
    @DisplayName("修改现有赛事")
    void update() {
        competitionRepo.UpdateOrganizerCompetition("湖南文理学院",year,name);

    }
}
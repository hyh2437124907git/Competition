package com.hyh.subjectcompetition.application.dto.input;

import lombok.Data;

/**
 * @author hyh
 * @date 2021-01-27 10:33
 */
@Data
public class CompetitionInputDTO {
    private String teamnumber;
    private Integer year;
    private String name;
    private String profession;
    private String organizer;
    private String level;
    private String category;

    @Override
    public String toString() {
        return "CompetitionInputDTO{" +
                "teamnumber='" + teamnumber + '\'' +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", organizer='" + organizer + '\'' +
                ", level='" + level + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
//    public Integer getYear() {
//        return year;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getProfession() {
//        return profession;
//    }
//
//    public String getOrganizer() {
//        return organizer;
//    }
//
//    public String getLevel() {
//        return level;
//    }
//
//    public String getCategory() {
//        return category;
//    }
}
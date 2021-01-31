package com.hyh.subjectcompetition.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Competition {
    @Id
    //@GeneratedValue(generator = "jpa-uuid")
    //@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
    //private String id;
    private String teamnumber;
    private Integer year;
    private String name;
    private String profession;
    private String organizer;
    private String level;
    private String category;


//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setYear(Integer year) {
//        this.year = year;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setProfession(String profession) {
//        this.profession = profession;
//    }
//
//    public void setOrganizer(String organizer) {
//        this.organizer = organizer;
//    }
//
//    public void setLevel(String level) {
//        this.level = level;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}

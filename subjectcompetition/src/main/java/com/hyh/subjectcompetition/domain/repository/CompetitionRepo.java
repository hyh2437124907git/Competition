package com.hyh.subjectcompetition.domain.repository;

import com.hyh.subjectcompetition.domain.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CompetitionRepo extends JpaRepository<Competition,String> {

    //根据年份修改赛事名称
    @Transactional
    @Modifying
    @Query("UPDATE Competition a SET a.name=?1 WHERE a.year=?2")
    public int UpdateNameCompetition(String name,int year);

    //根据年份和赛事名称修改主办单位
    @Transactional
    @Modifying
    @Query("UPDATE Competition a SET a.organizer=?1 WHERE a.year=?2 and a.name=?3")
    public int UpdateOrganizerCompetition(String organizer,int year,String name);

    //根据年份和赛事名称精确删除相关信息
    @Transactional
    @Modifying
    @Query("DELETE FROM Competition a WHERE a.name=?1 AND a.year=?2")
    public int DeleteCompetition(String name,int year);


    //删除现有赛事内容
    @Transactional
    @Modifying
    @Query(value="truncate table competition;",nativeQuery=true)
    public int DeleteCompetition1(String name,int year);


}

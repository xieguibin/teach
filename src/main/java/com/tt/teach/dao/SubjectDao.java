package com.tt.teach.dao;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectDao {
    @Select("select subject.*,gradeName from subject,grade where subject.gradeID=grade.gradeID")
    List<Subject> getSubjectList();
    @Delete("delete from subject where subjectNo=#{subjectNo}")
    int deleteSubject(Integer subjectNo);
    @Update("update subject set subjectName=#{subjectName},classHour=#{classHour} where subjectNo=#{subjectNo}")
    int updateSubject(Subject subject);
    @Insert("insert into subject (subjectName,gradeID,classHour)values(#{subjectName},#{gradeID},#{classHour})")
    int addSubject(Subject subject);
    @Select("select * from grade")
    List<Grade> getGradeList();
}

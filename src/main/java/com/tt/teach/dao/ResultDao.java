package com.tt.teach.dao;

import com.tt.teach.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ResultDao {

    @Select("SELECT result.*,student.studentName AS studentName,subject.subjectName AS subjectName FROM result,student,SUBJECT WHERE result.studentNo=student.studentNo AND result.subjectNo=subject.subjectNo ORDER BY result.examDate DESC")
    List<Result> getResultList();
    @Delete("delete from result where resultNo=#{resultNo}")
    int deleteResult(Integer resultNo);
    @Update("update result set studentResult=#{studentResult} where resultNo=#{resultNo}")
    int updateResult(Result result);
}

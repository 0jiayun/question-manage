package com.example.questionairmanage.dao;

import com.example.questionairmanage.model.Admin;
import com.example.questionairmanage.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author Acloud
 * @message
 * @date 2021/4/26 11:39
 **/
@Mapper
@Repository
public interface AdminDao {
    /**
     * 查找管理员
     * @param username
     * @return
     */
    Admin selectAdmin(String username);

    Integer insertAdmin(Admin admin);

    Integer getQuestionMaxId();

    ArrayList<Question> listQuestion(@Param("name") String name, @Param("start")Integer start, @Param("number") Integer number);

    Integer insertQuestion(Question question);

    Integer updateQuestion(Question question);

    Integer getQuestionCount();

    Integer deleteQuestion(@Param("id") Integer id);
}

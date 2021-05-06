package com.example.questionairmanage.service;

import com.example.questionairmanage.model.Admin;
import com.example.questionairmanage.model.Question;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Acloud
 * @message
 * @date 2021/4/26 11:33
 **/
public interface AdminService {
    Admin selectAdmin(String username);
    Integer insertAdmin(Admin admin);
    Map<String,Object> listQuestion(String name,Integer page,Integer limit);
    Integer insertQuestion(Question question);
    Integer updateQuestion(Question question);

    Integer deleteQuestion(Integer id);
}

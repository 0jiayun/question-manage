package com.example.questionairmanage.service.impl;

import com.example.questionairmanage.dao.AdminDao;
import com.example.questionairmanage.model.Admin;
import com.example.questionairmanage.model.Question;
import com.example.questionairmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Acloud
 * @message
 * @date 2021/4/26 11:36
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin selectAdmin(String username) {
        return adminDao.selectAdmin(username);
    }

    @Override
    public Integer insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    @Override
    public Map<String,Object> listQuestion(String name,Integer page,Integer limit) {
        HashMap<String,Object> map = new HashMap<>();
        ArrayList<Question> list =  adminDao.listQuestion(name,page,limit);
        int code = 0;
        String msg = "success";
        if (list == null ){
            code = 1;
            msg = "fail";
        }
        map.put("code",code);
        map.put("msg",msg);
        map.put("count",adminDao.getQuestionCount());
        map.put("data",list);


        return map;
    }

    @Override
    public Integer insertQuestion(Question question) {
        Integer nowId = adminDao.getQuestionMaxId()+1;
        question.setId(nowId);
        return adminDao.insertQuestion(question);
    }

    @Override
    public Integer updateQuestion(Question question) {
        return adminDao.updateQuestion(question);
    }

    @Override
    public Integer deleteQuestion(Integer id) {
        return adminDao.deleteQuestion(id);
    }
}

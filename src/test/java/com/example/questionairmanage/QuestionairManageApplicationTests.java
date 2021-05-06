package com.example.questionairmanage;

import com.example.questionairmanage.dao.AdminDao;
import com.example.questionairmanage.model.Admin;
import com.example.questionairmanage.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest

class QuestionairManageApplicationTests {

    @Autowired
    AdminDao adminDao;
    @Test
    void contextLoads() {
        Question question = new Question(51,"test2");
        System.out.println(adminDao.updateQuestion(question));
    }

}

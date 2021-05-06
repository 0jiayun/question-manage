package com.example.questionairmanage.model;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author honzooban
 * @version 1.0.0
 * @ClassName Question.java
 * @Description
 * @createTime 2020年03月29日 18:33:00
 */
public class Question {

    @Excel(name = "编号id" , orderNum = "0")
    private Integer id;

    @Excel(name = "问题内容",orderNum = "0")
    private String question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Question() {
    }
}

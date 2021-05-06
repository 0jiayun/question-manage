package com.example.questionairmanage.controller;

import com.example.questionairmanage.common.CommonResult;
import com.example.questionairmanage.common.ResultCodeEnum;
import com.example.questionairmanage.model.Admin;
import com.example.questionairmanage.model.Question;
import com.example.questionairmanage.service.AdminService;
import com.example.questionairmanage.util.FileUtil;
import com.example.questionairmanage.util.vaild.CommonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Acloud
 * @message
 * @date 2021/4/26 11:37
 **/
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public CommonResult login(@RequestBody Admin admin, HttpSession httpSession){
        Admin adminResult = adminService.selectAdmin(admin.getUsername());
        if (adminResult==null){
            return CommonResult.failed(ResultCodeEnum.FAILED,"账号名错误");
        }
        if (!adminResult.getPassword().equals(admin.getPassword())){
            return CommonResult.failed(ResultCodeEnum.FAILED,"密码错误");
        }
        httpSession.setAttribute("loginUser",adminResult.getUsername());

        return CommonResult.success("登陆成功",adminResult);
    }

    @RequestMapping("loginOut")
    public CommonResult loginOut(HttpSession httpSession){
        httpSession.removeAttribute("loginUser");

        return CommonResult.success("success");
    }

    @GetMapping("getQuestions")
    public Map<String,Object> getQuestions(@RequestParam(name = "limit", required = false) Integer limit,
                                           @RequestParam(name = "page", required = false) Integer page,
                                           @RequestParam(name="name",required = false) String name){
        if(limit==null||page==null) {
            page=null;
            limit=null;
        } else {
            page=(page-1)*limit;
        }

        return adminService.listQuestion(name,page,limit);
    }

    @PostMapping("insertQuestion")
    public CommonResult insertQuestion(@RequestBody Question question){

        return adminService.insertQuestion(question)==1 ? CommonResult.success("新增问题成功") :
                CommonResult.failed(ResultCodeEnum.FAILED, "新增问题失败，请重试");
    }

    @PostMapping("updateQuestion")
    public CommonResult updateQuestion(@RequestBody Question question){

        return adminService.updateQuestion(question)==1 ? CommonResult.success("更新问题成功") :
                CommonResult.failed(ResultCodeEnum.FAILED, "更新问题失败，请重试");
    }

    @PostMapping("insertAdmin")
    public CommonResult insertAdmin(@RequestBody Admin admin){

        Admin adminResult = adminService.selectAdmin(admin.getUsername());
        if (adminResult!=null){
            return CommonResult.failed(ResultCodeEnum.FAILED,"注册失败，账号已存在");
        }

        return adminService.insertAdmin(admin)==1 ? CommonResult.success("注册成功") :
                CommonResult.failed(ResultCodeEnum.FAILED, "注册失败，请重试");
    }
    @RequestMapping("/delete")
    @ResponseBody
    public CommonResult deleteUser(@RequestParam("id") int id){
        return adminService.deleteQuestion(id)==1 ? CommonResult.success("删除成功") :
                CommonResult.failed(ResultCodeEnum.FAILED, "删除失败，请重试");
    }

    @RequestMapping("export")
    @ResponseBody
    public void export(HttpServletResponse response){
        Map<String,Object> map=adminService.listQuestion(null,null,null);
        List<Question> list = (ArrayList<Question>)map.get("data");
        FileUtil.exportExcel(list,null,null,Question.class,"问卷数据表.xls",true,response);


        //TODO 保存数据库
    }
}

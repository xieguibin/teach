package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
 /**
   * @作者：解贵斌
   *@时间：2018/12/20  11:09
   *@描述：学生管理的控制器
  */
@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController{
    @Resource
    private StudentService studentService;
    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }
    @RequestMapping("/index")
    public String index() {
        String studentName= (String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null){
            return "/student/index";
        }else {
            return REDIRECT+":/stu/login";
        }
    }
    //updateStudent
    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public String updateStudent() {
        String xuehao=getRequest().getParameter("stuNo");
        Integer stuNo=Integer.parseInt(xuehao);
        String stuName=getRequest().getParameter("stuName");
        String stuPwd=getRequest().getParameter("stuPwd");
        String stuPhone=getRequest().getParameter("stuPhone");
        Student student = new Student();
        student.setStudentNo(stuNo);
        student.setLoginPwd(stuPwd);
        student.setStudentName(stuName);
        student.setPhone(stuPhone);
        int result=studentService.updateStudent(student);
        if (result>0){
            return FORWARD+":/stu/student";
        }
            return  FORWARD+":/stu/student";
    }



    @RequestMapping(value="/student")
    public String student() {
        return "/student/student";
    }


    @RequestMapping(value="/getStudentList",method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentList() {
        List<Student> list=studentService.getStudent();
        return list;
    }

    @RequestMapping(value="/deleteStudent/{stuNo}",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteStudent(@PathVariable Integer stuNo) {
        int result=studentService.deleteStudent(stuNo);
        if (result>0){
            return JsonResult.ok("删除成功",result);
        }
        return JsonResult.no("删除失败",result);
    }

    @RequestMapping("/logout")
    public String logout() {
        getSession().removeAttribute(SESSION_KEY);
        return REDIRECT+":/stu/login";
    }
    //请求的url：http://localhost:8080/stu/login
    @PostMapping("doLogin")
    public String doLogin() {
        String xuehao=getRequest().getParameter("studentNo");
        Integer studentNo=Integer.parseInt(xuehao);
        String loginPwd=getRequest().getParameter("loginPwd");
        Student student = new Student();
        student.setLoginPwd(loginPwd);
        student.setStudentNo(studentNo);
        Student student1 = studentService.doLogin(student);
        if(student1!=null){
            getSession().setAttribute(SESSION_KEY,student1.getStudentName());
            return FORWARD+":/stu/index";
        }else {
            return REDIRECT+":/stu/login ";
        }







    }


     //getStuByNo


     @GetMapping("/getStuByNo/{studentNo}")
     @ResponseBody
     public Object getStuByNo(@PathVariable Integer studentNo) {
        Student student = studentService.getStuByNo(studentNo);
        if (student!=null){
            return JsonResult.ok("有该学生",student);
        }
         return JsonResult.ok("没有该学生",student);
     }
 }

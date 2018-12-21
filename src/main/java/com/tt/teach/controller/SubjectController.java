package com.tt.teach.controller;

import com.tt.teach.pojo.Grade;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.SubjectService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sub")
public class SubjectController extends JsonResult{
    @Resource
    private SubjectService subjectService;

    @RequestMapping("/subject")
    public String subject(Model model) {
        List<Grade> list = subjectService.getGradeList();
        model.addAttribute("gradeList",list);
        return "/subject/subject";
    }

    @GetMapping("/getSubjectList")
    @ResponseBody
    public Object getSubjectList() {
       List<Subject> list = subjectService.getSubjectList();
        return list;
    }
    @DeleteMapping("/deleteSubject/{subjectNo}")
    @ResponseBody
    public Object deleteSubject(@PathVariable Integer subjectNo) {
        int result=subjectService.deleteSubject(subjectNo);
        if (result>0){
            return JsonResult.ok("删除成功",result);
        }
        return JsonResult.no("删除失败",result);
    }

    @PutMapping("/updateSubject")
    @ResponseBody
    public Object updateSubject(@RequestParam Integer subjectNo,@RequestParam String subjectName, @RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setClassHour(classHour);
        subject.setSubjectName(subjectName);
        subject.setSubjectNo(subjectNo);
        int result=subjectService.updateSubject(subject);
        if (result>0){
            return JsonResult.ok("修改成功",result);
        }
        return JsonResult.no("修改失败",result);
    }

    @PutMapping("/addSubject")
    @ResponseBody
    public Object addSubject(@RequestParam Integer gradeID,@RequestParam String subjectName, @RequestParam Integer classHour) {
        Subject subject = new Subject();
        subject.setClassHour(classHour);
        subject.setSubjectName(subjectName);
        subject.setGradeID(gradeID);
        int result=subjectService.addSubject(subject);
        if (result>0){
            return JsonResult.ok("添加成功",result);
        }
        return JsonResult.no("添加失败",result);
    }




}

package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.pojo.Student;
import com.tt.teach.pojo.Subject;
import com.tt.teach.service.ResultService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/result")
    public String toString(Model model) {
        List<Subject> list = resultService.getSubject();
        model.addAttribute("subjectList",list);
        return "/result/result";
    }










    @GetMapping("/getResultList")
    @ResponseBody
    public Object getResultList() {
        List<Result> list=resultService.getResultList();
        return list;
    }
    @DeleteMapping("/deleteResult/{resultNo}")
    @ResponseBody
    public Object deleteResult(@PathVariable Integer resultNo) {
        int result = resultService.deleteResult(resultNo);
        if(result>0){
            return JsonResult.ok("删除成功",result);
        }
        return JsonResult.no("删除失败",result);
    }
    @PutMapping("/updateResult")
    @ResponseBody
    public Object updateResult(@RequestParam Integer resultNo,@RequestParam Integer studentResult) {
        Result result = new Result();
        result.setResultNo(resultNo);
        result.setStudentResult(studentResult);
        int result1 = resultService.updateResult(result);
        if(result1>0){
            return JsonResult.ok("修改成功",result);
        }
        return JsonResult.no("修改失败",result);
    }

    @PutMapping("/addResult")
    @ResponseBody
    public Object addResult(@RequestParam Integer studentNo, @RequestParam Integer studentResult, @RequestParam Integer subjectNo, @RequestParam String examDate) throws ParseException {
        Result result = new Result();
        result.setStudentNo(studentNo);
        result.setSubjectNo(subjectNo);
        result.setStudentResult(studentResult);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result.setExamDate(simpleDateFormat.parse(examDate));

        int result2 = resultService.addResult(result);
        if(result2>0){
            return JsonResult.ok("添加成功",result);
        }
        return JsonResult.no("添加失败",result);
    }




}

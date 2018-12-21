package com.tt.teach.controller;

import com.tt.teach.pojo.Result;
import com.tt.teach.service.ResultService;
import com.tt.teach.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/res")
public class ResultController {
    @Resource
    private ResultService resultService;

    @RequestMapping("/result")
    public String toString() {
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


}

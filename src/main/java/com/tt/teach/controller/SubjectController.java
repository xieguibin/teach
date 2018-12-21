package com.tt.teach.controller;

import com.tt.teach.service.SubjectService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class SubjectController {
    @Resource
    private SubjectService subjectService;

}

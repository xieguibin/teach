package com.tt.teach.service;

import com.tt.teach.pojo.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentService {
    Student doLogin(Student student);

    List<Student> getStudent();

    int updateStudent(Student student);

    int deleteStudent(Integer stuNo);
}

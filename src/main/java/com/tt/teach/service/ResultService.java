package com.tt.teach.service;

import com.tt.teach.pojo.Result;

import java.util.List;

public interface ResultService {

    List<Result> getResultList();

    int deleteResult(Integer resultNo);

    int updateResult(Result result);
}

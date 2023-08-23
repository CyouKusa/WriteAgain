package com.example.writeagain.mapper;

import com.example.writeagain.javabean.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface ExcelToSQLMapper {
    int findIdByTitle(String fatherName);

    int save(Subject subject);

    int saves(List<Subject> list);

    int lastInsertId();
}

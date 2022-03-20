package com.wuguan.dao;

import com.wuguan.dto.Student;

import java.sql.Connection;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/14 11:19
 * @description
 */
public class StudentDao implements BaseDao<Student> {
    Connection c = null;

    public StudentDao(Connection c) {
        this.c = c;
    }


    @Override
    public boolean insert(Student student) {
        return false;
    }

    @Override
    public boolean delete(Student student) {
        return false;
    }

    @Override
    public boolean delById(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public Student findOne(Student student) {
        return null;
    }

    @Override
    public List<Student> findAll(Student student) {
        return null;
    }
}

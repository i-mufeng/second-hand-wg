package com.wuguan.dao;

import com.wuguan.dto.Teacher;

import java.sql.Connection;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/14 11:24
 * @description 教师
 */
public class TeacherDao implements BaseDao<Teacher> {

    Connection c = null;

    public TeacherDao(Connection c) {
        this.c = c;
    }

    @Override
    public boolean insert(Teacher teacher) {
        return false;
    }

    @Override
    public boolean delete(Teacher teacher) {
        return false;
    }

    @Override
    public boolean update(Teacher teacher) {
        return false;
    }

    @Override
    public Teacher findOne(Teacher teacher) {
        return null;
    }

    @Override
    public List<Teacher> findAll(Teacher teacher) {
        return null;
    }
}

package com.wuguan.dao;

import com.wuguan.dto.Admin;
import com.wuguan.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/14 19:05
 * @description
 */
public class AdminDao implements BaseDao<Admin> {

    Connection c =null;
    public AdminDao(Connection c){
        this.c=c;
    }

    @Override
    public boolean insert(Admin admin) {
        return false;
    }

    @Override
    public boolean delete(Admin admin) {
        return false;
    }

    @Override
    public boolean delById(Integer integer) {
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        return false;
    }

    @Override
    public Admin findOne(Admin admin) {
        String sql= "select name,password from boss where name=?";
        try {
            return DBUtil.queryOne(new DBUtil.CallBack<Admin>() {
                @Override
                public Admin getData(ResultSet rs) {
                    Admin b = null;
                    try {
                        if (rs.next()) {
                            b = new Admin();
                            b.setName(rs.getString("name"));
                            b.setPassWord(rs.getString("passWord"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return b;
                }
            }, sql, admin.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> findAll(Admin admin) {
        return null;
    }
}

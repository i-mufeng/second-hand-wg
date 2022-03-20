package com.wuguan.serviceImp;

import com.wuguan.dao.AdminDao;
import com.wuguan.dto.Admin;
import com.wuguan.dto.ResMod;
import com.wuguan.service.AdminService;
import com.wuguan.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author MFMG
 * @data 2022/01/14 20:34
 * @description
 */
public class AdminServiceImpl implements AdminService {

    AdminDao adminDao;
    Connection connection;
    @Override
    public ResMod log(Admin admin) {
        ResMod resMod = new ResMod();
        try {
            connection = DBUtil.getConnection();
            adminDao = new AdminDao(connection);
            Admin adminB = adminDao.findOne(admin);
            if (admin.equals(adminB)) {
                resMod.setCode(0);
                resMod.setMsg("登录成功");
                resMod.setData(adminB);
            } else {
                resMod.setCode(1);
                resMod.setMsg("验证失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resMod;
    }
}

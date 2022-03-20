package com.wuguan.serviceImp;

import com.wuguan.dao.ClassDao;
import com.wuguan.dto.Classer;
import com.wuguan.dto.ResMod;
import com.wuguan.service.ClasserService;
import com.wuguan.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/15 10:53
 * @description
 */
public class ClasserServiceImpl implements ClasserService {
    ClassDao classDao;
    Connection connection;
    @Override
    public ResMod add(Classer classer) {
        ResMod resMod = new ResMod();
        try {
            connection = DBUtil.getConnection();
            classDao = new ClassDao(connection);
            boolean insert = classDao.insert(classer);
            if (insert) {
                resMod.setCode(1);
                resMod.setMsg("添加成功");
                resMod.setData(classer);
            } else {
                resMod.setCode(0);
                resMod.setMsg("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resMod;
    }

    @Override
    public ResMod delById(int id) {
        ResMod resMod = new ResMod();
        try {
            Classer classer = new Classer(id, "");
            connection = DBUtil.getConnection();
            classDao = new ClassDao(connection);
            boolean delete = classDao.delete(classer);
            if (delete) {
                resMod.setCode(1);
                resMod.setMsg("删除成功");
                resMod.setData(classer);
            } else {
                resMod.setCode(0);
                resMod.setMsg("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resMod;
    }

    @Override
    public ResMod update(Classer classer) {
        ResMod resMod = new ResMod();
        try {
            connection = DBUtil.getConnection();
            ClassDao classDao = new ClassDao(connection);
            boolean update = classDao.update(classer);
            if (update) {
                resMod.setCode(1);
                resMod.setMsg("修改成功");
                resMod.setData(classer);
            } else {
                resMod.setCode(0);
                resMod.setMsg("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resMod;
    }

    @Override
    public ResMod findOne(Classer classer) {
        return null;
    }

    @Override
    public ResMod findAll() {
        ResMod resMod = new ResMod();
        ClassDao classDao = new ClassDao(null);
        List<Classer> classers = classDao.findAll(new Classer());
        if (classers != null && classers.size() > 0) {
            resMod.setCode(1);
            resMod.setMsg("获取商品成功");
            resMod.setData(classers);

        } else {
            resMod.setCode(1);
            resMod.setMsg("还未添加班级");
        }
        return resMod;
    }
}

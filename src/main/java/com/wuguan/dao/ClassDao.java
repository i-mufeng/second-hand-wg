package com.wuguan.dao;

import com.wuguan.dto.Classer;
import com.wuguan.util.DBUtil;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/14 11:25
 * @description
 */
@AllArgsConstructor
public class ClassDao implements BaseDao<Classer> {
    Connection c = null;

    /**
     * 单独添加班级
     * @param classer 班级
     * @return 是否成功添加
     */
    @Override
    public boolean insert(Classer classer) {
        String sql = "INSERT INTO class(id,name) values(?,?)";
        try {
            return DBUtil.executeUpdate(c, sql, classer.getClassId(), classer.getClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Classer classer) {
        return false;
    }


    @Override
    public boolean delById(Integer id) {
        String sql = "DELETE FROM class WHERE ID=?";
        try {
            return DBUtil.executeUpdate(c, sql, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Classer classer) {
        String sql = "update class set id=?, name=? where id=?";
        try{
            return DBUtil.executeUpdate(c,sql,classer.getClassId(),classer.getClassName(), classer.getClassId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Classer findOne(Classer classer) {
        return null;
    }

    @Override
    public List<Classer> findAll(Classer classer) {
        String sql = "select id,name from class";
        List<Classer> classerList = new ArrayList<Classer>();
        try {
            DBUtil.queryList(new DBUtil.CallBack<Classer>() {
                @Override
                public List<Classer> getDatas(ResultSet rs) {
                    try {
                        while (rs.next()) {
                            Classer classer1 = new Classer();
                            classer1.setClassId(rs.getInt("id"));
                            classer1.setClassName(rs.getString("name"));
                            classerList.add(classer1);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return classerList;
                }
            },sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classerList;
    }
}

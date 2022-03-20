package com.wuguan.dao;

import java.util.List;

/**
 * @author MFMG
 * @data 2022/01/14 11:17
 * @description 基本增删改查
 */
public interface BaseDao<T> {
    public boolean insert(T t);

    public boolean delete(T t);

    public boolean delById(Integer integer);

    public boolean update(T t);

    public T findOne(T t);

    public List<T> findAll(T t);
}

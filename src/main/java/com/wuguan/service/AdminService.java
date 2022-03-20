package com.wuguan.service;

import com.wuguan.dto.Admin;
import com.wuguan.dto.ResMod;

/**
 * @author MFMG
 * @data 2022/01/14 20:32
 * @description
 */
public interface AdminService {
    /**
     * Boss登录
     * @param admin admin
     * @return 是否登录成功
     */
    public ResMod log(Admin admin);
}

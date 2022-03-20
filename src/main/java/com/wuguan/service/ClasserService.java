package com.wuguan.service;

import com.wuguan.dto.Classer;
import com.wuguan.dto.ResMod;

/**
 * @author MFMG
 * @data 2022/01/14 18:32
 * @description
 */
public interface ClasserService {
    /**
     * 增加班级
     * @param classer 班级
     * @return 是否添加成功
     */
    public ResMod add(Classer classer);

    public ResMod delById(int id);

    public ResMod update(Classer classer);

    public ResMod findOne(Classer classer);
    public ResMod findAll();
}

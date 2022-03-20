package com.wuguan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MFMG
 * @data 2022/01/14 17:41
 * @description
 * 该类用于存储返回给前端的数据结果集
 * 以状态、相关提示、数据组成
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResMod {
    private int code;
    private String msg;
    private Object data;
}

package com.wuguan.dto;

import lombok.*;

/**
 * @author wuguan
 * @data 2022/01/14 19:03
 * @description 管理员
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Admin {
    private String name;
    private String passWord;
}

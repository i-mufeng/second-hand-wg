package com.wuguan.dto;

import lombok.*;

/**
 * @author WuGuan
 * @data 2022/01/14 10:52
 * @description 教师
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String terName;
    private int terId;
    private String terType;
}

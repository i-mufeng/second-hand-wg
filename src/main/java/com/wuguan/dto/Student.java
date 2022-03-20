package com.wuguan.dto;

import lombok.*;

/**
 * @author MFMG
 * @data 2022/01/14 10:55
 * @description 学员
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentName;
    private int studentId;
    private Classer studentClass;
}

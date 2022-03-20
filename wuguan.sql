/*
Source Server         : mysql
Source Server Version : 50550
Source Host           : imufeng.cn:3306
Source Database       : wuguan

Target Server Type    : MYSQL
Target Server Version : 50550
File Encoding         : 65001

Date: 2022/01/15 10:02
*/

SET FOREIGN_KEY_CHECKS=0;


DROP TABLE IF EXISTS `addr`;
CREATE TABLE `teacher`
(
    `id`   varchar(11) PRIMARY KEY ,
    `name` varchar(11)  NOT NULL,
    `type` varchar(11)  NOT NULL
) ;


DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss`
(
    `name`     varchar(11) NOT NULL,
    `passWord` varchar(11)
);
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`
(
    `id` INT(11) NOT NULL PRIMARY KEY ,
    `name` VARCHAR(11) NOT NULL
);

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id` INT(11) NOT NULL PRIMARY KEY,
    `name` VARCHAR(11) NOT NULL
);


INSERT INTO `boss` SET name="admin",passWord="admin";

INSERT INTO `student`(id, name) values(20220001, "张三");
INSERT INTO `student`(id, name) values(20220002, "李四");
INSERT INTO `student`(id, name) values(20220003, "王五");

INSERT INTO `teacher`(id, name, type) values(10001, "张老师","健美老师");
INSERT INTO `teacher`(id, name, type) values(10002, "李老师","舞蹈老师");
INSERT INTO `teacher`(id, name, type) values(10003, "王老师","拳击老师");

INSERT INTO `class`(id, name) values(201, "健美班");
INSERT INTO `class`(id, name) values(202, "拳击班");
INSERT INTO `class`(id, name) values(203, "舞蹈班");


update class set id=206, name="形体1班" where id=206;

SELECT *
FROM class;






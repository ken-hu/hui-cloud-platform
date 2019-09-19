CREATE DATABASE `hui_cloud_auth` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

DROP TABLE IF EXISTS `t_auth_client_detail`;
CREATE TABLE `t_uc_sys_user` (
	`clientId` BIGINT ( 20 ) NOT NULL COMMENT '用户ID',
	`clientSecret` VARCHAR ( 50 ) NULL COMMENT '用户密码',
	`user_name` VARCHAR ( 50 ) NULL COMMENT '用户名',
	`deleted` INT ( 2 ) NULL COMMENT '是否逻辑删除 1：已删除 0：未删除',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
	PRIMARY KEY ( `user_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户表';

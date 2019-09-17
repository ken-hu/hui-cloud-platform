CREATE DATABASE `hui_cloud_uc` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

DROP TABLE IF EXISTS `t_uc_user`;
CREATE TABLE `t_uc_user` (
	`user_id` BIGINT ( 20 ) NOT NULL COMMENT '用户ID',
	`password` VARCHAR ( 50 ) NULL COMMENT '用户密码',
	`user_name` VARCHAR ( 50 ) NULL COMMENT '用户名',
	`deleted` INT ( 2 ) NULL COMMENT '是否逻辑删除 1：已删除 0：未删除',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
	PRIMARY KEY ( `user_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户表';

DROP TABLE IF EXISTS `t_uc_role`;
CREATE TABLE `t_uc_role` (
	`role_id` BIGINT ( 20 ) NOT NULL COMMENT '角色ID',
	`role_code` VARCHAR ( 50 ) NULL COMMENT '角色代码',
	`role_name` VARCHAR ( 50 ) NULL COMMENT '角色名字',
	`deleted` INT ( 2 ) NULL COMMENT '是否逻辑删除 1：已删除 0：未删除',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
	PRIMARY KEY ( `role_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色表';

DROP TABLE IF EXISTS `t_uc_resource`;
CREATE TABLE `t_uc_resource` (
	`resource_id` BIGINT ( 20 ) NOT NULL COMMENT '资源ID',
	`resource_code` VARCHAR ( 50 ) NULL COMMENT '资源代码',
	`resource_name` VARCHAR ( 50 ) NULL COMMENT '资源名字',
	`resource_type` VARCHAR ( 50 ) NULL COMMENT '资源类型',
	`resource_uri` VARCHAR ( 50 ) NULL COMMENT '资源URI',
	`deleted` INT ( 2 ) NULL COMMENT '是否逻辑删除 1：已删除 0：未删除',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `resource_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '资源表';
CREATE DATABASE `hui_cloud_uc` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

DROP TABLE IF EXISTS `t_uc_sys_user`;
CREATE TABLE `t_uc_sys_user` (
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


DROP TABLE IF EXISTS `t_uc_sys_role`;
CREATE TABLE `t_uc_sys_role` (
	`role_id` BIGINT ( 20 ) NOT NULL COMMENT '角色ID',
	`role_code` VARCHAR ( 50 ) NULL COMMENT '角色代码',
	`role_name` VARCHAR ( 50 ) NULL COMMENT '角色名字',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
	PRIMARY KEY ( `role_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色表';

DROP TABLE IF EXISTS `t_uc_sys_user_role_ref`;
CREATE TABLE `t_uc_sys_user_role_ref` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '主键ID自增',
	`user_id` VARCHAR ( 50 ) NULL COMMENT '用户ID',
	`role_id` VARCHAR ( 50 ) NULL COMMENT '角色ID',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户-角色-关联表';

DROP TABLE IF EXISTS `t_uc_sys_resource`;
CREATE TABLE `t_uc_sys_resource` (
	`resource_id` BIGINT ( 20 ) NOT NULL COMMENT '资源ID',
	`resource_code` VARCHAR ( 50 ) NULL COMMENT '资源代码',
	`resource_name` VARCHAR ( 50 ) NULL COMMENT '资源名字',
	`resource_type` VARCHAR ( 50 ) NULL COMMENT '资源类型',
	`resource_uri` VARCHAR ( 50 ) NULL COMMENT '资源URI',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `resource_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '资源表';

DROP TABLE IF EXISTS `t_uc_sys_permission`;
CREATE TABLE `t_uc_sys_permission` (
	`permission_id` BIGINT ( 20 ) NOT NULL COMMENT '权限ID',
	`permission_code` VARCHAR ( 50 ) NULL COMMENT '权限代码',
	`permission_name` VARCHAR ( 50 ) NULL COMMENT '权限名字',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `permission_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '权限表';

DROP TABLE IF EXISTS `t_uc_sys_resource_permission_ref`;
CREATE TABLE `t_uc_sys_role_group_ref` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '主键ID自增',
	`resource_id` VARCHAR ( 50 ) NULL COMMENT '资源ID',
	`permission_id` VARCHAR ( 50 ) NULL COMMENT '权限ID',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '资源-权限-关联表';

DROP TABLE IF EXISTS `t_uc_sys_group`;
CREATE TABLE `t_uc_sys_group` (
	`group_id` BIGINT ( 20 ) NOT NULL COMMENT '组ID',
	`group_code` VARCHAR ( 50 ) NULL COMMENT '组代码',
	`group_name` VARCHAR ( 50 ) NULL COMMENT '组名字',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `group_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '组表';

DROP TABLE IF EXISTS `t_uc_sys_user_group_ref`;
CREATE TABLE `t_uc_sys_user_group_ref` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '主键ID自增',
	`user_id` VARCHAR ( 50 ) NULL COMMENT '用户ID',
	`group_id` VARCHAR ( 50 ) NULL COMMENT '用户组ID',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '用户-组-关联表';

DROP TABLE IF EXISTS `t_uc_sys_role_group_ref`;
CREATE TABLE `t_uc_sys_role_group_ref` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT '主键ID自增',
	`role_id` VARCHAR ( 50 ) NULL COMMENT '角色ID',
	`group_id` VARCHAR ( 50 ) NULL COMMENT '组ID',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT '角色-组-关联表';
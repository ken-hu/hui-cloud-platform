CREATE DATABASE `hui_cloud_auth` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

DROP TABLE IF EXISTS `t_auth_client_detail`;
CREATE TABLE `t_auth_client_detail` (
	`client_id` VARCHAR ( 200 ) NOT NULL COMMENT '客户端ID',
	`resource_ids` VARCHAR ( 200 ) NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
	`client_secret` VARCHAR ( 200 ) NULL COMMENT '客户端密匙',
	`scope` VARCHAR ( 200 ) NULL COMMENT '客户端申请的权限范围',
	`authorized_grant_types` VARCHAR ( 200 ) NULL COMMENT ' 客户端支持的grant_type',
	`web_server_redirect_uri` VARCHAR ( 200 ) NULL COMMENT ' 重定向URI',
	`authorities` VARCHAR ( 200 ) NULL COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
	`access_token_validity` INT ( 11 ) NULL COMMENT '访问令牌有效时间值(单位:秒)',
	`refresh_token_validity` INT ( 11 ) NULL COMMENT '更新令牌有效时间值(单位:秒)',
	`additional_information` VARCHAR ( 200 ) NULL COMMENT '预留字段',
	`autoapprove` VARCHAR ( 200 ) NULL COMMENT '用户是否自动Approval操作',
	PRIMARY KEY ( `client_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT 'Oauth客户端表';

DROP TABLE IF EXISTS `t_auth_approvals_detail`;
CREATE TABLE `t_auth_approvals_detail` (
	`user_id` VARCHAR ( 200 ) NOT NULL COMMENT '客户端ID',
	`client_id` VARCHAR ( 200 ) NULL COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
	`scope` VARCHAR ( 200 ) NULL COMMENT '客户端密匙',
	`status` VARCHAR ( 200 ) NULL COMMENT '客户端申请的权限范围',
	`expiresat` VARCHAR ( 200 ) NULL COMMENT ' 客户端支持的grant_type',
	`lastmodifiedat` VARCHAR ( 200 ) NULL COMMENT ' 重定向URI',
	PRIMARY KEY ( `client_id` ) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT 'Oauth客户端表';
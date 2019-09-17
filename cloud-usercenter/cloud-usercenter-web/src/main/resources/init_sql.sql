CREATE TABLE `t_uc_user` (
	`user_id` BIGINT (20) NOT NULL COMMENT '用户ID',
	`password` VARCHAR (50) NULL COMMENT '用户密码',
	`user_name` VARCHAR (50) NULL COMMENT '用户名',
	`create_time` datetime ( 0 ) NULL COMMENT '创建时间',
	`create_user` VARCHAR ( 50 ) NULL COMMENT '创建用户',
	`modify_time` datetime ( 0 ) NULL COMMENT '修改时间',
	`modify_user` VARCHAR ( 50 ) NULL COMMENT '修改用户',
	PRIMARY KEY ( `user_id` ) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表'

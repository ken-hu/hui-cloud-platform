-- t_uc_sys_user
INSERT INTO t_uc_sys_user(user_id, user_name, password, deleted , create_time, create_user, modify_time, modify_user)VALUES ('1','user1','user',0,'2019-01-01 00:00:00','gary.hu','2019-01-01 00:00:00','gary.hu');
INSERT INTO t_uc_sys_user(user_id, user_name, password, deleted , create_time, create_user, modify_time, modify_user)VALUES ('2','user2','user',0,'2019-01-01 00:00:00','gary.hu','2019-01-01 00:00:00','gary.hu');
INSERT INTO t_uc_sys_user(user_id, user_name, password, deleted , create_time, create_user, modify_time, modify_user)VALUES ('3','user3','user',0,'2019-01-01 00:00:00','gary.hu','2019-01-01 00:00:00','gary.hu');
INSERT INTO t_uc_sys_user(user_id, user_name, password, deleted , create_time, create_user, modify_time, modify_user)VALUES ('4','user4','user',0,'2019-01-01 00:00:00','gary.hu','2019-01-01 00:00:00','gary.hu');
INSERT INTO t_uc_sys_user(user_id, user_name, password, deleted , create_time, create_user, modify_time, modify_user)VALUES ('5','user5','user',0,'2019-01-01 00:00:00','gary.hu','2019-01-01 00:00:00','gary.hu');

-- t_uc_sys_role
INSERT INTO t_uc_sys_role(role_id, role_code, role_name, create_time, create_user, modify_time, modify_user) VALUES ('1', 'R1', 'role1', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role(role_id, role_code, role_name, create_time, create_user, modify_time, modify_user) VALUES ('2', 'R2', 'role2', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role(role_id, role_code, role_name, create_time, create_user, modify_time, modify_user) VALUES ('3', 'R3', 'role3', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role(role_id, role_code, role_name, create_time, create_user, modify_time, modify_user) VALUES ('4', 'R4', 'role4', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role(role_id, role_code, role_name, create_time, create_user, modify_time, modify_user) VALUES ('5', 'R5', 'role5', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_permission
INSERT INTO t_uc_sys_permission(permission_id, permission_code, permission_name, create_time, create_user, modify_time, modify_user) VALUES ('1', 'P1', 'permission1', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_permission(permission_id, permission_code, permission_name, create_time, create_user, modify_time, modify_user) VALUES ('2', 'P2', 'permission2', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_permission(permission_id, permission_code, permission_name, create_time, create_user, modify_time, modify_user) VALUES ('3', 'P3', 'permission3', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_permission(permission_id, permission_code, permission_name, create_time, create_user, modify_time, modify_user) VALUES ('4', 'P4', 'permission4', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_permission(permission_id, permission_code, permission_name, create_time, create_user, modify_time, modify_user) VALUES ('5', 'P5', 'permission5', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_group
INSERT INTO t_uc_sys_group(group_id, group_code, group_name, create_time, create_user, modify_time, modify_user) VALUES ('1', 'G1', 'group1', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_group(group_id, group_code, group_name, create_time, create_user, modify_time, modify_user) VALUES ('2', 'G2', 'group2', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_group(group_id, group_code, group_name, create_time, create_user, modify_time, modify_user) VALUES ('3', 'G3', 'group3', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_group(group_id, group_code, group_name, create_time, create_user, modify_time, modify_user) VALUES ('4', 'G4', 'group4', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_group(group_id, group_code, group_name, create_time, create_user, modify_time, modify_user) VALUES ('5', 'G5', 'group5', '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_resource
INSERT INTO t_uc_sys_resource(resource_id, resource_code, resource_name, resource_type, resource_uri, create_time, create_user, modify_time, modify_user) VALUES ('1', 'Re1', 'resource1','MENU', '/usercenter-service',  '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource(resource_id, resource_code, resource_name, resource_type, resource_uri, create_time, create_user, modify_time, modify_user) VALUES ('2', 'Re2', 'resource2','ELEMENT', '/usercenter-service/sys',  '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource(resource_id, resource_code, resource_name, resource_type, resource_uri, create_time, create_user, modify_time, modify_user) VALUES ('3', 'Re3', 'resource3','FILE', '',  '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource(resource_id, resource_code, resource_name, resource_type, resource_uri, create_time, create_user, modify_time, modify_user) VALUES ('4', 'Re4', 'resource4','DATA', '',  '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource(resource_id, resource_code, resource_name, resource_type, resource_uri, create_time, create_user, modify_time, modify_user) VALUES ('5', 'Re5', 'resource5','MENU', '/auth-service',  '2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_user_role_rel
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('1','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('1','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('1','3','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('2','3','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('2','4','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_role_rel(user_id, role_id, create_time, create_user, modify_time, modify_user) VALUES ('2','5','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_user_group_rel
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('1','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('2','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('3','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('3','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('4','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_user_group_rel(user_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('5','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_resource_permission_rel
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('1','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('2','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('3','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('3','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('4','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_resource_permission_rel(resource_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('5','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_role_permission_rel
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('1','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('1','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('1','3','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('2','3','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('2','4','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_permission_rel(role_id, permission_id, create_time, create_user, modify_time, modify_user) VALUES ('2','5','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');

-- t_uc_sys_role_group_rel
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('1','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('2','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('3','1','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('3','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('4','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');
INSERT INTO t_uc_sys_role_group_rel(role_id, group_id, create_time, create_user, modify_time, modify_user) VALUES ('5','2','2019-01-01 00:00:00', 'gary.hu', '2019-01-01 00:00:00', 'gary.hu');


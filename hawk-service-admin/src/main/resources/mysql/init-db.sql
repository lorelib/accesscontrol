INSERT INTO sys_menu(id, parentId, menuName, menuAlias, description) VALUES(1, -1, '统计分析', 'statistics', '统计');
INSERT INTO sys_menu(id, parentId, menuName, menuAlias) VALUES(2, 1, '客户业务量统计', 'biz_volume_statistics');
INSERT INTO sys_menu(id, parentId, menuName, menuAlias) VALUES(3, 1, '自动估价服务统计', 'auto_enquiry_statistics');

INSERT INTO sys_menu(id, parentId, menuName, menuAlias, description) VALUES(4, -1, '数据管理', 'data_management', '数据管理');

INSERT INTO sys_menu(id, parentId, menuName, menuAlias, description) VALUES(5, -1, '系统管理', 'sys_management', '系统管理');
INSERT INTO sys_menu(id, parentId, menuName, menuAlias) VALUES(6, 5, '角色管理', 'role_management');
INSERT INTO sys_menu(id, parentId, menuName, menuAlias) VALUES(7, 5, '用户管理', 'user_management');
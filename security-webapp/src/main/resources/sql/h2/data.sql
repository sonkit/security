INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (1,NULL,'root','root',NULL,NULL,'root',NULL);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (2,'组织1','组织1','组织1','组织1','省级机构','组织1',1);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (3,'组织2','组织2','组织2','组织2','市级机构','组织2',1);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (4,'组织3','组织3','组织3','组织3','县级机构','组织3',1);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (5,'组织4','组织4','组织4','组织4','部门','组织4',1);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (6,'组织5','组织5','组织5','组织5','省级机构','组织5',1);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (8,'组织1.1','组织1.1','组织1.1','组织1.1','部门','组织1.1',2);
INSERT INTO `sec_orga` (`id`,`address`,`code`,`description`,`districtCode`,`orgaType`,`text`,`parent_id`) VALUES (9,'组织5.1','组织5.1','组织5.1','组织5.1',NULL,'组织5.1',6);

INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (1,'root','root','root',NULL);
INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (2,'系统资源1','系统资源1','系统资源1',1);
INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (3,'系统资源2','系统资源2','系统资源2',1);
INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (4,'系统资源3','系统资源3','系统资源3',1);
INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (5,'系统资源4','系统资源4','系统资源4',1);
INSERT INTO `sec_resc` (`id`,`code`,`description`,`text`,`parent_id`) VALUES (6,'系统资源5','系统资源5','系统资源5',1);

INSERT INTO `sec_role` (`id`,`code`,`description`,`name`) VALUES (1,'角色1','角色1','角色1');
INSERT INTO `sec_role` (`id`,`code`,`description`,`name`) VALUES (2,'角色2','角色2','角色2');
INSERT INTO `sec_role` (`id`,`code`,`description`,`name`) VALUES (3,'角色3','角色3','角色3');
INSERT INTO `sec_role` (`id`,`code`,`description`,`name`) VALUES (4,'角色4','角色4','角色4');
INSERT INTO `sec_role` (`id`,`code`,`description`,`name`) VALUES (5,'角色5','角色5','角色5');

INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,1);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (1,2);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (2,2);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (3,2);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (4,2);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,2);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (2,3);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (3,3);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (4,3);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,3);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (3,4);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (4,4);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,4);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (4,5);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,5);
INSERT INTO `sec_role_resc` (`role_id`,`resc_id`) VALUES (5,6);

INSERT INTO `sec_user` (`id`,`fax`,`loginName`,`password`,`phone`,`sex`,`userCard`,`username`,`orga_id`) VALUES (1,'333','wangqiang','e10adc3949ba59abbe56e057f20f883e','222','男','111','王强',3);
INSERT INTO `sec_user` (`id`,`fax`,`loginName`,`password`,`phone`,`sex`,`userCard`,`username`,`orga_id`) VALUES (3,'5555','yaokai','c33367701511b4f6020ec61ded352059','33333','男','2222','姚楷',8);

INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (1,1);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (3,1);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (1,2);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (1,3);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (1,4);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (1,5);
INSERT INTO `sec_user_role` (`user_id`,`role_id`) VALUES (3,5);

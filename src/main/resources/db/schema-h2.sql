DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `email` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

-- DROP TABLE IF EXISTS `authorities`;
-- DROP TABLE IF EXISTS `users`;

-- --
-- -- Table structure for table `users`
-- --

-- CREATE TABLE `users` (
--   `username` varchar(50) NOT NULL,
--   `password` varchar(50) NOT NULL,
--   `enabled` tinyint NOT NULL,
--   PRIMARY KEY (`username`)
-- );

-- --
-- -- Table structure for table `authorities`
-- --

-- CREATE TABLE `authorities` (
--   `username` varchar(50) NOT NULL,
--   `authority` varchar(50) NOT NULL,
--   UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
--   CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
-- );

drop table if EXISTS `ic_alarms`;
create table ic_alarms
(
    id           bigint auto_increment primary key,
    source varchar(64) null comment '故障来源',
    content varchar(4096)  null comment '故障内容',
    submit_time  datetime  null comment '上报时间'
);


CREATE TABLE `userinfo`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `username`    varchar(64) NOT NULL COMMENT 'user name',
    `password`    varchar(64) NOT NULL,
    `create_time` datetime    NOT NULL,
    `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY `pk_id` (`id`),
    UNIQUE KEY `uk_username` (`username`)
);

INSERT userinfo (username, password, create_time) VALUE ('ms_admin', 'mangosteen', NOW());
INSERT userinfo (username, password, create_time) VALUE ('lazyben', '123456', NOW());
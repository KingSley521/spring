create table person(
    `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
    `name` varchar(64) not null default "",
    `age` int not null default 0

)ENGINE = InnoDB Character set = utf8 COLLATE = utf8_general_ci COMMENT = '人员基础信息表';
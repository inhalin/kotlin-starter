drop table if exists users;

create table users
(
    user_id    bigint      not null auto_increment,
    email      varchar(50) not null comment '이메일-로그인ID',
    name       varchar(30) not null comment '이름',
    phone      varchar(20) null comment '전화번호',
    created_at datetime    null,
    updated_at datetime    null,
    primary key (user_id),
    unique key UK_users_email (email)
)
    engine = innodb
    default character set = utf8mb4
    collate = utf8mb4_0900_ai_ci;

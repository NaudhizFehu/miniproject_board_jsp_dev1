create database board_dev1 default character set utf8;
create user 'dev1'@'localhost' identified by 'dev1';
create user 'dev1'@'%' identified by 'dev1';
grant all privileges on board_dev1.* to 'dev1'@'localhost';
grant all privileges on board_dev1.* to 'dev1'@'%';

create table board_dev1.member (
	id varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate datetime not null,
    email varchar(50) not null,
    phoneNumber1 varchar(3) not null,
    phoneNumber2 varchar(4) not null,
    phoneNumber3 varchar(4) not null
) engine=InnoDB default character set = utf8;

create table board_dev1.article (
    article_no int auto_increment primary key,
    writer_id varchar(50) not null,
    writer_name varchar(50) not null,
    title varchar(255) not null,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int,
    foreign key (writer_id) references board_dev1.member (id)
) engine=InnoDB default character set = utf8;

create table board_dev1.article_content (
    article_no int primary key,
    content text,
    foreign key (article_no) references board_dev1.article (article_no)
) engine=InnoDB default character set = utf8;
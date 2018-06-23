create table insure_info(
	insure_key int primary key auto_increment,
	insure_name varchar(30) unique not null,
	insure_code varchar(20) not null,
	insure_type int not null,
	attribute varchar(50),
	attribute1 varchar(50),
	attribute2 varchar(50)	
);


insert into insure_info values (0,'실손보험','01','01',null,null,null);
insert into insure_info values (0,'태아보험','02','01',null,null,null);
insert into insure_info values (0,'자동차보험','03','01',null,null,null);
insert into insure_info values (0,'운전자보험','04','01',null,null,null);
insert into insure_info values (0,'암보험','05','01',null,null,null);
insert into insure_info values (0,'치아보험','06','01',null,null,null);
insert into insure_info values (0,'종신보험','07','01',null,null,null);
insert into insure_info values (0,'변액연금보험','08','01',null,null,null);


drop table insure_question;

create table insure_question(
	question_id int primary key auto_increment,
	writer_id int not null,
	insure_title varchar(20) not null,
	insure_code varchar(20),
	info_open boolean not null default true,
	question_title varchar(100) not null,
	question_content varchar(2000),
	hospital_type int not null default 1,
	treatement_days int not null default 1,
	reg_date datetime not null default current_timestamp,
	last_update_date datetime not null
);

create table insure_answer(
	answer_id int primary key auto_increment,
	question_id int not null,
	consultant_id int not null,
	reg_date datetime not null default current_timestamp,
	last_update_date datetime not null 
);
answer_id	question_id	consultant_id	reg_date	last_update_date




create table member(
member_num int primary key auto_increment,
member_id varchar(50) not null unique,
member_name varchar(50) not null,
member_reg_date datetime not null default current_timestamp,
member_status varchar(20) not null default 'ACTIVE',
last_update_date datetime not null default current_timestamp,
expire_date datetime not null
);

alter table member add column class tinyint not null default 1;
alter table member add column password varchar(51) not null ;


member_num
member_id
member_name
member_reg_date
member_status  : ACTIVE, STOP, EXPIRED
last_update_date
expire_date

create table consultant(
	consultant_num int primary key auto_increment,
	consultant_id varchar(50) not null unique,	
	consultant_name varchar(50) not null,
	consultant_reg_date datetime not null default current_timestamp,
	consultant_status varchar(20) not null default 'ACTIVE',
	last_update_date datetime not null default current_timestamp,
	expire_date datetime not null,
	consultant_score int default 0,
	consultant_recommand int default 0
);






















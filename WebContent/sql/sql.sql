create table userlogin(
userid int(11) Primary Key not null,
username varchar(200) not null,
password varchar(200) not null,
role int(11) default 2);

insert into userlogin values(1,'admin',123456,0);
insert into userlogin values(2,'teacher1',123456,1);
insert into userlogin values(3,'student1',123456,2);

create table student(
userid int(11) Primary Key not null,
username varchar(200) not null,
sex varchar(10) not null,
birthyear Year not null,
gradeyear Year not null,
college varchar(200) not null,
account varchar(200) not null,
passwd varchar(200) not null);

insert into student values(1,'zz','男','2000','2019','云计算系','网络安全','student2','123456');
insert into student values(2,'aa','男','2000','2019','云计算系','大数据','student3','123456');

create table course(
crs_id int(11) Primary Key not null,
crs_code varchar(255) not null,
crs_name varchar(200) not null,
crs_time varchar(200) not null,
crs_class varchar(200) not null,
crs_teacher varchar(200) not null,
crs_address varchar(200) not null,);

insert into course(crs_code,crs_name,crs_time,crs_class,crs_teacher,crs_address) values('CC131024','Java基础','周一第3、4节{第1-9周}','18413302','姚红','二教504');
insert into course(crs_code,crs_name,crs_time,crs_class,crs_teacher,crs_address) values('CC131024','Java基础','周三第1、2节{第10周}','18413302','姚红','二教505');

create table teacher(
userid int(11) Primary Key not null,
username varchar(200) not null,
course_name varchar(200) not null);

create table fraction(
userid int(11) not null,
crs_code varchar(255) not null,
mark int(11) not null
);

create table electiveCourse(
crs_id int(11) Primary Key not null,
crs_code varchar(255) not null,
crs_name varchar(200) not null,
crs_attribute varchar(255) not null,
crs_credit int(11) not null,
crs_semester varchar(200) not null,
crs_time varchar(200) not null,
crs_number int(11) not null
crs_teacher varchar(200) not null,
crs_address varchar(200) not null,);

create table role(
roleId int(5) Primary Key not null,
roleName varchar(255) not null,
permissions varchar(255) default null
);
insert into role value(0,'admin',null),(2,'student',null),(1,'teacher',null);

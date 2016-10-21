create database fileOnline_db;
use fileOnline_db;
create table Admins(
		Admin_ID char(10) not null primary key,
		Admin_password varchar(18) not null
		);

create table Departments(
		Dept_ID char(6) not null primary key,
		Dept_name varchar(12) not null
		);

create table Titles(
		Title_ID char(6) not null primary key,
		Title_name varchar(12) not null,
		Title_PERMISSION_NUM int not null
		);

create table FileClass(
		FileClass_ID char(5) not null primary key,
		FileClass_name varchar(15) not null,
		Permission_need int not null
		);

create table Employees(
		Employee_ID char(14) not null primary key,
		Employee_password varchar(20) not null,
		Employee_Title_ID char(6) not null,
		Employee_Title_name varchar(12) not null,
		Employee_Dept_ID char(6) not null,
		Employee_Dept_name varchar(12) not null,
		Employee_Title_PERMISSION_NUM int not null,
		foreign key (Employee_Title_ID) references Titles (Title_ID),
		foreign key (Employee_Dept_ID) references Departments (Dept_ID)
		);

create table Files(
		File_ID char(36) not null primary key,
		File_name varchar(100) not null,
		File_type varchar(6) not null,
		File_FileClass_ID char(5) not null,
		File_FileClass_name varchar(15) not null,
		File_Employee_ID char(14) not null,
		File_Dept_ID char(6) not null,
		File_Dept_name varchar(12) not null,
		Browse_Times int default 0 not null,
		Upload_Time datetime not null,
		Download_times int default 0 not null,
		File_Content mediumblob,
		foreign key (File_FileClass_ID) references FileClass (FileClass_ID),
		foreign key (File_Employee_ID) references Employees (Employee_ID),
		foreign key (File_Dept_ID) references Departments (Dept_ID)
		);

create table Download(
		Download_Employee_ID char(14) not null,
		Download_File_ID char(36) not null,
		Download_time datetime not null,
		Download_File_name varchar(100) not null,
		Download_Dept_name varchar(12) not null,
		Download_FileClass_name varchar(15) not null,
		primary key(Download_Employee_ID,Download_File_ID,Download_time),
		foreign key (Download_Employee_ID) references Employees (Employee_ID),
		foreign key (Download_File_ID) references Files (File_ID)
		);

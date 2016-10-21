drop procedure if exists pro_GetPerNum$0;
delimiter #
create procedure pro_GetPerNum$0(in Id char(14))
comment "Get permission num by employee's id."
begin
	select Employee_Title_PERMISSION_NUM from Employees where Employee_ID=Id;
end#
delimiter ;

drop procedure if exists pro_GetDeptId;
delimiter #
create procedure pro_GetDeptId(in Id char(14))
comment "Get deparement's id by employee's id."
begin
	select Employee_Dept_ID from Employees where Employee_ID=Id;
end#
delimiter ;

drop procedure if exists pro_GetDeptName;
delimiter #
create procedure pro_GetDeptName(in Id char(14))
comment "Get deparement's name by employee's id."
begin
	select Employee_Dept_name from Employees where Employee_ID=Id;
end#
delimiter ;

drop procedure if exists pro_GetEmpInfo;
delimiter #
create procedure pro_GetEmpInfo()
comment "Get employee's infomation."
begin
	select * from Employees;
end#
delimiter ;

drop procedure if exists pro_UpdatePassword;
delimiter #
create procedure pro_UpdatePassword(in Id char(14), in password varchar(20))
comment "Update employee's password."
begin
	update Employees set Employee_password=password where Employee_ID=Id;
end#
delimiter ;

drop procedure if exists pro_GetDownloadInfo();
delimiter #
create procedure pro_GetDownloadInfo()
comment "Get download infomation."
begin
	select * from Download;
end#
delimiter ;

drop procedure if exists pro_GetAdminInfo();
delimiter #
create procedure pro_GetAdminInfo()
comment "Get admin's infomation."
begin
	select * from Admins;
end#
delimiter ;

drop procedure if exists pro_SearchFile$0;
delimiter #
create procedure pro_SearchFile$0(in Id char(36))
comment "Search file by file's id."
begin
	select File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files where File_ID=Id;
end#
delimiter ;

drop procedure if exists pro_SearchFile$1;
delimiter #
create procedure pro_SearchFile$1(in Name varchar(100))
comment "Search file by file's name."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files where File_name like concat('%',Name,'%');
end#
delimiter ;

drop procedure if exists pro_SearchFile$2;
delimiter #
create procedure pro_SearchFile$2(in Type varchar(6))
comment "Search file by file's type."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files where File_type like concat('%',Type,'%');
end#
delimiter ;

drop procedure if exists pro_SearchFile$5;
delimiter #
create procedure pro_SearchFile$5(in EmpId char(14))
comment "Search file by employee's id."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files where File_Employee_ID=EmpId;
end#
delimiter ;

drop procedure if exists pro_LatestFile;
delimiter #
create procedure pro_LatestFile()
comment "Get the latest upload file."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files order by Upload_Time desc limit 5;
end#
delimiter ;

drop procedure if exists pro_MostDownload;
delimiter #
create procedure pro_MostDownload()
comment "Get the most download file."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files order by Download_times desc limit 5;
end#
delimiter ;

drop procedure if exists pro_MostBrowse;
delimiter #
create procedure pro_MostBrowse()
comment "Get the most browse file."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files order by Browse_Times desc limit 5;
end#
delimiter ;

drop procedure if exists pro_GetFileInfo;
delimiter #
create procedure pro_GetFileInfo()
comment "Get the file infomation."
begin
	select File_ID, File_name, File_type, File_FileClass_ID, File_FileClass_name, File_Employee_ID, File_Dept_ID, File_Dept_name, Browse_Times, Upload_Time, Download_times from Files;
end#
delimiter ;

drop procedure if exists pro_UpdateBrowseTimes;
delimiter #
create procedure pro_UpdateBrowseTimes(in FileId char(36))
comment "Update the browse times by file id."
begin
	update Files set Browse_Times=Browse_Times + 1 where File_ID=FileId;
end#
delimiter ;

drop procedure if exists pro_UploadFile;
delimiter #
create procedure pro_UploadFile(in FileId char(36), in FileName varchar(100), in FileType varchar(6), in FileClassId char(5), in FileClassName varchar(15), in FileEmpId char(14), in FileDeptId char(6), in FileDeptName varchar(12), in FilePath varchar(100))
comment "Upload file."
begin
	insert into Files values(FileId, FileName, FileType, FileClassId, FileClassName, FileEmpId, FileDeptId, FileDeptName, 0, now(), 0, load_file(FilePath));
end#
delimiter ;

drop procedure if exists pro_InsertDownload;
delimiter #
create procedure pro_InsertDownload(in EmpId char(14), in FileId char(36), in FileName varchar(100), in DeptName varchar(12), in FileClassName varchar(15))
comment "Insert download record."
begin
	insert into Download values(EmpId, FileId, now(), FileName, DeptName, FileClassName);
end#
delimiter ;
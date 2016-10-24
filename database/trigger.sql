use fileOnline_db;
drop trigger if exists tri_IncsDownloadTimes;
delimiter #
create trigger tri_IncsDownloadTimes
after insert on Download
for each row
begin
	update Files set Download_times=Download_times + 1 where File_ID=new.Download_File_ID;
end#
delimiter ;
use fileOnline_db;
insert into Admins values ('0123456789','000000');
insert into Departments values ('000001','Technology'),('000002','Personnel'),('000003','Finance');
insert into Titles values ('000001','Staff',1),('000002','Manager',2),('000003','President',3);
insert into FileClass values ('00001','Normal',1),('00002','Important',2),('00003','Secret',3);
insert into Employees values ('01234567890123','000000','000001','Staff','000001','Technology',1);

insert into Files values('2fc0ca60-f4ea-41c8-9def-1b451c20bcda','wallpaper16','jpg','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);
insert into Files values('13d100a2-0df7-4286-8afb-90defa78e3e0','compressed09','pdf','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);
insert into Files values('97d2fe4a-2fd8-4ce2-b106-d5b4fac0a81f','fontAwesome','txt','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);
insert into Files values('563944ba-83df-4874-ab16-a0cd6a02ae87','CompCha4','ppt','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);
insert into Files values('e150097e-dbac-4922-9807-ebba7a24bdcd','rc','lua','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);
insert into Files values('e848139e-f3aa-4b12-a93d-c0b034467ddd','texlive-zh-cn','tex','00001', 'Normal','01234567890123','000002','Technology',0,now(),0);

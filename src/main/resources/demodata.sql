--bataneko
INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,'多媒体会议室',30,0,'一楼，有多媒体配套设施');
INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,'小型会议室',10,0,'二楼，小会议室无配套设施');
INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,'中型会议室',20,0,'二楼，无配套设施');
INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,'大型会议室',200,0,'三楼，有讲台，有多媒体，有音响');
INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,'股东会议室',20,0,'四楼，会议室桌配备会议麦');

insert into meeting_dept values(meeting_dept_did_seq.nextval,'技术部',0,0,'主要负责公司软件技术产品代码开发');
insert into meeting_dept values(meeting_dept_did_seq.nextval,'销售部',0,0,'主要负责公司软件技术产品完成后的销售工作');
insert into meeting_dept values(meeting_dept_did_seq.nextval,'人事部',0,0,'主要负责公司人事以及后勤保障 保证工公司正常运营');
insert into meeting_dept values(meeting_dept_did_seq.nextval,'财务部',0,0,'主要负责公司经济管理');

insert into meeting_emp values(meeting_emp_eid_seq.nextval,'bataneko','hym740',to_date('2021-04-15','yyyy-mm-dd'),
                               '12345678910',to_date('2000-06-15','yyyy-mm-dd'),'null.jpg',0,2,0);



COMMIT;
--bataneko
CREATE TABLE meeting_emp(
                            eid number(4) primary key,
                            ename varchar2(30) not null,
                            password varchar(50) not null,
                            hire_date date not null,
                            telephone varchar2(20) unique,
                            birth_day date,
                            photo_img varchar2(100),
                            role number(2) not null,--0经理 1员工
                            did number(4),
                            e_status number(2)--0在职 1离职
);
CREATE SEQUENCE meeting_emp_eid_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE TABLE meeting_dept(
                             did number(4) primary key,
                             dname varchar2(50) not null,
                             manager_id number(4),
                             d_status number(2),--0正常 1停用
                             d_desc varchar(400)
);
CREATE SEQUENCE meeting_dept_did_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE TABLE meeting_room(
                             rid number(4) primary key,
                             rname varchar(50) not null,
                             rnum number(3),
                             rstate number(2),--0可用 1不可用
                             rdesc varchar(400)
);
CREATE SEQUENCE meeting_room_rid_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE TABLE meeting_meet(
                             mid number(4) primary key,
                             eid number(4),
                             msdate date,
                             medate date,
                             mtitle varchar(400),
                             rid number(4),
                             mstate number(2)--0未开始 1已结束 2已取消 3进行中
);
CREATE SEQUENCE meeting_meet_mid_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;

CREATE TABLE meeting_participants(
                                     pid number(4) primary key,
                                     mid number(4),
                                     eid number(4)
);
CREATE SEQUENCE meeting_participants_pid_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;
drop view emp_dept_view;
CREATE VIEW emp_dept_view AS (
                             SELECT e.eid,e.ename,e.password,e.hire_date,e.telephone,e.birth_day,e.photo_img,e.role,e.e_status,d.dname
                             FROM meeting_emp e,meeting_dept d
                             WHERE e.did=d.did);

COMMIT;
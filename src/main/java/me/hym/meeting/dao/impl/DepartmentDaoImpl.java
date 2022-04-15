package me.hym.meeting.dao.impl;

import me.hym.meeting.dao.DepartmentDao;
import me.hym.meeting.entity.Department;
import me.hym.meeting.util.DBUtil;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public int insert(Department department) {
        return DBUtil.commonsUpdate("INSERT INTO meeting_dept VALUES(meeting_dept_did_seq.nextval,?,?,?,?)",
                department.getDname(), department.getManager_id(), department.getD_desc(), department.getD_desc());
    }

    @Override
    public List<Department> selectAll() {
        return DBUtil.commonsQuery(Department.class,"SELECT * FROM meeting_dept");
    }

    @Override
    public Department selectByID(int id) {
        return DBUtil.commonsQuery(Department.class,"SELECT * FROM meeting_dept WHERE did=?",id).get(0);
    }

    @Override
    public int update(Department department) {
        return DBUtil.commonsUpdate("UPDATE meeting_dept SET did=?,dname=?,manager_id=?,d_status=?,d_desc=?",
                department.getDid(),department.getDname(),department.getManager_id(),department.getD_status(),
                department.getD_desc());
    }

    @Override
    public int delete(int id) {
        return DBUtil.commonsUpdate("DELETE meeting_dept WHERE did=?",id);
    }
}

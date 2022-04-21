package me.hym.meeting.dao.impl;

import me.hym.meeting.dao.EmployeeDao;
import me.hym.meeting.entity.Employee;
import me.hym.meeting.util.DBUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public int insert(Employee employee) {
        return DBUtil.commonsUpdate("INSERT INTO meeting_emp VALUES(meeting_emp_eid_seq.nextval,?,?,to_date(?,'yyyy-mm-dd'),?,to_date(?,'yyyy-mm-dd'),?,?,?,?)",
                employee.getEname(),employee.getPassword(),df.format(employee.getHire_date()),
                employee.getTelephone(),df.format(employee.getBirth_day()),employee.getPhoto_img(),employee.getRole(),
                employee.getDid(),employee.getE_status());
    }

    @Override
    public List<Employee> selectAll() {
        return DBUtil.commonsQuery(Employee.class,"SELECT * FROM meeting_emp");
    }

    @Override
    public Employee selectByID(int id) {
        List<Employee> employeeList = DBUtil.commonsQuery(Employee.class,"SELECT * FROM meeting_emp WHERE eid=?",id);
        if(employeeList.size()==0){
            return null;
        }
        return employeeList.get(0);
    }

    @Override
    public Employee selectByTelephone(String tel) {
        List<Employee> employeeList = DBUtil.commonsQuery(Employee.class,"SELECT * FROM meeting_emp WHERE telephone=?",tel);
        if(employeeList.size()==0){
            return null;
        }
        return employeeList.get(0);
        //BUG: 当找不到时，集合为空，引发IndexOutOfBoundsException
//      return DBUtil.commonsQuery(Employee.class,"SELECT * FROM meeting_emp WHERE telephone=?",tel).get(0);
    }

    @Override
    public int update(Employee employee) {
        return DBUtil.commonsUpdate("UPDATE meeting_emp SET ename=?,password=?,hire_date=to_date(?,'yyyy-mm-dd'),telephone=?,birth_day=to_date(?,'yyyy-mm-dd'),photo_img=?,role=?,did=?,e_status=? WHERE eid=?",
                employee.getEname(),employee.getPassword(),df.format(employee.getHire_date()),
                employee.getTelephone(),df.format(employee.getBirth_day()),employee.getPhoto_img(),employee.getRole(),
                employee.getDid(),employee.getE_status(),employee.getEid());
    }

    @Override
    public int delete(int id) {
        return DBUtil.commonsUpdate("DELETE meeting_emp WHERE eid=?",id);
    }
}

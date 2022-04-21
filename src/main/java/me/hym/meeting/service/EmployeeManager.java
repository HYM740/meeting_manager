package me.hym.meeting.service;

import me.hym.meeting.dao.EmployeeDao;
import me.hym.meeting.dao.impl.EmployeeDaoImpl;
import me.hym.meeting.entity.Employee;

import java.util.List;

public class EmployeeManager {
    private static EmployeeDao ed = new EmployeeDaoImpl();
    public static boolean createEmployee(Employee employee){
        return ed.insert(employee)==1;
    }
    public static boolean updateEmployee(Employee employee){
        return ed.update(employee)==1;
    }
    public static boolean deleteEmployee(int id){
        return ed.delete(id)==1;
    }
    public static Employee getEmployee(int id){
        return ed.selectByID(id);
    }
    public static Employee getEmployee(String tel){
        return ed.selectByTelephone(tel);
    }
    public static List<Employee> getAllEmployee(){
        return ed.selectAll();
    }
}

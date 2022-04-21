package me.hym.meeting.service;

import me.hym.meeting.dao.DepartmentDao;
import me.hym.meeting.dao.impl.DepartmentDaoImpl;
import me.hym.meeting.entity.Department;

import java.util.List;

public class DepartmentManager {
    private static DepartmentDao dd = new DepartmentDaoImpl();

    public static List<Department> getAllDepartment() {
        return dd.selectAll();
    }

    public static boolean createDepartment(Department department) {
        return dd.insert(department) == 1;
    }

    public static boolean updateDepartment(Department department) {
        return dd.update(department) == 1;
    }

    public static boolean deleteDepartment(int id) {
        return dd.delete(id) == 1;
    }

    public static Department getDepartment(int id) {
        return dd.selectByID(id);
    }
}

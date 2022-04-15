package me.hym.meeting.dao;

import me.hym.meeting.entity.Employee;

import java.util.List;

/**
 * 对员工表的基本操作。包括对主键查找、列出全部、增加、修改、删除。
 * @author bataneko
 */
public interface EmployeeDao {

    /**
     * 增加员工
     * @param employee 员工对象
     * @return 影响记录行数
     */
    int insert(Employee employee);

    /**
     * 列出全部员工
     * @return 由所有员工组成的集合
     */
    List<Employee> selectAll();

    /** 通过主键查找员工
     * @param id 主键值
     * @return 目标员工
     */
    Employee selectByID(int id);
    /**
     * 通过电话号码查找员工
     * @param tel 电话号码
     * @return 目标员工
     */
    Employee selectByTelephone(String tel);
    /**
     * @param employee
     * @return 影响记录行数
     */
    int update(Employee employee);

    /**
     * @param id
     * @return 影响记录行数
     */
    int delete(int id);
}

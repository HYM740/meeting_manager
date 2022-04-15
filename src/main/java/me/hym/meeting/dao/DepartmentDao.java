package me.hym.meeting.dao;

import me.hym.meeting.entity.Department;

import java.util.List;

/**
 * 对部门表的基本操作。包括对主键查找、列出全部、增加、修改、删除。
 * @author bataneko
 */
public interface DepartmentDao {

    /**
     * 增加部门
     * @param department 部门对象
     * @return 影响记录行数
     */
    int insert(Department department);

    /**
     * 列出全部部门
     * @return 由所有部门组成的集合
     */
    List<Department> selectAll();

    /**
     * 通过主键查找部门
     * @param id 主键值
     * @return 目标部门
     */
    Department selectByID(int id);

    /**
     * 更新部门
     * @param department 部门对象
     * @return 影响记录行数
     */
    int update(Department department);

    /**
     * 通过主键删除部门
     * @param id 主键ID
     * @return 影响记录行数
     */
    int delete(int id);
}

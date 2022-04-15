package me.hym.meeting.dao;

import me.hym.meeting.entity.Meet;

import java.util.List;

/**
 * 对会议表的基本操作。包括对主键查找、列出全部、增加、修改、删除。
 * @author bataneko
 */
public interface MeetDao {

    /**
     * @param meet
     * @return 影响记录行数
     */
    int insert(Meet meet);

    /**
     * @return
     */
    List<Meet> selectAll();

    /**
     * @param id
     * @return
     */
    Meet selectByID(int id);

    /**
     * @param meet
     * @return 影响记录行数
     */
    int update(Meet meet);

    /**
     * @param id
     * @return 影响记录行数
     */
    int delete(int id);
}

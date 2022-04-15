package me.hym.meeting.dao;

import me.hym.meeting.entity.MeetingRoom;

import java.util.List;

/**
 * 对会议室表的基本操作。包括对主键查找、列出全部、增加、修改、删除。
 * @author bataneko
 */
public interface MeetingRoomDao {

    /**
     * @param meetRoom
     * @return 影响记录行数
     */
    int insert(MeetingRoom meetRoom);

    /**
     * @return
     */
    List<MeetingRoom> selectAll();

    /**
     * @param id
     * @return
     */
    MeetingRoom selectByID(int id);

    /**
     * @param meetRoom
     * @return 影响记录行数
     */
    int update(MeetingRoom meetRoom);

    /**
     * @param id
     * @return 影响记录行数
     */
    int delete(int id);
}

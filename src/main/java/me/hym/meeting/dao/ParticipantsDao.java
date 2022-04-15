package me.hym.meeting.dao;

import me.hym.meeting.entity.Participants;

import java.util.List;

/**
 * 对与会者表的基本操作。包括对主键查找、列出全部、增加、修改、删除。
 * @author bataneko
 */
public interface ParticipantsDao {

    /**
     * @param participants
     * @return 影响记录行数
     */
    int insert(Participants participants);

    /**
     * @return
     */
    List<Participants> selectAll();

    /**
     * @param id
     * @return
     */
    Participants selectByID(int id);

    /**
     * @param participants
     * @return 影响记录行数
     */
    int update(Participants participants);

    /**
     * @param id
     * @return 影响记录行数
     */
    int delete(int id);
}

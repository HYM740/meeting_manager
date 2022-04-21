package me.hym.meeting.dao.impl;

import me.hym.meeting.dao.ParticipantsDao;
import me.hym.meeting.entity.Participants;
import me.hym.meeting.util.DBUtil;

import java.util.List;

public class ParticipantsDaoImpl implements ParticipantsDao {
    @Override
    public int insert(Participants participants) {
        return DBUtil.commonsUpdate("INSERT INTO meeting_participants VALUES(meeting_participants_pid_seq.nextval,?,?)",
                participants.getMid(),participants.getEid());
    }

    @Override
    public List<Participants> selectAll() {
        return DBUtil.commonsQuery(Participants.class,"SELECT * FROM meeting_participants");
    }

    @Override
    public Participants selectByID(int id) {
        List<Participants> participants = DBUtil.commonsQuery(Participants.class,"SELECT * FROM meeting_participants WHERE pid=?,",id);
        return participants.size()==0?null:participants.get(0);
    }

    @Override
    public int update(Participants participants) {
        return DBUtil.commonsUpdate("UPDATE meeting_participants SET mid=?,eid=?) WHERE pid=?",
                participants.getMid(),participants.getEid(),participants.getPid());
    }

    @Override
    public int delete(int id) {
        return DBUtil.commonsUpdate("DELETE meeting_participants WHERE pid=?",id);
    }
}

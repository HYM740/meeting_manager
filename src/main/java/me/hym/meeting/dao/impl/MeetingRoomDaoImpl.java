package me.hym.meeting.dao.impl;

import me.hym.meeting.dao.MeetingRoomDao;
import me.hym.meeting.entity.MeetingRoom;
import me.hym.meeting.util.DBUtil;

import java.util.List;

public class MeetingRoomDaoImpl implements MeetingRoomDao {
    @Override
    public int insert(MeetingRoom meetRoom) {
        //TODO
        return DBUtil.commonsUpdate("INSERT INTO meeting_room VALUES(meeting_room_rid_seq.nextval,?,?,?,?)",
                meetRoom.getRname(),meetRoom.getRnum(),meetRoom.getRstate(),meetRoom.getRdesc());
    }

    @Override
    public List<MeetingRoom> selectAll() {
        return DBUtil.commonsQuery(MeetingRoom.class,"SELECT * FROM meeting_room");
    }

    @Override
    public MeetingRoom selectByID(int id) {
        List<MeetingRoom> meetingRoomList = DBUtil.commonsQuery(MeetingRoom.class,"SELECT * FROM meeting_room where rid=?", id);
        return meetingRoomList.size()==0?null:meetingRoomList.get(0);
    }

    @Override
    public int update(MeetingRoom meetRoom) {
        return DBUtil.commonsUpdate("UPDATE meeting_room VALUES(?,?,?,?,?) WHERE mid=?",meetRoom.getRid(),
                meetRoom.getRname(),meetRoom.getRnum(),meetRoom.getRstate(),meetRoom.getRdesc());
    }

    @Override
    public int delete(int id) {
        return DBUtil.commonsUpdate("DELETE meeting_room WHERE mid=?",id);
    }
}

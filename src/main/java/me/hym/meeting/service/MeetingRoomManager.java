package me.hym.meeting.service;

import me.hym.meeting.dao.MeetingRoomDao;
import me.hym.meeting.dao.impl.MeetingRoomDaoImpl;
import me.hym.meeting.entity.MeetingRoom;

import java.util.List;

public class MeetingRoomManager {
    private static MeetingRoomDao md = new MeetingRoomDaoImpl();
    public static List<MeetingRoom> getAllMeetingRoom(){
        return md.selectAll();
    }
    public static MeetingRoom getMeetingRoom(int id){
        return md.selectByID(id);
    }
    public static boolean createMeetingRoom(MeetingRoom meetingRoom){
        return md.insert(meetingRoom)==1;
    }
    public static boolean updateMeetingRoom(MeetingRoom meetingRoom){
        return md.update(meetingRoom)==1;
    }
    public static boolean deleteMeetingRoom(int id){
        return md.delete(id)==1;
    }
}

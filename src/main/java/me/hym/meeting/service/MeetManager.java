package me.hym.meeting.service;

import me.hym.meeting.dao.MeetDao;
import me.hym.meeting.dao.impl.MeetDaoImpl;
import me.hym.meeting.entity.Meet;

import java.util.List;

public class MeetManager {
    private static MeetDao md = new MeetDaoImpl();
    public static boolean createMeet(Meet meet){
        return md.insert(meet)==1;
    }
    public static boolean updateMeet(Meet meet){
        return md.update(meet)==1;
    }
    public static boolean deleteMeet(int id){
        return md.delete(id)==1;
    }
    public static Meet getMeet(int id){
        return md.selectByID(id);
    }
    public static List<Meet> getAllMeet(){
        return md.selectAll();
    }
}

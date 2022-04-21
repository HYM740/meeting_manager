package me.hym.meeting.service;

import me.hym.meeting.dao.ParticipantsDao;
import me.hym.meeting.dao.impl.ParticipantsDaoImpl;
import me.hym.meeting.entity.Participants;

import java.util.List;

public class ParticipantsManager {
    private static ParticipantsDao pd = new ParticipantsDaoImpl();
    public static boolean createParticipants(Participants participants){
        return pd.insert(participants)==1;
    }
    public static boolean updateParticipants(Participants participants){
        return pd.update(participants)==1;
    }
    public static boolean deleteParticipants(int id){
        return pd.delete(id)==1;
    }
    public static List<Participants> getAllParticipants(){
        return pd.selectAll();
    }
    public static Participants getParticipants(int id){
        return pd.selectByID(id);
    }
}

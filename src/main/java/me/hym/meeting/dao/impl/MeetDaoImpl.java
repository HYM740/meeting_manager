package me.hym.meeting.dao.impl;

import me.hym.meeting.dao.MeetDao;
import me.hym.meeting.entity.Meet;
import me.hym.meeting.util.DBUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class MeetDaoImpl implements MeetDao {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Override
    public int insert(Meet meet) {
        return DBUtil.commonsUpdate("INSERT INTO meeting_meet VALUES(meeting_meet_mid_seq.nextval,?,to_date(?,'yyyy-mm-dd hh24:mi'),to_date(?,'yyyy-mm-dd hh24:mi'),?,?,?)",
                meet.getEid(),df.format(meet.getMsdate()),df.format(meet.getMedate()),meet.getMtitle(),meet.getRid(),meet.getMstate());
    }

    @Override
    public List<Meet> selectAll() {
        return DBUtil.commonsQuery(Meet.class,"SELECT * FROM meeting_meet");
    }

    @Override
    public Meet selectByID(int id) {
        List<Meet> meetList=DBUtil.commonsQuery(Meet.class,"SELECT * FROM meeting_meet WHERE mid=?",id);
        return meetList.size()==0?null:meetList.get(0);
    }

    @Override
    public int update(Meet meet) {
        return DBUtil.commonsUpdate("UPDATE meeting_meet SET eid=?,msdate=to_date(?,'yyyy-mm-dd hh24:mi'),medate=to_date(?,'yyyy-mm-dd hh24:mi'),mtitle=?,rid=?,mstate=? WHERE mid=?",
                meet.getEid(),df.format(meet.getMsdate()),df.format(meet.getMedate()),meet.getMtitle(),meet.getRid(),
                meet.getMstate(),meet.getMid());
    }

    @Override
    public int delete(int id) {
        return DBUtil.commonsUpdate("DELETE meeting_meet WHERE mid=?",id);
    }
}

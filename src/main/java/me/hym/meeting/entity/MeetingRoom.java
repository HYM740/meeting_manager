package me.hym.meeting.entity;

public class MeetingRoom {
    int rid;
    String rname;
    int rnum;
    int rstate;
    String rdesc;

    public MeetingRoom() {
    }

    public MeetingRoom(int rid, String rname, int rnum, int rstate, String rdesc) {
        this.rid = rid;
        this.rname = rname;
        this.rnum = rnum;
        this.rstate = rstate;
        this.rdesc = rdesc;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public int getRstate() {
        return rstate;
    }

    public void setRstate(int rstate) {
        this.rstate = rstate;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rnum=" + rnum +
                ", rstate=" + rstate +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}

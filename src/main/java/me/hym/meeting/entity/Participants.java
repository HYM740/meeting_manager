package me.hym.meeting.entity;

public class Participants {
    int pid;
    int mid;
    int eid;

    public Participants() {
    }

    public Participants(int pid, int mid, int eid) {
        this.pid = pid;
        this.mid = mid;
        this.eid = eid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "Participants{" +
                "pid=" + pid +
                ", mid=" + mid +
                ", eid=" + eid +
                '}';
    }
}

package me.hym.meeting.entity;

import java.util.Date;

public class Meet {
    int mid;
    int eid;
    Date msdate;
    Date medate;
    String mtitle;
    int rid;
    int mstate;

    public Meet() {
    }

    public Meet(int mid, int eid, Date msdate, Date medate, String mtitle, int rid, int mstate) {
        this.mid = mid;
        this.eid = eid;
        this.msdate = msdate;
        this.medate = medate;
        this.mtitle = mtitle;
        this.rid = rid;
        this.mstate = mstate;
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

    public Date getMsdate() {
        return msdate;
    }

    public void setMsdate(Date msdate) {
        this.msdate = msdate;
    }

    public Date getMedate() {
        return medate;
    }

    public void setMedate(Date medate) {
        this.medate = medate;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMstate() {
        return mstate;
    }

    public void setMstate(int mstate) {
        this.mstate = mstate;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "mid=" + mid +
                ", eid=" + eid +
                ", msdate=" + msdate +
                ", medate=" + medate +
                ", mtitle='" + mtitle + '\'' +
                ", rid=" + rid +
                ", mstate=" + mstate +
                '}';
    }
}

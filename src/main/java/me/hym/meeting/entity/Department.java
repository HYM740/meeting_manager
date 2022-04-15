package me.hym.meeting.entity;

public class Department {
    int did;
    String dname;
    int manager_id;
    int d_status;
    int d_desc;

    public Department() {
    }

    public Department(int did, String dname, int manager_id, int d_status, int d_desc) {
        this.did = did;
        this.dname = dname;
        this.manager_id = manager_id;
        this.d_status = d_status;
        this.d_desc = d_desc;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getD_status() {
        return d_status;
    }

    public void setD_status(int d_status) {
        this.d_status = d_status;
    }

    public int getD_desc() {
        return d_desc;
    }

    public void setD_desc(int d_desc) {
        this.d_desc = d_desc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", manager_id=" + manager_id +
                ", d_status=" + d_status +
                ", d_desc=" + d_desc +
                '}';
    }
}

package me.hym.meeting.entity;

import java.util.Date;
@Deprecated
public class EmployeeDetail {
    int eid;
    String ename;
    String password;
    Date hire_date;
    String telephone;
    Date birth_day;
    String photo_img;
    int role;
    int did;
    int e_status;
    String dname;

    public EmployeeDetail() {
    }

    public EmployeeDetail(int eid, String ename, String password, Date hire_date, String telephone, Date birth_day, String photo_img, int role, int did, int e_status, String dname) {
        this.eid = eid;
        this.ename = ename;
        this.password = password;
        this.hire_date = hire_date;
        this.telephone = telephone;
        this.birth_day = birth_day;
        this.photo_img = photo_img;
        this.role = role;
        this.did = did;
        this.e_status = e_status;
        this.dname = dname;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }

    public String getPhoto_img() {
        return photo_img;
    }

    public void setPhoto_img(String photo_img) {
        this.photo_img = photo_img;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getE_status() {
        return e_status;
    }

    public void setE_status(int e_status) {
        this.e_status = e_status;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", password='" + password + '\'' +
                ", hire_date=" + hire_date +
                ", telephone='" + telephone + '\'' +
                ", birth_day=" + birth_day +
                ", photo_img='" + photo_img + '\'' +
                ", role=" + role +
                ", did=" + did +
                ", e_status=" + e_status +
                ", dname='" + dname + '\'' +
                '}';
    }
}

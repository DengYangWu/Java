package cn.tycoding.pojo;

import java.io.Serializable;

//管理器
public class Admin implements Serializable {
    private int aid;
    private String adminname;
    private String password;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminrname) {
        this.adminname = adminrname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

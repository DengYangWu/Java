package com.giit.www.entity;

import java.util.Date;

public class LimitTheLogin {
    private int iduser;
    private int countlogin;
    private Date datelogin;

    @Override
    public String toString() {
        return "LimitTheLogin{" +
                "iduser=" + iduser +
                ", countlogin=" + countlogin +
                ", datelogin=" + datelogin +
                '}';
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getCountlogin() {
        return countlogin;
    }

    public void setCountlogin(int countlogin) {
        this.countlogin = countlogin;
    }

    public Date getDatelogin() {
        return datelogin;
    }

    public void setDatelogin(Date datelogin) {
        this.datelogin = datelogin;
    }
}

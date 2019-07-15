package com.example.mohit.roomdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int sid;

    @ColumnInfo(name = "stu_name")  // stu_name is the name of the column
    private String sname;

    @ColumnInfo(name = "stu_pass")
    private String spass;

    public Student(String sname, String spass) {
        this.sname = sname;
        this.spass = spass;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getSpass() {
        return spass;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSpass(String spass) {
        this.spass = spass;
    }
}

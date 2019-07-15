package com.example.mohit.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Student.class} , version = 1)
public abstract class StudentDB extends RoomDatabase {
    abstract StudentDao getStudentDao();
}

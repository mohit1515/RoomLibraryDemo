package com.example.mohit.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    Long insert(Student student);

    @Query("Select * from Student")
    List<Student> getstudents();

    @Delete
    int delete(Student student);

    @Update
    int update(Student student);
}

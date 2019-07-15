package com.example.mohit.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText ename, epass;
    private Student student;
    private StudentDao studentDao;
    private StudentDB studentDB;
    String name ,password;

    public static final String Database_Name = "StudentDB";
    private long id;
    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.edtname);
        epass = findViewById(R.id.edtpass);

        //here database is created
        studentDB = Room.databaseBuilder(getApplicationContext() , StudentDB.class , Database_Name).build();
        //here all the fuctions are activated line insert, delete
        studentDao = studentDB.getStudentDao();
    }

    public void datasave(View view) {
        name = ename.getText().toString().trim();
        password = epass.getText().toString().trim();
        new inserttask().execute(name , password);
    }


    public class inserttask extends AsyncTask<String , Void , Void>
    {

        @Override
        protected Void doInBackground(String... strings) {
            name = strings[0];
            password = strings[1];

            student = new Student(name , password);
            id = studentDao.insert(student);

            //Updating UI from background
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(id == -1){
                        Toast.makeText(MainActivity.this, "data not inserted", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return null;
        }
    }



}

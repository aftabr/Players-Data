package com.example.assignment4_rida_aftab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PlayerList extends AppCompatActivity {

    DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Player Listing");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Black)));

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        db = new DBAdapter(this);

        db.open();
        Cursor result = db.getAllPlayers();

        List<String> data =  new ArrayList<>();

        Log.d("result",""+ result.getCount());
        while(result.moveToNext()){
            int id = result.getInt(0);
            String name = result.getString(1);
            String position = result.getString(2);
            int numGoals = result.getInt(3);

            String info = " " + id + " " + name + " " + position +" "+ numGoals;
            //player = new Player(id,name,position,numGoals);
            data.add(info);
            Log.d( "result "+id , name + " , "+position);

        }

        ListView listView = findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1 , data);
        listView.setAdapter(adapter);
    }
}

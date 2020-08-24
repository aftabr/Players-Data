package com.example.assignment4_rida_aftab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     Player player;
     DBAdapter db;

    EditText playerName;
    EditText numOfGoals;


    RadioGroup radioGroup;
    RadioButton goalieButton;
    RadioButton defenceButton;
    RadioButton forwardButton;

    String select;

    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBAdapter(this); // create the instance of db adapter class

        select = "Goalie";


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Player Info");
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Black)));
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        playerName = (EditText) findViewById(R.id.editText_playerName);
        numOfGoals = (EditText) findViewById(R.id.editText_NumberofGoals);

        goalieButton = (RadioButton) findViewById(R.id.radioButton_Goalie);
        defenceButton = (RadioButton) findViewById(R.id.radioButton_Defence);
        forwardButton = (RadioButton) findViewById(R.id.radioButton_Forward);



        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton_Goalie:
                        select = "Goalie";
                        break;
                    case R.id.radioButton_Defence:
                        select = "Defence";
                        break;
                    case R.id.radioButton_Forward:
                        select = "Forward";
                        break;
                    default:
                }
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }


    public void SaveData(View view) {

        id+=1;

        String name = playerName.getText().toString();
        String position = select;
        int numGoals = Integer.parseInt(numOfGoals.getText().toString());

        player = new Player(id,name,position,numGoals);

       // sava data to the table
       db.open();
       db.insertPlayer(name,position,numGoals);
       db.close();
       playerName.setText("");
       numOfGoals.setText("");
       Toast.makeText(this,"Save: " + id, Toast.LENGTH_LONG).show();
        //Toast.makeText(this,"Save " + numGoals, Toast.LENGTH_LONG).show();


    }

    public void viewAllPlayers(View view) {

        Intent intent = new Intent(this, PlayerList.class);
        startActivity(intent);
    }
}

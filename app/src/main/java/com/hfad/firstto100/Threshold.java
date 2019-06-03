package com.hfad.firstto100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Threshold extends AppCompatActivity {



    static int th=0;
    EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threshold);
        ed=findViewById(R.id.editText);
    }

    public void start_game(View view){
        if(ed.getText().toString().equals("0"))
            Toast.makeText(this,"Number must be greater than zero",Toast.LENGTH_SHORT).show();
        else{
            if (MainActivity.flag == 0) {
                Intent in = new Intent(this, GameWin.class);
                startActivity(in);
                th = Integer.parseInt(ed.getText().toString());
                finish();
            } else if (MainActivity.flag == 1) {
                Intent in = new Intent(this, Multi_Player.class);
                startActivity(in);
                th = Integer.parseInt(ed.getText().toString());
                finish();
            }
        }
    }
}

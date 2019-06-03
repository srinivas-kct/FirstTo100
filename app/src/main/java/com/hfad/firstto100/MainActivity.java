package com.hfad.firstto100;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void single(View view){
        Intent intent = new Intent(this,Threshold.class);
        flag=0;
        startActivity(intent);
    }
    public void multi(View view){
        flag=1;
        Intent intent = new Intent(this,Threshold.class);
        startActivity(intent);
    }


}


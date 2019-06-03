package com.hfad.firstto100;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Multi_Player extends AppCompatActivity {
    int sum,input,threshold;
    TextView text,winner,bot_score,my_score;
    Handler handler;
    Random r;
    int flag=0,player=1;
    int my,bot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);
        sum = 0;
        text = findViewById(R.id.txt);
        winner = findViewById(R.id.winner);
        bot_score = findViewById(R.id.bot_score);
        my_score = findViewById(R.id.my_score);
        handler = new Handler();
        r = new Random();
        winner.setText("Player "+player+" Turn!!!");
        my_score.setText("Player 1: 0");
        bot_score.setText("Player 2: 0");
    }

    @Override
    public void onStart()
    {
        super.onStart();

    }
    public void onClick(View v) {
        if (flag == 0) {
            switch (v.getId()) {
                case R.id._1:
                    input = 1;
                    break;

                case R.id._2:
                    input = 2;
                    break;
                case R.id._3:
                    input = 3;
                    break;
                case R.id._4:
                    input = 4;
                    break;
                case R.id._5:
                    input = 5;
                    break;
                case R.id._6:
                    input = 6;
                    break;
                case R.id._7:
                    input = 7;
                    break;
                case R.id._8:
                    input = 8;
                    break;
                case R.id._9:
                    input = 9;
                    break;
                case R.id._10:
                    input = 10;
            }

            sum += input;
            text.setText(String.valueOf(sum));
            text.setBackgroundColor(Color.GREEN);
            if (sum >= Threshold.th){
                if(player==1){
                    my++;
                    my_score.setText("Player 1: "+my);
                }
                else {
                    bot++;
                    bot_score.setText("Player 2: " + bot);
                }

                winner.setText("Player "+player+" Won \uD83D\uDC4F");
                flag=1;
                pop_up("Player "+player+" Won \uD83D\uDC4F");
                return;
            }
            player=(player%2)+1;
            winner.setText("Player "+player+" Turn!!!");
        }
        else if(flag==1)
            Toast.makeText(this,"Oops!!Game Already Finished",Toast.LENGTH_SHORT).show();
    }

    public void pop_up(String st){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(Multi_Player.this, R.style.Theme_AppCompat_Dialog);
        builder.setTitle(st);
        builder.setMessage("Do you want to try again?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                flag=0;
                player=1;
                sum=0;
                text.setText("0");
                text.setBackgroundColor(Color.GREEN);
                winner.setText("Player 1 Turn!!!");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}

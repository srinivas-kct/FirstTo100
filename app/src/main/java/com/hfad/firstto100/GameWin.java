package com.hfad.firstto100;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import  java.util.Random;

public class GameWin extends AppCompatActivity {
int sum,input;
TextView text,winner,my_score,bot_score;
String val;
Handler handler;
Random r;
int flag=0,bound=9;
int my=0,bot=0,threshold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win);
        sum = 0;
        text = findViewById(R.id.txt);
        bot_score = findViewById(R.id.bot_score);
        my_score = findViewById(R.id.my_score);
        winner = findViewById(R.id.winner);
        handler = new Handler();
        r = new Random();
        winner.setText("Your Turn!!!");
        threshold=Threshold.th;
    }

    @Override
    public void onStart()
    {
        super.onStart();

    }

    public void onClick(View v) {
        if (flag == 0) {
            flag=2;
            winner.setText("");
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
            if (sum >= threshold){
                winner.setText("You Won\uD83D\uDC4F");
                pop_up("You Won\uD83D\uDC4F");
                my++;
                my_score.setText("Your Score: "+my);
                flag=1;
                return;
            }
            handler.postDelayed(new Runnable() {
                                    public void run() {
                                        //sum += no(sum);   //hunger100
                                        sum+=logic(sum);
                                        //
                                        /*bound=threshold-sum;
                                        if(bound>=9)
                                            bound=9;
                                        else if(bound>1)
                                            bound--;
                                        else
                                            bound=1;
                                        int temp=r.nextInt(bound) + 1;
                                        sum+=temp;
                                        */
                                        //




                                        if (sum >= threshold){
                                            winner.setText("You Lost☹️");
                                            pop_up("You Lost☹️");
                                            flag=1;
                                            bot++;
                                            bot_score.setText("Bot Score: "+bot);
                                            text.setText(String.valueOf(sum));
                                            text.setBackgroundColor(Color.RED);
                                            return;
                                        }
                                        text.setText(String.valueOf(sum));
                                        text.setBackgroundColor(Color.RED);
                                        winner.setText("Your Turn!!!");
                                        flag=0;
                                    }

                                }
                    , 1000);
        }
        else if(flag==1)
            Toast.makeText(this,"Oops!!!Game Already Finished",Toast.LENGTH_SHORT).show();
    }
    int logic(int s){
        if(Threshold.th-s<=10){
            return Threshold.th-s;

        }
        int i,f=0;
        for(i=Threshold.th;i>0;i=i-11){
            if(i>s&&i<s+10){
                f=1;
                break;
            }
        }
        if(f==0)
            return ((r.nextInt(9) + 1));
        return i-s;
    }

    public void pop_up(String st){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(GameWin.this, R.style.Theme_AppCompat_Dialog);
        builder.setTitle(st);
        builder.setMessage("Do you want to try again?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                flag=0;
                sum=0;
                text.setText("0");
                text.setBackgroundColor(Color.GREEN);
                winner.setText("Your Turn!!!");
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

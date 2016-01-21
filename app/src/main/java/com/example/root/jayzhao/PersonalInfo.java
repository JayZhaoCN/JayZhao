package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by root on 16-1-11.
 */
public class PersonalInfo extends Activity {


    public static int sportGoal = 0;

    TextView sport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.personal_info_layout);

        sport = (TextView) findViewById(R.id.sportText);

        final ImageButton imageButton01 = (ImageButton) findViewById(R.id.imagebutton01);
        imageButton01.getBackground().setAlpha(0);
        ImageButton imageButton02 = (ImageButton) findViewById(R.id.imagebutton02);
        imageButton02.getBackground().setAlpha(0);


        ImageButton imageButton03 = (ImageButton) findViewById(R.id.imagebutton03);
        imageButton03.getBackground().setAlpha(0);
        ImageButton imageButton04 = (ImageButton) findViewById(R.id.imagebutton04);
        imageButton04.getBackground().setAlpha(0);
        ImageButton imageButton05 = (ImageButton) findViewById(R.id.imagebutton05);
        imageButton05.getBackground().setAlpha(0);
        ImageButton imageButton06 = (ImageButton) findViewById(R.id.imagebutton06);
        imageButton06.getBackground().setAlpha(0);
        ImageButton imageButton07 = (ImageButton) findViewById(R.id.imagebutton07);
        imageButton07.getBackground().setAlpha(0);
        ImageButton imageButton08 = (ImageButton) findViewById(R.id.imagebutton08);
        imageButton08.getBackground().setAlpha(0);

        ImageButton imageButton09 = (ImageButton) findViewById(R.id.imagebutton09);
        imageButton09.getBackground().setAlpha(0);

        imageButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInfo.this.finish();
            }
        });

        imageButton01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev_2));
                        break;
                    case MotionEvent.ACTION_UP:
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev));
                        break;
                }


                return false;
            }
        });

        LinearLayout linear01 = (LinearLayout) findViewById(R.id.linearlayout01);


        linear01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo.this, Me.class);
                PersonalInfo.this.startActivity(intent);
            }
        });
        LinearLayout linear03 = (LinearLayout) findViewById(R.id.linear03);
        linear03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo.this, Lab.class);
                PersonalInfo.this.startActivity(intent);
            }
        });
        LinearLayout linear06 = (LinearLayout) findViewById(R.id.linear06);
        linear06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo.this, unit.class);
                PersonalInfo.this.startActivity(intent);
            }
        });

        LinearLayout linear04 = (LinearLayout) findViewById(R.id.linear04);
        linear04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo.this, SportGoal.class);
                PersonalInfo.this.startActivity(intent);
            }
        });

        LinearLayout linear07 = (LinearLayout) findViewById(R.id.linear07);
        linear07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(PersonalInfo.this, About.class);
                PersonalInfo.this.startActivity(intent);
            }
        });





        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {

        sport.setText((sportGoal*1000+2000) + "步/天");
        super.onResume();
    }
}

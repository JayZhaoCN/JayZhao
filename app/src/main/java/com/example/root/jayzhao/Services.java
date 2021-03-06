package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by root on 16-1-12.
 */
public class Services extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.setContentView(R.layout.services_layout);

        final ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);
        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.this.finish();
            }
        });
        ImageButton image02 = (ImageButton) findViewById(R.id.imagebutton02);
        image02.getBackground().setAlpha(0);
        ImageButton image03 = (ImageButton) findViewById(R.id.imagebutton03);
        image03.getBackground().setAlpha(0);
        ImageButton image04 = (ImageButton) findViewById(R.id.imagebutton04);
        image04.getBackground().setAlpha(0);
        ImageButton image05 = (ImageButton) findViewById(R.id.imagebutton05);
        image05.getBackground().setAlpha(0);
        ImageButton image06 = (ImageButton) findViewById(R.id.imagebutton06);
        image06.getBackground().setAlpha(0);
        ImageButton image07 = (ImageButton) findViewById(R.id.imagebutton07);
        image07.getBackground().setAlpha(0);
        ImageButton image08 = (ImageButton) findViewById(R.id.imagebutton08);
        image08.getBackground().setAlpha(0);
        ImageButton image09 = (ImageButton) findViewById(R.id.imagebutton09);
        image09.getBackground().setAlpha(0);

        LinearLayout l1 = (LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Services.this, Weixin.class);
                Services.this.startActivity(intent);
            }
        });

        LinearLayout l2 = (LinearLayout) findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Services.this, QQ.class);
                Services.this.startActivity(intent);
            }
        });
        LinearLayout l3 = (LinearLayout) findViewById(R.id.l3);
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Services.this, Weibo.class);
                Services.this.startActivity(intent);
            }
        });


        image01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        image01.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev_2));
                        break;
                    case MotionEvent.ACTION_UP:
                        image01.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev));
                        break;
                }
                return false;
            }
        });
        super.onCreate(savedInstanceState);
    }
}

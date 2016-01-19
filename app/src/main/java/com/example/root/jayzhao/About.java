package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by hm on 16-1-18.
 */
public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.about);

        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                About.this.finish();
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        back.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev_2));
                        break;
                    case MotionEvent.ACTION_UP:
                        back.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev));
                        break;
                }
                return false;
            }
        });


        ImageButton mi = (ImageButton) findViewById(R.id.mi);
        mi.getBackground().setAlpha(0);

        ImageButton image01 = (ImageButton) findViewById(R.id.image01);
        image01.getBackground().setAlpha(0);

        ImageButton image02 = (ImageButton) findViewById(R.id.image02);
        image02.getBackground().setAlpha(0);

        ImageButton image03 = (ImageButton) findViewById(R.id.image03);
        image03.getBackground().setAlpha(0);

        ImageButton image04 = (ImageButton) findViewById(R.id.image04);
        image04.getBackground().setAlpha(0);

        ImageButton image05 = (ImageButton) findViewById(R.id.image05);
        image05.getBackground().setAlpha(0);

        LinearLayout layout01 = (LinearLayout) findViewById(R.id.linear01);
        LinearLayout layout02 = (LinearLayout) findViewById(R.id.linear02);
        LinearLayout layout03 = (LinearLayout) findViewById(R.id.linear03);
        LinearLayout layout04 = (LinearLayout) findViewById(R.id.linear04);
        LinearLayout layout05 = (LinearLayout) findViewById(R.id.linear05);

        layout01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(About.this, Suggest.class);
                About.this.startActivity(intent);
            }
        });
        layout02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.baidu.com");
                intent.setData(content_url);
                startActivity(intent);

            }
        });
        layout03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this, "正在检查新版本......", Toast.LENGTH_SHORT).show();

                Toast.makeText(About.this, "已经是最新版本", Toast.LENGTH_SHORT).show();


            }
        });
        layout04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.mi.com");
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        layout05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






    }
}

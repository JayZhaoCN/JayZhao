package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016/1/17.
 */
public class Lab extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.lab_layout);
        super.onCreate(savedInstanceState);

        ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);

        ImageButton image02 = (ImageButton) findViewById(R.id.imagebutton02);
        image02.getBackground().setAlpha(0);

        ImageButton image03 = (ImageButton) findViewById(R.id.imagebutton03);
        image03.getBackground().setAlpha(0);

        ImageButton image04 = (ImageButton) findViewById(R.id.imagebutton04);
        image04.getBackground().setAlpha(0);

        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lab.this.finish();
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
    }
}

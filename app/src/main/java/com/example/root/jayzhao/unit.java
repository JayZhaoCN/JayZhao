package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2016/1/17.
 */
public class unit extends Activity {

    int state1 = 1;
    int state2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.unit_layout);
        super.onCreate(savedInstanceState);

        final ImageButton image01 = (ImageButton) findViewById(R.id.image01);
        image01.getBackground().setAlpha(0);


        final ImageButton image02 = (ImageButton) findViewById(R.id.image02);
        image02.getBackground().setAlpha(0);
        final ImageButton image03 = (ImageButton) findViewById(R.id.image03);
        image03.getBackground().setAlpha(0);
        final ImageButton image04 = (ImageButton) findViewById(R.id.image04);
        image04.getBackground().setAlpha(0);
        final ImageButton image05 = (ImageButton) findViewById(R.id.image05);
        image05.getBackground().setAlpha(0);

        LinearLayout linear01 = (LinearLayout) findViewById(R.id.layout01);
        LinearLayout linear02 = (LinearLayout) findViewById(R.id.layout02);

        LinearLayout linear03 = (LinearLayout) findViewById(R.id.layout03);
        LinearLayout linear04 = (LinearLayout) findViewById(R.id.layout04);
        LinearLayout linear05 = (LinearLayout) findViewById(R.id.layout05);

        linear01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(state1 == 2) {
                    state1 = 1;
                    image01.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image02.setImageResource(R.color.white);
                }
            }
        });

        linear02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state1 == 1) {
                    state1 = 2;
                    image02.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                }
            }
        });

        linear03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state2 != 1) {
                    state1 = 1;
                    image03.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image04.setImageResource(R.color.white);
                    image05.setImageResource(R.color.white);
                }
            }
        });

        linear04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state2 != 2) {
                    state2 = 2;
                    image04.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image03.setImageResource(R.color.white);
                    image05.setImageResource(R.color.white);
                }
            }
        });

        linear05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state2 != 3) {
                    state2 = 3;
                    image05.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image04.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                }
            }
        });




        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);

        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unit.this.finish();
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


        ImageButton space1 = (ImageButton) findViewById(R.id.spaceImage);
        space1.getBackground().setAlpha(0);

        ImageButton space2 = (ImageButton) findViewById(R.id.spaceImage2);
        space2.getBackground().setAlpha(0);



    }
}

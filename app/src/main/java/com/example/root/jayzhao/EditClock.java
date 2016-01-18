package com.example.root.jayzhao;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by hm on 16-1-12.
 */
public class EditClock extends Activity {

    public static String time = "周一到周五";

    TextView timeText = null;
    int index;
    TimePicker tp = null;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.edit_clock_layout);
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        position = intent.getIntExtra("index", -1);


        timeText = (TextView) findViewById(R.id.time_text);

        tp = (TimePicker) findViewById(R.id.timePicker);


        ImageButton image02 = (ImageButton) findViewById(R.id.imagebutton02);
        image02.getBackground().setAlpha(0);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditClock.this.finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartColok.time.set(position, tp.getCurrentHour() + ":" + tp.getCurrentMinute());
                EditClock.this.finish();
            }
        });

        LinearLayout linear = (LinearLayout) findViewById(R.id.timeSet);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment02 df2 = new MyDialogFragment02(index);
                df2.setCancelable(true);
                df2.show(getFragmentManager(), null);
            }
        });


    }

    @Override
    protected void onResume() {
        timeText.setText(time);
        super.onResume();
    }


    class MyDialogFragment02 extends DialogFragment {
        int indexx = 0;

        MyDialogFragment02(int index) {
            this.indexx = index;
        }

        @Override
        public void onStart() {
            super.onStart();

            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            container = (ViewGroup)inflater.inflate(R.layout.pick_time, null);
            final ImageButton image01 = (ImageButton) container.findViewById(R.id.image01);
            final ImageButton image02 = (ImageButton) container.findViewById(R.id.image02);
            final ImageButton image03 = (ImageButton) container.findViewById(R.id.image03);
            final ImageButton image04 = (ImageButton) container.findViewById(R.id.image04);
            ImageButton spaceImage = (ImageButton) container.findViewById(R.id.spaceImage);

            switch (indexx) {
                case 1:
                    image01.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image02.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    break;
                case 2:
                    image02.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    break;
                case 3:
                    image03.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image02.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    break;
                case 4:
                    image04.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image02.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    break;
            }

            image01.getBackground().setAlpha(0);
            image02.getBackground().setAlpha(0);
            image03.getBackground().setAlpha(0);
            image04.getBackground().setAlpha(0);
            spaceImage.getBackground().setAlpha(0);

            LinearLayout layout01 = (LinearLayout) container.findViewById(R.id.layout01);
            LinearLayout layout02 = (LinearLayout) container.findViewById(R.id.layout02);
            LinearLayout layout03 = (LinearLayout) container.findViewById(R.id.layout03);
            LinearLayout layout04 = (LinearLayout) container.findViewById(R.id.layout04);

            layout01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = 1;
                    timeText.setText("只响一次");
                    image01.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image02.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });

            layout02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = 2;
                    timeText.setText("每天");
                    image02.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    getDialog().dismiss();
                    ft.commit();
                }
            });

            layout03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = 3;
                    timeText.setText("周一至周五");
                    image03.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image02.setImageResource(R.color.white);
                    image04.setImageResource(R.color.white);
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });

            layout04.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index = 4;
                    timeText.setText("自定义");
                    image04.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                    image01.setImageResource(R.color.white);
                    image02.setImageResource(R.color.white);
                    image03.setImageResource(R.color.white);
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();

                    Intent intent = new Intent();
                    intent.setClass(EditClock.this, PickColokDate.class);
                    EditClock.this.startActivity(intent);
                }
            });


            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

            return container;
        }
    }






}

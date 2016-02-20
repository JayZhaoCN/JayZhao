package com.example.root.jayzhao;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/1/16.
 */
public class Me extends Activity {

    TextView userName = null;
    TextView sex = null;
    TextView brith = null;
    TextView height = null;

    LinearLayout linear01;
    LinearLayout linear02;
    LinearLayout linear03;
    LinearLayout linear04;

    MyDialogFragment01 df1;
    MyDialogFragment02 df2;
    MyDialogFragment03 df3;
    MyDialogFragment04 df4;

    boolean isMale = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.me_layout);

        userName = (TextView) findViewById(R.id.username);
        sex = (TextView) findViewById(R.id.text02);
        brith = (TextView) findViewById(R.id.text04);
        height = (TextView) findViewById(R.id.text06);

        final ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);

        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Me.this.finish();
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

        ImageButton image02 = (ImageButton) findViewById(R.id.image01);
        image02.getBackground().setAlpha(0);

        ImageButton image03 = (ImageButton) findViewById(R.id.image02);
        image03.getBackground().setAlpha(0);

        ImageButton image04 = (ImageButton) findViewById(R.id.image03);
        image04.getBackground().setAlpha(0);

        ImageButton image05 = (ImageButton) findViewById(R.id.image04);
        image05.getBackground().setAlpha(0);

        ImageButton user = (ImageButton) findViewById(R.id.image05);
        user.getBackground().setAlpha(0);

        final ImageButton imageModify = (ImageButton) findViewById(R.id.imageModify);
        imageModify.getBackground().setAlpha(0);

        imageModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df1 = new MyDialogFragment01();
                df1.setCancelable(true);
                df1.show(getFragmentManager(), null);
            }
        });

        imageModify.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageModify.setImageDrawable(getResources().getDrawable(R.drawable.btn_dynamic_detail_sleep_modify_pressed));
                        break;
                    case MotionEvent.ACTION_UP:
                        imageModify.setImageDrawable(getResources().getDrawable(R.drawable.btn_dynamic_detail_sleep_modify_normal));
                        break;
                }
                return false;
            }
        });

        linear01 = (LinearLayout) findViewById(R.id.linear01);
        linear02 = (LinearLayout) findViewById(R.id.linear02);
        linear03 = (LinearLayout) findViewById(R.id.linear03);
        linear04 = (LinearLayout) findViewById(R.id.linear04);

        linear01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df2 = new MyDialogFragment02();
                df2.setCancelable(true);
                df2.show(getFragmentManager(), null);
            }
        });
        linear02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df3 = new MyDialogFragment03();
                df3.setCancelable(true);
                df3.show(getFragmentManager(), null);

            }
        });
        linear03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df4 = new MyDialogFragment04();
                df4.setCancelable(true);
                df4.show(getFragmentManager(), null);

            }
        });
        linear04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    class MyDialogFragment01 extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            container = (ViewGroup)inflater.inflate(R.layout.modify_name_fragment, null);
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

            final EditText et = (EditText) container.findViewById(R.id.editName);

            Button confirm = (Button) container.findViewById(R.id.confirm);
            Button cancel = (Button) container.findViewById(R.id.cancel);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    userName.setText(et.getText().toString());
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });
            return container;
        }

        @Override
        public void onStart() {
            super.onStart();

            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }
    }

    class MyDialogFragment02 extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            container = (ViewGroup) inflater.inflate(R.layout.pick_sex, null);
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

            ImageButton space = (ImageButton) container.findViewById(R.id.spaceImage);
            final ImageButton image01 = (ImageButton) container.findViewById(R.id.image01);
            final ImageButton image02 = (ImageButton) container.findViewById(R.id.image02);

            if(isMale) {
                image01.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                image02.setImageResource(R.color.white);
            }
            else {
                image02.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                image01.setImageResource(R.color.white);
            }
            space.getBackground().setAlpha(0);
            image01.getBackground().setAlpha(0);
            image02.getBackground().setAlpha(0);

            LinearLayout linear01 = (LinearLayout)container.findViewById(R.id.layout01);
            LinearLayout linear02 = (LinearLayout)container.findViewById(R.id.layout02);

            linear01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isMale) {
                        isMale = true;
                        image01.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                        image02.setImageResource(R.color.white);
                        sex.setText("男");


                    }
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });
            linear02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isMale) {
                        isMale = false;
                        image02.setImageDrawable(getResources().getDrawable(R.drawable.arrow_single_choice));
                        image01.setImageResource(R.color.white);
                        sex.setText("女");
                    }
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });
            return container;
        }
        @Override
        public void onStart() {
            super.onStart();
            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }
    }

    class MyDialogFragment03 extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            container = (ViewGroup) inflater.inflate(R.layout.pick_birth, null);
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

            ImageButton space = (ImageButton) container.findViewById(R.id.spaceImage);
            space.getBackground().setAlpha(0);

            final DatePicker dp = (DatePicker) container.findViewById(R.id.datePicker);

            Button confirm = (Button) container.findViewById(R.id.confirm);
            Button cancel = (Button) container.findViewById(R.id.cancel);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int year = dp.getYear();
                    int month = dp.getMonth();
                    brith.setText(year + "年" + (month+1) + "月");
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });
            return container;
        }

        @Override
        public void onStart() {
            super.onStart();
            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }
    }

    class MyDialogFragment04 extends DialogFragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            container = (ViewGroup) inflater.inflate(R.layout.pick_height, null);
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

            final NumberPicker np = (NumberPicker) container.findViewById(R.id.picker01);
            np.setMinValue(40);
            np.setMaxValue(230);
            np.setValue(172);

            ImageButton space = (ImageButton) container.findViewById(R.id.spaceImage);
            space.getBackground().setAlpha(0);

            Button confirm = (Button) container.findViewById(R.id.confirm);
            Button cancel = (Button) container.findViewById(R.id.cancel);

            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int heightInt = np.getValue();
                    height.setText(heightInt + "厘米");
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getDialog().dismiss();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.commit();
                }
            });
            return container;
        }

        @Override
        public void onStart() {
            super.onStart();
            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }
    }
}

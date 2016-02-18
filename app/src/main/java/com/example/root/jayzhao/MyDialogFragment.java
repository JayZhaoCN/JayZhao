package com.example.root.jayzhao;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import javax.security.auth.login.LoginException;


public class MyDialogFragment extends DialogFragment {
    Context c = null;
    MyDialogFragment(Context c) {
        this.c = c;
    }



    @Override
    public void onStart() {
        super.onStart();



        final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        getDialog().getWindow().setWindowAnimations(R.style.dialogWindowAnim);
        layoutParams.gravity = Gravity.TOP;
        getDialog().getWindow().getDecorView().setPadding(0, 0, 0, 0);
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        getDialog().getWindow().setAttributes(layoutParams);
    }

    class MyAdapter1 extends BaseAdapter {

        LayoutInflater lf = null;
        MyAdapter1(LayoutInflater lf) {
            this.lf = lf;
        }
        
        @Override
        public int getCount() {
            return MainActivity.str02.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final int index = position;
            parent = (ViewGroup)lf.inflate(R.layout.list02, null);
            TextView t = (TextView) parent.findViewById(R.id.textView01);
            t.setText(MainActivity.str02.get(position));

            parent.setOnClickListener(new View.OnClickListener() {
                Intent intent = new Intent();

                public void onClick(View v) {
                    switch (index) {    
                        case 0:
                            intent.setClass(c, MyDevice.class);
                            intent.putExtra("index", index);
                            c.startActivity(intent);
                            break;
                        case 1:
                            intent.setClass(c, SmartColok.class);
                            intent.putExtra("index", index);
                            c.startActivity(intent);
                            break;
                        case 2:
                            intent.setClass(c, PersonalInfo.class);
                            intent.putExtra("index", index);
                            c.startActivity(intent);
                            break;
                        case 4:
                            intent.setClass(c, Services.class);
                            intent.putExtra("index", index);
                            c.startActivity(intent);
                            break;
                        case 6:
                            intent.setClass(c, Heartbeat.class);
                            intent.putExtra("index", index);
                            c.startActivity(intent);
                            break;
                    }
                }
            });

            return parent;
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container = (ViewGroup) inflater.inflate(R.layout.dialog_layout, null);
        ListView list = (ListView)container.findViewById(R.id.listView01);
        list.setAdapter(new MyAdapter1(inflater));
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        final ImageButton image = (ImageButton) container.findViewById(R.id.imagebutton01);

        image.getBackground().setAlpha(0);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.remove(MyDialogFragment.this);
                ft.commit();
            }
        });
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        image.setImageDrawable(getResources().getDrawable(R.drawable.menu_cancel_press));
                        break;
                    case MotionEvent.ACTION_UP:
                        image.setImageDrawable(getResources().getDrawable(R.drawable.menu_cancel_normal));
                        break;
                }
                return false;
            }
        });






        return container;
    }
}

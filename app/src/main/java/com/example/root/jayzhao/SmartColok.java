package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm on 16-1-12.
 */
public class SmartColok extends Activity {
    public static List<String> time = new ArrayList<String>();
    List<String>  status = new ArrayList<String>();
    List<Boolean> isOpen = new ArrayList<Boolean>();

    ImageButton image01;


    MyAdapter myAdapter = new MyAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.smart_colok);



        image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);


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



        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmartColok.this.finish();
            }
        });

        ListView listView = (ListView) findViewById(R.id.listView01);
        listView.setAdapter(myAdapter);
        time.clear();

        time.add("16:40");
        time.add("12:32");
        time.add("03:12");

        status.add("周一至周五");
        status.add("未开启");
        status.add("未开启");

        isOpen.add(true);
        isOpen.add(false);
        isOpen.add(false);

    }

    @Override
    protected void onResume() {
        myAdapter.notifyDataSetChanged();
        super.onResume();
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return time.size();
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
            Log.d("asd", time.size() + "");
            final int index = position;
            ViewGroup vg = (ViewGroup)getLayoutInflater().inflate(R.layout.list04, null);
            TextView t1 = (TextView) vg.findViewById(R.id.text01);
            TextView t2 = (TextView) vg.findViewById(R.id.text02);
            Switch switches = (Switch) vg.findViewById(R.id.switch1);
            t1.setText(time.get(position));
            t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("index", index);
                    intent.setClass(SmartColok.this, EditClock.class);
                    SmartColok.this.startActivity(intent);
                }
            });
            t2.setText(status.get(position));
            switches.setChecked(isOpen.get(position));
            return vg;
        }
    }
}

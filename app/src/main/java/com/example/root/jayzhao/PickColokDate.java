package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hm on 16-1-14.
 */
public class PickColokDate extends Activity {

    TextView title;
    Button button1, button2;

    List<String> strDate = new ArrayList<String>();
    ListView listView = null;
    int count = 0;

    List<Boolean> isPicked = new ArrayList<Boolean>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.pick_colok_date);
        super.onCreate(savedInstanceState);

        title = (TextView) findViewById(R.id.textView1);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickColokDate.this.finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickColokDate.this.finish();
            }
        });


        strDate.add("周一");
        strDate.add("周二");
        strDate.add("周三");
        strDate.add("周四");
        strDate.add("周五");
        strDate.add("周六");
        strDate.add("周日");
        isPicked.add(false);
        isPicked.add(true);
        isPicked.add(false);
        isPicked.add(false);
        isPicked.add(true);
        isPicked.add(false);
        isPicked.add(false);

        for(int i=0; i<isPicked.size(); i++) {
            if(isPicked.get(i)) count ++;
        }
        title.setText("已选择" + count + "项");

        listView = (ListView) findViewById(R.id.listView01);
        listView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return strDate.size();
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            final int index = position;
            parent = (ViewGroup)getLayoutInflater().inflate(R.layout.list05, null);
            final TextView t1 = (TextView) parent.findViewById(R.id.text01);

            final ImageButton image = (ImageButton) parent.findViewById(R.id.image01);
            if(isPicked.get(position))
                image.setImageDrawable(getResources().getDrawable(R.drawable.checkbox_checked));
            else
                image.setImageDrawable(getResources().getDrawable(R.drawable.checkbox_unchecked));

            image.getBackground().setAlpha(0);

            t1.setText(strDate.get(position));

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isPicked.get(index)) {
                        image.setImageDrawable(getResources().getDrawable(R.drawable.checkbox_unchecked));
                        isPicked.set(index, false);
                        count --;
                    } else {
                        image.setImageDrawable(getResources().getDrawable(R.drawable.checkbox_checked));
                        isPicked.set(index, true);
                        count ++;
                    }
                    title.setText("已选择" + count + "项");

                }
            });





            return parent;
        }
    }

}

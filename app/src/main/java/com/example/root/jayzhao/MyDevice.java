package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-1-11.
 */
public class MyDevice extends Activity {

    List<String> strs = new ArrayList<String>();
    List<String> strs1 = new ArrayList<String>();
    List<Bitmap> imageList01 = new ArrayList<Bitmap>();

    public void addButton() {
        final ImageButton imageButton01 = (ImageButton)findViewById(R.id.imagebutton01);
        imageButton01.getBackground().setAlpha(0);

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

        imageButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDevice.this.finish();
            }
        });
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return strs.size();
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
            ViewGroup vg = (ViewGroup)getLayoutInflater().inflate(R.layout.list03, null);

            TextView t = (TextView) vg.findViewById(R.id.text01);
            if(t == null) Log.d("TextView", "yes");
            t.setText(strs.get(position));
            ImageView image = (ImageView) vg.findViewById(R.id.image01);
            image.setImageBitmap(imageList01.get(position));

            TextView t2 = (TextView) vg.findViewById(R.id.text02);
            t2.setText(strs1.get(position));

            ImageButton imageButton01 = (ImageButton) vg.findViewById(R.id.image02);
            imageButton01.getBackground().setAlpha(0);

            return vg;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.mydevicelayout);
        Intent intent = this.getIntent();
        int index = intent.getIntExtra("index", -1);

        TextView tv = (TextView)findViewById(R.id.textView1);
        Log.d("index", index + "");
        Log.d("size", MainActivity.str02.size() + "");
        tv.setText(MainActivity.str02.get(index));

        addButton();

        Resources res=getResources();

        imageList01.add(BitmapFactory.decodeResource(res, R.drawable.shoes_lining_liejun_color));
        imageList01.add(BitmapFactory.decodeResource(res, R.drawable.shoes_lining_liejun_color));
        imageList01.add(BitmapFactory.decodeResource(res, R.drawable.shoes_lining_liejun_color));

        strs.add("小米手环");
        strs.add("小米体重秤");
        strs.add("李宁智能跑鞋");
        strs1.add("已绑定");
        strs1.add("未绑定");
        strs1.add("未绑定");

        ListView listView = (ListView) findViewById(R.id.list01);
        listView.setAdapter(new MyAdapter());

    }

}

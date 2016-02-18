package com.example.root.jayzhao;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> strs = new ArrayList<String>();
    ViewGroup.LayoutParams lp = null;
    ListView listView01 = null;
    boolean isUp = false;
    LinearLayout layout01 = null;
    Toolbar toolbar = null;
    MyDialogFragment df;

    public static List<String> str02 = new ArrayList<String>();

    ImageButton imageButton01 = null;
    ImageButton imageButton02 = null;

    List<Fragment> fragmentList = null;
    ViewPager viewPager = null;
    MyHandler handler = new MyHandler();

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            lp.height = msg.what;
            layout01.setLayoutParams(lp);
            super.handleMessage(msg);
        }
    }

    class MyThread implements Runnable {
        int start = 0;
        int end = 0;
        int flag = 0;
        MyThread(int start, int end, int flag) {
            this.start = start;
            this.end = end;
            this.flag = flag;
        }
        @Override
        public void run() {
            while(start != end) {
                if(flag == 1) {
                    start += 100;
                }
                else {
                    start -= 100;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(start);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(-1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Hello from Windows!!!", Toast.LENGTH_SHORT).show();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        imageButton01 = (ImageButton) findViewById(R.id.imagebutton01);
        imageButton01.getBackground().setAlpha(0);

        imageButton02 = (ImageButton)findViewById(R.id.imagebutton02);
        imageButton02.getBackground().setAlpha(0);

        imageButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                df = new MyDialogFragment(MainActivity.this);
                df.setCancelable(true);

                df.show(getFragmentManager(), "");
            }
        });

        imageButton02.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageButton02.setImageDrawable(getResources().getDrawable(R.drawable.btn_more_pressed));
                        break;
                    case MotionEvent.ACTION_UP:
                        imageButton02.setImageDrawable(getResources().getDrawable(R.drawable.btn_more_normal));
                        break;
                }
                return false;
            }
        });

        imageButton01.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.btn_statistic_pressed));
                        break;
                    case MotionEvent.ACTION_UP:
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.btn_statistic_normal));
                        break;
                }
                return false;
            }
        });

        strs.add("每天8000步赢春节双重福利，100%有礼");
        strs.add("8:16~8.27活动了8分钟，共286米");
        strs.add("6:56~7:09走了1348步，共1公里");
        strs.add("3:30~5:40走了1348步，共1公里");
        strs.add("9:16~11.27活动了8分钟，共286米");

        str02.clear();
        str02.add("我的设备");
        str02.add("智能闹钟");
        str02.add("个人信息");
        str02.add("跑步");
        str02.add("服务");
        str02.add("亲友");
        str02.add("心率");
        str02.add("分享");

        layout01 = (LinearLayout)findViewById(R.id.linearlayout02);
        lp = layout01.getLayoutParams();
        lp.height = 3000;
        layout01.setLayoutParams(lp);

        listView01 = (ListView)findViewById(R.id.listView01);
        MyAdapter adapter = new MyAdapter();
        listView01.setAdapter(adapter);
        listView01.setOnTouchListener(new View.OnTouchListener() {
            float firstY = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        if (firstY >= event.getY()) {
                            isUp = false;
                            Log.d("1", "Up");

                        } else {
                            isUp = true;

                            if (lp.height == 500) {
                                new Thread(new MyThread(500, 3000, 1)).start();
                            }
                            Log.d("1", "Down");
                        }
                        firstY = event.getY();
                        break;
                }
                return false;
            }
        });

        listView01.setOnScrollListener(new AbsListView.OnScrollListener() {
            int firstIndex = 0;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        Log.d("2", "fling");
                        if (!isUp) {
                            new Thread(new MyThread(3000, 500, 0)).start();
                        }
                        firstIndex = view.getFirstVisiblePosition();
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });

        fragmentList = new ArrayList<Fragment>();
        viewPager = (ViewPager) findViewById(R.id.viewPager01);

        Fragment fragment01 = new Fragment() {
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_layout, container, false);
                TextView tv = (TextView) view.findViewById(R.id.textViewxx);
                tv.setText("昨晚睡了7小时25分");
                return view;
            }
        };

        Fragment fragment02 = new Fragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_layout, container, false);
                TextView tv = (TextView) view.findViewById(R.id.textViewxx);
                tv.setText("1886步");
                return view;
            }
        };

        Fragment fragment03 = new Fragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_layout, container, false);
                TextView tv = (TextView) view.findViewById(R.id.textViewxx);
                tv.setText("67.0公斤");
                return view;
            }
        };

        fragmentList.add(fragment01);
        fragmentList.add(fragment02);
        fragmentList.add(fragment03);

        //给ViewPager设置适配器
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1);  //设置当前显示标签页为第2页
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                LinearLayout linearLayout01 = (LinearLayout)findViewById(R.id.linearlayout02);
                Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
                TextView t = (TextView) findViewById(R.id.textView1);
                switch (position) {
                    case 0:
                        linearLayout01.setBackgroundColor(getResources().getColor(R.color.myColor2));
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.btn_statistic_normal));
                        t.setText("昨晚睡眠");
                        toolbar.setBackgroundColor(getResources().getColor(R.color.myColor2));
                        break;
                    case 1:
                        linearLayout01.setBackgroundColor(getResources().getColor(R.color.myColor));
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.btn_statistic_normal));
                        t.setText("今日活动");
                        toolbar.setBackgroundColor(getResources().getColor(R.color.myColor));
                        break;
                    case 2:
                        linearLayout01.setBackgroundColor(getResources().getColor(R.color.myColor1));
                        t.setText("未绑定体重秤");
                        imageButton01.setImageDrawable(getResources().getDrawable(R.drawable.btn_statistic_weight_normal));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.myColor1));
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    @Override
    protected void onPause() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.remove(df);
        ft.commit();
        super.onPause();
    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
            ViewGroup vg = (ViewGroup) getLayoutInflater().inflate(R.layout.list01, null);
            TextView t1 = (TextView)vg.findViewById(R.id.textView2);
            if(position == 0 || position == 1) {
                ImageView imageView01 = (ImageView) vg.findViewById(R.id.imageView01);
                imageView01.setImageDrawable(getResources().getDrawable(R.drawable.game_banner_icon));
            }
            ImageButton imageButton02 = (ImageButton) vg.findViewById(R.id.imageButton02);
            imageButton02.getBackground().setAlpha(0);

            t1.setText(strs.get(position));
            return vg;
        }
    }
}

package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hm on 16-1-19.
 */
public class Weibo extends Activity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.wx_layout);
        super.onCreate(savedInstanceState);

        ImageButton Weixin = (ImageButton) findViewById(R.id.imageQQ);
        Weixin.getBackground().setAlpha(0);


        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Weibo.this.finish();
            }
        });

        tv = (TextView) findViewById(R.id.textView1);
        tv.setText("绑定微博");


    }
}

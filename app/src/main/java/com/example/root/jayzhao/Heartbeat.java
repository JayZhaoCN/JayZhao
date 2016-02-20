package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by root on 16-1-12.
 */
public class Heartbeat extends Activity {
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setContentView(R.layout.heartbeat_layout);

        final ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);

        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Heartbeat.this.finish();
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

        Button button1 = (Button) findViewById(R.id.button01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://m.mi.com/1/#/product/view?product_id=1154500018");
                intent.setData(content_url);
                startActivity(intent);
            }
        });

        super.onCreate(savedInstanceState);


    }


}

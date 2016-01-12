package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by root on 16-1-12.
 */
public class Heartbeat extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setContentView(R.layout.heartbeat_layout);

        ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);

        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Heartbeat.this.finish();
            }
        });

        super.onCreate(savedInstanceState);
    }
}

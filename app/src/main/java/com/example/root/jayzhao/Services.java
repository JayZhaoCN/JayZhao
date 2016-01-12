package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by root on 16-1-12.
 */
public class Services extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setContentView(R.layout.services_layout);

        ImageButton image01 = (ImageButton) findViewById(R.id.imagebutton01);
        image01.getBackground().setAlpha(0);
        image01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.this.finish();
            }
        });
        ImageButton image02 = (ImageButton) findViewById(R.id.imagebutton02);
        image02.getBackground().setAlpha(0);
        ImageButton image03 = (ImageButton) findViewById(R.id.imagebutton03);
        image03.getBackground().setAlpha(0);
        ImageButton image04 = (ImageButton) findViewById(R.id.imagebutton04);
        image04.getBackground().setAlpha(0);
        ImageButton image05 = (ImageButton) findViewById(R.id.imagebutton05);
        image05.getBackground().setAlpha(0);
        ImageButton image06 = (ImageButton) findViewById(R.id.imagebutton06);
        image06.getBackground().setAlpha(0);
        ImageButton image07 = (ImageButton) findViewById(R.id.imagebutton07);
        image07.getBackground().setAlpha(0);
        ImageButton image08 = (ImageButton) findViewById(R.id.imagebutton08);
        image08.getBackground().setAlpha(0);
        ImageButton image09 = (ImageButton) findViewById(R.id.imagebutton09);
        image09.getBackground().setAlpha(0);





        super.onCreate(savedInstanceState);
    }
}

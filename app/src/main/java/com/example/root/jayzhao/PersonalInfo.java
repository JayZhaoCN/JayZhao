package com.example.root.jayzhao;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by root on 16-1-11.
 */
public class PersonalInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.personal_info_layout);

        ImageButton imageButton01 = (ImageButton) findViewById(R.id.imagebutton01);
        imageButton01.getBackground().setAlpha(0);
        ImageButton imageButton02 = (ImageButton) findViewById(R.id.imagebutton02);
        imageButton02.getBackground().setAlpha(0);
        ImageButton imageButton03 = (ImageButton) findViewById(R.id.imagebutton03);
        imageButton03.getBackground().setAlpha(0);
        ImageButton imageButton04 = (ImageButton) findViewById(R.id.imagebutton04);
        imageButton04.getBackground().setAlpha(0);
        ImageButton imageButton05 = (ImageButton) findViewById(R.id.imagebutton05);
        imageButton05.getBackground().setAlpha(0);
        ImageButton imageButton06 = (ImageButton) findViewById(R.id.imagebutton06);
        imageButton06.getBackground().setAlpha(0);
        ImageButton imageButton07 = (ImageButton) findViewById(R.id.imagebutton07);
        imageButton07.getBackground().setAlpha(0);
        ImageButton imageButton08 = (ImageButton) findViewById(R.id.imagebutton08);
        imageButton08.getBackground().setAlpha(0);

        ImageButton imageButton09 = (ImageButton) findViewById(R.id.imagebutton09);
        imageButton09.getBackground().setAlpha(0);

        imageButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInfo.this.finish();
            }
        });







        super.onCreate(savedInstanceState);
    }
}

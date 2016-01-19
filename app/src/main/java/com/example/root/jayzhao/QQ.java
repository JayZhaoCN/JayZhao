package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016/1/18.
 */
public class QQ extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.qq_layout);

        ImageButton QQ = (ImageButton) findViewById(R.id.imageQQ);
        QQ.getBackground().setAlpha(0);


        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QQ.this.finish();
            }
        });

    }
}

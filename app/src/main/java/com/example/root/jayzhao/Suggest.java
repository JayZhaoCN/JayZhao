package com.example.root.jayzhao;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016/1/18.
 */
public class Suggest extends Activity {

    boolean keyboardVisable = false;
    int keyboardHeight = 0;
    int heightx = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.suggest_layout);
        super.onCreate(savedInstanceState);

        final EditText suggest = (EditText) findViewById(R.id.edit02);

        final ViewGroup.LayoutParams params = suggest.getLayoutParams();
        heightx = params.height;

        final View decorView = this.getWindow().getDecorView();

        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                decorView.getWindowVisibleDisplayFrame(rect);
                int displayHeight = rect.bottom - rect.top;
                int height = decorView.getHeight();
                keyboardHeight = height - displayHeight;
                if(keyboardHeight > 50 && keyboardVisable == true) {
                }
                else if(keyboardHeight > 50 && keyboardVisable == false) {
                    keyboardVisable = true;
                    params.height -= keyboardHeight - 100;
                    suggest.setLayoutParams(params);
                }
                else if(keyboardVisable == true) {
                    keyboardVisable = false;
                    params.height = heightx;
                    suggest.setLayoutParams(params);
                }
            }
        });







        final ImageButton back = (ImageButton) findViewById(R.id.back);
        back.getBackground().setAlpha(0);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suggest.this.finish();
            }
        });

        back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        back.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev_2));
                        break;
                    case MotionEvent.ACTION_UP:
                        back.setImageDrawable(getResources().getDrawable(R.drawable.ic_indicator_prev));
                        break;
                }
                return false;
            }
        });
    }
}

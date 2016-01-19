package com.example.root.jayzhao;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by hm on 16-1-19.
 */
public class Weixin extends Activity {

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
                Weixin.this.finish();
            }
        });

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialogFragment df = new MyDialogFragment();
                df.setCancelable(true);
                df.show(getFragmentManager(), null);

                Toast.makeText(Weixin.this, "额，似乎微信还没有给我开放接口...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyDialogFragment extends DialogFragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            container = (ViewGroup) inflater.inflate(R.layout.weixin_progress, null);
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            return container;
        }

        @Override
        public void onStart() {
            super.onStart();

            final WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
            layoutParams.gravity = Gravity.BOTTOM;
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            getDialog().getWindow().setAttributes(layoutParams);
        }


    }

}

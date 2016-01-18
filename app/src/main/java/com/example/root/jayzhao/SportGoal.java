package com.example.root.jayzhao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by hm on 16-1-18.
 */
public class SportGoal extends Activity {
    NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setContentView(R.layout.sport_goal);
        super.onCreate(savedInstanceState);

        np = (NumberPicker) findViewById(R.id.picker01);
        String [] display = new String[29];
        for(int i=2; i<=30; i++) {
            display[i-2] = 1000*i + "";
        }
        np.setDisplayedValues(display);
        np.setMinValue(0);
        np.setMaxValue(28);
        np.setValue(6);

        Button cancel = (Button) findViewById(R.id.cancel);
        Button confirm = (Button) findViewById(R.id.confirm);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportGoal.this.finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SportGoal.this.finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInfo.sportGoal = np.getValue();
                SportGoal.this.finish();
            }
        });

    }
}

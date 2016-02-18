package com.example.root.jayzhao;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by hm on 16-2-17.
 */
public class Login extends Activity {

    public ProgressBar progressBar;

    MyService myService = null;

    MyReceiver receiver;

    Boolean first = false;

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.MyBinder myBinder = (MyService.MyBinder) service;
            myService = myBinder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = intent.getStringExtra("msg");
            if(msg.equals("s")) {
                Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Login.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        if(first) {
            unbindService(conn);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login_layout);



        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MY_BROADCAST");
        registerReceiver(receiver, filter);

        SharedPreferences mySharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE);

        progressBar = (ProgressBar) findViewById(R.id.login_progress);

        if(mySharedPreferences.getBoolean("firststart", true)) {
            first = true;

            Intent intent = new Intent(Login.this, MyService.class);
            bindService(intent, conn, BIND_AUTO_CREATE);

            final EditText username = (EditText) findViewById(R.id.username);
            final EditText password = (EditText) findViewById(R.id.password);

            Button loginButton = (Button) findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String usernameStr = username.getText().toString();
                    String passwordStr = password.getText().toString();


                    myService.login(usernameStr, passwordStr, Login.this);
                }
            });
        }
        else {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void jump() {
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

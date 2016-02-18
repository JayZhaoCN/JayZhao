package com.example.root.jayzhao;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by hm on 16-2-17.
 */
public class MyService extends Service {

    MyHandler handler = new MyHandler();

    boolean success = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public void login(String name, String password, final Login login) {
        final String name1 = name;
        final String password1 = password;

        new Thread(new Runnable() {

            DataOutputStream dos = null;
            DataInputStream dis = null;

            @Override
            public void run() {
                try {
                    Socket client = new Socket("192.168.123.1", 8888);
                    dos = new DataOutputStream(client.getOutputStream());
                    dis = new DataInputStream(client.getInputStream());

                    dos.writeUTF(name1);
                    dos.writeUTF(password1);

                    //login.progressBar.setVisibility(View.VISIBLE);


                    if(dis.readUTF().equals("accept")) {
                        success = true;
                        handler.sendEmptyMessage(1);
                        login.jump();


                    }
                    else {
                        success = false;
                        handler.sendEmptyMessage(0);
                    }
                    //login.progressBar.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {

                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "s");
                sendBroadcast(intent);

                SharedPreferences mySharedPreferences= getSharedPreferences("test", Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putBoolean("firststart", false);
                editor.commit();

            }
            else {
                Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                intent.putExtra("msg", "f");
                sendBroadcast(intent);
            }
        }
    }
}

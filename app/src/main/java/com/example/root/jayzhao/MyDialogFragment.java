package com.example.root.jayzhao;



import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class MyDialogFragment extends DialogFragment {

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return MainActivity.str02.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final int index = position;

            ViewGroup vg = (ViewGroup) getLayoutInflater(null).inflate(R.layout.list02, null);



            vg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent();
                    intent.putExtra("index", index);
                    switch (index) {
                        case 0:
                            intent.setClass(getContext(), MyDevice.class);
                            getContext().startActivity(intent);
                            break;
                        case 2:
                            intent.setClass(getContext(), PersonalInfo.class);
                            getContext().startActivity(intent);

                            break;
                        case 4:
                            intent.setClass(getContext(), Services.class);
                            getContext().startActivity(intent);
                            break;
                        case 6:
                            intent.setClass(getContext(), Heartbeat.class);
                            getContext().startActivity(intent);
                            break;

                    }

                }
            });

            TextView tv = (TextView) vg.findViewById(R.id.textView01);
            tv.setText(MainActivity.str02.get(position));
            return vg;
        }
    }



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        Dialog dialog = new Dialog(getActivity(), R.style.AppTheme);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // must be called before set content
        dialog.setContentView(R.layout.listview);
        dialog.setCanceledOnTouchOutside(true);
        ListView listView01 = (ListView)dialog.findViewById(R.id.listView01);
        listView01.setAdapter(new MyAdapter());

        Window window = dialog.getWindow();

        dialog.setCanceledOnTouchOutside(true);

        //window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //设置dialog的透明度
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(wlp);

        return dialog;
    }
}

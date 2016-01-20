package com.example.root.jayzhao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by hm on 16-1-20.
 */
public class MySwitch extends View implements View.OnClickListener {

    int index = 0;
    public MySwitch(Context context) {
        this(context, null);
        // TODO Auto-generated constructor stub
    }

    public MySwitch(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        // TODO Auto-generated constructor stub
    }

    public MySwitch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
        init();
    }

    private Bitmap thumb, thumbEnable, track, thumbDisable;
    int maxMove;
    int move = 0;
    float current = 0;
    float first = 0;
    boolean switchOn  =true;
    Rect mDest, mSrc;
    public static Bitmap resizeImage(Bitmap bitmap, int w, int h) {
        Bitmap BitmapOrg = bitmap;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        int newWidth = w;
        int newHeight = h;

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
                height, matrix, true);
        return resizedBitmap;
    }


    public void init() {
        thumbEnable = BitmapFactory.decodeResource(getResources(),
                R.drawable.switch_thumb_enable);

        track = BitmapFactory.decodeResource(getResources(),
                R.drawable.switch_track_enable);
        thumbDisable = BitmapFactory.decodeResource(getResources(),
                R.drawable.switch_thumb_disable);
        thumbEnable = resizeImage(thumbEnable, 50, 50);
        thumbDisable = resizeImage(thumbDisable, 50, 50);
        track =  resizeImage(track, 100, 50);
        thumb = thumbEnable;


        maxMove = track.getWidth() - thumb.getWidth();
        mSrc = new Rect(0, 0, thumb.getWidth(), thumb.getHeight());
        mDest = new Rect();


        setOnClickListener(this);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                first = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                current = event.getX();
                move = (int)(current - first);
                if((switchOn && move < 0)||(!switchOn && move > 0)) {
                    move = 0;
                }
                if(Math.abs(move) > maxMove) {
                    move = move > 0 ? maxMove : -maxMove;
                }
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                if(move != 0 && Math.abs(move) < maxMove/2) {
                    move = 0;
                    invalidate();
                    return true;
                }
                else if(Math.abs(move) >= maxMove/2 && Math.abs(move) < maxMove) {
                    move = move > 0? maxMove:-maxMove;
                    if(switchOn) {
                        switchOn = false;
                        thumb = thumbDisable;
                    }
                    else {
                        switchOn = true;
                        thumb = thumbEnable;
                    }
                    move = 0;
                    invalidate();
                    return true;
                }
                return super.onTouchEvent(event);
            case MotionEvent.ACTION_CANCEL:
                if(move != 0 && Math.abs(move) < maxMove/2) {
                    move = 0;
                    invalidate();
                    return true;
                }
                else if(Math.abs(move) >= maxMove/2 && Math.abs(move) < maxMove) {
                    move = move > 0? maxMove:-maxMove;
                    if(switchOn) {
                        switchOn = false;
                        thumb = thumbDisable;
                    }
                    else {
                        switchOn = true;
                        thumb = thumbEnable;
                    }
                    move = 0;
                    invalidate();
                    return true;
                }
                return super.onTouchEvent(event);
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  //设置控件的尺寸
        // TODO Auto-generated method stub
        setMeasuredDimension(track.getWidth(), track.getHeight());
    }



    @Override
    protected void onDraw(Canvas canvas) {

        if(move > 0 || move == 0 && switchOn) {
            mDest.set(move, 0, move + thumb.getWidth(), thumb.getHeight());
        }
        else if(move < 0 || move == 0 && !switchOn){
            mDest.set(move + track.getWidth() - thumb.getWidth(), 0, move + track.getWidth(), thumb.getHeight());
        }

        canvas.drawBitmap(track, 0, 0, null);
        canvas.drawBitmap(thumb, mSrc, mDest, null);

        super.onDraw(canvas);
    }

    @Override
    public void onClick(View v) {
        //Log.d("Jay", "Clicked!!!+'" + ++index);
        if(switchOn) {
            switchOn = false;
            move = maxMove;
            thumb = thumbDisable;
        }
        else {
            switchOn = true;
            move = -maxMove;
            thumb = thumbEnable;
        }
        invalidate();
    }
}

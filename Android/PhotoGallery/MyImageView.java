package com.example.photogallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

@SuppressLint("AppCompatCustomView")
public class MyImageView extends ImageView {

    private Bitmap mBitmap;
    private int imageWidth;
    private int imageHeight;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private final static float minZoom =  0.1f;
    private final static float maxZoom = 10.0f;
    private final static int NONE = 0;
    private final static int PAN = 1;
    private final static int ZOOM = 2;
    private int eventState;
    private float startX = 0;
    private float startY = 0;
    private float moveX = 0;
    private float moveY = 0;
    private float prevMoveX = 0;
    private float prevMoveY = 0;


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(minZoom,
                    Math.min(mScaleFactor, maxZoom));
            return true;
        }
    }


    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        eventState = PAN;
                        startX = event.getX() - prevMoveX;
                        startY = event.getY() - prevMoveY;
                        break;
                    case MotionEvent.ACTION_UP:
                        eventState = NONE;
                        prevMoveX = moveX;
                        prevMoveY = moveY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        eventState = PAN;
                        moveX = event.getX() - startX;
                        moveY = event.getY() - startY;
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        eventState = ZOOM;

                        break;
                }
                mScaleGestureDetector.onTouchEvent(event);
                if(eventState == PAN && mScaleFactor != minZoom || eventState == ZOOM) {
                    invalidate();
                    requestLayout();
                }
        mScaleGestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int scaledWidth = Math.round(imageWidth * mScaleFactor);
        int scaledHeight = Math.round(imageHeight * mScaleFactor);

        setMeasuredDimension(Math.min(width, scaledWidth), Math.min(height, scaledHeight));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        //canvas.scale(mScaleFactor, mScaleFactor, mScaleGestureDetector.getFocusX(), mScaleGestureDetector.getFocusY());
        canvas.scale(mScaleFactor,mScaleFactor);
        if((moveX * -1)< 0){
            moveX = 0;
        }else if((moveX * -1) > imageWidth * mScaleFactor - getWidth()){
            moveX = (imageWidth * mScaleFactor - getWidth()) * -1;
        }
        if((moveY * -1)< 0){
            moveY = 0;
        }else if((moveY * -1) > imageHeight * mScaleFactor - getHeight()){
            moveY = (imageHeight * mScaleFactor - getHeight()) * -1;
        }
        canvas.translate(moveX/mScaleFactor, moveY/mScaleFactor);
        canvas.drawBitmap(mBitmap, 0 , (this.getMeasuredHeight() - imageHeight)/2, null);
        canvas.restore();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setmBitmap(Bitmap bitmap){
        float ratio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        imageWidth = displayMetrics.widthPixels;
        imageHeight = Math.round(imageWidth * ratio);
        mBitmap = Bitmap.createScaledBitmap(bitmap, imageWidth, imageHeight, false);

        invalidate();
        requestLayout();
    }
}

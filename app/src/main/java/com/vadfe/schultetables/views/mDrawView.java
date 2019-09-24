package com.vadfe.schultetables.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class mDrawView extends SurfaceView implements SurfaceHolder.Callback {
    private Context context;
    private mDrawThread drawThread;

    public mDrawView(Context _context, AttributeSet attrs){
        super(_context, attrs);
        this.context = _context;
        getHolder().addCallback(this);
    }


    /*@Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
    }*/

    public mDrawView(Context _context) {
        super(_context);
        this.context = _context;
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new mDrawThread(getHolder(), this.context, getMeasuredWidth(), getMeasuredHeight());
        drawThread.setRunning(true);
        drawThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        drawThread.setRunning(false);
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }
    }
}

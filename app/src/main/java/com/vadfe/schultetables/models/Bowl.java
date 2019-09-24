package com.vadfe.schultetables.models;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Bowl {
    private double size = 0.0;
    private double speed = 0.0;
    private double x = 0.0;
    private double y  = 0.0;
    private int containerWidth;
    private int containerHeight;
    private Drawable drawable;
    private Rect rect;
    private Paint p;
    private Vector2D vector;

    public Bowl(int _containerWidth, int _containerHeight, Drawable _drawable){
        this.containerWidth = _containerWidth;
        this.containerHeight = _containerHeight;
        this.drawable = _drawable;
        rect = new Rect(0,0,_containerWidth,_containerHeight);
        p = new Paint();
        p.setColor(Color.WHITE);
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.FILL);
        this.vector = new Vector2D();
        reset();
    }

    private void reset() {

        size = Math.random() * 50 / 2 + 50 / 2;
        //speed = 60;//Math.random() * 30 / 2 + 30 / 2;
        y = Math.random() * containerHeight;
        x = Math.random() * containerWidth;
    }

    public void update() {
        x += this.vector.xkat;//speed;
        y += this.vector.ykat;//speed;
        if (y > containerHeight || y < 0) {
            //reset();
            this.vector.reversY();
        }
        if (x > containerWidth || x < 0) {
            //reset();
            this.vector.reversX();
        }
    }

    public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        canvas.drawRect(rect, p);
        drawable.setBounds((int) x,(int) y,(int) (x + size), (int) (y + size));
        drawable.draw(canvas);
    }
}

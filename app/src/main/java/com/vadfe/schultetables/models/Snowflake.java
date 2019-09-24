package com.vadfe.schultetables.models;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class Snowflake {

    private double size = 0.0;
    private double speed = 0.0;
    private double x = 0.0;
    private double y  = 0.0;

    private int containerWidth;
    private int containerHeight;
    private Drawable drawable;
    private float maxSize;
    private float maxSpeed;

    public Snowflake(int _containerWidth, int _containerHeight, Drawable _drawable, float _maxSize, float _maxSpeed){
        this.containerWidth = _containerWidth;
        this.containerHeight = _containerHeight;
        this.drawable = _drawable;
        this.maxSize = _maxSize;
        this.maxSpeed = _maxSpeed;
        reset();
    }

    private void reset() {
        size = Math.random() * maxSize / 2 + maxSize / 2;
        speed = Math.random() * maxSpeed / 2 + maxSpeed / 2;
        y = -size;
        x = Math.random() * containerWidth;
    }

    public void update() {
        x += speed/2;
        y += speed;
        if (y > containerHeight) {
            reset();
        }
    }
     public void draw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        drawable.setBounds((int) x,(int) y,(int) (x + size), (int) (y + size));
        drawable.draw(canvas);
     }

}


package com.vadfe.schultetables.models;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RoundDraw extends Drawable {
    Paint p;

    public RoundDraw(){
        p = new Paint();
        p.setStrokeWidth(3);
    }
    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(100, 200, 50, p);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }
}

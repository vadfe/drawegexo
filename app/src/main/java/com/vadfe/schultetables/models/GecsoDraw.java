package com.vadfe.schultetables.models;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.vadfe.schultetables.utils.Point2d;

import java.util.ArrayList;

public class GecsoDraw extends Drawable {
    private float width;
    private float heith;
    Paint p;
    ArrayList<Point2d> coords;

    public GecsoDraw(){
        p = new Paint();
        p.setStrokeWidth(3);
        coords = new ArrayList<Point2d>();
    }

    private void fillPoints(){
        for(int i = 0; i < 361; i+=60){
            double angleInRadian = Math.toRadians(i);
            double angleInRadian2 = Math.toRadians(i+60);
            float tx1 = (float) Math.sin(angleInRadian)*this.width/2+this.width/2;
            float ty1 = (float) Math.cos(angleInRadian)*this.heith/2+this.heith/2;
            float tx2 = (float) Math.sin(angleInRadian2)*this.width/2+this.width/2;
            float ty2 = (float) Math.cos(angleInRadian2)*this.heith/2+this.heith/2;
            coords.add(new Point2d(tx1,ty1));
            coords.add(new Point2d(tx2,ty2));
        }
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        width = bounds.right-bounds.left;
        heith = bounds.bottom-bounds.top;
        fillPoints();
    }


    @Override
    public void draw(@NonNull Canvas canvas) {
        for(int i = 0; i<coords.size()-1; i++){
            canvas.drawLine(coords.get(i).x, coords.get(i).y, coords.get(i+1).x, coords.get(i+1).y, p);
        }

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

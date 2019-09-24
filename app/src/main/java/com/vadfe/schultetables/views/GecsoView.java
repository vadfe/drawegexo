package com.vadfe.schultetables.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.vadfe.schultetables.utils.Point2d;

import java.util.ArrayList;

public class GecsoView extends View {
    private float width;
    private float heith;
    Paint p;
    ArrayList<Point2d> coords;
    String letter;
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i<coords.size()-1; i++){
            canvas.drawLine(coords.get(i).x, coords.get(i).y, coords.get(i+1).x, coords.get(i+1).y, p);
        }

        p.setColor(Color.BLUE);
        p.setTextSize(30);
        canvas.drawText("text left", 150, 500, p);
    }


    public GecsoView(Context context) {
        super(context);
    }

    public GecsoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        letter = attrs.getAttributeValue(0);
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = getMeasuredWidth();
        this.heith = getMeasuredHeight();
        fillPoints();
    }

}

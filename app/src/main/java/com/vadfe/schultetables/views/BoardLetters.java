package com.vadfe.schultetables.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BoardLetters extends View {
    private float width;
    private float heith;
    Paint p;
    Rect rect;
    StringBuilder sb;
    public BoardLetters(Context context, AttributeSet attrs){
        super(context);

        p = new Paint();

        sb = new StringBuilder();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = getMeasuredWidth();
        this.heith = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect = new Rect(10,10,(int) this.width-10, (int) this.heith-10);
        canvas.drawARGB(80, 102, 204, 255);
        p.setColor(Color.BLUE);
        p.setStrokeWidth(12);
        p.setTextSize(this.width/2);
        sb.setLength(0);
        sb.append("A");
        canvas.drawText(sb.toString(), this.width/2, this.heith/2, p);

        p.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, p);
        Log.w("trtr", "wdt="+getMeasuredWidth());
    }

}

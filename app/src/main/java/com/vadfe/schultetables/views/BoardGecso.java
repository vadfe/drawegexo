package com.vadfe.schultetables.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.vadfe.schultetables.models.GecsoDraw;
import com.vadfe.schultetables.utils.Point2d;

import java.util.ArrayList;
import java.util.List;

public class BoardGecso extends View {
    private float width;
    private float heith;
    ArrayList<GecsoDraw> gd;
    @Override
    protected void onDraw(Canvas canvas) {
        /*for (int i=0;i<6;i++){

        }*/
        for (GecsoDraw gsd: gd) {
            gsd.draw(canvas);
        }
    }

    private void setPosition(){
        for(int i=0;i<6;i++){
            double angleInRadian = Math.toRadians(i*60);
            float tx1 = (float) Math.sin(angleInRadian)*this.width/2/6+this.width/2/6;
            float ty1 = (float) Math.cos(angleInRadian)*this.heith/2/6+this.heith/2/6;
            gd.get(i).setBounds((int) tx1,(int) ty1,(int) (tx1+this.width/6),(int) (ty1+this.heith/6));
            Log.w("trtr","setPosition left="+gd.get(i).getBounds().left+" top="+gd.get(i).getBounds().top+" right="+gd.get(i).getBounds().right+" bottom="+gd.get(i).getBounds().bottom);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = getMeasuredWidth();
        this.heith = getMeasuredHeight();
        Log.w("trtr","onMeasure width="+this.width+" heith="+this.heith);
        setPosition();
    }

    public BoardGecso(Context context) {
        super(context);
    }

    public BoardGecso(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        gd = new ArrayList<GecsoDraw>();
        for (int i =0; i<6; i++){
            gd.add(new GecsoDraw());
        }

    }
}

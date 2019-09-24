package com.vadfe.schultetables.models;

import android.util.Log;

public class Vector2D {
    public double angle;
    public double xkat;
    public double ykat;

    public  Vector2D(){
        this.xkat = Math.random() * 50;
        this.ykat = Math.random() * 50;
        //this.angle = Math.atan(this.xkat/this.ykat);
        //Log.w("trtr", "Vector2D atan="+angle+" tan="+(this.xkat/this.ykat));
    }

    public void reversX(){
        this.xkat = -this.xkat;
    }

    public void reversY(){
        this.ykat = -this.ykat;
    }

}

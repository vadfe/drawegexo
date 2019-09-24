package com.vadfe.schultetables.utils;

import java.util.List;

public class Utils {

    public static float[] list2arr(List<Point2d> list){
        int sz = list.size()*2;
        float[] res = new float[sz];
        for(int i =0; i<sz; i++){
            res[i] = list.get(Math.round(i/2)).x;
            res[i] = list.get(Math.round(i/2)).y;
        }
        return res;
    }
}

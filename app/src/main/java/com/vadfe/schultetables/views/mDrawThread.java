package com.vadfe.schultetables.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;

import com.vadfe.schultetables.R;
import com.vadfe.schultetables.models.Bowl;
import com.vadfe.schultetables.models.Snowflake;

import java.util.ArrayList;

public class mDrawThread  extends Thread {
    private ArrayList<Snowflake> snowflakes;
    private boolean cancelled = false;
    private boolean running = false;
    private SurfaceHolder surfaceHolder;
    private Bowl bowl;



    public mDrawThread(SurfaceHolder _surfaceHolder, Context _context, int _width, int _height) {
        this.surfaceHolder = _surfaceHolder;
        this.bowl = new Bowl(_width, _height, _context.getDrawable(R.drawable.snowflake));
        /*this.snowflakes = new ArrayList<Snowflake>();
        for (int i = 0; i < 10 ; i++){
            this.snowflakes.add(
                    new Snowflake(_width, _height,
                            _context.getDrawable(R.drawable.snowflake), 20, 20
                            //context.getResources().getDimension(R.dimen.max_snowflake_size),
                            //context.resources.getDimension(R.dimen.max_snowflake_speed)
                    )
            );
        }*/
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        Canvas canvas;

        while (running) {
            canvas = surfaceHolder.lockCanvas(null);

            try {

                if (canvas == null)
                    continue;
                drawBowl(canvas);
                //drawSnow(canvas);
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    private void drawBowl(Canvas canvas){
        //canvas.drawColor(Color.WHITE);
        bowl.update();
        bowl.draw(canvas);
    }

    private void drawSnow(Canvas canvas){
        //canvas.drawColor(Color.WHITE);
        for (Snowflake sn: snowflakes) {
            sn.update();
            sn.draw(canvas);
        }

    }

    private void draw_here(Canvas canvas){
        Paint p;
        Rect rect;
        p = new Paint();
        rect = new Rect();
        // заливка канвы цветом
        canvas.drawARGB(80, 102, 204, 255);

        // настройка кисти
        // красный цвет
        p.setColor(Color.RED);
        // толщина линии = 10
        p.setStrokeWidth(10);

        // рисуем точку (50,50)
        canvas.drawPoint(50, 50, p);

        // рисуем линию от (100,100) до (500,50)
        canvas.drawLine(100,100,500,50,p);

        // рисуем круг с центром в (100,200), радиус = 50
        canvas.drawCircle(100, 200, 50, p);

        // рисуем прямоугольник
        // левая верхняя точка (200,150), нижняя правая (400,200)
        canvas.drawRect(200, 150, 400, 200, p);

        // настройка объекта Rect
        // левая верхняя точка (250,300), нижняя правая (350,500)
        rect.set(250, 300, 350, 500);
        // рисуем прямоугольник из объекта rect
        canvas.drawRect(rect, p);
    }
}

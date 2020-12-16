package xyxgame.gameplane.GIf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;

import java.util.Random;

import xyxgame.gameplane.Base.BaseActivity;

public class TextDraw_copy {
    BaseActivity baseActivity;
    int i=0;


    public TextDraw_copy(BaseActivity baseActivity) {
        this.baseActivity=baseActivity;
        handler.postDelayed(new run(),0);

    }

    Handler handler=new Handler();
    class run implements Runnable{
        @Override
        public void run() {
            {

                if (!baseActivity.start){handler=null;return;}
               i=new Random().nextInt(10000);
                x=500;y=500;
                over=false;
                if (baseActivity.start)  handler.postDelayed(this,800);

            }
        }
    }


    int j=0;

    boolean over=false;
    int x=500,y=500;
    public void draw(Canvas canvas){
        if (!baseActivity.start)return;
        if (handler==null){handler=new Handler(Looper.getMainLooper()); handler.postDelayed(new run(),800);}

        if (over)return;

        j+=5;

        if (j>150){j=0;over=true;}


        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setTextSize(j);

        Typeface typeFace = Typeface.createFromAsset(baseActivity.getAssets(),"xyx.ttf");
        paint.setTypeface(typeFace);
//        canvas.drawText("-"+i,500,1000,paint);






        canvas.drawText("-"+i,x,y,paint);
        x+=2;
        y--;





    }
}

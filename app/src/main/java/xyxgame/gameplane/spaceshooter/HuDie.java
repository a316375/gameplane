package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import java.util.logging.LogRecord;

import xyxgame.gameplane.R;

public class HuDie {

    private   Bitmap resource;
    private   ArrayList<Bitmap> zeros;

    int i=0;
    int times;//每一帧整图出现的次数
    Handler handler=new  Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //TODO: Replace this with your own logic
            //超时需要重新启动超时执行功能
            handler.postDelayed(this,1000);
            i++;
            if (i>=times) i=0;
        }
    };

    public Bitmap getResult() {
        start();
        return zeros.get(i);
    }





    public HuDie(Context context,int drawable,int times) {
        this.times=times;
        resource = BitmapFactory.decodeResource(context.getResources(), drawable);

        zeros=new ArrayList<>();
        for (int i =0; i <times ; i++) {
            Bitmap bitmap = Bitmap.createBitmap(resource, resource.getWidth() * i / times, 0,
                    resource.getWidth() / times, resource.getHeight());

            zeros.add( Bitmap.createScaledBitmap(bitmap,bitmap.getWidth()*1/5,bitmap.getHeight()*1/5,false));
        }

    }

    public void start(){
        handler.postDelayed(runnable,0);//立即执行
    }

    public void pause(){
        handler.removeCallbacks(runnable);
    }
}

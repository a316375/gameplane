package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import java.util.logging.LogRecord;

import xyxgame.gameplane.GL.BTMAP;
import xyxgame.gameplane.R;

public class HuDie {

    private final Bitmap resource;
    private final ArrayList<Bitmap> zeros;


    int times;//每一帧整图出现的次数


    public Bitmap getResult( int count) {
        //start();

        return zeros.get((count/5)%times);
    }





    public HuDie(Context context, BTMAP btmap, int who, int times) {
        this.times=times;
        resource = btmap.getBitmaps().get(who);

        zeros=new ArrayList<>();
        for (int i =0; i <times ; i++) {
            Bitmap bitmap = Bitmap.createBitmap(resource, resource.getWidth() * i / times, 0,
                    resource.getWidth() / times, resource.getHeight());

            zeros.add( Bitmap.createScaledBitmap(bitmap,bitmap.getWidth()*1/5,bitmap.getHeight()*1/5,false));
        }

    }

    public void start(){
      //  handler.postDelayed(runnable,0);//立即执行
    }

    public void pause(){
      //  handler.removeCallbacks(runnable);
    }
}

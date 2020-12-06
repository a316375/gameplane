package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

import xyxgame.gameplane.R;

public class BTMAP {
    Context context;

    public ArrayList<Bitmap> getBitmaps() {
        return bitmaps;
    }

    ArrayList<Bitmap> bitmaps;


    int BG=0,Laser=1,Laser2=2,play=6;
    public BTMAP(Context context) {
        this.context = context;
        bitmaps=new ArrayList<>();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize=2;

        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg2,options));//0
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1,options));//1
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.my_bullet_purple,options));//2
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c2a,options));//3
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.aaa,options));//4
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.ea,options));//5
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c1,options));//6
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.spaceship_1_blue,options));//7
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg3,options));//8
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c2a,options));//9帧动画
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.a002,options));//10
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));

    }


}

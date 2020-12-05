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
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg2));//0
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));//1
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.my_bullet_purple));//2
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c2a));//3
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.aaa));//4
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.ea));//5
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c1));//6
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.spaceship_1_blue));//7
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg3));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));

    }


}

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

    public BTMAP(Context context) {
        this.context = context;
        bitmaps=new ArrayList<>();
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.bg2));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.my_bullet_purple));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.c2a));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.aaa));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.ea));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
        bitmaps.add(BitmapFactory.decodeResource(context.getResources(),R.drawable.laser_1));
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

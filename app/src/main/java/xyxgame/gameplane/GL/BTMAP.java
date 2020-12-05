package xyxgame.gameplane.GL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import java.util.ArrayList;

import xyxgame.gameplane.R;

public class BTMAP {
    Context context;
    private  BitmapFactory.Options options;

    public ArrayList<Bitmap> getBitmaps() {
        return bitmaps;
    }

    ArrayList<Bitmap> bitmaps;


    int BG=0,Laser=1,Laser2=2,play=6;
    public BTMAP(Context context) {
        this.context = context;
        bitmaps=new ArrayList<>();
        options = new BitmapFactory.Options();
//        options.inPreferredConfig=Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;

        bitmaps.add(Creat(R.drawable.bg2));//0
        bitmaps.add(Creat(R.drawable.laser_1));//1
        bitmaps.add(Creat(R.drawable.my_bullet_purple));//2
        bitmaps.add(Creat(R.drawable.c2a));//3
        bitmaps.add(Creat(R.drawable.aaa));//4
        bitmaps.add(Creat(R.drawable.ea));//5
        bitmaps.add(Creat(R.drawable.c1));//6
        bitmaps.add(Creat(R.drawable.spaceship_1_blue));//7
        bitmaps.add(Creat(R.drawable.laser_1));
        bitmaps.add(Creat(R.drawable.laser_1));
        bitmaps.add(Creat(R.drawable.laser_1));



    }

    public Bitmap Creat(int draw){



        Bitmap bitmap=BitmapFactory.decodeResource(context.getResources(),draw, options);
         //bitmap=Bitmap.createScaledBitmap(bitmap,bitmap.getWidth()/2,bitmap.getHeight()/2,false);

        return bitmap;
    }


}

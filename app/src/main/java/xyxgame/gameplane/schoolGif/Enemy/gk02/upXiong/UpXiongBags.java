package xyxgame.gameplane.schoolGif.Enemy.gk02.upXiong;

import android.graphics.Bitmap;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBags3;

public class UpXiongBags extends XiongBags3 {
    int i;
    boolean isleftout=false;
    boolean isrightout=false;
    public UpXiongBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        i=new Random().nextInt(10);
    }

    @Override
    public void drawpath() {

        y+=obj.speed;
        if (i%2==0){x+=1;}else {x-=1;}
        if (x<=0)isleftout=true;
        if (x>=obj.maXx-w)isrightout=true;
        if (isleftout)x+=2;
        if (isrightout)x-=2;



    }
}

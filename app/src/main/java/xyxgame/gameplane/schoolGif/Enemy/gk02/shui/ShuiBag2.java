package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;
import android.graphics.Path;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class ShuiBag2 extends ShuiBag{
    int i;
    public ShuiBag2(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        i=new Random().nextInt(10);
        Beser_path = new Path();

        intPath(obj,i);


    }

    private void intPath(GifObj obj,int i) {
        if (i%2==0){

        x=-obj.oW+10;y=0;
       Beser_path.moveTo(x, y);
        Beser_path.quadTo(obj.maXx/2-obj.oW/2, obj.maXy/2, obj.maXx+10, 0-20);

            beser_speed=400;

        }
        else {
            x=obj.maXx;y=0;
            Beser_path.moveTo(x, y);
           // Beser_path.quadTo(obj.maXx*3/4, obj.maXy/2, obj.maXx, 0);
            Beser_path.quadTo(obj.maXx/2-obj.oW/2,  obj.maXy/2,  -obj.oW-10, 0);
            beser_speed=400;
        }
    }
}

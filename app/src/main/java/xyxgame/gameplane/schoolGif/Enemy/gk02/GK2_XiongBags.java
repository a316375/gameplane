package xyxgame.gameplane.schoolGif.Enemy.gk02;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;

import java.util.concurrent.CopyOnWriteArrayList;


import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBags;


public class GK2_XiongBags extends XiongBags {

    private Path path;

    public GK2_XiongBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        path = new Path();
        path.moveTo(obj.maXx, 500);
        path.quadTo(obj.maXx/2, 800+obj.maXx/2, -obj.oW - 10, 500-10);


    }


    int iCurStep = 0;// current animation step

    @Override
    public void drawpath() {
        PathMeasure pm = new PathMeasure(path, false);
        float fSegmentLen = pm.getLength() / 200;//we'll get 20 points from path to animate the circle
        float afP[] = {0f, 0f};

        if (iCurStep <= 200) {
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
            //canvas.drawCircle(afP[0],afP[1],20,new UIPaint(null).paint2());
            x = (int) afP[0];
            y = (int) afP[1];
            iCurStep++;
            // invalidate();
        } else {
            iCurStep = 0;
        }
        ;

    }

}

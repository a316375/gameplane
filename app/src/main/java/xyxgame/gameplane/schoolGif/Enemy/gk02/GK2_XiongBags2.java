package xyxgame.gameplane.schoolGif.Enemy.gk02;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.XiongBags;

public class GK2_XiongBags2 extends XiongBags {

    private Path path;
    private PathMeasure pm;

    public GK2_XiongBags2(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);
        path = new Path();
        path.moveTo(-obj.oW+5, 500-50);
        path.quadTo(obj.maXx/2, 500-obj.maXx/2, obj.maXx+10, 500+10);


    }


    int iCurStep = 0;// current animation step

    @Override
    public void drawpath() {
       if (pm==null)pm = new PathMeasure(path, false);
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

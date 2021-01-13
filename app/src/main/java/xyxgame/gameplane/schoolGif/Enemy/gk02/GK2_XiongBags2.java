package xyxgame.gameplane.schoolGif.Enemy.gk02;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Point;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBags;

public class GK2_XiongBags2 extends XiongBags {
    public Path Beser_path;//贝塞尔曲线路径

    private PathMeasure pm;


    public GK2_XiongBags2(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);

        Beser_path = new Path();
        Beser_path.moveTo(-obj.oW+5, 500-50);
        Beser_path.quadTo(obj.maXx/2, 500-obj.maXx/2, obj.maXx+10, 500+10);


    }


    int iCurStep = 0;// current animation step

    public int beser_speed=200;


    private boolean over_run=false;
    @Override
    public void drawpath() {
        if (over_run)return;
       if (pm==null)pm = new PathMeasure(Beser_path, false);
        float fSegmentLen = pm.getLength() / beser_speed;//we'll get 20 points from path to animate the circle
        float afP[] = {0f, 0f};

        if (iCurStep <= beser_speed) {
            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
            //canvas.drawCircle(afP[0],afP[1],20,new UIPaint(null).paint2());
            x = (int) afP[0];
            y = (int) afP[1];
            iCurStep++;
            // invalidate();
        } else {
            iCurStep = 0;
            over_run=true;//结束绘制
        }
        ;

    }

}

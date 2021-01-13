package xyxgame.gameplane.schoolGif.Enemy.gk02;

import android.graphics.Canvas;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Effect.Shui;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongGif;
import xyxgame.gameplane.schoolGif.Enemy.gk01.xiongState;

public class GK2_XiongGif2 extends XiongGif {
   // private Path path;
    public GK2_XiongGif2(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
     //   path = new Path();
      //  path.moveTo(obj.maXx, obj.maXy/2);

    //   path.quadTo(500, 500,  -obj.oW-10, obj.maXy/2);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
        GK2_XiongBags2 xiongBags = new GK2_XiongBags2(obj, list);
        xiongBags.setShuiEffect(new Shui(list_shui));
        xiongBags.addState(new xiongState());
        bags.add(xiongBags);
    }
    int iCurStep = 0;// current animation step
    @Override
    public void drawCanvas(Canvas canvas) {
        super.drawCanvas(canvas);

       // canvas.drawPath(path,new UIPaint(null).paint());
//        PathMeasure pm = new PathMeasure(path, false);
//        float fSegmentLen = pm.getLength() / 200;//we'll get 20 points from path to animate the circle
//        float afP[] = {0f, 0f};
//
//        if (iCurStep <= 200) {
//            pm.getPosTan(fSegmentLen * iCurStep, afP, null);
//            canvas.drawCircle(afP[0],afP[1],20,new UIPaint(null).paint2());
//            iCurStep++;
//            // invalidate();
//        } else {
//            iCurStep = 0;
//        };



    }
}

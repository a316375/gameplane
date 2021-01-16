package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Model.Level;

public class FireEffect extends BaseGifObj {


    public FireEffect(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);

    }





    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new FireBag(obj,list).moveToXY(300,1200);

    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


        return allBitmaps.getfire(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {

       // bags.add(new FireBag(obj,list).moveToXY(300,1200));
    }


    @Override
    public void add_drawCanvas(Canvas canvas) {
        super.add_drawCanvas(canvas);

        Iterator<BaseGifBag> iterator = bags.iterator();
        while (iterator.hasNext()){


            BaseGifBag next = iterator.next();


             next.rect.set(next.x+next.w/3 ,next.y+next.h*3/4,next.x+next.w-next.w/3,next.y+next.h);
           // canvas.drawRect(next.rect,new UIPaint(null).paint1());

            next.showtime++;
            if (next.showtime>next.showMaxtime){
                bags.remove(next);
            }

        }
    }

    public void add(BaseGifBag bag,int level) {

        if (bags.size()>150)return;

        bags.add(new FireBag(obj,list).moveToXY(bag.x-10,bag.y).withHit(new Level(level).backValue().hit));
        if (level>15)  bags.add(new FireBag(obj,list).moveToXY(bag.x-10-90-new Random().nextInt(50),bag.y-90).withHit(new Level(level).backValue().hit));
        if (level>30)  bags.add(new FireBag(obj,list).moveToXY(bag.x-10+90+new Random().nextInt(50),bag.y-90).withHit(new Level(level).backValue().hit));
        if (level>50) {
            bags.add(new FireBag(obj,list).moveToXY(bag.x-10-60-new Random().nextInt(50),bag.y+60).withHit(new Level(level).backValue().hit));
            bags.add(new FireBag(obj,list).moveToXY(bag.x-10+60+new Random().nextInt(50),bag.y+60).withHit(new Level(level).backValue().hit));
        }

    }
}

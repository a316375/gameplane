package xyxgame.gameplane.schoolGif.Laser;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class LaserRewardGif extends BaseGifObj {

    CopyOnWriteArrayList<Bitmap> list1,list3,list5;
    int num;

    public LaserRewardGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);
        list1=allBitmaps.getlaser_lv1(obj.oW,obj.oH);
        list3=allBitmaps.getlaser_lv3(obj.oW,obj.oH);
        list5=allBitmaps.getlaser_lv5(obj.oW,obj.oH);

    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag= new LaserRewardBags(obj,list);
    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
        return null;
    }

    @Override
    protected void add_bags_add_new_obj_list() {

    }

    public void  add(int x,int y){

        obj.oX=x;
        obj.oY=y;
        num=new Random().nextInt(100);
        //Log.d("---", "add: "+num);
        if (num==0){
            LaserRewardBags laserRewardBags = new LaserRewardBags(obj, list1);
            laserRewardBags.showMaxtime=500;
            laserRewardBags.setLv(1);
            bags.add(laserRewardBags);
        }
        if (num==1){
            LaserRewardBags laserRewardBags = new LaserRewardBags(obj, list3);
            laserRewardBags.showMaxtime=500;
            laserRewardBags.setLv(3);
            bags.add(laserRewardBags);
        }
        if (num==2){
            LaserRewardBags laserRewardBags = new LaserRewardBags(obj, list5);
            laserRewardBags.showMaxtime=500;
            laserRewardBags.setLv(5);
            bags.add(laserRewardBags);
        }

    }

    @Override
    public void add_drawCanvas(Canvas canvas) {
        super.add_drawCanvas(canvas);
    }

    @Override
    public void After_draw() {
        super.After_draw();

        Iterator<BaseGifBag> iterator = bags.iterator();
        while (iterator.hasNext()){
            BaseGifBag next = iterator.next();
            next.showtime++;
            if (next.showtime>next.showMaxtime){
                bags.remove(next);
            }
        }


    }
}

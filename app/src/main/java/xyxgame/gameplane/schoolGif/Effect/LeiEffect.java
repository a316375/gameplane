package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class LeiEffect extends BaseGifObj {


    public LeiEffect(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);

    }





    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag=new LeiBag(obj,list).moveToXY(500,0);

    }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {


        return allBitmaps.getlei(obj.oW/2,obj.oH/2);
    }

    @Override
    protected void add_bags_add_new_obj_list() {

       // bags.add(new LeiBag(obj,list).moveToXY(300,1200));
    }

int i=0;
    @Override
    public void drawCanvas(Canvas canvas) {
        i++;
        if (i>500)i=0;
        add_drawCanvas(canvas);

        Iterator<BaseGifBag> iterator = bags.iterator();
        while (iterator.hasNext()){
            BaseGifBag next = iterator.next();
            if (next.list.size()==0)return;
            next.i=next.i%next.list.size();
            canvas.drawBitmap(next.list.get(next.i),next.x,next.y,null);
            next.drawpath();//调用一下去更新路径，不然不更新
           if (i%5==0)next.i++;
        }
    }



    public boolean open=false;
    public void add_leiBag(BaseGifBag bag, int level){
        bags.add(new LeiBag(obj,list).moveToXY(bag.x+bag.w/10, bag.y-obj.oH/2));

    }





    @Override
    public void add_drawCanvas(Canvas canvas) {

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


}

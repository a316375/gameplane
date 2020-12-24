package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.renderscript.BaseObj;
import android.util.Log;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathMu;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UIPaint;

public class ShuiEffect  {
    GifObj obj;
    CopyOnWriteArrayList<Bitmap> list;
    GifAllBitmaps allBitmaps;
//    ShuiBag shuiBag;
    public  CopyOnWriteArrayList<ShuiBag> shuiBags;
    private ShuiBag shuiBag;

    public ShuiEffect(GifObj obj, GifAllBitmaps allBitmaps) {
        this.allBitmaps=allBitmaps;
       this.obj=obj;
        shuiBags=new CopyOnWriteArrayList<>();

        list=allBitmaps.getlaser08(obj.oW,obj.oH);

//        shuiBag=new ShuiBag(obj,list);
//        add(new GifObj(1,100,100).withPoint(500,200).withSize(300,200),500);
//        add(new GifObj(1,100,100).withPoint(100,1200).withSize(300,200),250);
    }

    public void remove_effcet(BaseGifBag enemy,int shuxin){
        Iterator<ShuiBag> iterator1 =  shuiBags.iterator();
        while (iterator1.hasNext()){
            ShuiBag next = iterator1.next();
            if (Rect.intersects(next.rect,enemy.rect)){
                next.life=-100;
                if (shuxin== ShuXin.Mu){
                    if (enemy.baseState==null)return;
                    enemy.path=new PathMu(enemy);
                    enemy.baseState.changState(State.Att,enemy, allBitmaps);
                }
            }
        }
    }

    public void add(GifObj gifObj,int showTime){
        list=allBitmaps.getlaser08(gifObj.oW,gifObj.oH);
        shuiBag = (ShuiBag) new ShuiBag(gifObj,list).withShowTime(showTime);

        shuiBag.life=gifObj.life;
         shuiBags.add(shuiBag);
          //这里有问题的,每次碰撞都添加到集合，导致闪烁
        //闪烁解决：
        Iterator<ShuiBag> iterator = shuiBags.iterator();
        while (iterator.hasNext()){
            ShuiBag next = iterator.next();
            if (Rect.intersects(next.rect,shuiBag.rect))
            if (next.time!=0||next.life<=0   ){  shuiBags.remove(next);  return;  }
        }

       // Log.v("--","-----"+shuiBags.size());
    }






//     int i=0;
    int j=0;


    public void drawCanvas(Canvas canvas) {

        if (list==null||list.size()==0)return;

        j++;
        if (j>1000)j=1;



        Iterator<ShuiBag> iterator = shuiBags.iterator();
        while (iterator.hasNext()){
            ShuiBag next = iterator.next();
            if (next.time>next.showTime||next.life<=0 ){  shuiBags.remove(next);  return;  }
            next.time++;

             for (Bitmap bitmap:next.list){
                 next.i= next.i%next.list.size();
                canvas.drawBitmap(next.list.get(next.i),next.x,next.y,null);
//                canvas.drawRect(next.rect,new UIPaint(null).paint1());
            }

            if (j%5==0) next.i++;

        }




//                i=i%list.size();
//        Iterator<Bitmap> iterators = list.iterator();
//        while (iterators.hasNext()){
//            Bitmap next = iterators.next();
//            canvas.drawBitmap(list.get(i),obj.oX,obj.oY+500,null);
//        }






//        if (j%5==0) i++;

    }
}

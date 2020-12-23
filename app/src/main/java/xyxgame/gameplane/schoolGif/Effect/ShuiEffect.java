package xyxgame.gameplane.schoolGif.Effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.renderscript.BaseObj;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Tool.UIPaint;

public class ShuiEffect  {
    GifObj obj;
    CopyOnWriteArrayList<Bitmap> list;
    GifAllBitmaps allBitmaps;
//    ShuiBag shuiBag;
    public  CopyOnWriteArrayList<ShuiBag> shuiBags;

    public ShuiEffect(GifObj obj, GifAllBitmaps allBitmaps) {
        this.allBitmaps=allBitmaps;
       this.obj=obj;
      //  list=allBitmaps.getlaser08(obj.oW,obj.oH);
        shuiBags=new CopyOnWriteArrayList<>();
     //   shuiBag=new ShuiBag(obj,list);
//        add(new GifObj(1,100,100).withPoint(500,200).withSize(300,200),500);
//        add(new GifObj(1,100,100).withPoint(100,1200).withSize(300,200),250);
    }



    public void add(GifObj gifObj,int showTime){
        list=allBitmaps.getlaser08(gifObj.oW,gifObj.oH);
        ShuiBag shuiBag= (ShuiBag) new ShuiBag(gifObj,list).withShowTime(showTime);

        shuiBag.life=gifObj.life;
         shuiBags.add(shuiBag);
    }






//    int i=0;
    int j=0;


    public void drawCanvas(Canvas canvas) {

        if (list==null||list.size()==0)return;

        j++;
        if (j>1000)j=1;
//        i=i%list.size();
//        Iterator<Bitmap> iterators = list.iterator();
//        while (iterators.hasNext()){
//            Bitmap next = iterators.next();
//            canvas.drawBitmap(list.get(i),obj.oX,obj.oY+500,null);
//        }


        Iterator<ShuiBag> iterator = shuiBags.iterator();
        while (iterator.hasNext()){
            ShuiBag next = iterator.next();

            if (j%5==0) next.i++;


            next.time++;

            if (next.time>=next.showTime||next.life<=0 ){
                shuiBags.remove(next);
               }



            Iterator<Bitmap> iterator1 = next.list.iterator();
            while (iterator1.hasNext()){
                Bitmap next1 = iterator1.next();
                next.i= next.i%next.list.size();
                canvas.drawBitmap(next.list.get(next.i),next.x,next.y,null);


//              canvas.drawRect(next.rect,new UIPaint(null).paint1());


            }

        }


//        if (j%5==0) i++;

    }
}

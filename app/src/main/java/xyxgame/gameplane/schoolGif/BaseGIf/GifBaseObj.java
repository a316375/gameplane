package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;



//**继承自这个类需要实现三个方法，这个类可以控制集合的自我清理+自我创建，三个方法都是加载**//
public abstract class GifBaseObj   {
    public  GifObj obj;
    public  GifAllBitmaps allBitmaps;

    public   BaseGifBag gifBag;
    public  CopyOnWriteArrayList<Bitmap> list;

    public  CopyOnWriteArrayList<BaseGifBag> bags;
    private Paint paint;

    public GifBaseObj(GifObj obj, GifAllBitmaps allBitmaps) {
        this.obj = obj;
        this.allBitmaps = allBitmaps;
        bags=new CopyOnWriteArrayList<>();

        lodebitmaps_list__allBitmaps_get_objow_obj_oh();
        creatBags_gifbag_newxx_obj_list();

    }

    protected abstract void creatBags_gifbag_newxx_obj_list();

    protected abstract void lodebitmaps_list__allBitmaps_get_objow_obj_oh();

//    private void creatBags() {
//        gifBag= new LayerBags(obj,  list);
//      }
//
//    private void lodebitmaps() {
//        if (obj.giflist==0)list=allBitmaps.getyu2(obj.oW,obj.oH);
//        if (obj.giflist==1)list=allBitmaps.getlaser03(obj.oW/5,obj.oH);
//    }
//
//    private void bags_addbag() {
//        bags.add(new LayerBags(obj, list) );
//    }

//以下是run方法

    public int F5_GIf=5;
    public int Time_wait=50;
    int i=0;  int t=0;
    public void draw(Canvas canvas){

        if (gifBag==null)return;

        t++;
        if (t>6000)t=1;

        if (bags.size()<obj.max&& t%Time_wait==0){
            add_bags_add_new_obj_list();
           };

        Iterator<BaseGifBag> remove = bags.iterator();
        while (remove.hasNext()){
            BaseGifBag next = remove.next();
            if (next.list.size()==0)return;
            if (next.x<-obj.oW||next.y<-obj.oH||next.x>obj.pointx||next.y>obj.pointy){
                next.list=null;
                bags.remove(next);
            }
        }


        if (paint==null) {
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
            paint.setStrokeWidth(5);
            paint.setColor(Color.RED);
        }

        Iterator<BaseGifBag> iterator = bags.iterator();
        while (iterator.hasNext()){
            BaseGifBag next = iterator.next();
            if (next.list.size()==0)return;
            i=i%next.list.size();
            next.rect.set(next.x,next.y,next.x+next.w,next.y+next.h);

           canvas.drawBitmap(next.list.get(i),next.x,next.y ,null);
            if (next.obj.showRect) canvas.drawRect(next.rect,paint);
            next.drawpath();////这个是分离代码

        }


        if (t%F5_GIf==0)i++;



    }

    protected abstract void add_bags_add_new_obj_list();


}

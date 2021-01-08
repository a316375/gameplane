package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.Effect.ShuiBag;
import xyxgame.gameplane.schoolGif.Effect.ShuiEffect;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Music.MusicUtils;
import xyxgame.gameplane.schoolGif.Play.PlayGif;


//**继承自这个类需要实现三个方法，这个类可以控制集合的自我清理+自我创建，三个方法都是加载**//
public abstract class BaseGifObj extends View   {


    public  MusicUtils music;

    public  GifObj obj;
    public  GifAllBitmaps allBitmaps;

    public   BaseGifBag gifBag;
    public  CopyOnWriteArrayList<Bitmap> list;

    public  CopyOnWriteArrayList<BaseGifBag> bags;
    private Paint paint;






    public BaseGifObj(GifObj obj, GifAllBitmaps allBitmaps) {
        super(allBitmaps.activity);
        this.obj = obj;
        this.allBitmaps = allBitmaps;
        bags=new CopyOnWriteArrayList<>();



        lodebitmaps_list__allBitmaps_get_objow_obj_oh();//赋予图片
        creatBags_gifbag_newxx_obj_list();//赋予路径
//        if (bags.size()==0&&(gifBag != null))  add_bags_add_new_obj_list();//集合赋予图片

    }
   //**赋予路径**//
    protected abstract void creatBags_gifbag_newxx_obj_list();
    //**赋予图片**//
    protected abstract void lodebitmaps_list__allBitmaps_get_objow_obj_oh();

    public BaseGifObj setMusic(MusicUtils music){
        this.music=music;
        return this;
    }


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

    public BaseGifObj withTime_wait(int Time_wait){
        this.Time_wait=Time_wait;
        return this;
    }
    public BaseGifObj withF5_GIf(int F5_GIf){
        this.F5_GIf=F5_GIf;
        return this;
    }


    public int F5_GIf=5;
    public int Time_wait=50;
//    int i=0;
    public int t=0;
    private boolean ready=true;
    public void drawCanvas(Canvas canvas) {

        add_drawCanvas(canvas);//补充绘制其他内容


        if (gifBag == null) return;



        t++;
        if (t > 6000) t = 1;
       if (bags.size()==0&&ready) {add_bags_add_new_obj_list();ready=false;}//集合赋予图片
        if (bags.size() < obj.max && t % Time_wait == 0) {

            add_bags_add_new_obj_list();//集合赋予图片
            playmusic();
        }

        ;

        Iterator<BaseGifBag> remove = bags.iterator();
        while (remove.hasNext()) {
            BaseGifBag next = remove.next();
            if (next.list.size() == 0) return;
            if (next.x < -obj.oW || next.y < -obj.oH || next.x > obj.maXx || next.y > obj.maXy) {
                next.list = null;
                bags.remove(next);

            }
        }


        if (paint == null) {
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
            paint.setStrokeWidth(5);
            paint.setColor(Color.RED);
        }

        Iterator<BaseGifBag> iterator = bags.iterator();
        while (iterator.hasNext()) {
            BaseGifBag next = iterator.next();
            if (next.list.size() == 0) return;
            next.i= next.i % next.list.size();
            next.setRect(next.x , next.y, next.x + next.w, next.y + next.h);


            canvas.drawBitmap(next.list.get(next.i), next.x, next.y, null);
            if (next.obj.showRect) canvas.drawRect(next.rect, paint);
          if (next.path!=null) next.path.drawpath();////这个是分离代码

            if (next.shuiEffect!=null)next.shuiEffect.draw(canvas);


            if (t % F5_GIf == 0) next.i++;
        }


       // if (t % F5_GIf == 0) i++;



    }

;


    public void playmusic(){};

    //**集合赋予图片**//
    protected abstract void add_bags_add_new_obj_list();



    public void add_drawCanvas(Canvas canvas){}



}

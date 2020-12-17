package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public  class GifBaseObj   {
    GifObj obj;
    GifAllBitmaps allBitmaps;

     GifBag gifBag;
     CopyOnWriteArrayList<Bitmap> list;

     CopyOnWriteArrayList<GifBag> bags;

    public GifBaseObj(GifObj obj, GifAllBitmaps allBitmaps) {
        this.obj = obj;
        this.allBitmaps = allBitmaps;
        if (obj.giflist==0)list=allBitmaps.getyu2(obj.oW,obj.oH);
        if (obj.giflist==1)list=allBitmaps.getlaser03(obj.oW/5,obj.oH);
        gifBag= new GifBag(obj.oX, obj.oY, obj.oW, obj.oH, list);
        bags=new CopyOnWriteArrayList<>();
        handler.postDelayed(new RunFrame(),0);
        handler.postDelayed(new RunFrame2(),100);




    }

    Handler handler=new Handler(Looper.getMainLooper());



     int i=0;


      int t=0;
    public void draw(Canvas canvas){


        t++;
        if (t>500)t=1;

        if (bags.size()<obj.max&& t%50==0){
            bags.add(new GifBag(obj.oX, obj.oY, obj.oW, obj.oH, list) );};

        Iterator<GifBag> remove = bags.iterator();
        while (remove.hasNext()){
            GifBag next = remove.next();
            if (next.list.size()==0)return;
            if (next.x<-obj.oW||next.y<-obj.oH||next.x>obj.pointx||next.y>obj.pointy){
                next.list=null;
                bags.remove(next);
            }
        }


        Iterator<GifBag> iterator = bags.iterator();
        while (iterator.hasNext()){
            GifBag next = iterator.next();
            if (next.list.size()==0)return;
            i=i%next.list.size();
            canvas.drawBitmap(next.list.get(i),next.x,next.y ,null);

            next.drawpath();////这个是分离代码

        }





    }



    int delaymillis=50;//帧动画刷新频率
    class RunFrame extends Thread{

        @Override
        public void run() {

            i++;

            handler.postDelayed(this,delaymillis);

        }
    }





    class RunFrame2 extends Thread{

        @Override
        public void run() {


            handler.postDelayed(this,300);//50-

        }
    }










       class GifBag  {
        int x,y,w,h;
        CopyOnWriteArrayList<Bitmap> list;



        public GifBag(int x, int y, int w, int h, CopyOnWriteArrayList<Bitmap> list) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.list = list;
        }


           public void drawpath() {
             this.y-=obj.speed;
           }
       }




}

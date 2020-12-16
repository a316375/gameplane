package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Laser {
    int hit;
    int speed;
    int pointx;
    int pointy;

    GIFPlay gifPlay;


    private final CopyOnWriteArrayList<Bitmap> bitmaps;

    CopyOnWriteArrayList<Bags> bags;

    public Laser(GIFPlay gifPlay) {

        this.gifPlay = gifPlay;
        hit=100;
        speed=1;
        this.pointx=gifPlay.xX;
        this.pointy=gifPlay.xY;

        bitmaps = gifPlay.bitmapsS.getxue(gifPlay.bitmapsS.activity);
        bags=new CopyOnWriteArrayList<>();



    }


   int i=0;

    int j=0;
    public void  draw(Canvas canvas){

        i++;
        if (i>500)i=1;
        if (i%50==0)add();

        if (bags.size()==0)return;



        Iterator<Bags> remove = bags.iterator();
        while (remove.hasNext()){
            Bags next = remove.next();
            if (next.x<0||next.y<0){
                next.bitmaps=null;
                bags.remove(next);}
        }


        Iterator<Bags> iterator = bags.iterator();
        while (iterator.hasNext()){
            Bags next = iterator.next();
            if (next.bitmaps.size()==0)return;
            j=j%next.bitmaps.size();
            canvas.drawBitmap(next.bitmaps.get(j),next.x,next.y,null);
            next.y-=10*speed;
         }

        if (i%5==0) j++;
        if (j>500)j=1;

    }

    public void add(){
     if (bags.size()<20) bags.add(new Bags(gifPlay.xX,gifPlay.xY,bitmaps));


    }





    public class Bags {
        int x;int y;
        CopyOnWriteArrayList<Bitmap> bitmaps;

        public Bags(int x, int y, CopyOnWriteArrayList<Bitmap> bitmaps) {
            this.x = x;
            this.y = y;
            this.bitmaps = bitmaps;
        }
    }
}

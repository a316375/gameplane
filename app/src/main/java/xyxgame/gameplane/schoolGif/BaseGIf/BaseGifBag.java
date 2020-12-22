package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.Tool.ShuXin;


/**继承自这个类需要实现路径的绘制，不绘制默认静止，此时obj的max应该为最大为1**/
public abstract class BaseGifBag   implements BaseGifBagPath{
    public int x,y,w,h;
    public  CopyOnWriteArrayList<Bitmap> list;

    public  GifObj obj;
    public Rect rect;
    public int i;

    public int life;
    public int hit;


    public int shuxin;

    public BaseGifBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        path=this;
        this.shuxin=obj.ShuXin;
        this.obj=obj;
        this.x = obj.oX;
        this.y = obj.oY;
        this.w = obj.oW;
        this.h = obj.oH;
        this.list = list;
        this.life=obj.life;
        this.hit=obj.hit;
       if (list.size()>0)i=new Random().nextInt(500)%list.size();
        rect=new Rect(x,y,x+w,y+h);
    }


    public  BaseGifBagPath path;

    public void setRect(int x,int y,int w,int h){
        rect.set(x,y,w,h);
    }

    public void moveToXY(int pointXFix, int pointYFix,int MaxX,int MaxY) {
        x=pointXFix;
        y=pointYFix;
        if (x<-20)x=-20;if (y<50)y=50;
        if (x>MaxX+20-w)x=MaxX+20-w;
        if (y>MaxY-20)y=MaxY-20;
    }


    public void resetPath(){
        path=this;
    }


}

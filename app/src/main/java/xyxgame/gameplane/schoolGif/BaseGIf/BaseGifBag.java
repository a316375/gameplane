package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Rect;

import java.util.concurrent.CopyOnWriteArrayList;


/**继承自这个类需要实现路径的绘制，不绘制默认静止，此时obj的max应该为最大为1**/
public abstract class BaseGifBag   {
    public int x,y,w,h;
    public  CopyOnWriteArrayList<Bitmap> list;

    public  GifObj obj;
    public Rect rect;

    public BaseGifBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        this.obj=obj;
        this.x = obj.oX;
        this.y = obj.oY;
        this.w = obj.oW;
        this.h = obj.oH;
        this.list = list;
        rect=new Rect(x,y,x+w,y+h);
    }


    public  abstract void drawpath();

    public void moveToXY(int pointXFix, int pointYFix,int MaxX,int MaxY) {
        x=pointXFix;
        y=pointYFix;
        if (x<-20)x=-20;if (y<50)y=50;
        if (x>MaxX+20-w)x=MaxX+20-w;
        if (y>MaxY-20)y=MaxY-20;
    }


}
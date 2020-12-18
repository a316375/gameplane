package xyxgame.gameplane.schoolGif.BaseGIf;


import android.graphics.Rect;

//**一个属性的类，赋予坐标，血量，大小**//
public class GifObj {
    public  int max;//数组最大值上限
    public int pointx,pointy;//屏幕最大值

    public  int level=1;
    public  int hit=10;
    public  int speed=2;
    public  int life=100;
    public  int giflist=0;//默认图片


    public   int oX=0;//默认坐标
    public    int oY=0;//默认坐标
    public    int oW=100;//默认宽度
    public    int oH=100;//默认高度

    public  boolean showRect=false;
    public GifObj showRect(boolean showRect){
        this.showRect=showRect;
        return this;
    }

    public GifObj withPoint(int oX, int oY) {

        this.oX = oX;
        this.oY = oY;
        return this;
    }
    public GifObj withSize( int oW, int oH) {

        this.oW = oW;
        this.oH = oH;
        return this;
    }

    public GifObj  (int Max,int pointx,int pointy) {
        this.max=Max;
        this.pointx=pointx;
        this.pointy=pointy;

    }


    public GifObj setgiflist(int giflist){this.giflist=giflist;return this;};
    public GifObj init(int level, int hit, int speed, int life, int giflist) {
        this.level = level;
        this.hit = hit;
        this.speed = speed;
        this.life = life;
        this.giflist = giflist;
        return this;
    }
}

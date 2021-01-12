package xyxgame.gameplane.schoolGif.BaseGIf;


//**一个属性的类，赋予坐标，血量，大小**//
public class GifObj {
    public  int maxSize =1;//数组最大值上限
    public int maXx=1000, maXy=2000;//屏幕最大值

    public  int level=1;
    public  int hit=10;
    public  int speed=2;
    public  int life=100;
    public  int ShuXin= xyxgame.gameplane.schoolGif.Tool.ShuXin.Jin;//默认属性


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

    public GifObj  (int Max, int maXx, int maXy) {
        this.maxSize =Max;
        this.maXx = maXx;
        this.maXy = maXy;

    }
    public GifObj(){}//当你不声明的时候,可能会被回收
    public GifObj withLife(int life){
        this.life=life;
        return this;
    }

    public GifObj setSpeed(int speed){this.speed=speed;return this;};
    public GifObj setShuXin(int ShuXin){this.ShuXin=ShuXin;return this;};
    public GifObj init(int level, int hit, int speed, int life, int ShuXin) {
        this.level = level;
        this.hit = hit;
        this.speed = speed;
        this.life = life;
        this.ShuXin = ShuXin;
        return this;
    }
}

package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.Effect.ShuiEffect;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UiThead;


/**继承自这个类需要实现路径的绘制，不绘制默认静止，此时obj的max应该为最大为1**/
public abstract class BaseGifBag   implements BaseGifBagPath{
    public int x,y,w,h;
    public  CopyOnWriteArrayList<Bitmap> list;
    public  CopyOnWriteArrayList<Bitmap> list_copy;//备份一下数组




    public  GifObj obj;
    public Rect rect;
    public int i;

    public int life;
    public int hit;


    public int showtime=0;//显示时间
    public int showMaxtime;//时间最大值
    public int shuxin ;
    public BaseState baseState;
    public int state=-State.Null;

    public boolean isDie=false;

    public ShuiEffect shuiEffect;
    public void setShuiEffect(ShuiEffect shuiEffect) {
        this.shuiEffect = shuiEffect;
    }



    public void addState(BaseState baseState){
        this.baseState=baseState;

    }

    public Matrix matrix;
    public int matrix_degress=0;
    public BaseGifBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        path=this;
        matrix=new Matrix();

        this.shuxin=obj.ShuXin;

        this.list_copy=list;

        this.obj=obj;
        this.x = obj.oX;
        this.y = obj.oY;
        this.w = obj.oW;
        this.h = obj.oH;
        this.list = list;
        this.life=obj.life;
        this.hit=obj.hit;
//       if (list.size()>0)i=new Random().nextInt(500)%list.size();
        i=0;
        rect=new Rect(x,y,x+w,y+h);

        showMaxtime=ShuXin.Speed*50+new Random().nextInt(50);


//        matrix.setRotate(90);

    }



    public int FireTime=0;
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

    public BaseGifBag moveToXY(int point_x, int point_y) {
        x=point_x;
        y=point_y;
        return this;
    }



    public void resetPath(){
        path=this;
        list=list_copy;
        state=State.Null;
    }


    public  BaseGifBag withHit(int hit){
        this.hit=hit;
        return this;
    };

    /**移除子弹**/
    public void startA(CopyOnWriteArrayList<BaseGifBag> laser_bags, BaseGifBag laser_bag){
        laser_bags.remove(laser_bag);
    };
    /**增加经验**/
    public void startB(final SchoolGifView schoolGifView){
        if (isMaxLevel_Boolean(schoolGifView)){
            if (!schoolGifView.uiList.exp.equals( tomorrow))schoolGifView.uiList.exp=today;
            if (schoolGifView.uiList.exp.equals( today))  UiThead.runInUIThread(new Runnable() {
                @Override
                public void run() {
                    schoolGifView.uiList.exp=tomorrow;
                }
            },3000);
            return;}

        schoolGifView.exp.exp+=1;

        //升级攻击力
        if (schoolGifView.exp.exp>schoolGifView.level.backValue().exp-1){
            schoolGifView.exp.exp=0;
            schoolGifView.level.level++;
            schoolGifView.laserGif.obj.level=schoolGifView.level.level;
            schoolGifView.laserGif.obj.hit=schoolGifView.level.backValue().hit;


//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Jin)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*5;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Mu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*2;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Shui)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*1;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Huo)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*4;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Tu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*3;
        }


    };
    /**扣除金币**/
    public void startC(SchoolGifView schoolGifView){
        schoolGifView.money.all-=1;
    };
    /**计算伤害**/
    public int startD(BaseGifBag enemy_bag,BaseGifBag laser_bag){
        int lose=laser_bag.hit;
        enemy_bag.life-=lose;
        return lose;
    };
    /**绘制扣血动画**/
    public void startE(SchoolGifView schoolGifView, int lose_life,BaseGifBag enemy_bag){
          schoolGifView.blastTextGif.addBag( lose_life,enemy_bag.rect.left+enemy_bag.w/2,enemy_bag.rect.top+enemy_bag.h/2);
    };
    public void startF(){};
    public void startG(){};

    private String today="WILL NOT  UPGRADE  TODAY",tomorrow="COME BACK TOMORROW";
    private boolean isMaxLevel_Boolean(final SchoolGifView schoolGifView) {
        return schoolGifView.level.level >= schoolGifView.level.Max_Level_day(schoolGifView.getContext());
    }



}

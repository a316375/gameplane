package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.Effect.ShuiEffect;
import xyxgame.gameplane.schoolGif.Model.Level;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathMu;
import xyxgame.gameplane.schoolGif.Path.PathShui;
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
//        rect=new Rect(x,y,x+w,y+h);//原始rect
        rect=new Rect(obj.maXx,0,obj.maXx,0);//原始rect

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
             }
        else {

        schoolGifView.exp.exp+=1;

        //升级攻击力
        if (schoolGifView.exp.exp>schoolGifView.level.backValue().exp-1) {
            schoolGifView.exp.exp = 0;
            schoolGifView.level.level++;
            schoolGifView.laserGif.obj.level = schoolGifView.level.level;
            schoolGifView.laserGif.obj.hit = new Level(schoolGifView.level.level).backValue().hit;
        }

        }


    };
    /**扣除金币**/
    public void startC(SchoolGifView schoolGifView){
        schoolGifView.money.all-=1;
    };
    /**计算伤害**/
    public int startD( BaseGifBag laser_bag){
        int lose=laser_bag.hit;
        life-=lose;
       // Log.d("UP---", "life="+ life);
        return lose;
    };
    /**绘制扣血动画**/
    public void startE(SchoolGifView schoolGifView, int lose_life ){
          schoolGifView.blastTextGif.addBag( lose_life, rect.left+ w/2, rect.top+ h/2);
    };

    /**绘制木路径**/
    public void startF(SchoolGifView schoolGifView,BaseGifBag laser_bag){

            if (laser_bag.shuxin== ShuXin.Mu){
                if ( shuiEffect!=null)   shuiEffect.stop_shui();
//
                this.path=new PathMu(this);
                if ( baseState!=null&& state!= State.Att)
                     baseState.changState(State.Att,this,schoolGifView.allBitmaps);
            }

    };


    /**绘制水特效**/
    public void startG(SchoolGifView schoolGifView,BaseGifBag laser_bag){
        if (laser_bag.shuxin== ShuXin.Shui&& shuxin!=ShuXin.Boss){
//
            PathShui path = new PathShui(this,100+schoolGifView.level.level*3);
            this.path= path;
            if (this.baseState!=null&&this.state!= State.Stop)
                this.baseState.changState(State.Stop,this,schoolGifView.allBitmaps);
            GifObj gifObj = new GifObj() .withPoint(this.x, this.y + this.h / 3)  .withSize(this.w, this.h / 2) ;
            gifObj.life=this.life;

            if (this.shuiEffect!=null) {
                this.shuiEffect.reset_time();
                this.shuiEffect.add(this,path.showTime);
            }


        }
    };

    /**绘制火攻+雷特效**/
    public void startH(SchoolGifView schoolGifView, BaseGifBag laser_bag){{
        if (laser_bag.shuxin== ShuXin.Huo){
            schoolGifView.fireEffect.add(laser_bag,schoolGifView.level.level);
        }

        if (schoolGifView.leiEffect.open==true){
            schoolGifView.leiEffect.add_leiBag(this,schoolGifView.gifPlay.obj.level);}
    }};

    /**死亡奖励经验**/
    public void startI(SchoolGifView schoolGifView){
        if (this.life<=0) {
            if (!isMaxLevel_Boolean(schoolGifView))
                schoolGifView.exp.exp += 1;

            schoolGifView.money.all += 5;
            if (this.shuxin == ShuXin.Boss) schoolGifView.money.all += 2000;//奖励金币boss
        }
    };

    /**敌人死亡特效移除**/
    public void startJ(SchoolGifView schoolGifView){
        if (this.life<=0)  {
            if (this.shuxin==ShuXin.Shui)  schoolGifView.dieShui.add(this);;//水属性死亡后添加die特效
            //  if (enemy_bag.shuiEffect!=null)  enemy_bag.shuiEffect.stop_shui();

            //移除水的特效
//                            schoolGifView.shuiEffect.remove_effcet(enemy_bag, ShuXin.Null);


            if (this.shuxin== ShuXin.Huo){

                schoolGifView.fireEffect.add(this,schoolGifView.level.level);
            }//火属性死亡后添加火特效



            schoolGifView.laserRewardGif.add(this.x+this.rect.right/2-this.rect.left/2,this.y+this.rect.bottom/2-this.rect.top/2);
            schoolGifView.dieEnemyGif.add(this.x+this.rect.right/2-this.rect.left/2,this.y+this.rect.bottom/2-this.rect.top/2);




        }
    };

    /**移除对象**/
    public void startK(BaseGifObj enemy_obj){
        if (this.life<=0) {
            if (this.shuxin != ShuXin.Boss) enemy_obj.bags.remove(this);//不是boss则直接移除
            else this.isDie = true;//标记Boss死亡
        }
    };


    private String today="WILL NOT  UPGRADE  TODAY",tomorrow="COME BACK TOMORROW";
    private boolean isMaxLevel_Boolean(final SchoolGifView schoolGifView) {
        return schoolGifView.level.level >= schoolGifView.level.Max_Level_day(schoolGifView.getContext());
    }

//    /**被火烧**/
//    public   void startONFire_hit(SchoolGifView schoolGifView,int lose_life){
//        life-=lose_life;//扣血
//        startE(schoolGifView,lose_life);//绘制扣血动画
//    };




    /**火技能特效伤害**/

//    public   void startA1(SchoolGifView schoolGifView, BaseGifObj gifObj){
//
//        Iterator<BaseGifBag> iterator = schoolGifView.fireEffect.bags.iterator();//拿到火特效集合
//        while (iterator.hasNext()){
//            BaseGifBag next = iterator.next();//例遍火特效
//
//            if (next.rect.intersect(this.rect)) {
////                next.showMaxtime=1000;
//                   next.showtime=0;//火特效重载时间为0，延长火燃烧
//
//                    life-=new Level(schoolGifView.level.level).backValue().hit;
//                    // Log.d("--------", "life---"+life);
//                    schoolGifView.blastTextGif.addBag(new Level(schoolGifView.level.level).backValue().hit,
//                            this.rect.left+this.w/2, this.rect.top+this.h/2);
//
//                    if (this.life<0){
//                        this.isDie=true;
//                        if (this.shuxin==ShuXin.Shui)  schoolGifView.dieShui.add(this);;//添加死亡水特效
//                        if (this.shuxin==ShuXin.Huo)  schoolGifView.fireEffect.add(this,schoolGifView.gifPlay.obj.level);;//添加死亡火特效
//                        if (this.shuxin!=ShuXin.Boss)gifObj.bags.remove(this);//移除普通怪
//                    }
//
//            }
//
//        }
//    };
}

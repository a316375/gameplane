package xyxgame.gameplane.schoolGif.Teacher;

import android.graphics.Rect;

import java.util.Iterator;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Model.State;
import xyxgame.gameplane.schoolGif.Path.PathMu;
import xyxgame.gameplane.schoolGif.Path.PathShui;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.Tool.UiThead;


//**处理laser的老师，注意，只能处理集合，本身不能创建对象，可以调用别的地方的对象集合**//
public class LaserTeacher {

    SchoolGifView schoolGifView;
    private final BaseGifObj laserGif;

    public LaserTeacher(SchoolGifView schoolGifView) {
        this.schoolGifView = schoolGifView;
        laserGif = schoolGifView.laserGif;
    }

    public void PKResult(){
//        pk(schoolGifView.xiong);
       // pk(schoolGifView.gk01.xiongGifs);
        PK(schoolGifView.gk01.xiongGifs1);
        PK(schoolGifView.gk01.xiongGifs2);
        PK(schoolGifView.gk01.xiongGifs3);
        PK(schoolGifView.gk01.xiongGifs4);
        PK(schoolGifView.gk01.xiongGifs5);
        PK(schoolGifView.gk01.xiongGifs6);
        PK(schoolGifView.gk01.xiongGifs7);
        PK(schoolGifView.gk01.xiongBoss);
        PK(schoolGifView.gk02.xiongGifs);
        PK(schoolGifView.gk02.xiongGifs2);
        PK(schoolGifView.gk02.shuiGif);
        PK(schoolGifView.gk02.upXiongGif);
        PK(schoolGifView.gk02.shuiGif2);
        PK(schoolGifView.gk02.upxiongGifBoss);

    }






    private void PK(BaseGifObj baseGifBag){
        if (baseGifBag==null||baseGifBag.bags==null)return;

        Iterator<BaseGifBag> iterator = laserGif.bags.iterator();
        for (Iterator<BaseGifBag> it = iterator; it.hasNext(); ) {
            final BaseGifBag laser_bag = it.next();

            for (Iterator<BaseGifBag> iter = baseGifBag.bags.iterator(); iter.hasNext(); ) {
                final BaseGifBag enemy_bag = iter.next();
                //enemy_bag.startA1(schoolGifView,baseGifBag);//被火烧的时候，绘制伤害 优先于子弹碰撞

                if (Rect.intersects(laser_bag.rect,enemy_bag.rect)) {
                    startPK(baseGifBag, laser_bag, enemy_bag);//开始pk
                }
            }
        }
    }

    private void startPK(BaseGifObj enemy_obj, BaseGifBag laser_bag, BaseGifBag enemy_bag) {

        enemy_bag.startA(laserGif.bags,laser_bag);//移除子弹
        enemy_bag.startB(schoolGifView,laser_bag);//添加经验
        enemy_bag.startC(schoolGifView,laser_bag);//扣除金币
        int lose_life = enemy_bag.startD(laser_bag);//计算伤害
        enemy_bag.startE(schoolGifView,lose_life,laser_bag);//绘制扣血动画
        enemy_bag.startF(schoolGifView,laser_bag);//绘制木路径
        enemy_bag.startG(schoolGifView,laser_bag);//绘制水攻特效
        enemy_bag.startH(schoolGifView,laser_bag);//绘制火攻特效


         enemy_bag.startI(schoolGifView);//死亡经验奖励
        enemy_bag.startJ(schoolGifView);//死亡移除特效/产出特效
        enemy_bag.startK(enemy_obj);//移除对象或者标记死亡--Boss需要额外设置





//        int lei  = addlei_hit(laser_bag, enemy_bag, 0);//处理雷击伤害+扣除金币
//
//        int add_hit=new Random().nextInt(laser_bag.hit/10)+lei;//初始伤害
//        if (laser_bag.shuxin!=ShuXin.Huo)  {
//
//          add_hit=  life_enemy(enemy_bag,laser_bag,add_hit);//计算伤害
//
//              }
//        enemy_bag.life-=add_hit;//结算伤害
//
//        drawHit_Text(laser_bag, add_hit);//绘制伤害
        //Log.v("-----","-----"+enemy_bag.life);


//        addMuPath(laser_bag, enemy_bag);//添加木属性的怪物路径
//        addShuiPath_Effct(laser_bag, enemy_bag);//添加水属性的怪物路径+水特效
//        addFireEffect(laser_bag);//添加火特效
         //敌人被击败
//        life_die(enemy_obg, enemy_baj);
    }

    private void life_die(BaseGifObj enemy_obg, BaseGifBag enemy_bag) {
        if (enemy_bag.life<=0)  {
            if (enemy_bag.shuxin==ShuXin.Shui) addDieShuiEffect(enemy_bag);//水属性死亡后添加die特效
          //  if (enemy_bag.shuiEffect!=null)  enemy_bag.shuiEffect.stop_shui();

                //移除水的特效
//                            schoolGifView.shuiEffect.remove_effcet(enemy_bag, ShuXin.Null);

                //奖励经验
            if (!isMaxLevel_Boolean())   schoolGifView.exp.exp+= schoolGifView.level.level*5;
                schoolGifView.money.all+=2;
                if (enemy_bag.shuxin== ShuXin.Boss)schoolGifView.money.all+=2000;//奖励金币boss

            if (enemy_bag.shuxin==ShuXin.Huo) addFireEffect(enemy_bag);//火属性死亡后添加火特效



            if (enemy_bag.shuxin!=ShuXin.Boss)enemy_obg.bags.remove(enemy_bag);//不是boss则直接移除
            else enemy_bag.isDie=true;//标记Boss死亡

        }
    }

    private boolean isMaxLevel_Boolean() {
        return schoolGifView.level.level >= schoolGifView.level.Max_Level_day(schoolGifView.getContext());
    }

    private void addDieShuiEffect(BaseGifBag enemy_bag) {
        schoolGifView.dieShui.add(enemy_bag);
    }

    private void addFireEffect(BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo){

            schoolGifView.fireEffect.add(laser_bag,schoolGifView.gifPlay.obj.level);
        }
    }

    private void addShuiPath_Effct(BaseGifBag laser_bag, BaseGifBag enemy_bag) {
        if (laser_bag.shuxin== ShuXin.Shui&&enemy_bag.shuxin!=ShuXin.Boss){
//
            PathShui path = new PathShui(enemy_bag,100+schoolGifView.level.level*3);
            enemy_bag.path= path;
       if (enemy_bag.baseState!=null&&enemy_bag.state!= State.Stop)
           enemy_bag.baseState.changState(State.Stop,enemy_bag,schoolGifView.allBitmaps);
            GifObj gifObj = new GifObj() .withPoint(enemy_bag.x, enemy_bag.y + enemy_bag.h / 3)  .withSize(enemy_bag.w, enemy_bag.h / 2) ;
             gifObj.life=enemy_bag.life;

            if (enemy_bag.shuiEffect!=null) {
                enemy_bag.shuiEffect.reset_time();
                enemy_bag.shuiEffect.add(enemy_bag,path.showTime);
            }


        }
    }

    private void addMuPath(BaseGifBag laser_bag, BaseGifBag enemy_bag) {
        if (laser_bag.shuxin== ShuXin.Mu){
        if (enemy_bag.shuiEffect!=null)   enemy_bag.shuiEffect.stop_shui();
//
         enemy_bag.path=new PathMu(enemy_bag);
     if (enemy_bag.baseState!=null&&enemy_bag.state!= State.Att)
         enemy_bag.baseState.changState(State.Att,enemy_bag,schoolGifView.allBitmaps);
        }
    }

//    private void drawHit_Text(BaseGifBag laser_bag, int add_hit) {
//        if (laser_bag.shuxin!= ShuXin.Huo)     schoolGifView.blastTextGif.addBag( add_hit,laser_bag.rect.left,laser_bag.rect.top);
//    }

    private int addlei_hit(BaseGifBag laser_bag, BaseGifBag enemy_bag, int lei) {
        if (schoolGifView.leiEffect.open==true&&laser_bag.shuxin!= ShuXin.Huo){
            schoolGifView.leiEffect.add_leiBag(enemy_bag,schoolGifView.gifPlay.obj.level);
            lei=laser_bag.hit*2;
            lostMoney(laser_bag);

        }else  lei=laser_bag.hit;
        return lei;
    }

    private void lostMoney(BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Jin) schoolGifView.money.all-=30;
        if (laser_bag.shuxin==ShuXin.Mu) schoolGifView.money.all-=20;
        if (laser_bag.shuxin==ShuXin.Shui) schoolGifView.money.all-=10;
    }
    private void addMoney(BaseGifBag laser_bag) {
        if (schoolGifView.leiEffect.open==true){
        if (laser_bag.shuxin== ShuXin.Jin) schoolGifView.money.all+=35;
        if (laser_bag.shuxin==ShuXin.Mu) schoolGifView.money.all+=25;
        if (laser_bag.shuxin==ShuXin.Shui) schoolGifView.money.all+=15;
        }
    }

    private int life_enemy(BaseGifBag enemy_bag,BaseGifBag laser_bag,int add_hit) {
      if (enemy_bag.shuxin==ShuXin.Boss) {

          addMoney(laser_bag);
        laser_bag.hit=schoolGifView.laserGif.obj.hit;
         // laser_bag.hit=10;
          add_hit=schoolGifView.laserGif.obj.hit;
         // schoolGifView.laserGif.obj.hit= laser_bag.hit;
      }

      return add_hit;

    }

    private String today="WILL NOT  UPGRADE  TODAY",tomorrow="COME BACK TOMORROW";
    public void  addexp(final SchoolGifView schoolGifView){
        if (isMaxLevel_Boolean()){
           if (!schoolGifView.uiList.exp.equals( tomorrow))schoolGifView.uiList.exp=today;
            if (schoolGifView.uiList.exp.equals( today))  UiThead.runInUIThread(new Runnable() {
                @Override
                public void run() {
                    schoolGifView.uiList.exp=tomorrow;
                }
            },3000);
            return;}

        schoolGifView.exp.exp+=50;

        //升级攻击力
        if (schoolGifView.exp.exp>schoolGifView.level.backValue().exp-1){
            schoolGifView.exp.exp=0;
            schoolGifView.level.level++;
            schoolGifView.gifPlay.obj.level=schoolGifView.level.level;
            schoolGifView.gifPlay.obj.hit=schoolGifView.level.backValue().hit;


//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Jin)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*5;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Mu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*2;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Shui)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*1;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Huo)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*4;
//            if (schoolGifView.laserGif.obj.ShuXin== ShuXin.Tu)schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*3;
        }


    }

}

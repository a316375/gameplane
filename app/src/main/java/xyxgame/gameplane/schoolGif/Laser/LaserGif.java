package xyxgame.gameplane.schoolGif.Laser;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Play.PlayGif;
import xyxgame.gameplane.schoolGif.Model.Money;

public class LaserGif extends BaseGifObj {
    PlayGif playGif;

    public LaserGif with(PlayGif playGif){
        this.playGif=playGif;
        return this;}

    public LaserGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);

    }

    Money money;
    public LaserGif withMoney(Money money) {
       this.money=money;
       return this;

    }



    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
        gifBag= new LaserBags(obj,  list);

      }

    @Override
    protected CopyOnWriteArrayList<Bitmap> lodebitmaps_list__allBitmaps_get_objow_obj_oh() {
//        list=allBitmaps.getlaser03(obj.oW,obj.oH);

        return allBitmaps.getlaser02(obj.oW,obj.oH);
    }


    private int laser_lv=0;

    public int getLaser_lv() {
        return laser_lv;
    }

    public void setLaser_lv(int laser_lv) {
        this.laser_lv = laser_lv;
    }

    @Override
    protected void add_bags_add_new_obj_list() {
//        if (money.all<=0) return;
//
//        //子弹重新定义位置
//        if (playGif.bags.size()<=0||money==null)return;
//        if (playGif!=null) {
//            obj.oX=playGif.bags.get(0).x+playGif.bags.get(0).w/2-obj.oW/2;
//            obj.oY=playGif.bags.get(0).y;
//        }


      add();



//        //各个级别的子弹逻辑
//        if (playGif.obj.level<=9) bags.add(new LaserBags(obj, list));
//        if (playGif.obj.level>9&&playGif.obj.level<=39){
//
//            obj.oX+=25;
//            bags.add(new LaserBags(obj, list));
//            obj.oX-=50;
//            bags.add(new LaserBags(obj, list));
//        }
//        if (playGif.obj.level>39&&playGif.obj.level<=99){
//
//            bags.add(new LaserBags(obj, list));
//            obj.oX+=25;
//            bags.add(new LaserBags1(obj, list));
//            obj.oX-=50;
//            bags.add(new LaserBags2(obj, list));
//        }
//        if (playGif.obj.level>99&&playGif.obj.level<=999999){
//            bags.add(new LaserBags(obj, list));
//            obj.oX+=30;
//            bags.add(new LaserBags1(obj, list));
//           // bags.add(new LaserBags(obj, list));
//            obj.oX+=30;
//            bags.add(new LaserBags(obj, list));
//            obj.oX-=30*3;
//            bags.add(new LaserBags2(obj, list));
//           // bags.add(new LaserBags(obj, list));
//            obj.oX-=30;
//            bags.add(new LaserBags(obj, list));
//
//        }



//
//         if (playGif.obj.level>0)money.all-=1;
//         if (playGif.obj.level>10)money.all-=1;
//         if (playGif.obj.level>20)money.all-=1;
//         if (playGif.obj.level>30)money.all-=1;
//         if (playGif.obj.level>40)money.all-=1;







    }

    public void add() {
        if (money.all<=0) return;

        //子弹重新定义位置
        if (playGif.bags.size()<=0||money==null)return;
        if (playGif!=null) {
            obj.oX=playGif.bags.get(0).x+playGif.bags.get(0).w/2-obj.oW/2;
            obj.oY=playGif.bags.get(0).y;
        }
     if (laser_lv==0)  bags.add(new LaserBags(obj, list));
     if (laser_lv==1) {
            obj.oX+=50;
            bags.add(new LaserBags(obj, list));
            obj.oX-=100;
            bags.add(new LaserBags(obj, list));}
     if (laser_lv==3) {

         bags.add(new LaserBags(obj, list));
            obj.oX+=35;
            bags.add(new LaserBags1(obj, list));
            obj.oX-=70;
            bags.add(new LaserBags2(obj, list));
     }
     if (laser_lv==5) {
         bags.add(new LaserBags(obj, list));
            obj.oX+=30;
            bags.add(new LaserBags1(obj, list));
           // bags.add(new LaserBags(obj, list));
            obj.oX+=30;
            bags.add(new LaserBags(obj, list));
            obj.oX-=30*3;
            bags.add(new LaserBags2(obj, list));
           // bags.add(new LaserBags(obj, list));
            obj.oX-=30;
            bags.add(new LaserBags(obj, list));

        }



    }

    @Override
    public void playmusic() {
        super.playmusic();

        // Log.v("----","------雷打开---------");
     if (playGif.lei_Open)    music.playLaser2();
     else music.playLaser();
    }

}

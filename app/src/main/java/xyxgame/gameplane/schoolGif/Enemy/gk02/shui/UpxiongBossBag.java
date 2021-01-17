package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.Enemy.gk01.XiongBossBags;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;

public class UpxiongBossBag extends XiongBossBags {
    public UpxiongBossBag(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);

        //matrix_degress=180;
    }

//    @Override
//    public void startONFire_hit(SchoolGifView schoolGifView, int lose_life) {
//
//    }

    @Override
    public void startA(CopyOnWriteArrayList<BaseGifBag> laser_bags, BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo)return;
        super.startA(laser_bags, laser_bag);
    }

    @Override
    public void startH(SchoolGifView schoolGifView, BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo)return;
        super.startH(schoolGifView, laser_bag);
    }

    @Override
    public void startE(SchoolGifView schoolGifView, int lose_life, BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo)return;
        super.startE(schoolGifView, lose_life, laser_bag);
    }

    @Override
    public void startB(SchoolGifView schoolGifView, BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo)return;
        super.startB(schoolGifView, laser_bag);
    }

    @Override
    public void startC(SchoolGifView schoolGifView, BaseGifBag laser_bag) {
        if (laser_bag.shuxin== ShuXin.Huo)return;
        super.startC(schoolGifView, laser_bag);
    }

    @Override
    public int startD(BaseGifBag laser_bag) {
        if (laser_bag.shuxin==ShuXin.Huo)return 0;
        return super.startD(laser_bag);
    }



    @Override
    public void startF(SchoolGifView schoolGifView, BaseGifBag laser_bag) {
        super.startF(schoolGifView, laser_bag);
    }

    @Override
    public void startG(SchoolGifView schoolGifView, BaseGifBag laser_bag) {
        super.startG(schoolGifView, laser_bag);
    }

    @Override
    public void startI(SchoolGifView schoolGifView) {
        super.startI(schoolGifView);
    }

    @Override
    public void startJ(SchoolGifView schoolGifView) {
        super.startJ(schoolGifView);
    }

    @Override
    public void startK(BaseGifObj enemy_obj) {
        super.startK(enemy_obj);
    }

    @Override
    public void drawpath() {

        y+=obj.speed;
    }

    @Override
    public void setRect(int x, int y, int w, int h) {
         rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);
    }


}

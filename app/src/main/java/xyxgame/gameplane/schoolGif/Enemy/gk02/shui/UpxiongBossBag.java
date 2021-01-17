package xyxgame.gameplane.schoolGif.Enemy.gk02.shui;

import android.graphics.Bitmap;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
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
    public void drawpath() {

        y+=obj.speed;
    }

    @Override
    public void setRect(int x, int y, int w, int h) {
         rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);
    }


}

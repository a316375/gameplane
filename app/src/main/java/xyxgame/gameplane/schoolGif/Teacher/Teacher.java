package xyxgame.gameplane.schoolGif.Teacher;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.laser.LaserBags;
import xyxgame.gameplane.schoolGif.laser.LaserGif;

public class Teacher extends View {

    SchoolGifView schoolGifView;
    public Teacher(SchoolGifView schoolGifView) {
        super(schoolGifView.mBaseActivity);
        this.schoolGifView = schoolGifView;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (schoolGifView.buttonGif01.bags.size()<=0)return true;
                if (schoolGifView.buttonGif01.bags.get(0).rect.contains((int) event.getX(),(int) event.getY())){
                    Log.v("-------","------O-nClickListener---obj--"+schoolGifView.buttonGif01.obj.giflist);


                    schoolGifView.showlistA=true;//打开列表A

                   //示例改变子弹
                    schoolGifView.laserGif.F5_GIf=3;
                    schoolGifView.laserGif. obj.oW=100;
                    schoolGifView.laserGif. obj.oH=150;
                    schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser04(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                }

                if (schoolGifView.listAGif.rect1.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.F5_GIf=5;
                    schoolGifView.laserGif. obj.oW=100;
                    schoolGifView.laserGif. obj.oH=200;
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps1;


                }
                if (schoolGifView.listAGif.rect2.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps2;
                }
                if (schoolGifView.listAGif.rect3.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps3;
                }
                if (schoolGifView.listAGif.rect4.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps4;
                }
                if (schoolGifView.listAGif.rect5.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps5;
                }
                if (schoolGifView.listAGif.rect6.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps6;
                }
                if (schoolGifView.listAGif.rect7.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps7;
                }
                if (schoolGifView.listAGif.rect8.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps8;
                }
                if (schoolGifView.listAGif.rect9.contains((int) event.getX(),(int) event.getY())){
                    schoolGifView.laserGif.list=schoolGifView.listAGif.bitmaps9;
                }
















                if (schoolGifView.buttonGif02.bags.size()<=0)return true;
                if (schoolGifView.buttonGif02.bags.get(0).rect.contains((int) event.getX(),(int) event.getY())){
                    Log.v("-------","------O-nClickListener---obj--"+schoolGifView.buttonGif02.obj.giflist);


                }




                return true;}

        return true;
    }



}

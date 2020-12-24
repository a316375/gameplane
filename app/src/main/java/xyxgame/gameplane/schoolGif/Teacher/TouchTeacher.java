package xyxgame.gameplane.schoolGif.Teacher;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.SchoolGifActivity;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.ShuXin;
import xyxgame.gameplane.schoolGif.ShowList.ListB;

public class TouchTeacher extends View {

    SchoolGifView schoolGifView;
    public TouchTeacher(SchoolGifView schoolGifView) {
        super(schoolGifView.mBaseActivity);
        this.schoolGifView = schoolGifView;
    }



    private int lastX, lastY;//手指的位置
    private float pointX, pointY;//飞机的位置
    private int pointXFix, pointYFix;//最终飞机的位置


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Get the pointer ID


        // ... Many touch events later...




        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getPointerId(event.getActionIndex()) == 0){
                    lastX = (int) event.getX();//保存手指临时值
                    lastY = (int) event.getY();
                    if (schoolGifView.gifPlay.bags.size()<=0)return true;
                    pointX = schoolGifView.gifPlay.bags.get(0).x;//保存飞机按下时候的原始位置
                    pointY =schoolGifView.gifPlay. bags.get(0).y;
                  //  Log.v("-------","---coming");
                    downTouch(event,0);
                    return true;
                }


            case MotionEvent.ACTION_MOVE:
                if (event.getPointerId(event.getActionIndex()) == 0){
                    pointXFix = (int) (pointX + (event.getX() - lastX));
                    pointYFix = (int) (pointY + (event.getY() - lastY));

                    if (schoolGifView.gifPlay.bags.size()<=0)return true;
                    BaseGifBag baseGifBag = schoolGifView.gifPlay.bags.get(0);
                    baseGifBag.moveToXY(pointXFix, pointYFix,schoolGifView.gifPlay.obj.maXx,schoolGifView.gifPlay.obj.maXy);


                } return true;


            case MotionEvent.ACTION_POINTER_DOWN:

                if (event.getPointerId(event.getActionIndex()) == 1){

                    //Log.v("-------","---coming1");
                    downTouch(event,1);

                }


                return true;

        }
        return true;


    }






//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//
//        switch (event.getActionMasked()) {
//            case MotionEvent.ACTION_DOWN:
//                if (downTouch(event)) return true;
//
//
//                return true;}
//
//        return true;
//    }

    private boolean downTouch(MotionEvent event, int i) {




        if (schoolGifView.buttonGif01.bags.size()<=0) return true;
        if (schoolGifView.buttonGif01.bags.get(0).rect.contains((int) event.getX(i),(int) event.getY(i))){
         //   Log.v("-------","------O-nClickListener---obj--" +schoolGifView.buttonGif01.obj.ShuXin);



        }


        if (schoolGifView.buttonGif02.bags.size()<=0) return true;
        if (schoolGifView.buttonGif02.bags.get(0).rect.contains((int) event.getX(i),(int) event.getY(i))){
         //   Log.v("-------","------O-nClickListener---obj--"+schoolGifView.buttonGif01.obj.giflist);


            schoolGifView.showlistA=!schoolGifView.showlistA;//打开列表A

//                   //示例改变子弹
//                    schoolGifView.laserGif.F5_GIf=3;
//                    schoolGifView.laserGif. obj.oW=100;
//                    schoolGifView.laserGif. obj.oH=150;
//                    schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser04(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

        }


        if (schoolGifView.showlistA) {

            ListB listB = schoolGifView.listB;
            ArrayList<BaseStopBitmap> list = listB.list;
            for (BaseStopBitmap baseStopBitmap:list){
                if (baseStopBitmap.rect.contains((int) event.getX(i),(int) event.getY(i))){
                   // schoolGifView.showlistA=!schoolGifView.showlistA;
                    if (baseStopBitmap.num== ShuXin.Jin){
                        schoolGifView.laserGif.F5_GIf=5;
                        schoolGifView.laserGif. obj.oW=50;
                        schoolGifView.laserGif. obj.oH=100;
                        schoolGifView.laserGif. Time_wait=15;
                        schoolGifView.laserGif. obj.speed=30;
                        schoolGifView.laserGif.obj.max=10;
                        schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*5;
                        schoolGifView.laserGif.obj.ShuXin= ShuXin.Jin;
                        schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser02(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                    }
                    if (baseStopBitmap.num==ShuXin.Mu){

                        int size = schoolGifView.laserGif.bags.size();



                        schoolGifView.laserGif.F5_GIf=3;
                        schoolGifView.laserGif. obj.oW=100;
                        schoolGifView.laserGif. obj.oH=150;
                        schoolGifView.laserGif. Time_wait=28;
                        schoolGifView.laserGif. obj.speed=22;
                        schoolGifView.laserGif.obj.max=10;
                        schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*2;
                        schoolGifView.laserGif.obj.ShuXin= ShuXin.Mu;
                        schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser04(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                    }
                    if (baseStopBitmap.num==ShuXin.Shui){
                        schoolGifView.laserGif.F5_GIf=5;
                        schoolGifView.laserGif. obj.oW=100;
                        schoolGifView.laserGif. obj.oH=150;
                        schoolGifView.laserGif. Time_wait=25;
                        schoolGifView.laserGif. obj.speed=23;
                        schoolGifView.laserGif.obj.max=10;
                        schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit;
                        schoolGifView.laserGif.obj.ShuXin= ShuXin.Shui;
                        schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser05(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                    }
                    if (baseStopBitmap.num==ShuXin.Huo){
                        schoolGifView.laserGif.F5_GIf=5;
                        schoolGifView.laserGif. obj.oW=100;
                        schoolGifView.laserGif. obj.oH=130;
                        schoolGifView.laserGif. Time_wait=24;
                        schoolGifView.laserGif. obj.speed=24;
                        schoolGifView.laserGif.obj.max=10;
                        schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit;
                        schoolGifView.laserGif.obj.ShuXin= ShuXin.Huo;
                        schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser09(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                    }
                    if (baseStopBitmap.num==ShuXin.Tu){
                        schoolGifView.leiEffect.open=!schoolGifView.leiEffect.open;
//                        schoolGifView.laserGif.obj.max=0;
//                        schoolGifView.laserGif.obj.hit=99999;
//                        schoolGifView.laserGif.obj.ShuXin= ShuXin.Tu;
//                        schoolGifView.laserGif.F5_GIf=10;
//                        schoolGifView.laserGif. obj.oW=220;
//                        schoolGifView.laserGif. obj.oH=200;
//                        schoolGifView.laserGif. Time_wait=20;
//                        schoolGifView.laserGif. obj.speed=20;
//                        schoolGifView.laserGif. obj.max=1;
//                        schoolGifView.laserGif. obj.hit=schoolGifView.gifPlay. obj.hit*4;
//                        schoolGifView.laserGif.list=schoolGifView.laserGif. allBitmaps.getlaser06(schoolGifView.laserGif. obj.oW,schoolGifView.laserGif. obj.oH);

                    }
                }
            }
        }




        if (schoolGifView.showAD)
        if (schoolGifView.adList.rect.contains((int) event.getX(i),(int) event.getY(i))) {


            ((SchoolGifActivity) schoolGifView.mBaseActivity).show_AD();




        }


        return false;
    }


}

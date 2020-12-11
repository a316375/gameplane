package xyxgame.gameplane.school;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import java.util.stream.Stream;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseEffectStudent;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.R;
import xyxgame.gameplane.school.Students.StudentA;
import xyxgame.gameplane.school.Students.StudentB;
import xyxgame.gameplane.school.Students.StudentC;
import xyxgame.gameplane.school.Students.StudentD;
import xyxgame.gameplane.school.Students.StudentVIPA;
import xyxgame.gameplane.school.Students.StudentVIPB;
import xyxgame.gameplane.school.Students.StudentVIP_Play;

public class StudentList {


    //这个类负责bitmap管理，bitmap的控制类要求是全局变量，可以复用，否则会很卡，拒绝recycle提高复用率实现高性能
    int students_Max=5;//每次同时出现的最大值




//普通无帧动画的Student
    BaseStudent studentA,studentB,studentC,studentD;
    private final BaseBag baseBagA,baseBagB,baseBagC,baseBagD;
    ArrayList<BaseStudent> listA,listB,listC,listD  ;




//特殊有帧动画的Student 比普通多一组Arrlist<Bitmaps>
    BaseStudent studentVIP_Play;//特例
    BaseStudent   StudentVIPA,StudentVIPB;
    private final BaseBag baseBagVIP_Play,baseBagVIPA,baseBagVIPB;
    ArrayList<BaseStudent> listVip_Play,listVipA ,listVipB;
    ArrayList<Bitmap> listVIPPlay_Bitmaps,listVIPA_Bitmaps,listVIPB_Bitmaps;




    BaseActivity context;



    public StudentList(BaseActivity context) {
        this.context=context;

        listA=new ArrayList<>();
        listB=new ArrayList<>();
        listC=new ArrayList<>();
        listD=new ArrayList<>();


        listVip_Play =new ArrayList<>();
        listVIPPlay_Bitmaps =creatEffcetList(R.drawable.c1ani);
        listVipA =new ArrayList<>();
        listVIPA_Bitmaps =creatEffcetList(R.drawable.b_001);
        listVipB =new ArrayList<>();
        listVIPB_Bitmaps =creatEffcetList(R.drawable.b_001_1);


        baseBagA = new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple).changWH(50,200);
        baseBagB = new BaseBag((ASchoolActivity) context, R.drawable.c1);
        baseBagC = new BaseBag((ASchoolActivity) context, R.drawable.laser_1);
        baseBagD = new BaseBag((ASchoolActivity) context, R.drawable.spaceship_1_blue);
        baseBagVIP_Play = new BaseBag((ASchoolActivity) context, R.drawable.c1ani);
        baseBagVIPA = new BaseBag((ASchoolActivity) context, R.drawable.b_001);
        baseBagVIPB = new BaseBag((ASchoolActivity) context, R.drawable.b_001_1);


        studentA=new StudentA(baseBagA);
        studentB=new StudentB(baseBagB);
        studentC=new StudentC(baseBagC);
        studentD=new StudentD(baseBagD);
        studentVIP_Play =new StudentVIP_Play(this.baseBagVIP_Play, listVIPPlay_Bitmaps,
                new Point(context.point.x/2,context.point.y-500));
        StudentVIPA =new BaseEffectStudent(this.baseBagVIPA, listVIPA_Bitmaps,new Point(50,20));
        StudentVIPB =new BaseEffectStudent(this.baseBagVIPB, listVIPB_Bitmaps,new Point(50,20));



        //特例玩家
        listVip_Play.add(studentVIP_Play);

    }


    public void AddList(){

        try {
            justclean();
            if (OnTimeClean){onTimeClean(); }
        }finally {

        if (listA.size()<students_Max*2) {

            listA.add(new StudentA(baseBagA).onBuildXY(studentVIP_Play));}
        if (listB.size()<students_Max) {listB.add(new StudentB(baseBagB));}
        if (listC.size()<students_Max) {listC.add(new StudentC(baseBagC));}
        if (listD.size()<students_Max) {listD.add(new StudentD(baseBagD));}
        if (listVipA.size()<students_Max) {listVipA.add(new StudentVIPA(baseBagVIPA, listVIPA_Bitmaps,
                new Point(new Random().nextInt(context.point.x),new Random().nextInt(context.point.y))));}
        if (listVipB.size()<students_Max) {listVipB.add(new StudentVIPB(baseBagVIPB, listVIPB_Bitmaps,
                new Point(new Random().nextInt(context.point.x),new Random().nextInt(context.point.y))));}
        }

    }


    //即时清理对象用于子弹 私有自己去维护
    protected void justclean(){
        cleanNull(listA);
        cleanNullEffect(listVipA);
        cleanNullEffect(listVipB);
    }

    public  boolean OnTimeClean=false;
    //定时清理用于boss产出 其他类去维护，因为时间在RoomA这个类控制,如果把时间传过来处理会导致卡顿，所以不推荐
    protected void onTimeClean(){
        cleanNull(listB);
        cleanNull(listC);
        cleanNull(listD);
        OnTimeClean=false;

    }

    protected void cleanNullEffect(ArrayList   list) {

        Iterator<BaseEffectStudent> iterator = list.iterator();

        while (iterator.hasNext()){

            if (iterator.next().bitmaps_is_over){iterator.remove();};
       }


    }




    protected void cleanNull(ArrayList<BaseStudent> list){

        Iterator<BaseStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().is_over)iterator.remove();

       }

    }

    protected    ArrayList<Bitmap> creatEffcetList(int draw){

            ArrayList<Bitmap> list = new ArrayList<>();

                Bitmap bt = BitmapUtils.decodeSampledBitmapFromResource(context.getResources(), draw, 1000, 100);
                for (int i = 0; i < 10; i++) {
                    Bitmap bt2 = Bitmap.createBitmap(bt, bt.getWidth() * i / 10, 0, bt.getWidth() / 10, bt.getHeight());
                    // bt2=Bitmap.createScaledBitmap(bt2,1000,1000,false);
                    list.add(bt2);
                }

                return list;

        }

    }




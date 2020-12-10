package xyxgame.gameplane.school;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

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

public class StudentList {


    //这个类负责bitmap管理，要求是全局变量，可以复用，否则会很卡

    public HashMap<Integer,ArrayList<BaseStudent>> Map;
//普通无帧动画的Student
    BaseStudent studentA,studentB,studentC,studentD;
    private final BaseBag baseBagA,baseBagB,baseBagC,baseBagD;
    ArrayList<BaseStudent> listA,listB,listC,listD  ;

//特殊有帧动画的Student 比普通多一组Arrlist<Bitmaps>
    BaseStudent StudentVIPA,StudentVIPB;
    private final BaseBag baseBagVIPA,baseBagVIPB;
    ArrayList<BaseStudent> listVipA ,listVipB;
    ArrayList<Bitmap> listVIPA_Bitmaps,listVIPB_Bitmaps;




    BaseActivity context;



    public StudentList(BaseActivity context) {
        this.context=context;
        Map=new HashMap<>();
        listA=new ArrayList<>();
        listB=new ArrayList<>();
        listC=new ArrayList<>();
        listD=new ArrayList<>();

        listVipA =new ArrayList<>();
        listVIPA_Bitmaps =creatEffcetList(R.drawable.b_001);
        listVipB =new ArrayList<>();
        listVIPB_Bitmaps =creatEffcetList(R.drawable.b_001_1);


        baseBagA = new BaseBag((ASchoolActivity) context, R.drawable.laser_1);
        baseBagB = new BaseBag((ASchoolActivity) context, R.drawable.c1);
        baseBagC = new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple);
        baseBagD = new BaseBag((ASchoolActivity) context, R.drawable.meteor_1);
        baseBagVIPA = new BaseBag((ASchoolActivity) context, R.drawable.b_001);
        baseBagVIPB = new BaseBag((ASchoolActivity) context, R.drawable.b_001_1);


        studentA=new StudentA(baseBagA);
        studentB=new StudentB(baseBagB);
        studentC=new StudentC(baseBagC);
        studentD=new StudentC(baseBagD);
        StudentVIPA =new BaseEffectStudent(this.baseBagVIPA, listVIPA_Bitmaps,new Point(50,20));
        StudentVIPB =new BaseEffectStudent(this.baseBagVIPB, listVIPB_Bitmaps,new Point(50,20));

        for (int i = 0; i <1 ; i++) {
            listA.add(studentA);
            listB.add(studentB);
            listC.add(studentC);
            listD.add(studentD);
            listVipA.add(StudentVIPA);
            listVipB.add(StudentVIPB);
        }

        Map.put(0,listA);
        Map.put(1,listB);
        Map.put(2,listC);
        Map.put(3,listD);
        Map.put(4, listVipA);
        Map.put(5, listVipB);


    }




    int students_Max=5;//每次同时出现的最大值

    public void AddList(){

        try {
         cleanNull(listA);
         cleanNull(listB);
         cleanNull(listC);
         cleanNull(listD);
         cleanNullEffect(listVipA);
         cleanNullEffect(listVipB);

    }finally {

        if (listA.size()<students_Max) {listA.add(new StudentA(baseBagA));}
        if (listB.size()<students_Max) {listB.add(new StudentB(baseBagB));}
        if (listC.size()<students_Max) {listC.add(new StudentC(baseBagC));}
        if (listD.size()<students_Max) {listD.add(new StudentD(baseBagD));}
        if (listVipA.size()<students_Max) {listVipA.add(new StudentVIPA(baseBagVIPA, listVIPA_Bitmaps,
                new Point(new Random().nextInt(context.point.x),new Random().nextInt(context.point.y))));}
        if (listVipB.size()<students_Max) {listVipB.add(new StudentVIPB(baseBagVIPB, listVIPB_Bitmaps,
                new Point(new Random().nextInt(context.point.x),new Random().nextInt(context.point.y))));}
    }
    }

    protected void cleanNullEffect(ArrayList list) {

        Iterator<BaseEffectStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().bitmaps_is_over){iterator.remove();};
       }


    }

    protected void cleanNull(ArrayList list){

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




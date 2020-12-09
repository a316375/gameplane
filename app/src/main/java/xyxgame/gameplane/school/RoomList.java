package xyxgame.gameplane.school;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

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

public class RoomList {

    public HashMap<Integer,ArrayList<BaseStudent>> Map;

    ArrayList<BaseStudent> listA;
    ArrayList<BaseStudent> listB;
    ArrayList<BaseStudent> listC;
    ArrayList<BaseStudent> listD;
    ArrayList<Bitmap> listDBitmaps;

    BaseStudent studentA;
    BaseStudent studentB;
    BaseStudent studentC;
    BaseStudent studentD;
    BaseActivity context;
    private final BaseBag baseBag;

    public RoomList(BaseActivity context) {
        this.context=context;
        Map=new HashMap<>();
        listA=new ArrayList<>();
        listB=new ArrayList<>();
        listC=new ArrayList<>();
        listD=new ArrayList<>();
        listDBitmaps=creatEffcetList(R.drawable.b_001);
        baseBag = new BaseBag((ASchoolActivity) context, R.drawable.b_001);

        studentA=new StudentA(new BaseBag((ASchoolActivity) context, R.drawable.laser_1));
        studentB=new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.c1));
        studentC=new StudentC(new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple));
        studentD=new BaseEffectStudent(baseBag, listDBitmaps,new Point(50,20));

        for (int i = 0; i <1 ; i++) {
            listA.add(studentA);
            listB.add(studentB);
            listC.add(studentC);
            listD.add(studentD);
        }

        Map.put(0,listA);
        Map.put(1,listB);
        Map.put(2,listC);
        Map.put(3,listD);


    }





    public void AddList(){

        try {
         cleanNull(listA);
         cleanNull(listB);
         cleanNull(listC);
         cleanNullEffect(listD);

    }finally {

        if (listA.size()<=3) {listA.add(new StudentA(new BaseBag((ASchoolActivity) context, R.drawable.laser_1)));}
        if (listB.size()<=3) {listB.add(new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.c1)));}
        if (listC.size()<=3) {listC.add(new StudentC(new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple)));}
        if (listD.size()<=3) {listD.add(new StudentD(baseBag, listDBitmaps,
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
            if (iterator.next().bitmap.isRecycled())iterator.remove();
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




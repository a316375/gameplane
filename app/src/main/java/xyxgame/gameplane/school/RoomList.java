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
    private final BaseBag baseBagD;
    private final BaseBag baseBagA;
    private final BaseBag baseBagB;
    private final BaseBag baseBagC;

    public RoomList(BaseActivity context) {
        this.context=context;
        Map=new HashMap<>();
        listA=new ArrayList<>();
        listB=new ArrayList<>();
        listC=new ArrayList<>();
        listD=new ArrayList<>();
        listDBitmaps=creatEffcetList(R.drawable.b_001);
        baseBagD = new BaseBag((ASchoolActivity) context, R.drawable.b_001);

        baseBagA = new BaseBag((ASchoolActivity) context, R.drawable.laser_1);
        baseBagB = new BaseBag((ASchoolActivity) context, R.drawable.c1);
        baseBagC = new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple);
        studentA=new StudentA(baseBagA);
        studentB=new StudentB(baseBagB);
        studentC=new StudentC(baseBagC);
        studentD=new BaseEffectStudent(this.baseBagD, listDBitmaps,new Point(50,20));

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

        if (listA.size()<=3) {listA.add(new StudentA(baseBagA));}
        if (listB.size()<=3) {listB.add(new StudentB(baseBagB));}
        if (listC.size()<=3) {listC.add(new StudentC(baseBagC));}
        if (listD.size()<=3) {listD.add(new StudentD(baseBagD, listDBitmaps,
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




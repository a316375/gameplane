package xyxgame.gameplane.school;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.R;

public class RoomList {

    public HashMap<Integer,ArrayList<BaseStudent>> Map;

    ArrayList<BaseStudent> listA;
    ArrayList<BaseStudent> listB;
    ArrayList<BaseStudent> listC;

    BaseStudent studentA;
    BaseStudent studentB;
    BaseStudent studentC;
    BaseActivity context;

    public RoomList(BaseActivity context) {
        this.context=context;
        Map=new HashMap<>();
        listA=new ArrayList<>();
        listB=new ArrayList<>();
        listC=new ArrayList<>();

        studentA=new StudentA(new BaseBag((ASchoolActivity) context, R.drawable.laser_1));
        studentB=new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.c1));
        studentC=new StudentC(new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple));

        for (int i = 0; i <1 ; i++) {
            listA.add(studentA);
            listB.add(studentB);
            listC.add(studentC);
        }

        Map.put(0,listA);
        Map.put(1,listB);
        Map.put(2,listC);


    }

    protected void cleanNull(ArrayList list){
        Iterator<BaseStudent> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().bitmap.isRecycled())iterator.remove();
        }
    }


    public void AddList(){

        try {
         cleanNull(listA);
         cleanNull(listB);
         cleanNull(listC);

    }finally {

        if (listA.size()<=3) {listA.add(new StudentA(new BaseBag((ASchoolActivity) context, R.drawable.laser_1)));}
        if (listB.size()<=3) {listB.add(new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.c1)));}
        if (listC.size()<=3) {listC.add(new StudentC(new BaseBag((ASchoolActivity) context, R.drawable.my_bullet_purple)));}
    }
    }




}

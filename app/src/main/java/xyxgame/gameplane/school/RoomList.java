package xyxgame.gameplane.school;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;

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
        studentB=new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.laser_2));
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

    public void AddList(){
        if (listA.size()<=10) {listA.add(new StudentA(new BaseBag((ASchoolActivity) context, R.drawable.laser_1)));}
        if (listB.size()<=10) {listB.add(new StudentB(new BaseBag((ASchoolActivity) context, R.drawable.meteor_1)));}
        if (listC.size()<=10) {listC.add(new StudentC(new BaseBag((ASchoolActivity) context, R.drawable.meteor_2)));}
    }




}

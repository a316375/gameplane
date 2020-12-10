package xyxgame.gameplane.school.Students;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentC extends BaseStudent {


    public StudentC(  BaseBag baseBag) {
        super(  baseBag);
        mx=point.x/2;
        my=0;

    }

    @Override
    public void drawXP() {
        my+=15;
    }


}

package xyxgame.gameplane.school.Students;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentA extends BaseStudent {


    public StudentA(  BaseBag baseBag) {
        super(  baseBag);
    }

    @Override
    public void drawXP() {
        my-=10;
    }


}

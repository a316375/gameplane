package xyxgame.gameplane.school;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentB extends BaseStudent {


    public StudentB(BaseBag baseBag) {
        super(baseBag);
    }

    @Override
    public void UPXP() {
        my-=10;
    }
}

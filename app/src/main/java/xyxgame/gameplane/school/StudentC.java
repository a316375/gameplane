package xyxgame.gameplane.school;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentC extends BaseStudent {


    public StudentC(BaseBag baseBag) {
        super(baseBag);
    }

    @Override
    public void UPXP() {
        mx+=1;
        my+=1;
    }
}

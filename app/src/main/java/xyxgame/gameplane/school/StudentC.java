package xyxgame.gameplane.school;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseStudent;

public class StudentC extends BaseStudent {
    public StudentC(Activity activity, int draw) {
        super(activity, draw);
    }

    @Override
    public void UPXP() {
        mx+=1;
        my+=1;
    }
}

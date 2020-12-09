package xyxgame.gameplane.school;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseStudent;

public class StudentB extends BaseStudent {
    public StudentB(Activity activity, int draw) {
        super(activity, draw);
    }

    @Override
    public void UPXP() {
        mx+=1;
    }
}

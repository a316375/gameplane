package xyxgame.gameplane.school;

import android.app.Activity;

import xyxgame.gameplane.Base.BaseStudent;

public class StudentA extends BaseStudent {
    public StudentA(Activity activity, int draw) {
        super(activity, draw);
    }

    @Override
    public void UPXP() {
         my+=1;
    }
}

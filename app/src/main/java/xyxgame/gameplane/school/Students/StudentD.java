package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;

public class StudentD extends BaseStudent {


    public StudentD(BaseBag baseBag) {
        super( baseBag);
        bitmap= Bitmap.createScaledBitmap(bitmap,150,150,false);
        mx_BaseStudent =point.x/2;
        my_BaseStudent =0;


    }



    @Override
    public void drawXP() {

        if (my_BaseStudent <500) {
            my_BaseStudent +=2;
            }else {

            my_BaseStudent+=3;


             }

    }


}

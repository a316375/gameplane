package xyxgame.gameplane.school;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseEffectStudent;

public class StudentD extends BaseEffectStudent {
    public StudentD(BaseBag baseBag,ArrayList<Bitmap> bitmaps, Point point) {
        super(baseBag,bitmaps, point);
    }

    @Override
    public void drawXP() {
        super.drawXP();
        my-=10;
    }
}
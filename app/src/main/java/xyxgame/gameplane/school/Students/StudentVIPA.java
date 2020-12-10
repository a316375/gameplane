package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseEffectStudent;

public class StudentVIPA extends BaseEffectStudent {
    public StudentVIPA(BaseBag baseBag, ArrayList<Bitmap> bitmaps, Point point) {
        super(baseBag,bitmaps, point);
    }

    @Override
    public void drawXP() {
        super.drawXP();
        my-=10;
    }
}
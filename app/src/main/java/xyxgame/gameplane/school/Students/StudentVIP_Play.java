package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseEffectStudent;

public class StudentVIP_Play extends BaseEffectStudent {
    public StudentVIP_Play(BaseBag baseBag, ArrayList<Bitmap> bitmaps, Point point) {
        super(baseBag,bitmaps, point);

    }

    @Override
    public void drawXP() {
        super.drawXP();
         
    }

    @Override
    public void draw(Canvas canvas) {

        run=run%10;

        if (j<30)
        {
            j++;
            if (bitmaps!=null&&!bitmaps.get(run).isRecycled() ){
                canvas.drawBitmap(bitmaps.get(run), mx_BaseStudent, my_BaseStudent,new Paint());
            }
        }
        if (j==30){j=0; }


        if (j%3==0)  run++;


    }


}
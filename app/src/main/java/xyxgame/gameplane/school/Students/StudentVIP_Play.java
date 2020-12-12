package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
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
    public void draw(Canvas canvas) {



        if (bitmaps==null)return;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawRect(rect,paint);
        rect.set((int)mx_BaseStudent,(int)my_BaseStudent,
                (int) mx_BaseStudent+bitmaps.get(0).getWidth(),
                (int)my_BaseStudent+bitmaps.get(0).getHeight());




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
package xyxgame.gameplane.school.Students;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

import xyxgame.gameplane.Base.BaseBag;
import xyxgame.gameplane.Base.BaseStudent;
import xyxgame.gameplane.Base.BezierUtil;

public class StudentA extends BaseStudent {


    private PointF pointF;

    public StudentA(BaseBag baseBag   ) {
        super(  baseBag);


    }


    @Override
    public void creatRect() {
        rect.set((int)mx_BaseStudent ,
                (int)my_BaseStudent,
                (int)mx_BaseStudent+bitmap.getWidth(),
                (int)my_BaseStudent+bitmap.getHeight()*1/5);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        //赛贝尔待续
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
//        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(3);

        Path path = new Path();
        path.moveTo(100, 100);

        path.quadTo(500, 0,  1000, 1000);
        path.quadTo(300, 500,  0, 2000);

        //        path.cubicTo(200, 200, 0, 0, 1000, 1000);
        canvas.drawPath(path, paint);




    }

    @Override
    public void drawXP() {

        my_BaseStudent -=15;







    }


}

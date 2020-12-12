package xyxgame.gameplane.Base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public abstract class BaseStudent {


    public Bitmap bitmap;
    public Rect rect;


    public float mx_BaseStudent, my_BaseStudent;
    public Point point;
    public boolean is_over=false;
    public  BaseBag baseBag;

    public  BaseStudent onBuildXY(BaseStudent baseStudent){
        mx_BaseStudent=baseStudent.mx_BaseStudent+100;
        my_BaseStudent=baseStudent.my_BaseStudent-200;
        return this;
    };

    public BaseStudent(BaseBag baseBag) {
        this.baseBag=baseBag;
        bitmap=baseBag.bitmap;
        point=baseBag.activity.point;
        mx_BaseStudent =point.x/2;
        my_BaseStudent =point.y-bitmap.getHeight()-200;
        rect=new Rect();
   }

   public void draw(Canvas canvas){

       creatRect();//矩形绘制


        if (!bitmap.isRecycled())
        canvas.drawBitmap(bitmap, mx_BaseStudent, my_BaseStudent,null);

       Paint paint = new Paint();
       paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
       paint.setStrokeWidth(5);
       paint.setColor(Color.RED);
       canvas.drawRect(rect,paint);
   }

   public void upXY(){

        drawXP();

      if (my_BaseStudent <-100|| mx_BaseStudent <-100|| mx_BaseStudent >point.x|| my_BaseStudent >point.y)is_over=true;
   }

   public void creatRect(){
       rect.set((int)mx_BaseStudent+bitmap.getWidth()/5,
               (int)my_BaseStudent,
               (int)mx_BaseStudent+bitmap.getWidth()*4/5,
               (int)my_BaseStudent+bitmap.getHeight()*3/5);
   }
    public abstract  void drawXP();


    public void  moveToXY(int x, int y){
        mx_BaseStudent =x;
        my_BaseStudent =y;

    }

}


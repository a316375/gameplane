package xyxgame.gameplane.Base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;

public class BaseEffectStudent extends BaseStudent {

    public ArrayList<Bitmap> bitmaps;//传入一堆Bitmap
    public   Point point;//一个坐标点


    public boolean bitmaps_is_over=false;
    public BaseEffectStudent(BaseBag baseBag,ArrayList<Bitmap> bitmaps, Point point) {
        super(baseBag);
        this.bitmaps = bitmaps;

        this.point=point;
        mx_BaseStudent =point.x;
        my_BaseStudent =point.y;




    }



       //run=循环读取，
        //j定时回收
       public   int run=0,j=0;


    @Override
    public  void draw(Canvas canvas){

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);  // 填充模式 - 描边
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawRect(rect,paint);

            run=run%10;

             if (j<30)
             {
                 j++;
                 if (bitmaps!=null&&!bitmaps.get(run).isRecycled() ){
                        canvas.drawBitmap(bitmaps.get(run), mx_BaseStudent, my_BaseStudent,new Paint());
                        }
        }
            if (j==30){j=0;
//            mX=new Random().nextInt(1000);
//            mY=new Random().nextInt(1500);
//                Iterator<Bitmap> iterator = bitmaps.iterator();
//                while (iterator.hasNext()){
//                    iterator.next().recycle();
//                }
                bitmaps=null;
                bitmaps_is_over=true;
            }


            if (j%3==0)     run++;


        }

    @Override
    public void drawXP() {
        if (bitmaps==null)return;
        rect.set((int)mx_BaseStudent,(int)my_BaseStudent,
                (int) mx_BaseStudent+bitmaps.get(0).getWidth(),
                (int)my_BaseStudent+bitmaps.get(0).getHeight());
    }


}

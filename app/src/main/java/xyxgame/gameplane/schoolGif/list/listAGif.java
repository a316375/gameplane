package xyxgame.gameplane.schoolGif.list;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.GifAllBitmaps;
import xyxgame.gameplane.schoolGif.BaseGIf.GifBaseObj;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class listAGif extends GifBaseObj {

    public final CopyOnWriteArrayList<Bitmap> bitmaps1;
    public final CopyOnWriteArrayList<Bitmap> bitmaps2;
    public final CopyOnWriteArrayList<Bitmap> bitmaps3;
    public final CopyOnWriteArrayList<Bitmap> bitmaps4;
    public final CopyOnWriteArrayList<Bitmap> bitmaps5;
    public final CopyOnWriteArrayList<Bitmap> bitmaps6;
    public final CopyOnWriteArrayList<Bitmap> bitmaps7;
    public final CopyOnWriteArrayList<Bitmap> bitmaps8;
    public final CopyOnWriteArrayList<Bitmap> bitmaps9;
    public final Paint debugInfoPaint;
    public Rect rect1,rect2,rect3,rect4,rect5,rect6,rect7,rect8,rect9;

    public listAGif(GifObj obj, GifAllBitmaps allBitmaps) {
        super(obj, allBitmaps);

        rect1=new Rect(120,120,120+200,120+200);
        rect2=new Rect(320,120,320+200,120+200);
        rect3=new Rect(520,120,520+200,120+200);
        rect4=new Rect(120,320,120+200,320+200);
        rect5=new Rect(320,320,320+200,320+200);
        rect6=new Rect(520,320,520+200,320+200);
        rect7=new Rect(120,520,120+200,520+200);
        rect8=new Rect(320,520,320+200,520+200);
        rect9=new Rect(520,520,520+200,520+200);

        bitmaps1 = allBitmaps.getlaser01(obj.oW, obj.oH);
        bitmaps2 = allBitmaps.getlaser02(obj.oW, obj.oH);
        bitmaps3 = allBitmaps.getlaser03(obj.oW, obj.oH);
        bitmaps4 = allBitmaps.getlaser04(obj.oW, obj.oH);
        bitmaps5 = allBitmaps.getlaser05(obj.oW, obj.oH);
        bitmaps6 = allBitmaps.getlaser06(obj.oW, obj.oH);
        bitmaps7 = allBitmaps.getlaser07(obj.oW, obj.oH);
        bitmaps8 = allBitmaps.getlaser08(obj.oW, obj.oH);
        bitmaps9 = allBitmaps.getlaser09(obj.oW, obj.oH);


        //设置无锯齿 也可以使用setAntiAlias(true)
        debugInfoPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        debugInfoPaint.setColor(Color.BLACK);//设置画笔颜色
        debugInfoPaint.setAlpha(100);
        debugInfoPaint.setStrokeWidth(1.5f);//设置线宽
        debugInfoPaint.setStyle(Paint.Style.FILL);//设置样式：FILL表示颜色填充整个；STROKE表示空心



    }

    @Override
    protected void creatBags_gifbag_newxx_obj_list() {
      //  gifBag=new listABags(obj,list);

    }



    @Override
    protected void lodebitmaps_list__allBitmaps_get_objow_obj_oh() {

       // list=allBitmaps.getlaser05(obj.oW,obj.oH);
    }

    @Override
    protected void add_bags_add_new_obj_list() {
      //  bags.add(new listABags(obj,list));
    }




    @Override
    public void draws(Canvas canvas) {

        canvas.drawRoundRect(new RectF(100, 100, 1000, 1000), 50, 50, debugInfoPaint);

        for (int i = 0; i <bitmaps1.size() ; i++) {
            canvas.drawBitmap(bitmaps1.get(0),120,120,null);

        }


        for (int i = 0; i <bitmaps2.size() ; i++) {
            canvas.drawBitmap(bitmaps2.get(0),320,120,null);

        }
        for (int i = 0; i <bitmaps3.size() ; i++) {
            canvas.drawBitmap(bitmaps3.get(0),520,120,null);

        }
        for (int i = 0; i <bitmaps4.size() ; i++) {
            canvas.drawBitmap(bitmaps4.get(0),120,320,null);

        }
        for (int i = 0; i <bitmaps5.size() ; i++) {
            canvas.drawBitmap(bitmaps5.get(0),320,320,null);

        }
        for (int i = 0; i <bitmaps6.size() ; i++) {
            canvas.drawBitmap(bitmaps6.get(0),520,320,null);

        }
        for (int i = 0; i <bitmaps7.size() ; i++) {
            canvas.drawBitmap(bitmaps7.get(0),120,520,null);

        }
        for (int i = 0; i <bitmaps8.size() ; i++) {
            canvas.drawBitmap(bitmaps8.get(0),320,520,null);

        }
        for (int i = 0; i <bitmaps9.size() ; i++) {
            canvas.drawBitmap(bitmaps9.get(0),520,520,null);

        }






    }
}

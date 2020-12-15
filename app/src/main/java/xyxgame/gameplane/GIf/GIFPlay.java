package xyxgame.gameplane.GIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.concurrent.CopyOnWriteArrayList;


//**玩家的类，不需要实现抽象方法**//
public class GIFPlay extends BaseGIFObject {

    CopyOnWriteArrayList<Bitmap> bitmapCopyOnWriteArrayList;
    public GIFPlay(CopyOnWriteArrayList<Bitmap> bitmaps, int x, int y, int time, CopyOnWriteArrayList<Bitmap> bitmapCopyOnWriteArrayList) {
        super(bitmaps, x, y, time);
        this.bitmapCopyOnWriteArrayList=bitmapCopyOnWriteArrayList;
    }


    int i=0;int j=0;
    @Override
    public void drawBG(Canvas canvas) {
        super.drawBG(canvas);

        if (bitmapCopyOnWriteArrayList.size()==0)return;
        j++;
        i=i%bitmapCopyOnWriteArrayList.size();
        canvas.drawBitmap(bitmapCopyOnWriteArrayList.get(i),xX-60,xY-20,null);
       if (j%5==0)i++;
       if (j>=500)j=0;
    }

    @Override
    void drawPath(Canvas canvas) {

    }


}

package xyxgame.gameplane.schoolGif.ShowList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.SchoolGifView;
import xyxgame.gameplane.schoolGif.Tool.Int0000;
import xyxgame.gameplane.schoolGif.Tool.Money;
import xyxgame.gameplane.schoolGif.Tool.UIPaint;

public class UIList {
    BaseActivity baseActivity;

   int  max,may;
    ArrayList<BaseStopBitmap> list;
    ArrayList<Rect>rects;
    UIPaint uiPaint;



  SchoolGifView schoolGifView;

    float i=44;
    private Bitmap bitmap;
    private Matrix matrix;


    //    int money=10000;
    public UIList(BaseActivity baseActivity, SchoolGifView schoolGifView) {
        this.baseActivity = baseActivity;
        this.schoolGifView=schoolGifView;
        list=new ArrayList<>();
        rects=new ArrayList<>();
        uiPaint=new UIPaint(baseActivity);

        max = baseActivity.point.x/2;
        may = baseActivity.point.y/2;

        list.add(new BaseStopBitmap(baseActivity, R.drawable.jinbi01, new Point(max*2-300+50, 130-70), 100, 100));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.jinbi02, new Point(max*2-300+50, 200-70), 100, 100));

        list.add(new BaseStopBitmap(baseActivity, R.drawable.att_bg, new Point(80-10, may*2-100+40 ), 200, 100));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.lv, new Point(120-10, may*2-200+40 ), 100, 100));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.pan_01, new Point(max*2-190, 380 ), 130, 130));






        bitmap = Bitmap.createBitmap(BitmapUtils
                        .decodeSampledBitmapFromResource(
                                baseActivity.getResources(),R.drawable.pan_zheng,30,80)
                  );

        matrix = new Matrix();


        for (BaseStopBitmap baseStopBitmap:list){
            rects.add(baseStopBitmap.rect);
        }



    }











    public void drawCanvas(Canvas canvas){


        if (list.size()<=0)return;







        for (BaseStopBitmap baseStopBitmap:list){
            baseStopBitmap.draws(canvas);
        }







//        canvas.drawText(schoolGifView.money.stringA(),max*2-200,may*2-40,uiPaint.paint1());
//        canvas.drawText(schoolGifView.money.stringB(),max*2-200,may*2+60,uiPaint.paint1());
//        canvas.drawText(Int0000.get0000(schoolGifView.laserGif.obj.hit),120-10,may*2-30+40,uiPaint.paint2());
//        canvas.drawText("DAMAGE",100-10,may*2+40+40,uiPaint.paint2());
//        canvas.drawText(Int0000.get00(schoolGifView.gifPlay.obj.level),145-10,may*2-135+40,uiPaint.paint1());

        canvas.drawText(schoolGifView.money.stringA(),max*2-200+50,130,uiPaint.paint1());
        canvas.drawText(schoolGifView.money.stringB(),max*2-200+50,200,uiPaint.paint1());
        canvas.drawText(Int0000.get0000(schoolGifView.laserGif.obj.hit),120-10,may*2-30+40,uiPaint.paint2());
        canvas.drawText("DAMAGE",100-10,may*2+40+40,uiPaint.paint2());
        canvas.drawText(Int0000.get00(schoolGifView.gifPlay.obj.level),145-10,may*2-135+40,uiPaint.paint1());


        i+=5;
        if (i>360)i=0;

        matrix.setRotate (i,bitmap.getWidth()/2,bitmap.getHeight()-10);
        matrix.postTranslate(max*2-140, 375);


       canvas.drawBitmap(bitmap,matrix,new Paint());
    }
}

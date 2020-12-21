package xyxgame.gameplane.schoolGif.ShowList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

import xyxgame.gameplane.Base.BaseActivity;
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
//    int money=10000;
    public UIList(BaseActivity baseActivity, SchoolGifView schoolGifView) {
        this.baseActivity = baseActivity;
        this.schoolGifView=schoolGifView;
        list=new ArrayList<>();
        rects=new ArrayList<>();
        uiPaint=new UIPaint(baseActivity);

        max = baseActivity.point.x/2;
        may = baseActivity.point.y/2;

        list.add(new BaseStopBitmap(baseActivity, R.drawable.jinbi01, new Point(max*2-300, may*2-100), 100, 100));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.jinbi02, new Point(max*2-300, may*2 ), 100, 100));

        list.add(new BaseStopBitmap(baseActivity, R.drawable.att_bg, new Point(80, may*2-100 ), 200, 100));
        list.add(new BaseStopBitmap(baseActivity, R.drawable.lv, new Point(120, may*2-200 ), 100, 100));



        for (BaseStopBitmap baseStopBitmap:list){
            rects.add(baseStopBitmap.rect);
        }



    }

    public void drawCanvas(Canvas canvas){


        if (list.size()<=0)return;






        for (BaseStopBitmap baseStopBitmap:list){
            baseStopBitmap.draws(canvas);
        }







        canvas.drawText(schoolGifView.money.stringA(),max*2-200,may*2-40,uiPaint.paint1());
        canvas.drawText(schoolGifView.money.stringB(),max*2-200,may*2+60,uiPaint.paint1());
        canvas.drawText(Int0000.get0000(schoolGifView.laserGif.obj.hit),120,may*2-30,uiPaint.paint2());
        canvas.drawText("DAMAGE",100,may*2+40,uiPaint.paint2());
        canvas.drawText(Int0000.get00(schoolGifView.gifPlay.obj.level),160,may*2-135,uiPaint.paint1());

    }
}

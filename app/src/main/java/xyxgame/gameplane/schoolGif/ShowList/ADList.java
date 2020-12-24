package xyxgame.gameplane.schoolGif.ShowList;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BitmapUtils;
import xyxgame.gameplane.R;
import xyxgame.gameplane.schoolGif.BaseGIf.BaseStopBitmap;
import xyxgame.gameplane.schoolGif.SchoolGifView;

public class ADList {
    BaseActivity baseActivity;SchoolGifView schoolGifView;
    private   Matrix matrix;
    private Bitmap bitmap;
    int  max,may;
    public BaseStopBitmap baseStopBitmap;
    public   Rect rect;


    public ADList(BaseActivity baseActivity, SchoolGifView schoolGifView) {
        this.baseActivity = baseActivity;
        this.schoolGifView = schoolGifView;
        max = baseActivity.point.x/2;
        may = baseActivity.point.y/2;

        matrix = new Matrix();
        bitmap = Bitmap.createBitmap(BitmapUtils
                .decodeSampledBitmapFromResource(
                        baseActivity.getResources(), R.drawable.pan_zheng,30,80)
        );


        baseStopBitmap = new BaseStopBitmap(baseActivity, R.drawable.pan_01, new Point(max * 2 - 190, 380), 130, 130);




        rect = new Rect(baseStopBitmap.rect);


    }

    int i=0;




    public void clear(){
        schoolGifView.showAD=false;
        baseStopBitmap.bitmap.recycle();
        bitmap.recycle();
    }


    public void drawCanvas(Canvas canvas){
        if (schoolGifView.showAD) {

            // Log.v("---showAD---","-----"+i);

            i += 5;
            if (i > 360) i = 0;

            matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() - 10);
            matrix.postTranslate(max * 2 - 140, 375);


            baseStopBitmap.draws(canvas);


            canvas.drawBitmap(bitmap, matrix, new Paint());


        }
    }


}

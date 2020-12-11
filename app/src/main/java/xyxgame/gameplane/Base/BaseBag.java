package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;

public class BaseBag {


    public Bitmap bitmap;
    BaseActivity activity;
    public BaseBag changWH(int width,int height){
        bitmap=Bitmap.createScaledBitmap(bitmap,width,height,false);
        return this;
    }

    public BaseBag(BaseActivity activity, int draw) {
        this.activity=activity;
        this.bitmap = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,100,100);
        //bitmap=Bitmap.createScaledBitmap(bitmap,100,100,false);
    }


}

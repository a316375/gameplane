package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class BaseBag {


    public Bitmap bitmap;
    public BaseActivity activity;


    public BaseBag changWH(int width,int height){
        bitmap=Bitmap.createScaledBitmap(bitmap,width,height,false);
        return this;
    }



    public BaseBag(BaseActivity activity, int draw) {

        this.activity=activity;
        changBitmap(draw);
      //  this.bitmap = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,100,100);
        //bitmap=Bitmap.createScaledBitmap(bitmap,100,100,false);


    }

    public void changBitmap(int draw){
        this.bitmap = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,100,100);
    }




}

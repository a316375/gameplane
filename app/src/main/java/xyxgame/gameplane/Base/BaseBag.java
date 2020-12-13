package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class BaseBag {


    public Bitmap bitmap;
    public BaseActivity activity;
    public ArrayList<Bitmap> bitmaplist;

    public BaseBag changWH(int width,int height){
        bitmap=Bitmap.createScaledBitmap(bitmap,width,height,false);
        return this;
    }

    private  int draw;

    public BaseBag(BaseActivity activity, int draw) {
        this.draw=draw;
        this.activity=activity;
        this.bitmap = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,100,100);
        //bitmap=Bitmap.createScaledBitmap(bitmap,100,100,false);
        creatEffcetList();

    }


    public BaseBag creatEffcetList(){
        bitmaplist =creatEffcetList(draw);
        return this;
    }







    protected ArrayList<Bitmap> creatEffcetList(int draw){

        bitmaplist = new ArrayList<>();

        Bitmap bt = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(), draw, 1000, 100);
        for (int i = 0; i < 10; i++) {
            Bitmap bt2 = Bitmap.createBitmap(bt, bt.getWidth() * i / 10, 0, bt.getWidth() / 10, bt.getHeight());
            // bt2=Bitmap.createScaledBitmap(bt2,1000,1000,false);
            bitmaplist.add(bt2);
        }

        return bitmaplist;

    }



}

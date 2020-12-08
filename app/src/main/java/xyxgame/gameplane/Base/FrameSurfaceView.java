package xyxgame.gameplane.Base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;

import java.util.ArrayList;

import java.util.Random;


import xyxgame.gameplane.GL.Effect;
import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;

public class FrameSurfaceView extends BaseSurfaceVIEW {

    Bitmap bitmap;

    ArrayList<Effect> effects;
    private final BitmapFactory.Options options;

    public ArrayList<Bitmap> getBitmaps() {
        return bitmaps;
    }

    private  ArrayList<Bitmap> bitmaps;

   private FPS fps;

    public FrameSurfaceView(Context context) {
        super(context);
        bitmap=decodeSampledBitmapFromResource(context.getResources(),R.drawable.bg4,1000,3000);

        effects =new ArrayList<>();
        fps=new FPS();

        options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize=2;

        bitmaps = new ArrayList<>();
        Bitmap bt=decodeSampledBitmapFromResource(context.getResources(),R.drawable.b_001,1000,100);
        for (int i = 0; i <10; i++) {
            Bitmap   bt2=Bitmap.createBitmap(bt,bt.getWidth()*i/10,0,bt.getWidth()/10,bt.getHeight());
            // bt2=Bitmap.createScaledBitmap(bt2,1000,1000,false);
            bitmaps.add(bt2);
        }


        for (int i = 0; i <1; i++) {
            Effect effect = new Effect( bitmaps, new Point(new Random().nextInt(1000), new Random().nextInt(1000)));

            effects.add(effect);
        }



    }

    int j;

    @Override
    protected void onFrameDrawFinish() {

    }

    @Override
    protected void onFrameDraw(Canvas canvas) {


        if (j<=1000)j++;
            if (effects.size()<=20&&j%5==0){
               Effect effect = new Effect( bitmaps, new Point(new Random().nextInt(1000), new Random().nextInt(1000)));
               effects.add(effect);
           }
        canvas.drawBitmap(bitmap,0,1,null);

        for (Effect effect:effects){
            effect.draw(canvas);
        }

        fps.draw(canvas);
    }





    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig=Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = true;
        //加载图片
        BitmapFactory.decodeResource(res,resId,options);
        //计算缩放比
        options.inSampleSize = calculateInSampleSize(options,reqHeight,reqWidth);
        //重新加载图片
        options.inJustDecodeBounds =false;
        return BitmapFactory.decodeResource(res,resId,options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if(height>reqHeight||width>reqWidth){
            int halfHeight = height/2;
            int halfWidth = width/2;
            //计算缩放比，是2的指数
            while((halfHeight/inSampleSize)>=reqHeight&&(halfWidth/inSampleSize)>=reqWidth){
                inSampleSize*=2;
            }
        }


        return inSampleSize;
    }


}

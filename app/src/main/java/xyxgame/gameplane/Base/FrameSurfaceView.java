package xyxgame.gameplane.Base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;

import java.util.Random;


import xyxgame.gameplane.GL.FPS;
import xyxgame.gameplane.R;

public class FrameSurfaceView extends BaseSurfaceVIEW {

    Bitmap bitmap;

    ArrayList<Effect> effects;


    public ArrayList<Bitmap> getBitmaps() {
        return bitmaps;
    }

    private  ArrayList<Bitmap> bitmaps;

   private FPS fps;

    public FrameSurfaceView(Context context, NUMManager numManager) {
        super(context,numManager);
        bitmap=BitmapUtils.decodeSampledBitmapFromResource(context.getResources(),R.drawable.bg4,numManager.scx,numManager.scy);



        effects =new ArrayList<>();
        fps=new FPS();

        bitmaps = new ArrayList<>();
        Bitmap bt=BitmapUtils.decodeSampledBitmapFromResource(context.getResources(),R.drawable.b_001,1000,100);
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

    @Override
    protected void onThreadDraw(Canvas canvas) {
        if (j<=1000)j++;
        if (effects.size()<=2&&j%5==0){
            Effect effect = new Effect( bitmaps, new Point(new Random().nextInt(1000), new Random().nextInt(1000)));
            effects.add(effect);
        }

        canvas.drawBitmap(bitmap,0,1,null);

        for (Effect effect:effects){
            effect.draw(canvas);
        }

        fps.draw(canvas);
    }

    int j;

    @Override
    protected void onFrameDrawFinish() {

    }




    protected void onFrameDraw( ) {



    }








}

package xyxgame.gameplane.GIf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.Base.BaseSurfaceVIEW;
import xyxgame.gameplane.R;

public class BaseGIF {

    public void setBitmaps(CopyOnWriteArrayList<Bitmap> bitmaps) {
        this.bitmaps = bitmaps;
    }

    public CopyOnWriteArrayList<Bitmap>  bitmaps;

    public BaseGIF(Activity mActivity,CopyOnWriteArrayList<Bitmap>  bitmaps,int x,int y,int time) {
        this.xX=x;
        this.xY=y;
        this.time=time;
        this. bitmaps =bitmaps;


    }

    private int j =0;private int i=0; int time;

    int xX,xY;




    public void draw(Canvas canvas){
        if (bitmaps.size()==0)return;
        j++;
         i=i%bitmaps.size();
        canvas.drawBitmap((Bitmap) bitmaps.get(i),xX,xY,null);
         if (j %time==0)i++;
         if (j >1000) j =0;

         xY+=2;


    }
}

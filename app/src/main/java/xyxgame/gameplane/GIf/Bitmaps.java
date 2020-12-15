package xyxgame.gameplane.GIf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import java.lang.reflect.Field;
import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.R;

public class Bitmaps {

    Activity activity;

    int width=100,height=100;
    public  CopyOnWriteArrayList<Bitmap> getxue(Activity activity){
        return getbitmaps(activity, R.drawable.gif_xue);
    }

    public  CopyOnWriteArrayList<Bitmap> getplay_bg(Activity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.play_bg);
    }

    public  CopyOnWriteArrayList<Bitmap> getniu(Activity activity){
        return getbitmaps(activity, R.drawable.gif_niu);
    }

    public  CopyOnWriteArrayList<Bitmap> getyu1(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu0);
    } public  CopyOnWriteArrayList<Bitmap> getyu2(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu1);
    } public  CopyOnWriteArrayList<Bitmap> getyu3(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu2);
    } public  CopyOnWriteArrayList<Bitmap> getyu4(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu3);
    } public  CopyOnWriteArrayList<Bitmap> getyu5(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu4);
    } public  CopyOnWriteArrayList<Bitmap> getyu6(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu5);
    } public  CopyOnWriteArrayList<Bitmap> getyu7(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu6);
    } public  CopyOnWriteArrayList<Bitmap> getyu8(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu7);
    } public  CopyOnWriteArrayList<Bitmap> getyu9(Activity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu8);
    }


    public  CopyOnWriteArrayList<Bitmap> getbitmaps(Activity activity,int draw){
        this.activity=activity;

        final CopyOnWriteArrayList<Bitmap> bitmaps=new CopyOnWriteArrayList<>();
         Glide.with(activity)
                .asGif()
                .load(draw).override(width,height).into(new CustomTarget<GifDrawable>(){
            @Override
            public void onResourceReady(@NonNull GifDrawable resource, @Nullable Transition<? super GifDrawable> transition) {
                try {

                    Object GifState = resource.getConstantState();
                    Field frameLoader = GifState.getClass().getDeclaredField("frameLoader");
                    frameLoader.setAccessible(true);
                    Object gifFrameLoader = frameLoader.get(GifState);

                    Field gifDecoder = gifFrameLoader.getClass().getDeclaredField("gifDecoder");
                    gifDecoder.setAccessible(true);
                    StandardGifDecoder standardGifDecoder = (StandardGifDecoder) gifDecoder.get(gifFrameLoader);
                    for (int i = 0; i < standardGifDecoder.getFrameCount(); i++) {
                        standardGifDecoder.advance();
                        bitmaps.add(standardGifDecoder.getNextFrame());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            @Override
            public void onLoadCleared(@Nullable Drawable placeholder) {

            }
        });
         return bitmaps;
    };


}

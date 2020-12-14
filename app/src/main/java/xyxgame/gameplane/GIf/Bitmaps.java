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

    public static CopyOnWriteArrayList<Bitmap> getxue(Activity activity){
        return getbitmaps(activity, R.drawable.gif_xue);
    }


    public static CopyOnWriteArrayList<Bitmap> getbitmaps(Activity activity,int draw){

        final CopyOnWriteArrayList<Bitmap> bitmaps=new CopyOnWriteArrayList<>();
         Glide.with(activity)
                .asGif()
                .load(draw).into(new CustomTarget<GifDrawable>(){
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

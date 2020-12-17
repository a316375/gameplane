package xyxgame.gameplane.GIf_v1;

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

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.R;

public class Bitmaps {

    BaseActivity activity;

    int width=100,height=100;
    public  CopyOnWriteArrayList<Bitmap> getxue(BaseActivity activity){
        return getbitmaps(activity, R.drawable.gif_xue);
    }

    public  CopyOnWriteArrayList<Bitmap> getxiong8Move(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.em_xiong_08move);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong8stop(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.em_xiong_08stop);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong8attker(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.em_xiong_08attker);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4Move(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.em_xiong_04move);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4stop(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.em_xiong_04stop);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4attker(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.em_xiong_04attker);
    }
    public  CopyOnWriteArrayList<Bitmap> getplay_bg(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.play_bg);
    } public  CopyOnWriteArrayList<Bitmap> getfb01(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb01);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb02(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb02);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb03(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb03);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb04(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb04);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb05(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb05);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb06(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb06);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb07(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb07);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb08(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb08);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb09(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb09);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb10(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb10);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb11(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb11);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb12(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.fb12);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser01(BaseActivity activity){
        width=20;height=100;
        return getbitmaps(activity, R.drawable.laser01);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser02(BaseActivity activity){
        width=20;height=100;
        return getbitmaps(activity, R.drawable.laser02);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser03(BaseActivity activity){
        width=20;height=100;
        return getbitmaps(activity, R.drawable.laser03);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser04(BaseActivity activity){
        width=20;height=100;
        return getbitmaps(activity, R.drawable.laser04);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser05(BaseActivity activity){
        width=20;height=100;
        return getbitmaps(activity, R.drawable.laser05);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser06(BaseActivity activity){
        width=50;height=50;
        return getbitmaps(activity, R.drawable.laser06);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser07(BaseActivity activity){
        width=50;height=50;
        return getbitmaps(activity, R.drawable.laser07);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser08(BaseActivity activity){
        width=100;height=100;
        return getbitmaps(activity, R.drawable.laser08);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser09(BaseActivity activity){
        width=50;height=50;
        return getbitmaps(activity, R.drawable.laser09);
    }


    public  CopyOnWriteArrayList<Bitmap> getniu(BaseActivity activity){
        return getbitmaps(activity, R.drawable.gif_niu);
    }

    public  CopyOnWriteArrayList<Bitmap> getyu1(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu0);
    } public  CopyOnWriteArrayList<Bitmap> getyu2(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu1);
    } public  CopyOnWriteArrayList<Bitmap> getyu3(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu2);
    } public  CopyOnWriteArrayList<Bitmap> getyu4(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu3);
    } public  CopyOnWriteArrayList<Bitmap> getyu5(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu4);
    } public  CopyOnWriteArrayList<Bitmap> getyu6(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu5);
    } public  CopyOnWriteArrayList<Bitmap> getyu7(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu6);
    } public  CopyOnWriteArrayList<Bitmap> getyu8(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu7);
    } public  CopyOnWriteArrayList<Bitmap> getyu9(BaseActivity activity){
        width=200;height=200;
        return getbitmaps(activity, R.drawable.gif_yu8);
    }


    public  CopyOnWriteArrayList<Bitmap> getbitmaps(BaseActivity activity,int draw){
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

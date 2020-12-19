package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Matrix;
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

public class GifAllBitmaps {

    public GifAllBitmaps(BaseActivity activity) {
        this.activity = activity;

    }

    BaseActivity activity;

     
    public  CopyOnWriteArrayList<Bitmap> getxue(int width,int height){
        
        return getbitmaps(width,height,activity, R.drawable.gif_xue);
    }

    public  CopyOnWriteArrayList<Bitmap> getPan(int width,int height){

        return getbitmaps( width, height,activity, R.drawable.pan);
    }

    public  CopyOnWriteArrayList<Bitmap> getxiong8Move(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_08move);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong8stop(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_08stop);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong8attker(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_08attker);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4Move(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_04move);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4stop(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_04stop);
    }
    public  CopyOnWriteArrayList<Bitmap> getxiong4attker(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.em_xiong_04attker);
    }
    public  CopyOnWriteArrayList<Bitmap> getplay_bg(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.play_bg);
    } public  CopyOnWriteArrayList<Bitmap> getfb01(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb01);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb02(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb02);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb03(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb03);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb04(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb04);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb05(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb05);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb06(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb06);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb07(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb07);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb08(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb08);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb09(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb09);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb10(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb10);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb11(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb11);
    }
    public  CopyOnWriteArrayList<Bitmap> getfb12(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.fb12);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser01(int width,int height){
        
        return getbitmaps( width, height,activity, R.drawable.laser01);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser02(int width,int height){
        
        return getbitmaps( width, height,activity, R.drawable.laser02);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser03(int width,int height){
        
        return getbitmaps( width, height,activity, R.drawable.laser03);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser04(int width,int height){
        
        return getbitmaps( width, height,activity, R.drawable.laser04);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser05(int width,int height){
        
        return getbitmaps( width, height,activity, R.drawable.laser05);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser06(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.laser06);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser07(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.laser07);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser08(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.laser08);
    }
    public  CopyOnWriteArrayList<Bitmap> getlaser09(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.laser09);
    }


    public  CopyOnWriteArrayList<Bitmap> getniu(int width,int height){
        return getbitmaps( width, height,activity, R.drawable.gif_niu);
    }

    public  CopyOnWriteArrayList<Bitmap> getyu1(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu0);
    } public  CopyOnWriteArrayList<Bitmap> getyu2(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu1);
    } public  CopyOnWriteArrayList<Bitmap> getyu3(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu2);
    } public  CopyOnWriteArrayList<Bitmap> getyu4(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu3);
    } public  CopyOnWriteArrayList<Bitmap> getyu5(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu4);
    } public  CopyOnWriteArrayList<Bitmap> getyu6(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu5);
    } public  CopyOnWriteArrayList<Bitmap> getyu7(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu6);
    } public  CopyOnWriteArrayList<Bitmap> getyu8(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu7);
    } public  CopyOnWriteArrayList<Bitmap> getyu9(int width,int height){
         
        return getbitmaps( width, height,activity, R.drawable.gif_yu8);
    }


    public  CopyOnWriteArrayList<Bitmap> getbitmaps(final int width, final int height, BaseActivity activity, int draw){


        final CopyOnWriteArrayList<Bitmap> bitmaps=new CopyOnWriteArrayList<>();
         Glide.with(activity)
                .asGif()
//                 .override(200,200)
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
                        Bitmap nextFrame = standardGifDecoder.getNextFrame();
//                        bitmaps.add(zoomImg(nextFrame,width,height));
                        bitmaps.add(Bitmap.createScaledBitmap(nextFrame,width,height,false));
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



    public  Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        Bitmap newbm = null;
        if (bm != null) {
            // 获得图片的宽高
            int width = bm.getWidth();
            int height = bm.getHeight();
            // 计算缩放比例
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;
            // 取得想要缩放的matrix参数
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            // 得到新的图片
            newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        }
        return newbm;
    }
}

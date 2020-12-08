package xyxgame.gameplane.Base;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class BitmapUtils {

    //高性能读取
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig=Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = true;
        //加载图片
        BitmapFactory.decodeResource(res,resId,options);
        //计算缩放比
        options.inSampleSize = calculateInSampleSize(options,reqHeight,reqWidth);
//        options.inSampleSize =3;
        //重新加载图片
        options.inJustDecodeBounds =false;
        return BitmapFactory.decodeResource(res,resId,options);
    }
     private static int calculateInSampleSize(BitmapFactory.Options options, int reqHeight, int reqWidth) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;//初始值为1
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




    public static Bitmap decodeBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight)
    {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置只加载宽高标志位
        options.inJustDecodeBounds = true;
        //加载原始图片宽高到Options中
        BitmapFactory.decodeResource(res, resId, options);
        //计算采样率，通过所需宽高和原始图片宽高
        options.inSampleSize = calculateSize(reqWidth, reqHeight, options);
        //还原并再次加载图片
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    //计算采样率
    private static int calculateSize(int reqWidth, int reqHeight, BitmapFactory.Options options)
    {
        //如果传入0参数，则将采样率设成1，即不压缩
        if (reqWidth == 0 || reqHeight == 0) {
            return 1;
        }

        int inSampleSize = 1;
        int width = options.outWidth;
        int height = options.outHeight;

        //当所需宽高比实际宽高小时才进行压缩
        if(reqWidth < width && reqHeight < height)
        {
            int halfWidth = width >>= 1;
            int halfHeight = height >>= 1;
            //保证压缩后的宽高不能小于所需宽高
            while(reqWidth <= halfWidth && reqHeight <= halfHeight)
            {
                inSampleSize <<= 1;
                halfWidth /= inSampleSize;
                halfHeight /= inSampleSize;
            }
        }
        return inSampleSize;
    }



















}

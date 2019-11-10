package xyxgame.gameplane.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import xyxgame.gameplane.R;

public class BG {
    Bitmap mBitmap;//


    public BG(Context context, int screenSizeX, int screenSizeY) {


        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg1);


        mBitmap = Bitmap.createScaledBitmap(mBitmap, screenSizeX, screenSizeY, false);
    }



    public Bitmap getmBitmap() {
        return mBitmap;
    }
}

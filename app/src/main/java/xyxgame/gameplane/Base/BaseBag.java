package xyxgame.gameplane.Base;

import android.app.Activity;
import android.graphics.Bitmap;

public class BaseBag {


    public Bitmap bitmap;

    public BaseBag(Activity activity, int draw) {
        this.bitmap = BitmapUtils.decodeSampledBitmapFromResource(activity.getResources(),draw,100,100);
    }
}

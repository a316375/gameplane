package xyxgame.gameplane.schoolGif.BaseGIf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;

import xyxgame.gameplane.Base.BaseActivity;
import xyxgame.gameplane.Base.BitmapUtils;


////***加载基础图片***///
public class BaseStopBitmap {
    BaseActivity baseActivity;
    Bitmap bitmap;
    public Rect rect;
    public int num;


    Point point;
    public BaseStopBitmap(BaseActivity baseActivity, int raw, Point point,int width,int height,int num) {
        this.num=num;
        this.baseActivity = baseActivity;
        this.point=point;
        bitmap= BitmapUtils.decodeSampledBitmapFromResource(baseActivity.getResources(),raw,width,height);
        this.rect=new Rect(point.x,point.y,point.x+width,point.y+height);
    }

    public void draws(Canvas canvas){

        if (bitmap==null)return;
        canvas.drawBitmap(bitmap,point.x,point.y,null);

    }
}

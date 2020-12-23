package xyxgame.gameplane.schoolGif.Tool;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import xyxgame.gameplane.Base.BaseActivity;

public class UIPaint {
    BaseActivity baseActivity;
    private Paint paint;

    public UIPaint(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        paint = new Paint();

        paint.setStyle(Paint.Style.FILL);  // 填充模式 - 所有
        paint.setStrokeWidth(10);
        paint.setTextSize(50);
      if (baseActivity!=null) paint.setTypeface(Typeface.createFromAsset(baseActivity.getAssets(),"xyx.ttf"));
    }

    public Paint paint1(){
        paint.setColor(Color.YELLOW);//设置画笔颜色
        return paint;
    }
    public Paint paint2(){
        paint.setColor(Color.RED);//设置画笔颜色
        return paint;
    }
}

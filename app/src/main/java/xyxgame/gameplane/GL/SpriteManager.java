package xyxgame.gameplane.GL;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import xyxgame.gameplane.spaceshooter.Laser;

public class SpriteManager {
    Bitmap bitmap;
    Point selfxy,cirxy;
    float angle=0;
    public Rect getRect() {
        return rect;
    }
     BTMAP bitmaps;int who;

    public Rect rect;
    public SpriteManager(BTMAP bitmaps,int who,Point selfxy,Point cirxy ) {
        this.bitmap = bitmaps.getBitmaps().get(who);
        this.selfxy=selfxy;
        this.cirxy=cirxy;

        this.bitmaps=bitmaps;
        this.who=who;

        radio= (int) Math.sqrt(Math.abs((selfxy.x - cirxy.x)* (selfxy.x - cirxy.x)+(selfxy.y - cirxy.y)* (selfxy.y - cirxy.y)));
        rect=new Rect();
    }

public void setWidthandHight(int newwidth,int newheight){
    // 获得图片的宽高
    int width = bitmap.getWidth();
    int height = bitmap.getHeight();
    // 计算缩放比例
    float scaleWidth = ((float) newwidth) / width;
    float scaleHeight = ((float) newheight) / height;
    // 取得想要缩放的matrix参数
    Matrix matrix = new Matrix();
    matrix.postScale(scaleWidth, scaleHeight);
    // 得到新的图片
    bitmap= Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
}


    int radio;


    public void UPXY(){
        angle=angle+0.2f;//每次旋转0.2f度数
        if (angle >= 360) angle = 0;

        selfxy.x = (int) (cirxy.x + radio * Math.sin(angle * Math.PI / 180));
        selfxy.y = (int) (cirxy.y - radio * Math.cos(angle * Math.PI / 180));//-是逆时针+是顺时针;
        rect.set(selfxy.x,selfxy.y,selfxy.x+bitmap.getWidth(),selfxy.y+bitmap.getHeight());
    }


    public void draw(Canvas canvas, Paint paint){


        if (!bitmap.isRecycled()){
            canvas.drawBitmap(bitmap,selfxy.x,selfxy.y,paint);
            UPXY();


        }

    }


    public void destory(ArrayList<Laser> lasers){
        if (!bitmap.isRecycled()){

        if (rect.left<0||rect.right<0)bitmap.recycle();


        if (lasers!=null&&!bitmap.isRecycled()){

            for (Iterator<Laser> it = lasers.iterator(); it.hasNext(); ) {
                Laser s = (Laser) it.next();
                if (Rect.intersects(s.getCollision(),getRect())){
                    if (new Random().nextInt(100)==8) { bitmap.recycle();}
                    it.remove();
                }
            }


        }
        }
    }

}

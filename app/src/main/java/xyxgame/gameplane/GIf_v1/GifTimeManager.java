package xyxgame.gameplane.GIf_v1;

import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/*在sufaceview调用的时候，记得要在生命周期调用一下starthandle stophandler 两方法否则会出错
*
* 负责产出，清理
*
* */
public class GifTimeManager {



    boolean isStart=true;
    CopyOnWriteArrayList<BaseGIFObject> gifAs;

    Handler handler=new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            if (!isStart){stopHandler();return;}

            gifAs.add(new E1(baseGIFObject.bitmaps,new Random().nextInt(1000),0,5));
            handler.postDelayed(runnable,3000);
        }
    };

    public void stopHandler(){
        isStart=false;
        if (handler!=null)handler=null;
    }
    public void startHandler(){
        if (handler==null){handler=new Handler();
        handler.postDelayed(runnable,300);}
        isStart=true;
    }



    BaseGIFObject baseGIFObject;
    public GifTimeManager(  BaseGIFObject baseGIFObject) {
        this.baseGIFObject = baseGIFObject;

        gifAs =new CopyOnWriteArrayList<>();
        handler.postDelayed(runnable,3000);

    }



    public void draw(Canvas canvas, Point point){


         clear_add(canvas,point,gifAs);

    }


    private void clear_add(Canvas canvas, Point point, CopyOnWriteArrayList<BaseGIFObject> gifs){




        Iterator<BaseGIFObject> remove = gifs.iterator();
        while (remove.hasNext()){
            BaseGIFObject next = remove.next();
            if (next.xY>point.y||next.xY<0||next.xX>point.x||next.xX<0)
            {
                next.setBitmaps(null);
                gifs.remove(next);

            }
        }


        Iterator<BaseGIFObject> iterator = gifs.iterator();
        while (iterator.hasNext()){
            iterator.next().draw(canvas);
        }


    }







}

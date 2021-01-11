package xyxgame.gameplane.schoolGif.Effect.die_shui;

import android.graphics.Bitmap;

import java.util.concurrent.CopyOnWriteArrayList;

import xyxgame.gameplane.schoolGif.BaseGIf.BaseGifBag;
import xyxgame.gameplane.schoolGif.BaseGIf.GifObj;

public class DieShuiBags extends BaseGifBag {




    int speed=10;


    public DieShuiBags(GifObj obj, CopyOnWriteArrayList<Bitmap> list) {
        super(obj, list);





    }
    int num=0;
    public DieShuiBags withPathNum(int num){
        this.num=num;
        return this;
    }




    @Override
    public void drawpath() {


       if (num==0){y+=(int) ( speed* Math.cos(Math.toRadians(22.5f)));

       x+= (int) ( speed* Math.sin(Math.toRadians(22.5f)));
       }
        if (num==1){y+=(int) ( speed* Math.cos(Math.toRadians(67.5f)));

            x+= (int) ( speed* Math.sin(Math.toRadians(67.5f)));
        }

        if (num==2){y+=(int) ( speed* Math.cos(Math.toRadians(22.5f)));
//       x= (int) (px+ Math.sin(30 * Math.PI / 180));
            x-= (int) ( speed* Math.sin(Math.toRadians(22.5f)));
        }
        if (num==3){y+=(int) ( speed* Math.cos(Math.toRadians(67.5f)));

            x-= (int) ( speed* Math.sin(Math.toRadians(67.5f)));
        }

        if (num==4){y-=(int) ( speed* Math.cos(Math.toRadians(-22.5f)));

            x+= (int) ( speed* Math.sin(Math.toRadians(-22.5f)));
        }
        if (num==5){y-=(int) ( speed* Math.cos(Math.toRadians(-67.5f)));

            x+= (int) ( speed* Math.sin(Math.toRadians(-67.5f)));
        }

        if (num==6){y-=(int) ( speed* Math.cos(Math.toRadians(-22.5f)));

            x-= (int) ( speed* Math.sin(Math.toRadians(-22.5f)));
        }
        if (num==7){y-=(int) ( speed* Math.cos(Math.toRadians(-67.5f)));

            x-= (int) ( speed* Math.sin(Math.toRadians(-67.5f)));
        }

        time++;
        if (time>=50000)time=maxtime;

    }

    public int time=0,maxtime=20;
    @Override
    public void setRect(int x, int y, int w, int h) {
        if (time>maxtime)  rect.set(x+this.w/5, y, w-this.w/5, h-this.h/5);
        else  rect.set(-100,-100,-100,-100);
    }
}

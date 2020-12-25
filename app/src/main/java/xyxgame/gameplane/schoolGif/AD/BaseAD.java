package xyxgame.gameplane.schoolGif.AD;

import xyxgame.gameplane.Base.BaseSurfaceVIEW;

public class BaseAD implements AD {
    BaseSurfaceVIEW baseSurfaceVIEW;
    public BaseAD(BaseSurfaceVIEW baseSurfaceVIEW) {
        this.baseSurfaceVIEW=baseSurfaceVIEW;
    }

    @Override
    public void coming() {
        baseSurfaceVIEW.showAD=true;
    }

    @Override
    public void reload() {
        baseSurfaceVIEW.showAD=true;
    }

    @Override
    public void exit() {
        baseSurfaceVIEW.showAD=false;
        baseSurfaceVIEW.startT();
        baseSurfaceVIEW.startDrawThread();
    }

    @Override
    public void FinishOK() {
//        schoolGifView.money.all+=10000;
//        schoolGifView.adList.clear();
        baseSurfaceVIEW.ADFinish();
    }
}

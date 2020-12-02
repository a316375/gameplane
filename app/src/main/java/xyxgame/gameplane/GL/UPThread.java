package xyxgame.gameplane.GL;

public class UPThread extends Thread{
    Shot shot;
    boolean mIsRun;

    public UPThread(Shot shot, boolean mIsRun) {
        this.shot = shot;
        this.mIsRun = mIsRun;
    }

    @Override
    public void run() {
        while (true){
          if (mIsRun)shot.upXY();
        }

    }
}

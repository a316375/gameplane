package xyxgame.gameplane.GL;

import java.util.concurrent.atomic.AtomicInteger;

public class UPThread extends Thread{
      private AtomicInteger mCounter ;//控制

    private boolean isGame;

    public UPThread(boolean isGame) {
        this.isGame = isGame;
        mCounter=new AtomicInteger(0);
    }

    @Override
    public void run() {
        while (isGame) {

            try {
                 sleep(600);
                mCounter.getAndIncrement();

                if (mCounter.get() > 600) mCounter.set(0);
                System.out.println(this.getName() +"---"+ mCounter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            }
        }



    public AtomicInteger getmCounter() {
        return this.mCounter;
    }
}

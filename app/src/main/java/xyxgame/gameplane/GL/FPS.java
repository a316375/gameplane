package xyxgame.gameplane.GL;

import java.util.LinkedList;

public class FPS {
    LinkedList<Long> times = new LinkedList<Long>(){{
        add(System.nanoTime());
    }};
    private final int MAX_SIZE = 100;
    private final double NANOS = 1000000000.0;

    /** Calculates and returns frames per second */
    public double fps() {
        long lastTime = System.nanoTime();
        double difference = (lastTime - times.getFirst()) / NANOS;
        times.addLast(lastTime);
        int size = times.size();
        if (size > MAX_SIZE) {
            times.removeFirst();
        }
        return difference > 0 ? times.size() / difference : 0.0;
    }
}

package rx;

public abstract class Scheduler {

    public static abstract class Worker implements Subscription {
    }

    public abstract Worker createWorker();

    public long now() {
        return System.currentTimeMillis();
    }
}

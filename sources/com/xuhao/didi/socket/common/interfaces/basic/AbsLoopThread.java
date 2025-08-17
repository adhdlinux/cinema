package com.xuhao.didi.socket.common.interfaces.basic;

import com.xuhao.didi.core.utils.SLog;

public abstract class AbsLoopThread implements Runnable {
    private volatile Exception ioException;
    private volatile boolean isShutdown;
    private volatile boolean isStop;
    private volatile long loopTimes;
    public volatile Thread thread;
    protected volatile String threadName;

    public AbsLoopThread() {
        this.thread = null;
        this.threadName = "";
        this.isStop = false;
        this.isShutdown = true;
        this.ioException = null;
        this.loopTimes = 0;
        this.isStop = true;
        this.threadName = getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public void beforeLoop() throws Exception {
    }

    public long getLoopTimes() {
        return this.loopTimes;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public boolean isShutdown() {
        return this.isShutdown;
    }

    /* access modifiers changed from: protected */
    public abstract void loopFinish(Exception exc);

    public final void run() {
        StringBuilder sb;
        try {
            this.isShutdown = false;
            beforeLoop();
            while (!this.isStop) {
                runInLoopThread();
                this.loopTimes++;
            }
            this.isShutdown = true;
            loopFinish(this.ioException);
            this.ioException = null;
            sb = new StringBuilder();
        } catch (Exception e2) {
            if (this.ioException == null) {
                this.ioException = e2;
            }
            this.isShutdown = true;
            loopFinish(this.ioException);
            this.ioException = null;
            sb = new StringBuilder();
        } catch (Throwable th) {
            this.isShutdown = true;
            loopFinish(this.ioException);
            this.ioException = null;
            SLog.w(this.threadName + " is shutting down");
            throw th;
        }
        sb.append(this.threadName);
        sb.append(" is shutting down");
        SLog.w(sb.toString());
    }

    /* access modifiers changed from: protected */
    public abstract void runInLoopThread() throws Exception;

    public synchronized void shutdown() {
        if (this.thread != null && !this.isStop) {
            this.isStop = true;
            this.thread.interrupt();
            this.thread = null;
        }
    }

    public synchronized void start() {
        if (this.isStop) {
            this.thread = new Thread(this, this.threadName);
            this.isStop = false;
            this.loopTimes = 0;
            this.thread.start();
            SLog.w(this.threadName + " is starting");
        }
    }

    public synchronized void shutdown(Exception exc) {
        this.ioException = exc;
        shutdown();
    }

    public AbsLoopThread(String str) {
        this.thread = null;
        this.threadName = "";
        this.isStop = false;
        this.isShutdown = true;
        this.ioException = null;
        this.loopTimes = 0;
        this.isStop = true;
        this.threadName = str;
    }
}

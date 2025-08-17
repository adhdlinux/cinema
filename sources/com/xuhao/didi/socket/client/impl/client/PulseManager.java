package com.xuhao.didi.socket.client.impl.client;

import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.socket.client.impl.exceptions.DogDeadException;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.bean.IPulse;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.common.interfaces.basic.AbsLoopThread;
import java.util.concurrent.atomic.AtomicInteger;

public class PulseManager implements IPulse {
    /* access modifiers changed from: private */
    public volatile boolean isDead = false;
    /* access modifiers changed from: private */
    public volatile long mCurrentFrequency;
    private volatile OkSocketOptions.IOThreadMode mCurrentThreadMode;
    /* access modifiers changed from: private */
    public volatile AtomicInteger mLoseTimes = new AtomicInteger(-1);
    /* access modifiers changed from: private */
    public volatile IConnectionManager mManager;
    /* access modifiers changed from: private */
    public volatile OkSocketOptions mOkOptions;
    private PulseThread mPulseThread = new PulseThread();
    /* access modifiers changed from: private */
    public IPulseSendable mSendable;

    private class PulseThread extends AbsLoopThread {
        private PulseThread() {
        }

        /* access modifiers changed from: protected */
        public void loopFinish(Exception exc) {
        }

        /* access modifiers changed from: protected */
        public void runInLoopThread() throws Exception {
            if (PulseManager.this.isDead) {
                shutdown();
                return;
            }
            if (!(PulseManager.this.mManager == null || PulseManager.this.mSendable == null)) {
                if (PulseManager.this.mOkOptions.getPulseFeedLoseTimes() == -1 || PulseManager.this.mLoseTimes.incrementAndGet() < PulseManager.this.mOkOptions.getPulseFeedLoseTimes()) {
                    PulseManager.this.mManager.send(PulseManager.this.mSendable);
                } else {
                    PulseManager.this.mManager.disconnect(new DogDeadException("you need feed dog on time,otherwise he will die"));
                }
            }
            Thread.sleep(PulseManager.this.mCurrentFrequency);
        }
    }

    PulseManager(IConnectionManager iConnectionManager, OkSocketOptions okSocketOptions) {
        this.mManager = iConnectionManager;
        this.mOkOptions = okSocketOptions;
        this.mCurrentThreadMode = this.mOkOptions.getIOThreadMode();
    }

    private void privateDead() {
        PulseThread pulseThread = this.mPulseThread;
        if (pulseThread != null) {
            pulseThread.shutdown();
        }
    }

    private synchronized void updateFrequency() {
        if (this.mCurrentThreadMode != OkSocketOptions.IOThreadMode.SIMPLEX) {
            this.mCurrentFrequency = this.mOkOptions.getPulseFrequency();
            long j2 = 1000;
            if (this.mCurrentFrequency >= 1000) {
                j2 = this.mCurrentFrequency;
            }
            this.mCurrentFrequency = j2;
        } else {
            privateDead();
        }
    }

    public synchronized void dead() {
        this.mLoseTimes.set(0);
        this.isDead = true;
        privateDead();
    }

    public synchronized void feed() {
        this.mLoseTimes.set(-1);
    }

    public int getLoseTimes() {
        return this.mLoseTimes.get();
    }

    public IPulseSendable getPulseSendable() {
        return this.mSendable;
    }

    public synchronized void pulse() {
        privateDead();
        updateFrequency();
        if (this.mCurrentThreadMode != OkSocketOptions.IOThreadMode.SIMPLEX && this.mPulseThread.isShutdown()) {
            this.mPulseThread.start();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void setOkOptions(OkSocketOptions okSocketOptions) {
        this.mOkOptions = okSocketOptions;
        this.mCurrentThreadMode = this.mOkOptions.getIOThreadMode();
        updateFrequency();
    }

    public synchronized IPulse setPulseSendable(IPulseSendable iPulseSendable) {
        if (iPulseSendable != null) {
            this.mSendable = iPulseSendable;
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void trigger() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDead     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.xuhao.didi.socket.client.sdk.client.OkSocketOptions$IOThreadMode r0 = r2.mCurrentThreadMode     // Catch:{ all -> 0x001e }
            com.xuhao.didi.socket.client.sdk.client.OkSocketOptions$IOThreadMode r1 = com.xuhao.didi.socket.client.sdk.client.OkSocketOptions.IOThreadMode.SIMPLEX     // Catch:{ all -> 0x001e }
            if (r0 == r1) goto L_0x001c
            com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager r0 = r2.mManager     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001c
            com.xuhao.didi.core.iocore.interfaces.IPulseSendable r0 = r2.mSendable     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001c
            com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager r0 = r2.mManager     // Catch:{ all -> 0x001e }
            com.xuhao.didi.core.iocore.interfaces.IPulseSendable r1 = r2.mSendable     // Catch:{ all -> 0x001e }
            r0.send(r1)     // Catch:{ all -> 0x001e }
        L_0x001c:
            monitor-exit(r2)
            return
        L_0x001e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xuhao.didi.socket.client.impl.client.PulseManager.trigger():void");
    }
}

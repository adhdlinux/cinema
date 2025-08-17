package com.startapp;

import android.os.HandlerThread;

public class xa extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    public final Object f36929a = new Object();

    public xa(String str) {
        super(str);
    }

    public void onLooperPrepared() {
        synchronized (this.f36929a) {
            this.f36929a.notifyAll();
        }
    }

    public void start() {
        synchronized (this.f36929a) {
            super.start();
            try {
                this.f36929a.wait();
            } catch (InterruptedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}

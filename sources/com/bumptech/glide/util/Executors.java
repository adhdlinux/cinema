package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f17142a = new Executor() {

        /* renamed from: b  reason: collision with root package name */
        private final Handler f17144b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f17144b.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f17143b = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };

    private Executors() {
    }

    public static Executor a() {
        return f17143b;
    }

    public static Executor b() {
        return f17142a;
    }
}

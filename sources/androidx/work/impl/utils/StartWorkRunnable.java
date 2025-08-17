package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;

public class StartWorkRunnable implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private WorkManagerImpl f12597b;

    /* renamed from: c  reason: collision with root package name */
    private String f12598c;

    /* renamed from: d  reason: collision with root package name */
    private WorkerParameters.RuntimeExtras f12599d;

    public StartWorkRunnable(WorkManagerImpl workManagerImpl, String str, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f12597b = workManagerImpl;
        this.f12598c = str;
        this.f12599d = runtimeExtras;
    }

    public void run() {
        this.f12597b.m().k(this.f12598c, this.f12599d);
    }
}

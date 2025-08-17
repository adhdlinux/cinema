package com.google.ar.core;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

final class ae implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f30261b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ af f30262c;

    ae(af afVar, AtomicBoolean atomicBoolean) {
        this.f30262c = afVar;
        this.f30261b = atomicBoolean;
    }

    public final void run() {
        if (!this.f30261b.getAndSet(true)) {
            Log.w("ARCore-InstallService", "requestInstall timed out, launching fullscreen.");
            af afVar = this.f30262c;
            afVar.f30265d.i(afVar.f30263b, afVar.f30264c);
        }
    }
}

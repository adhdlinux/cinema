package com.google.ar.core;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

final class af implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Activity f30263b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ v f30264c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ x f30265d;

    af(x xVar, Activity activity, v vVar) {
        this.f30265d = xVar;
        this.f30263b = activity;
        this.f30264c = vVar;
    }

    public final void run() {
        try {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.f30265d.f().d(this.f30263b.getApplicationInfo().packageName, Collections.singletonList(x.k()), new Bundle(), new ad(this, atomicBoolean));
            new Handler().postDelayed(new ae(this, atomicBoolean), 3000);
        } catch (RemoteException e2) {
            Log.w("ARCore-InstallService", "requestInstall threw, launching fullscreen.", e2);
            this.f30265d.i(this.f30263b, this.f30264c);
        }
    }
}

package com.google.ar.core;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.ArCoreApk;

final class aa implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f30252b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ h f30253c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ x f30254d;

    aa(x xVar, Context context, h hVar) {
        this.f30254d = xVar;
        this.f30252b = context;
        this.f30253c = hVar;
    }

    public final void run() {
        try {
            this.f30254d.f().e(this.f30252b.getApplicationInfo().packageName, x.k(), new z(this));
        } catch (RemoteException e2) {
            Log.e("ARCore-InstallService", "requestInfo threw", e2);
            this.f30253c.a(ArCoreApk.Availability.UNKNOWN_ERROR);
        }
    }
}

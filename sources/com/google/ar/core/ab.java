package com.google.ar.core;

import android.content.pm.PackageInstaller;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

final class ab extends PackageInstaller.SessionCallback {

    /* renamed from: a  reason: collision with root package name */
    final Map f30255a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ v f30256b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ x f30257c;

    ab(x xVar, v vVar) {
        this.f30257c = xVar;
        this.f30256b = vVar;
    }

    public final void onActiveChanged(int i2, boolean z2) {
    }

    public final void onBadgingChanged(int i2) {
    }

    public final void onCreated(int i2) {
        this.f30255a.put(Integer.valueOf(i2), this.f30257c.g().getSessionInfo(i2));
    }

    public final void onFinished(int i2, boolean z2) {
        PackageInstaller.SessionInfo sessionInfo = (PackageInstaller.SessionInfo) this.f30255a.remove(Integer.valueOf(i2));
        if (sessionInfo != null && "com.google.ar.core".equals(sessionInfo.getAppPackageName())) {
            Log.i("ARCore-InstallService", "Detected ARCore install completion");
            this.f30256b.a(w.COMPLETED);
        }
    }

    public final void onProgressChanged(int i2, float f2) {
    }
}

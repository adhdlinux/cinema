package com.google.ar.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class y implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f30374a;

    y(x xVar) {
        this.f30374a = xVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f30374a.d(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f30374a.e();
    }
}

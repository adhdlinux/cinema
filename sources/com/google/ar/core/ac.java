package com.google.ar.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class ac extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f30258a;

    ac(v vVar) {
        this.f30258a = vVar;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if ("com.google.android.play.core.install.ACTION_INSTALL_STATUS".equals(action) && extras != null && extras.containsKey("install.status")) {
            int i2 = extras.getInt("install.status");
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.f30258a.a(w.ACCEPTED);
            } else if (i2 == 4) {
                this.f30258a.a(w.COMPLETED);
            } else if (i2 == 6) {
                this.f30258a.a(w.CANCELLED);
            }
        }
    }
}

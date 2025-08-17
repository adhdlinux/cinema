package com.google.android.gms.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzar extends BroadcastReceiver {
    private zzar() {
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT".equals(intent.getAction())) {
            CastRemoteDisplayLocalService.stopService();
        } else if ("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED".equals(intent.getAction())) {
            CastRemoteDisplayLocalService.zzw(false);
        }
    }

    /* synthetic */ zzar(zzaq zzaq) {
    }
}

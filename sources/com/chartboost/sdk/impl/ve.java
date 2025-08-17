package com.chartboost.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public abstract class ve {

    /* renamed from: a  reason: collision with root package name */
    public static c9 f18879a = c9.UNKNOWN;

    public class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            c9 c9Var;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    c9Var = c9.NOT_DETECTED;
                } else if (intExtra == 1) {
                    c9Var = c9.UNKNOWN;
                } else {
                    return;
                }
                c9 unused = ve.f18879a = c9Var;
            }
        }
    }

    public static c9 a() {
        return vd.a() != k4.CTV ? c9.UNKNOWN : f18879a;
    }

    public static void a(Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}

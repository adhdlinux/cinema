package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

public final class zzav {
    public static void zza(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }
}

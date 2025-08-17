package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzcd implements Callable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzcd(Context context, Context context2) {
        this.zza = context;
        this.zzb = context2;
    }

    public final Object call() {
        SharedPreferences sharedPreferences;
        Context context = this.zza;
        Context context2 = this.zzb;
        boolean z2 = false;
        if (context != null) {
            zze.zza("Attempting to read user agent from Google Play Services.");
            sharedPreferences = context.getSharedPreferences("admob_user_agent", 0);
        } else {
            zze.zza("Attempting to read user agent from local cache.");
            sharedPreferences = context2.getSharedPreferences("admob_user_agent", 0);
            z2 = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zze.zza("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(context2);
            if (z2) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zze.zza("Persisting user agent.");
            }
        }
        return string;
    }
}

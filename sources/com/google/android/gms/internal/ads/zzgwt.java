package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

public final class zzgwt extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzgwt(zzbcn zzbcn) {
        this.zza = new WeakReference(zzbcn);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbcn zzbcn = (zzbcn) this.zza.get();
        if (zzbcn != null) {
            zzbcn.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbcn zzbcn = (zzbcn) this.zza.get();
        if (zzbcn != null) {
            zzbcn.zzd();
        }
    }
}

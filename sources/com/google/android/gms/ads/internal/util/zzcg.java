package com.google.android.gms.ads.internal.util;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzcg {
    private final BroadcastReceiver zza = new zzcf(this);
    private final Map zzb = new WeakHashMap();
    private boolean zzc = false;
    private boolean zzd;
    private Context zze;

    /* access modifiers changed from: private */
    public final synchronized void zze(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.zzb.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                arrayList.add((BroadcastReceiver) entry.getKey());
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((BroadcastReceiver) arrayList.get(i2)).onReceive(context, intent);
        }
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final synchronized void zzb(Context context) {
        if (!this.zzc) {
            Context applicationContext = context.getApplicationContext();
            this.zze = applicationContext;
            if (applicationContext == null) {
                this.zze = context;
            }
            zzbbm.zza(this.zze);
            this.zzd = ((Boolean) zzba.zzc().zzb(zzbbm.zzdz)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() || Build.VERSION.SDK_INT < 33) {
                this.zze.registerReceiver(this.zza, intentFilter);
            } else {
                Intent unused = this.zze.registerReceiver(this.zza, intentFilter, 4);
            }
            this.zzc = true;
        }
    }

    @SuppressLint({"UnprotectedReceiver"})
    public final synchronized void zzc(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzd) {
            this.zzb.put(broadcastReceiver, intentFilter);
            return;
        }
        zzbbm.zza(context);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjA)).booleanValue() || Build.VERSION.SDK_INT < 33) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            Intent unused = context.registerReceiver(broadcastReceiver, intentFilter, 4);
        }
    }

    public final synchronized void zzd(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzd) {
            this.zzb.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}

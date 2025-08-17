package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;

public final /* synthetic */ class zzbq implements Runnable {
    public final /* synthetic */ zzbs zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzbq(zzbs zzbs, String str, String str2) {
        this.zza = zzbs;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        Cast.MessageReceivedCallback messageReceivedCallback;
        zzbs zzbs = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        synchronized (zzbs.zza.zze) {
            messageReceivedCallback = (Cast.MessageReceivedCallback) zzbs.zza.zze.get(str);
        }
        if (messageReceivedCallback != null) {
            messageReceivedCallback.onMessageReceived(zzbs.zza.zzw, str, str2);
            return;
        }
        zzbt.zzg.d("Discarded message for unknown namespace '%s'", str);
    }
}

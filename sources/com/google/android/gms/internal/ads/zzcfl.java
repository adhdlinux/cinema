package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;

public final class zzcfl {
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcez] */
    public static final zzcez zza(Context context, zzcgo zzcgo, String str, boolean z2, boolean z3, zzaqs zzaqs, zzbco zzbco, zzbzx zzbzx, zzbce zzbce, zzl zzl, zza zza, zzawz zzawz, zzezn zzezn, zzezq zzezq, zzebl zzebl) throws zzcfk {
        StrictMode.ThreadPolicy threadPolicy;
        zzbbm.zza(context);
        try {
            zzcfh zzcfh = new zzcfh(context, zzcgo, str, z2, z3, zzaqs, zzbco, zzbzx, (zzbce) null, zzl, zza, zzawz, zzezn, zzezq, zzebl);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzcfh.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzcfk("Webview initialization failed.", th);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzt;
import java.lang.ref.WeakReference;

public final class zzcgx {
    private final zzbzx zza;
    private final Context zzb;
    private final WeakReference zzc;

    /* synthetic */ zzcgx(zzcgv zzcgv, zzcgw zzcgw) {
        this.zza = zzcgv.zza;
        this.zzb = zzcgv.zzb;
        this.zzc = zzcgv.zzc;
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzb;
    }

    public final zzaqs zzb() {
        return new zzaqs(new zzi(this.zzb, this.zza));
    }

    /* access modifiers changed from: package-private */
    public final zzbdy zzc() {
        return new zzbdy(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final zzbzx zzd() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zze() {
        return zzt.zzp().zzc(this.zzb, this.zza.zza);
    }

    /* access modifiers changed from: package-private */
    public final WeakReference zzf() {
        return this.zzc;
    }
}

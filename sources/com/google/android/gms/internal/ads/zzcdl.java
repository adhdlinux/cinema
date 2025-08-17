package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

public abstract class zzcdl implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzcdl(zzcca zzcca) {
        Context context = zzcca.getContext();
        this.zza = context;
        this.zzb = zzt.zzp().zzc(context, zzcca.zzn().zza);
        this.zzc = new WeakReference(zzcca);
    }

    static /* bridge */ /* synthetic */ void zze(zzcdl zzcdl, String str, Map map) {
        zzcca zzcca = (zzcca) zzcdl.zzc.get();
        if (zzcca != null) {
            zzcca.zzd("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract void zzf();

    public final void zzg(String str, String str2, String str3, String str4) {
        zzbzk.zza.post(new zzcdk(this, str, str2, str3, str4));
    }

    /* access modifiers changed from: protected */
    public final void zzh(String str, String str2, int i2) {
        zzbzk.zza.post(new zzcdi(this, str, str2, i2));
    }

    public final void zzj(String str, String str2, long j2) {
        zzbzk.zza.post(new zzcdj(this, str, str2, j2));
    }

    public final void zzn(String str, String str2, int i2, int i3, long j2, long j3, boolean z2, int i4, int i5) {
        zzbzk.zza.post(new zzcdh(this, str, str2, i2, i3, j2, j3, z2, i4, i5));
    }

    public final void zzo(String str, String str2, long j2, long j3, boolean z2, long j4, long j5, long j6, int i2, int i3) {
        Handler handler = zzbzk.zza;
        zzcdg zzcdg = r0;
        zzcdg zzcdg2 = new zzcdg(this, str, str2, j2, j3, j4, j5, j6, z2, i2, i3);
        handler.post(zzcdg);
    }

    /* access modifiers changed from: protected */
    public void zzp(int i2) {
    }

    /* access modifiers changed from: protected */
    public void zzq(int i2) {
    }

    /* access modifiers changed from: protected */
    public void zzr(int i2) {
    }

    /* access modifiers changed from: protected */
    public void zzs(int i2) {
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzcdd zzcdd) {
        return zzt(str);
    }
}

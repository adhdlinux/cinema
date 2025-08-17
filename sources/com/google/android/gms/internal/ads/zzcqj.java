package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcqj extends zzcpb {
    private final zzbgi zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzcqj(zzcrc zzcrc, zzbgi zzbgi, Runnable runnable, Executor executor) {
        super(zzcrc);
        this.zzc = zzbgi;
        this.zzd = runnable;
        this.zze = executor;
    }

    static /* synthetic */ void zzi(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final int zza() {
        return 0;
    }

    public final View zzc() {
        return null;
    }

    public final zzdq zzd() {
        return null;
    }

    public final zzezo zze() {
        return null;
    }

    public final zzezo zzf() {
        return null;
    }

    public final void zzg() {
    }

    public final void zzh(ViewGroup viewGroup, zzq zzq) {
    }

    public final void zzj() {
        this.zze.execute(new zzcqi(this, new zzcqh(new AtomicReference(this.zzd))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Runnable runnable) {
        try {
            if (!this.zzc.zzb(ObjectWrapper.wrap(runnable))) {
                zzi(((zzcqh) runnable).zza);
            }
        } catch (RemoteException unused) {
            zzi(((zzcqh) runnable).zza);
        }
    }
}

package com.google.android.gms.internal.ads;

final class zzfxa extends zzfwl {
    final /* synthetic */ zzfxc zza;
    private final zzfvi zzb;

    zzfxa(zzfxc zzfxc, zzfvi zzfvi) {
        this.zza = zzfxc;
        this.zzb = zzfvi;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzfwm zza2 = this.zzb.zza();
        zzfph.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzb);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zza.zze(th);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzt((zzfwm) obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zza.isDone();
    }
}

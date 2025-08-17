package com.google.android.gms.cast.internal;

public class zzp {
    protected final Logger zza = new Logger("MediaControlChannel", (String) null);
    private final String zzb;
    private zzar zzc;

    protected zzp(String str, String str2, String str3) {
        CastUtils.throwIfInvalidNamespace(str);
        this.zzb = str;
    }

    /* access modifiers changed from: protected */
    public final long zzd() {
        zzar zzar = this.zzc;
        if (zzar != null) {
            return zzar.zza();
        }
        this.zza.e("Attempt to generate requestId without a sink", new Object[0]);
        return 0;
    }

    public final String zze() {
        return this.zzb;
    }

    public void zzf() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzg(String str, long j2, String str2) throws IllegalStateException {
        zzar zzar = this.zzc;
        if (zzar == null) {
            this.zza.e("Attempt to send text message without a sink", new Object[0]);
        } else {
            zzar.zzb(this.zzb, str, j2, (String) null);
        }
    }

    public final void zzh(zzar zzar) {
        this.zzc = zzar;
        if (zzar == null) {
            zzf();
        }
    }
}

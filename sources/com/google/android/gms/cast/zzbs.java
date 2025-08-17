package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzab;
import com.google.android.gms.cast.internal.zzah;
import com.google.android.gms.cast.internal.zzq;
import com.google.android.gms.common.api.Status;

final class zzbs extends zzah {
    final /* synthetic */ zzbt zza;

    zzbs(zzbt zzbt) {
        this.zza = zzbt;
    }

    public final void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z2) {
        this.zza.zzp = applicationMetadata;
        this.zza.zzq = str;
        zzbt.zzD(this.zza, new zzq(new Status(0), applicationMetadata, str, str2, z2));
    }

    public final void zzc(int i2) {
        this.zza.zzU(i2);
    }

    public final void zzd(int i2) {
        zzbt.zzF(this.zza, i2);
        zzbt zzbt = this.zza;
        if (zzbt.zzx != null) {
            zzbt.zzo(zzbt).post(new zzbm(this, i2));
        }
    }

    public final void zze(int i2) {
        zzbt.zzF(this.zza, i2);
    }

    public final void zzf(zza zza2) {
        zzbt.zzo(this.zza).post(new zzbl(this, zza2));
    }

    public final void zzg(int i2) {
        zzbt.zzF(this.zza, i2);
    }

    public final void zzh(String str, byte[] bArr) {
        zzbt.zzg.d("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
    }

    public final void zzi(int i2) {
        zzbt.zzo(this.zza).post(new zzbr(this, i2));
    }

    public final void zzj(zzab zzab) {
        zzbt.zzo(this.zza).post(new zzbn(this, zzab));
    }

    public final void zzk(int i2) {
        zzbt.zzo(this.zza).post(new zzbo(this, i2));
    }

    public final void zzl(String str, long j2) {
        zzbt.zzE(this.zza, j2, 0);
    }

    public final void zzm(String str, long j2, int i2) {
        zzbt.zzE(this.zza, j2, i2);
    }

    public final void zzn(String str, double d2, boolean z2) {
        zzbt.zzg.d("Deprecated callback: \"onStatusReceived\"", new Object[0]);
    }

    public final void zzo(int i2) {
        zzbt.zzo(this.zza).post(new zzbp(this, i2));
    }

    public final void zzp(String str, String str2) {
        zzbt.zzg.d("Receive (type=text, ns=%s) %s", str, str2);
        zzbt.zzo(this.zza).post(new zzbq(this, str, str2));
    }
}

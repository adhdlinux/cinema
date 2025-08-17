package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzalq;
import com.google.android.gms.internal.ads.zzamh;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzcaj;
import java.util.Map;

public final class zzbn extends zzalk {
    private final zzcaj zza;
    private final zzbzq zzb;

    public zzbn(String str, Map map, zzcaj zzcaj) {
        super(0, str, new zzbm(zzcaj));
        this.zza = zzcaj;
        zzbzq zzbzq = new zzbzq((String) null);
        this.zzb = zzbzq;
        zzbzq.zzd(str, "GET", (Map) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzalq zzh(zzalg zzalg) {
        return zzalq.zzb(zzalg, zzamh.zzb(zzalg));
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzalg zzalg = (zzalg) obj;
        this.zzb.zzf(zzalg.zzc, zzalg.zza);
        zzbzq zzbzq = this.zzb;
        byte[] bArr = zzalg.zzb;
        if (zzbzq.zzk() && bArr != null) {
            zzbzq.zzh(bArr);
        }
        this.zza.zzd(zzalg);
    }
}

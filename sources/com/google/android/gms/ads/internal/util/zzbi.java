package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzalo;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzbzq;
import java.util.Collections;
import java.util.Map;

final class zzbi extends zzamo {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzbzq zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzbo zzbo, int i2, String str, zzalp zzalp, zzalo zzalo, byte[] bArr, Map map, zzbzq zzbzq) {
        super(i2, str, zzalp, zzalo);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzbzq;
    }

    public final Map zzl() throws zzaks {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    public final byte[] zzx() throws zzaks {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzz(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}

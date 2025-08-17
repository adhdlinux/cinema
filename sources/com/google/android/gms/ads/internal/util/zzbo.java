package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzcaj;
import com.google.android.gms.internal.ads.zzfwm;
import java.util.Map;

public final class zzbo {
    @Deprecated
    public static final zzbj zza = new zzbg();
    private static zzaln zzb;
    private static final Object zzc = new Object();

    public zzbo(Context context) {
        zzaln zzaln;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbbm.zza(context);
                if (!ClientLibraryUtils.isPackageSide()) {
                    if (((Boolean) zzba.zzc().zzb(zzbbm.zzeg)).booleanValue()) {
                        zzaln = zzax.zzb(context);
                        zzb = zzaln;
                    }
                }
                zzaln = zzamq.zza(context, (zzaly) null);
                zzb = zzaln;
            }
        }
    }

    public final zzfwm zza(String str) {
        zzcaj zzcaj = new zzcaj();
        zzb.zza(new zzbn(str, (Map) null, zzcaj));
        return zzcaj;
    }

    public final zzfwm zzb(int i2, String str, Map map, byte[] bArr) {
        String str2 = str;
        zzbl zzbl = new zzbl((zzbk) null);
        zzbh zzbh = new zzbh(this, str2, zzbl);
        zzbzq zzbzq = new zzbzq((String) null);
        zzbi zzbi = new zzbi(this, i2, str, zzbl, zzbh, bArr, map, zzbzq);
        if (zzbzq.zzk()) {
            try {
                zzbzq.zzd(str2, "GET", zzbi.zzl(), zzbi.zzx());
            } catch (zzaks e2) {
                zzbzr.zzj(e2.getMessage());
            }
        }
        zzb.zza(zzbi);
        return zzbl;
    }
}

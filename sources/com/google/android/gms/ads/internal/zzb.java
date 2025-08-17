package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.internal.ads.zzbtk;
import com.google.android.gms.internal.ads.zzbws;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbws zzc;
    private final zzbtk zzd = new zzbtk(false, Collections.emptyList());

    public zzb(Context context, zzbws zzbws, zzbtk zzbtk) {
        this.zza = context;
        this.zzc = zzbws;
    }

    private final boolean zzd() {
        zzbws zzbws = this.zzc;
        return (zzbws != null && zzbws.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbws zzbws = this.zzc;
            if (zzbws != null) {
                zzbws.zzd(str, (Map) null, 3);
                return;
            }
            zzbtk zzbtk = this.zzd;
            if (zzbtk.zza && (list = zzbtk.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzt.zzp();
                        zzs.zzH(this.zza, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}

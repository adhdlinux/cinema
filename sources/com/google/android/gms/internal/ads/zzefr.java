package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzefr {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzefs zzb;
    /* access modifiers changed from: private */
    public final zzfgr zzc;
    private final List zzd = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzech zzf;

    public zzefr(Clock clock, zzefs zzefs, zzech zzech, zzfgr zzfgr) {
        this.zza = clock;
        this.zzb = zzefs;
        this.zze = ((Boolean) zzba.zzc().zzb(zzbbm.zzgF)).booleanValue();
        this.zzf = zzech;
        this.zzc = zzfgr;
    }

    static /* bridge */ /* synthetic */ void zzg(zzefr zzefr, String str, int i2, long j2, String str2, Integer num) {
        String str3 = str + "." + i2 + "." + j2;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + str2;
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzby)).booleanValue() && num != null && !TextUtils.isEmpty(str2)) {
            str3 = str3 + "." + num;
        }
        zzefr.zzd.add(str3);
    }

    /* access modifiers changed from: package-private */
    public final zzfwm zze(zzezz zzezz, zzezn zzezn, zzfwm zzfwm, zzfgn zzfgn) {
        zzezq zzezq = zzezz.zzb.zzb;
        long elapsedRealtime = this.zza.elapsedRealtime();
        String str = zzezn.zzx;
        if (str != null) {
            zzfwc.zzq(zzfwm, new zzefq(this, elapsedRealtime, str, zzezn, zzezq, zzfgn, zzezz), zzcae.zzf);
        }
        return zzfwm;
    }

    public final String zzf() {
        return TextUtils.join("_", this.zzd);
    }
}

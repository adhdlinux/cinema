package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;

public final class zzeqj implements zzeqy {
    private final zzbxw zza;
    private final zzfwn zzb;
    private final Context zzc;

    public zzeqj(zzbxw zzbxw, zzfwn zzfwn, Context context) {
        this.zza = zzbxw;
        this.zzb = zzfwn;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final zzfwm zzb() {
        return this.zzb.zzb(new zzeqi(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqk zzc() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        Long l2;
        if (!this.zza.zzu(this.zzc)) {
            return new zzeqk((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zze = this.zza.zze(this.zzc);
        if (zze == null) {
            str = "";
        } else {
            str = zze;
        }
        String zzc2 = this.zza.zzc(this.zzc);
        if (zzc2 == null) {
            str2 = "";
        } else {
            str2 = zzc2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str3 = "";
        } else {
            str3 = zza2;
        }
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str4 = "";
        } else {
            str4 = zzb2;
        }
        if ("TIME_OUT".equals(str2)) {
            l2 = (Long) zzba.zzc().zzb(zzbbm.zzag);
        } else {
            l2 = null;
        }
        return new zzeqk(str, str2, str3, str4, l2);
    }
}

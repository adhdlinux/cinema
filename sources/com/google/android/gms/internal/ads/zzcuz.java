package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;
import org.json.JSONException;

public final class zzcuz extends zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzech zzh;
    private final Bundle zzi;

    public zzcuz(zzezn zzezn, String str, zzech zzech, zzezq zzezq, String str2) {
        String str3;
        String str4;
        String str5;
        String str6 = null;
        if (zzezn == null) {
            str3 = null;
        } else {
            str3 = zzezn.zzac;
        }
        this.zzb = str3;
        this.zzc = str2;
        if (zzezq == null) {
            str4 = null;
        } else {
            str4 = zzezq.zzb;
        }
        this.zzd = str4;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str6 = zzezn.zzw.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str6 != null ? str6 : str;
        this.zze = zzech.zzc();
        this.zzh = zzech;
        this.zzf = zzt.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgD)).booleanValue() || zzezq == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzezq.zzj;
        }
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziL)).booleanValue() || zzezq == null || TextUtils.isEmpty(zzezq.zzh)) {
            str5 = "";
        } else {
            str5 = zzezq.zzh;
        }
        this.zzg = str5;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final zzu zzf() {
        zzech zzech = this.zzh;
        if (zzech != null) {
            return zzech.zza();
        }
        return null;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        return this.zzb;
    }

    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}

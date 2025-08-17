package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;

public final class zzbea extends zzbei {
    static final int zza = Color.rgb(204, 204, 204);
    static final int zzb;
    private static final int zzc;
    private final String zzd;
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;

    static {
        int rgb = Color.rgb(12, 174, Sdk$SDKError.Reason.AD_ALREADY_FAILED_VALUE);
        zzc = rgb;
        zzb = rgb;
    }

    public zzbea(String str, List list, Integer num, Integer num2, Integer num3, int i2, int i3, boolean z2) {
        int i4;
        int i5;
        int i6;
        this.zzd = str;
        for (int i7 = 0; i7 < list.size(); i7++) {
            zzbed zzbed = (zzbed) list.get(i7);
            this.zze.add(zzbed);
            this.zzf.add(zzbed);
        }
        if (num != null) {
            i4 = num.intValue();
        } else {
            i4 = zza;
        }
        this.zzg = i4;
        if (num2 != null) {
            i5 = num2.intValue();
        } else {
            i5 = zzb;
        }
        this.zzh = i5;
        if (num3 != null) {
            i6 = num3.intValue();
        } else {
            i6 = 12;
        }
        this.zzi = i6;
        this.zzj = i2;
        this.zzk = i3;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final List zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }
}

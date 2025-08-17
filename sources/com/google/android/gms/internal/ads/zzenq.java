package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzenq implements Callable {
    public final /* synthetic */ zzenr zza;

    public /* synthetic */ zzenq(zzenr zzenr) {
        this.zza = zzenr;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzt.zzp();
        zzauz zzg = zzt.zzo().zzh().zzg();
        Bundle bundle = null;
        if (zzg != null && (!zzt.zzo().zzh().zzM() || !zzt.zzo().zzh().zzN())) {
            if (zzg.zzh()) {
                zzg.zzg();
            }
            zzaup zza2 = zzg.zza();
            if (zza2 != null) {
                str2 = zza2.zzd();
                str = zza2.zze();
                str3 = zza2.zzf();
                if (str2 != null) {
                    zzt.zzo().zzh().zzw(str2);
                }
                if (str3 != null) {
                    zzt.zzo().zzh().zzy(str3);
                }
            } else {
                str2 = zzt.zzo().zzh().zzj();
                str3 = zzt.zzo().zzh().zzk();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzt.zzo().zzh().zzN()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzt.zzo().zzh().zzM()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzens(bundle);
    }
}

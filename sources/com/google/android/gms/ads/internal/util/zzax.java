package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzaln;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzalz;
import com.google.android.gms.internal.ads.zzamg;
import com.google.android.gms.internal.ads.zzamk;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbke;
import com.google.android.gms.internal.ads.zzbzk;
import java.io.File;
import java.util.regex.Pattern;

public final class zzax extends zzalz {
    private final Context zzc;

    private zzax(Context context, zzaly zzaly) {
        super(zzaly);
        this.zzc = context;
    }

    public static zzaln zzb(Context context) {
        zzaln zzaln = new zzaln(new zzamg(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzax(context, new zzamk()), 4);
        zzaln.zzd();
        return zzaln;
    }

    public final zzalg zza(zzalk zzalk) throws zzalt {
        if (zzalk.zza() == 0) {
            if (Pattern.matches((String) zzba.zzc().zzb(zzbbm.zzeh), zzalk.zzk())) {
                zzay.zzb();
                if (zzbzk.zzs(this.zzc, 13400000)) {
                    zzalg zza = new zzbke(this.zzc).zza(zzalk);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzalk.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzalk.zzk())));
                }
            }
        }
        return super.zza(zzalk);
    }
}

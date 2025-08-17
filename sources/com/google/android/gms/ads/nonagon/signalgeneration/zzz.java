package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzfvy;

final class zzz implements zzfvy {
    final /* synthetic */ zzaa zza;

    zzz(zzaa zzaa) {
        this.zza = zzaa;
    }

    public final void zza(Throwable th) {
        zzt.zzo().zzu(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzaa zzaa = this.zza;
        zzf.zzc(zzaa.zzr, zzaa.zzj, "sgf", new Pair("sgf_reason", th.getMessage()));
        zzbzr.zzh("Failed to initialize webview for loading SDKCore. ", th);
    }

    public final /* synthetic */ void zzb(Object obj) {
        zzam zzam = (zzam) obj;
        zzbzr.zze("Initialized webview successfully for SDKCore.");
    }
}

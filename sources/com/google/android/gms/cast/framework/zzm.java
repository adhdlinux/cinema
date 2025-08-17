package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzaz;
import com.google.android.gms.cast.zzbd;
import com.google.android.gms.cast.zzbg;
import com.google.android.gms.cast.zzbt;
import com.google.android.gms.cast.zzbu;
import com.google.android.gms.common.api.internal.TaskApiCall;

final class zzm extends zzv {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzm(CastSession castSession, zzl zzl) {
        this.zza = castSession;
    }

    public final void zzb(int i2) {
        CastSession.zzg(this.zza, i2);
    }

    public final void zzc(String str, String str2) {
        CastSession castSession = this.zza;
        if (castSession.zzi != null && castSession.zzi.zzl()) {
            zzbt zzbt = (zzbt) this.zza.zzi;
            zzbt.doWrite(TaskApiCall.builder().run(new zzbg(zzbt, str, str2, (zzbu) null)).setMethodKey(8407).build()).addOnCompleteListener(new zzk(this));
        }
    }

    public final void zzd(String str, LaunchOptions launchOptions) {
        CastSession castSession = this.zza;
        if (castSession.zzi != null && castSession.zzi.zzl()) {
            zzbt zzbt = (zzbt) this.zza.zzi;
            zzbt.doWrite(TaskApiCall.builder().run(new zzaz(zzbt, str, launchOptions)).setMethodKey(8406).build()).addOnCompleteListener(new zzj(this));
        }
    }

    public final void zze(String str) {
        CastSession castSession = this.zza;
        if (castSession.zzi != null && castSession.zzi.zzl()) {
            zzbt zzbt = (zzbt) this.zza.zzi;
            zzbt.doWrite(TaskApiCall.builder().run(new zzbd(zzbt, str)).setMethodKey(8409).build());
        }
    }
}

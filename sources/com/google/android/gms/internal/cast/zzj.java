package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzj extends SessionTransferCallback {
    final /* synthetic */ zzk zza;

    public zzj(zzk zzk) {
        this.zza = zzk;
    }

    public final void onTransferFailed(int i2, int i3) {
        zzk.zza.d("onTransferFailed with type = %d and reason = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzf(zzk.zzh, i2, i3), 232);
        this.zza.zzk = false;
    }

    public final void onTransferred(int i2, SessionState sessionState) {
        zzk.zza.d("onTransferred with type = %d", Integer.valueOf(i2));
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzg(zzk.zzh, i2), 231);
        this.zza.zzk = false;
        this.zza.zzh = null;
    }

    public final void onTransferring(int i2) {
        zzk.zza.d("onTransferring with type = %d", Integer.valueOf(i2));
        this.zza.zzk = true;
        this.zza.zzu();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzg(zzk.zzh, i2), 230);
    }
}

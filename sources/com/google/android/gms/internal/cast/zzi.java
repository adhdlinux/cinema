package com.google.android.gms.internal.cast;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.vungle.ads.internal.protos.Sdk$SDKError;

@VisibleForTesting
public final class zzi implements SessionManagerListener {
    final /* synthetic */ zzk zza;

    public zzi(zzk zzk) {
        this.zza = zzk;
    }

    public final /* bridge */ /* synthetic */ void onSessionEnded(Session session, int i2) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i2);
    }

    public final /* synthetic */ void onSessionEnding(Session session) {
        this.zza.zzi = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i2) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i2);
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z2) {
        zzk.zza.d("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z2));
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzb(zzk.zzh, z2), 227);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzw();
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        zzk.zza.d("onSessionResuming with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        zzk zzk = this.zza;
        zzk.zzo(zzk, zzk.zzg, str);
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk2 = this.zza;
        this.zza.zzb.zzd(zzk2.zzc.zzc(zzk2.zzh), 226);
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i2) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i2);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        zzk.zza.d("onSessionStarted with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        zzk zzk = this.zza;
        zzk.zzh.zzf = str;
        this.zza.zzb.zzd(zzk.zzc.zza(zzk.zzh), Sdk$SDKError.Reason.INVALID_WATERFALL_PLACEMENT_ID_VALUE);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzw();
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        zzk.zza.d("onSessionStarting", new Object[0]);
        this.zza.zzi = (CastSession) session;
        if (this.zza.zzh != null) {
            zzk.zza.w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzv();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzd(zzk.zzh), Sdk$SDKError.Reason.AD_LOAD_FAIL_RETRY_AFTER_VALUE);
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i2) {
        zzk.zza.d("onSessionSuspended with reason = %d", Integer.valueOf(i2));
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zze(zzk.zzh, i2), JfifUtil.MARKER_APP1);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzt();
    }
}

package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;

final class zzbl implements SessionManagerListener {
    final /* synthetic */ zzbm zza;

    /* synthetic */ zzbl(zzbm zzbm, zzbk zzbk) {
        this.zza = zzbm;
    }

    public final /* bridge */ /* synthetic */ void onSessionEnded(Session session, int i2) {
        CastSession castSession = (CastSession) session;
        zzbm.zza.d("onSessionEnded with error = %d", Integer.valueOf(i2));
        zzbm.zzg(this.zza);
        zzbm zzbm = this.zza;
        if (zzbm.zzf != 2) {
            zzbm.zzq();
        }
    }

    public final /* bridge */ /* synthetic */ void onSessionEnding(Session session) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i2) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z2) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i2) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        CastSession castSession = (CastSession) session;
        zzbm.zza.d("onSessionStarted with transferType = %d", Integer.valueOf(this.zza.zzf));
        if (this.zza.zzb.zzg()) {
            zzbm zzbm = this.zza;
            if (zzbm.zzf == 2) {
                zzbm.zzi(zzbm);
            }
        }
        this.zza.zzq();
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        CastSession castSession = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i2) {
        CastSession castSession = (CastSession) session;
    }
}

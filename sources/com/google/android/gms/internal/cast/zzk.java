package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

public final class zzk {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("ApplicationAnalytics");
    /* access modifiers changed from: private */
    public final zzf zzb;
    /* access modifiers changed from: private */
    public final zzm zzc;
    private final zzh zzd = new zzh(this);
    private final Runnable zze = new zzg(this);
    private final Handler zzf = new zzdy(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final SharedPreferences zzg;
    /* access modifiers changed from: private */
    public zzl zzh;
    /* access modifiers changed from: private */
    public CastSession zzi;
    private boolean zzj;
    /* access modifiers changed from: private */
    public boolean zzk;

    public zzk(SharedPreferences sharedPreferences, zzf zzf2, Bundle bundle, String str) {
        this.zzg = sharedPreferences;
        this.zzb = zzf2;
        this.zzc = new zzm(bundle, str);
    }

    public static /* synthetic */ void zzg(zzk zzk2) {
        zzl zzl = zzk2.zzh;
        if (zzl != null) {
            zzk2.zzb.zzd(zzk2.zzc.zza(zzl), Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE);
        }
        zzk2.zzw();
    }

    static /* bridge */ /* synthetic */ void zzn(zzk zzk2, int i2) {
        zza.d("log session ended with error = %d", Integer.valueOf(i2));
        zzk2.zzu();
        zzk2.zzb.zzd(zzk2.zzc.zze(zzk2.zzh, i2), 228);
        zzk2.zzt();
        if (!zzk2.zzk) {
            zzk2.zzh = null;
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzk zzk2, SharedPreferences sharedPreferences, String str) {
        boolean z2 = false;
        if (zzk2.zzz(str)) {
            zza.d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzk2.zzh);
            return;
        }
        zzk2.zzh = zzl.zzb(sharedPreferences);
        if (zzk2.zzz(str)) {
            zza.d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzk2.zzh);
            zzl.zza = zzk2.zzh.zzd + 1;
            return;
        }
        zza.d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzl zza2 = zzl.zza(zzk2.zzj);
        zzk2.zzh = zza2;
        zzl zzl = (zzl) Preconditions.checkNotNull(zza2);
        CastSession castSession = zzk2.zzi;
        if (castSession != null && castSession.zzj()) {
            z2 = true;
        }
        zzl.zzj = z2;
        ((zzl) Preconditions.checkNotNull(zzk2.zzh)).zzb = zzs();
        ((zzl) Preconditions.checkNotNull(zzk2.zzh)).zzf = str;
    }

    static /* bridge */ /* synthetic */ void zzr(zzk zzk2, boolean z2) {
        Logger logger = zza;
        Object[] objArr = new Object[1];
        objArr[0] = true != z2 ? DownloadService.KEY_FOREGROUND : AppStateModule.APP_STATE_BACKGROUND;
        logger.d("update app visibility to %s", objArr);
        zzk2.zzj = z2;
        zzl zzl = zzk2.zzh;
        if (zzl != null) {
            zzl.zzi = z2;
        }
    }

    @Pure
    private static String zzs() {
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    /* access modifiers changed from: private */
    public final void zzt() {
        this.zzf.removeCallbacks(this.zze);
    }

    /* access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzu() {
        CastDevice castDevice;
        if (zzy()) {
            CastSession castSession = this.zzi;
            if (castSession != null) {
                castDevice = castSession.getCastDevice();
            } else {
                castDevice = null;
            }
            if (castDevice != null && !TextUtils.equals(this.zzh.zzc, castDevice.zzc())) {
                zzx(castDevice);
            }
            Preconditions.checkNotNull(this.zzh);
            return;
        }
        zza.w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
        zzv();
    }

    /* access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzv() {
        boolean z2;
        CastDevice castDevice;
        int i2 = 0;
        zza.d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzl zza2 = zzl.zza(this.zzj);
        this.zzh = zza2;
        zzl zzl = (zzl) Preconditions.checkNotNull(zza2);
        CastSession castSession = this.zzi;
        if (castSession == null || !castSession.zzj()) {
            z2 = false;
        } else {
            z2 = true;
        }
        zzl.zzj = z2;
        ((zzl) Preconditions.checkNotNull(this.zzh)).zzb = zzs();
        CastSession castSession2 = this.zzi;
        if (castSession2 == null) {
            castDevice = null;
        } else {
            castDevice = castSession2.getCastDevice();
        }
        if (castDevice != null) {
            zzx(castDevice);
        }
        zzl zzl2 = (zzl) Preconditions.checkNotNull(this.zzh);
        CastSession castSession3 = this.zzi;
        if (castSession3 != null) {
            i2 = castSession3.zzk();
        }
        zzl2.zzk = i2;
        Preconditions.checkNotNull(this.zzh);
    }

    /* access modifiers changed from: private */
    public final void zzw() {
        ((Handler) Preconditions.checkNotNull(this.zzf)).postDelayed((Runnable) Preconditions.checkNotNull(this.zze), 300000);
    }

    private final void zzx(CastDevice castDevice) {
        zzl zzl = this.zzh;
        if (zzl != null) {
            zzl.zzc = castDevice.zzc();
            zzl.zzg = castDevice.zza();
            zzl.zzh = castDevice.getModelName();
        }
    }

    @EnsuresNonNullIf(expression = {"analyticsSession"}, result = true)
    private final boolean zzy() {
        String str;
        if (this.zzh == null) {
            zza.d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzs = zzs();
        if (zzs == null || (str = this.zzh.zzb) == null || !TextUtils.equals(str, zzs)) {
            zza.d("The analytics session doesn't match the application ID %s", zzs);
            return false;
        }
        Preconditions.checkNotNull(this.zzh);
        return true;
    }

    private final boolean zzz(String str) {
        String str2;
        if (!zzy()) {
            return false;
        }
        Preconditions.checkNotNull(this.zzh);
        if (str != null && (str2 = this.zzh.zzf) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        zza.d("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }

    public final zzh zzc() {
        return this.zzd;
    }
}

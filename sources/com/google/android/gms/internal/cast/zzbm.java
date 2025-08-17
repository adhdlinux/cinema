package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.mediarouter.media.MediaRouter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

@TargetApi(30)
public final class zzbm {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("SessionTransController");
    /* access modifiers changed from: private */
    public final CastOptions zzb;
    private final Set zzc = Collections.synchronizedSet(new HashSet());
    private final Handler zzd;
    private final Runnable zze;
    /* access modifiers changed from: private */
    public int zzf;
    private SessionManager zzg;
    private CallbackToFutureAdapter.Completer zzh;
    private SessionState zzi;

    public zzbm(CastOptions castOptions) {
        this.zzb = castOptions;
        this.zzf = 0;
        this.zzd = new zzdy(Looper.getMainLooper());
        this.zze = new zzbh(this);
    }

    public static /* synthetic */ void zzd(zzbm zzbm, SessionState sessionState) {
        zzbm.zzi = sessionState;
        CallbackToFutureAdapter.Completer completer = zzbm.zzh;
        if (completer != null) {
            completer.b(null);
        }
    }

    public static /* synthetic */ void zze(zzbm zzbm) {
        zza.i("transfer with type = %d has timed out", Integer.valueOf(zzbm.zzf));
        zzbm.zzp(101);
    }

    static /* bridge */ /* synthetic */ void zzg(zzbm zzbm) {
        int i2 = zzbm.zzf;
        if (i2 == 0) {
            zza.d("No need to notify transferred if the transfer type is unknown", new Object[0]);
            return;
        }
        SessionState sessionState = zzbm.zzi;
        if (sessionState == null) {
            zza.d("No need to notify with null sessionState", new Object[0]);
            return;
        }
        zza.d("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i2), zzbm.zzi);
        for (SessionTransferCallback onTransferred : new HashSet(zzbm.zzc)) {
            onTransferred.onTransferred(zzbm.zzf, sessionState);
        }
    }

    static /* bridge */ /* synthetic */ void zzi(zzbm zzbm) {
        if (zzbm.zzi == null) {
            zza.d("skip restoring session state due to null SessionState", new Object[0]);
            return;
        }
        RemoteMediaClient zzo = zzbm.zzo();
        if (zzo == null) {
            zza.d("skip restoring session state due to null RemoteMediaClient", new Object[0]);
            return;
        }
        zza.d("resume SessionState to current session", new Object[0]);
        zzo.zzq(zzbm.zzi);
    }

    private final RemoteMediaClient zzo() {
        SessionManager sessionManager = this.zzg;
        if (sessionManager == null) {
            zza.d("skip transferring as SessionManager is null", new Object[0]);
            return null;
        }
        CastSession currentCastSession = sessionManager.getCurrentCastSession();
        if (currentCastSession != null) {
            return currentCastSession.getRemoteMediaClient();
        }
        zza.d("skip transferring as CastSession is null", new Object[0]);
        return null;
    }

    private final void zzp(int i2) {
        CallbackToFutureAdapter.Completer completer = this.zzh;
        if (completer != null) {
            completer.c();
        }
        zza.d("notify failed transfer with type = %d, reason = %d", Integer.valueOf(this.zzf), Integer.valueOf(i2));
        for (SessionTransferCallback onTransferFailed : new HashSet(this.zzc)) {
            onTransferFailed.onTransferFailed(this.zzf, i2);
        }
        zzq();
    }

    /* access modifiers changed from: private */
    public final void zzq() {
        ((Handler) Preconditions.checkNotNull(this.zzd)).removeCallbacks((Runnable) Preconditions.checkNotNull(this.zze));
        this.zzf = 0;
        this.zzi = null;
    }

    public final void zzj(SessionManager sessionManager) {
        this.zzg = sessionManager;
        ((Handler) Preconditions.checkNotNull(this.zzd)).post(new zzbg(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Exception exc) {
        zza.w(exc, "Fail to store SessionState", new Object[0]);
        zzp(100);
    }

    public final void zzl(MediaRouter.RouteInfo routeInfo, MediaRouter.RouteInfo routeInfo2, CallbackToFutureAdapter.Completer completer) {
        int i2;
        if (new HashSet(this.zzc).isEmpty()) {
            zza.d("No need to prepare transfer without any callback", new Object[0]);
            completer.b(null);
        } else if (routeInfo.o() != 1) {
            zza.d("No need to prepare transfer when transferring from local", new Object[0]);
            completer.b(null);
        } else {
            RemoteMediaClient zzo = zzo();
            if (zzo == null || !zzo.hasMediaSession()) {
                zza.d("No need to prepare transfer when there is no media session", new Object[0]);
                completer.b(null);
                return;
            }
            Logger logger = zza;
            logger.d("Prepare route transfer for changing endpoint", new Object[0]);
            if (routeInfo2.o() == 0) {
                zzr.zzd(zzln.CAST_TRANSFER_TO_LOCAL_USED);
                i2 = 1;
            } else if (CastDevice.getFromBundle(routeInfo2.i()) == null) {
                i2 = 3;
            } else {
                i2 = 2;
            }
            this.zzf = i2;
            this.zzh = completer;
            logger.d("notify transferring with type = %d", Integer.valueOf(i2));
            for (SessionTransferCallback onTransferring : new HashSet(this.zzc)) {
                onTransferring.onTransferring(this.zzf);
            }
            this.zzi = null;
            zzo.zzk((JSONObject) null).addOnSuccessListener(new zzbi(this)).addOnFailureListener(new zzbj(this));
            ((Handler) Preconditions.checkNotNull(this.zzd)).postDelayed((Runnable) Preconditions.checkNotNull(this.zze), NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        }
    }

    public final void zzm(SessionTransferCallback sessionTransferCallback) {
        zza.d("register callback = %s", sessionTransferCallback);
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        this.zzc.add(sessionTransferCallback);
    }

    public final void zzn(SessionTransferCallback sessionTransferCallback) {
        zza.d("unregister callback = %s", sessionTransferCallback);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionTransferCallback != null) {
            this.zzc.remove(sessionTransferCallback);
        }
    }
}

package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zzaz extends zzap {
    @NotOnlyInitialized
    private final SessionManagerListener zza;
    private final Class zzb;

    public zzaz(SessionManagerListener sessionManagerListener, Class cls) {
        this.zza = sessionManagerListener;
        this.zzb = cls;
    }

    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionEnded((Session) this.zzb.cast(session), i2);
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionEnding((Session) this.zzb.cast(session));
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResumeFailed((Session) this.zzb.cast(session), i2);
        }
    }

    public final void zzf(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResumed((Session) this.zzb.cast(session), z2);
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionResuming((Session) this.zzb.cast(session), str);
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStartFailed((Session) this.zzb.cast(session), i2);
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStarted((Session) this.zzb.cast(session), str);
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionStarting((Session) this.zzb.cast(session));
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        SessionManagerListener sessionManagerListener;
        Session session = (Session) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzb.isInstance(session) && (sessionManagerListener = this.zza) != null) {
            sessionManagerListener.onSessionSuspended((Session) this.zzb.cast(session), i2);
        }
    }
}

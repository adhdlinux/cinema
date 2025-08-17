package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzaf;

public abstract class Session {
    private static final Logger zza = new Logger("Session");
    private final zzam zzb;
    private final zzay zzc;

    protected Session(Context context, String str, String str2) {
        zzay zzay = new zzay(this, (zzax) null);
        this.zzc = zzay;
        this.zzb = zzaf.zzd(context, str, str2, zzay);
    }

    /* access modifiers changed from: protected */
    public abstract void end(boolean z2);

    public final String getCategory() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzh();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "getCategory", zzam.class.getSimpleName());
            }
        }
        return null;
    }

    public final String getSessionId() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzi();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "getSessionId", zzam.class.getSimpleName());
            }
        }
        return null;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return 0;
    }

    public boolean isConnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzp();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isConnected", zzam.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isConnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzq();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isConnecting", zzam.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isDisconnected() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzr();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isDisconnected", zzam.class.getSimpleName());
            }
        }
        return true;
    }

    public boolean isDisconnecting() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzs();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isDisconnecting", zzam.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isResuming() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzt();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isResuming", zzam.class.getSimpleName());
            }
        }
        return false;
    }

    public boolean isSuspended() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzu();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "isSuspended", zzam.class.getSimpleName());
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToResumeSession(int i2) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzj(i2);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifyFailedToResumeSession", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToStartSession(int i2) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzk(i2);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifyFailedToStartSession", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionEnded(int i2) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzl(i2);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifySessionEnded", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionResumed(boolean z2) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzm(z2);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifySessionResumed", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionStarted(String str) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzn(str);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifySessionStarted", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionSuspended(int i2) {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                zzam.zzo(i2);
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "notifySessionSuspended", zzam.class.getSimpleName());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResuming(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void onStarting(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public abstract void resume(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void start(Bundle bundle);

    /* access modifiers changed from: protected */
    public void zzi(Bundle bundle) {
    }

    public final int zzk() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                if (zzam.zze() >= 211100000) {
                    return this.zzb.zzf();
                }
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "getSessionStartType", zzam.class.getSimpleName());
            }
        }
        return 0;
    }

    public final IObjectWrapper zzl() {
        zzam zzam = this.zzb;
        if (zzam != null) {
            try {
                return zzam.zzg();
            } catch (RemoteException e2) {
                zza.d(e2, "Unable to call %s on %s.", "getWrappedObject", zzam.class.getSimpleName());
            }
        }
        return null;
    }
}

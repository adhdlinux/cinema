package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

abstract class zzfuy extends zzfvs implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    zzfwm zza;
    Object zzb;

    zzfuy(zzfwm zzfwm, Object obj) {
        zzfwm.getClass();
        this.zza = zzfwm;
        this.zzb = obj;
    }

    public final void run() {
        boolean z2;
        zzfwm zzfwm = this.zza;
        Object obj = this.zzb;
        boolean isCancelled = isCancelled();
        boolean z3 = true;
        if (zzfwm == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z4 = isCancelled | z2;
        if (obj != null) {
            z3 = false;
        }
        if (!z4 && !z3) {
            this.zza = null;
            if (zzfwm.isCancelled()) {
                zzt(zzfwm);
                return;
            }
            try {
                try {
                    Object zzf = zzf(obj, zzfwc.zzo(zzfwm));
                    this.zzb = null;
                    zzg(zzf);
                } catch (Throwable th) {
                    this.zzb = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e2) {
                zze(e2.getCause());
            } catch (RuntimeException e3) {
                zze(e3);
            } catch (Error e4) {
                zze(e4);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        String str;
        zzfwm zzfwm = this.zza;
        Object obj = this.zzb;
        String zza2 = super.zza();
        if (zzfwm != null) {
            str = "inputFuture=[" + zzfwm.toString() + "], ";
        } else {
            str = "";
        }
        if (obj != null) {
            return str + "function=[" + obj.toString() + "]";
        } else if (zza2 != null) {
            return str.concat(zza2);
        } else {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb() {
        zzs(this.zza);
        this.zza = null;
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzf(Object obj, Object obj2) throws Exception;

    /* access modifiers changed from: package-private */
    public abstract void zzg(Object obj);
}

package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzcau {
    private final WeakReference zza;

    public zzcau(View view) {
        this.zza = new WeakReference(view);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    public abstract void zzb(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    public final ViewTreeObserver zzc() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zza.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void zzd() {
        ViewTreeObserver zzc = zzc();
        if (zzc != null) {
            zza(zzc);
        }
    }

    public final void zze() {
        ViewTreeObserver zzc = zzc();
        if (zzc != null) {
            zzb(zzc);
        }
    }
}

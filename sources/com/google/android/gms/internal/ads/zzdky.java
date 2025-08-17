package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzdky extends zzbkt implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbec {
    private View zza;
    private zzdq zzb;
    private zzdgv zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdky(zzdgv zzdgv, zzdha zzdha) {
        this.zza = zzdha.zzf();
        this.zzb = zzdha.zzj();
        this.zzc = zzdgv;
        if (zzdha.zzr() != null) {
            zzdha.zzr().zzam(this);
        }
    }

    private final void zzg() {
        View view;
        zzdgv zzdgv = this.zzc;
        if (zzdgv != null && (view = this.zza) != null) {
            zzdgv.zzA(view, Collections.emptyMap(), Collections.emptyMap(), zzdgv.zzW(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbkx zzbkx, int i2) {
        try {
            zzbkx.zze(i2);
        } catch (RemoteException e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzbzr.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbeo zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbzr.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdgv zzdgv = this.zzc;
        if (zzdgv == null || zzdgv.zzc() == null) {
            return null;
        }
        return zzdgv.zzc().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdgv zzdgv = this.zzc;
        if (zzdgv != null) {
            zzdgv.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdkx(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbkx zzbkx) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbzr.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbkx, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            if (view == null) {
                str = "can not get video view.";
            } else {
                str = "can not get video controller.";
            }
            zzbzr.zzg("Instream internal error: ".concat(str));
            zzi(zzbkx, 0);
        } else if (this.zze) {
            zzbzr.zzg("Instream ad should not be used again.");
            zzi(zzbkx, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzt.zzx();
            zzcar.zza(this.zza, this);
            zzt.zzx();
            zzcar.zzb(this.zza, this);
            zzg();
            try {
                zzbkx.zzf();
            } catch (RemoteException e2) {
                zzbzr.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}

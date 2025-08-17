package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbes extends NativeAd.Image {
    private final zzber zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbes(zzber zzber) {
        Drawable drawable;
        double d2;
        int i2;
        this.zza = zzber;
        Uri uri = null;
        try {
            IObjectWrapper zzf2 = zzber.zzf();
            if (zzf2 != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzf2);
                this.zzb = drawable;
                uri = this.zza.zze();
                this.zzc = uri;
                d2 = this.zza.zzb();
                this.zzd = d2;
                int i3 = -1;
                i2 = this.zza.zzd();
                this.zze = i2;
                i3 = this.zza.zzc();
                this.zzf = i3;
            }
        } catch (RemoteException e2) {
            zzbzr.zzh("", e2);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zze();
        } catch (RemoteException e3) {
            zzbzr.zzh("", e3);
        }
        this.zzc = uri;
        try {
            d2 = this.zza.zzb();
        } catch (RemoteException e4) {
            zzbzr.zzh("", e4);
            d2 = 1.0d;
        }
        this.zzd = d2;
        int i32 = -1;
        try {
            i2 = this.zza.zzd();
        } catch (RemoteException e5) {
            zzbzr.zzh("", e5);
            i2 = -1;
        }
        this.zze = i2;
        try {
            i32 = this.zza.zzc();
        } catch (RemoteException e6) {
            zzbzr.zzh("", e6);
        }
        this.zzf = i32;
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zze;
    }
}

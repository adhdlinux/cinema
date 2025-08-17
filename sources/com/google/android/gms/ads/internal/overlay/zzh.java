package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcez;

public final class zzh {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzh(zzcez zzcez) throws zzf {
        this.zzb = zzcez.getLayoutParams();
        ViewParent parent = zzcez.getParent();
        this.zzd = zzcez.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzf("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcez.zzF());
        viewGroup.removeView(zzcez.zzF());
        zzcez.zzan(true);
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

final class zzbqj implements zzo {
    final /* synthetic */ zzbql zza;

    zzbqj(zzbql zzbql) {
        this.zza = zzbql;
    }

    public final void zzb() {
        zzbzr.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbql zzbql = this.zza;
        zzbql.zzb.onAdOpened(zzbql);
    }

    public final void zzbF() {
        zzbzr.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzbo() {
        zzbzr.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzby() {
        zzbzr.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zze() {
    }

    public final void zzf(int i2) {
        zzbzr.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbql zzbql = this.zza;
        zzbql.zzb.onAdClosed(zzbql);
    }
}

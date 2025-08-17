package com.google.android.gms.internal.ads;

import com.facebook.ads.internal.c.a;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.CollectionUtils;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.Map;

public final class zzbip implements zzbij {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", MRAIDPresenter.SET_ORIENTATION_PROPERTIES, "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzb zzb;
    private final zzbqq zzc;
    private final zzbqx zzd;

    public zzbip(zzb zzb2, zzbqq zzbqq, zzbqx zzbqx) {
        this.zzb = zzb2;
        this.zzc = zzbqq;
        this.zzd = zzbqx;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcez zzcez = (zzcez) obj;
        int intValue = ((Integer) zza.get((String) map.get(a.f20042a))).intValue();
        int i2 = 6;
        boolean z2 = true;
        if (intValue != 5) {
            if (intValue != 7) {
                if (!this.zzb.zzc()) {
                    this.zzb.zzb((String) null);
                    return;
                } else if (intValue == 1) {
                    this.zzc.zzb(map);
                    return;
                } else if (intValue == 3) {
                    new zzbqt(zzcez, map).zzb();
                    return;
                } else if (intValue == 4) {
                    new zzbqo(zzcez, map).zzc();
                    return;
                } else if (intValue != 5) {
                    if (intValue == 6) {
                        this.zzc.zza(true);
                        return;
                    } else if (intValue != 7) {
                        zzbzr.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            z2 = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        }
        if (zzcez == null) {
            zzbzr.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i2 = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            if (z2) {
                i2 = -1;
            } else {
                i2 = 14;
            }
        }
        zzcez.zzaq(i2);
    }
}

package com.google.android.gms.internal.ads;

import android.location.Location;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzbpa implements NativeMediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final zzbef zzg;
    private final List zzh = new ArrayList();
    private final boolean zzi;
    private final Map zzj = new HashMap();
    private final String zzk;

    public zzbpa(Date date, int i2, Set set, Location location, boolean z2, int i3, zzbef zzbef, List list, boolean z3, int i4, String str) {
        this.zza = date;
        this.zzb = i2;
        this.zzc = set;
        this.zze = location;
        this.zzd = z2;
        this.zzf = i3;
        this.zzg = zzbef;
        this.zzi = z3;
        this.zzk = str;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                if (str2.startsWith("custom:")) {
                    String[] split = str2.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            this.zzj.put(split[1], Boolean.TRUE);
                        } else if (Constants.CASEFIRST_FALSE.equals(split[2])) {
                            this.zzj.put(split[1], Boolean.FALSE);
                        }
                    }
                } else {
                    this.zzh.add(str2);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzej.zzf().zza();
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    public final NativeAdOptions getNativeAdOptions() {
        zzbef zzbef = this.zzg;
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbef == null) {
            return builder.build();
        }
        int i2 = zzbef.zza;
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbef.zzg);
                    builder.setMediaAspectRatio(zzbef.zzh);
                }
                builder.setReturnUrlsForImageAssets(zzbef.zzb);
                builder.setImageOrientation(zzbef.zzc);
                builder.setRequestMultipleImages(zzbef.zzd);
                return builder.build();
            }
            zzfl zzfl = zzbef.zzf;
            if (zzfl != null) {
                builder.setVideoOptions(new VideoOptions(zzfl));
            }
        }
        builder.setAdChoicesPlacement(zzbef.zze);
        builder.setReturnUrlsForImageAssets(zzbef.zzb);
        builder.setImageOrientation(zzbef.zzc);
        builder.setRequestMultipleImages(zzbef.zzd);
        return builder.build();
    }

    public final com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions() {
        return zzbef.zza(this.zzg);
    }

    public final boolean isAdMuted() {
        return zzej.zzf().zzx();
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzi;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final boolean isUnifiedNativeAdRequested() {
        return this.zzh.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }

    public final Map zza() {
        return this.zzj;
    }

    public final boolean zzb() {
        return this.zzh.contains("3");
    }
}

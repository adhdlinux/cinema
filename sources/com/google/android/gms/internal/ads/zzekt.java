package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class zzekt implements zzeqx {
    final zzfai zza;
    private final long zzb;

    public zzekt(zzfai zzfai, long j2) {
        Preconditions.checkNotNull(zzfai, "the targeting must not be null");
        this.zza = zzfai;
        this.zzb = j2;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Bundle bundle = (Bundle) obj;
        zzl zzl = this.zza.zzd;
        bundle.putInt("http_timeout_millis", zzl.zzw);
        bundle.putString("slotname", this.zza.zzf);
        int i2 = this.zza.zzo.zza;
        int i3 = i2 - 1;
        if (i2 != 0) {
            boolean z8 = true;
            if (i3 == 1) {
                bundle.putBoolean("is_new_rewarded", true);
            } else if (i3 == 2) {
                bundle.putBoolean("is_rewarded_interstitial", true);
            }
            bundle.putLong("start_signals_timestamp", this.zzb);
            String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzl.zzb));
            if (zzl.zzb != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzfat.zzf(bundle, "cust_age", format, z2);
            zzfat.zzb(bundle, "extras", zzl.zzc);
            int i4 = zzl.zzd;
            if (i4 != -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzfat.zze(bundle, "cust_gender", i4, z3);
            zzfat.zzd(bundle, "kw", zzl.zze);
            int i5 = zzl.zzg;
            if (i5 != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzfat.zze(bundle, "tag_for_child_directed_treatment", i5, z4);
            if (zzl.zzf) {
                bundle.putBoolean("test_request", true);
            }
            if (zzl.zza < 2 || !zzl.zzh) {
                z5 = false;
            } else {
                z5 = true;
            }
            zzfat.zze(bundle, "d_imp_hdr", 1, z5);
            String str = zzl.zzi;
            if (zzl.zza < 2 || TextUtils.isEmpty(str)) {
                z6 = false;
            } else {
                z6 = true;
            }
            zzfat.zzf(bundle, "ppid", str, z6);
            Location location = zzl.zzk;
            if (location != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putFloat("radius", location.getAccuracy() * 1000.0f);
                bundle2.putLong("lat", (long) (location.getLatitude() * 1.0E7d));
                bundle2.putLong("long", (long) (1.0E7d * location.getLongitude()));
                bundle2.putLong("time", location.getTime() * 1000);
                bundle.putBundle("uule", bundle2);
            }
            zzfat.zzc(bundle, ImagesContract.URL, zzl.zzl);
            zzfat.zzd(bundle, "neighboring_content_urls", zzl.zzv);
            zzfat.zzb(bundle, "custom_targeting", zzl.zzn);
            zzfat.zzd(bundle, "category_exclusions", zzl.zzo);
            zzfat.zzc(bundle, "request_agent", zzl.zzp);
            zzfat.zzc(bundle, "request_pkg", zzl.zzq);
            boolean z9 = zzl.zzr;
            if (zzl.zza >= 7) {
                z7 = true;
            } else {
                z7 = false;
            }
            zzfat.zzg(bundle, "is_designed_for_families", z9, z7);
            if (zzl.zza >= 8) {
                int i6 = zzl.zzt;
                if (i6 == -1) {
                    z8 = false;
                }
                zzfat.zze(bundle, "tag_for_under_age_of_consent", i6, z8);
                zzfat.zzc(bundle, "max_ad_content_rating", zzl.zzu);
                return;
            }
            return;
        }
        throw null;
    }
}

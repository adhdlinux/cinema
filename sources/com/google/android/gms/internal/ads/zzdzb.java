package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import java.util.regex.Pattern;

public final class zzdzb implements zzczy, zza, zzcwa, zzcvk {
    private final Context zza;
    private final zzfax zzb;
    private final zzezz zzc;
    private final zzezn zzd;
    private final zzeba zze;
    private Boolean zzf;
    private final boolean zzg = ((Boolean) zzba.zzc().zzb(zzbbm.zzgE)).booleanValue();
    private final zzfev zzh;
    private final String zzi;

    public zzdzb(Context context, zzfax zzfax, zzezz zzezz, zzezn zzezn, zzeba zzeba, zzfev zzfev, String str) {
        this.zza = context;
        this.zzb = zzfax;
        this.zzc = zzezz;
        this.zzd = zzezn;
        this.zze = zzeba;
        this.zzh = zzfev;
        this.zzi = str;
    }

    private final zzfeu zzf(String str) {
        String str2;
        zzfeu zzb2 = zzfeu.zzb(str);
        zzb2.zzh(this.zzc, (zzbze) null);
        zzb2.zzf(this.zzd);
        zzb2.zza("request_id", this.zzi);
        if (!this.zzd.zzu.isEmpty()) {
            zzb2.zza("ancn", (String) this.zzd.zzu.get(0));
        }
        if (this.zzd.zzaj) {
            if (true != zzt.zzo().zzx(this.zza)) {
                str2 = "offline";
            } else {
                str2 = "online";
            }
            zzb2.zza("device_connectivity", str2);
            zzb2.zza("event_timestamp", String.valueOf(zzt.zzB().currentTimeMillis()));
            zzb2.zza("offline_ad", "1");
        }
        return zzb2;
    }

    private final void zzg(zzfeu zzfeu) {
        if (this.zzd.zzaj) {
            this.zze.zzd(new zzebc(zzt.zzB().currentTimeMillis(), this.zzc.zzb.zzb.zzb, this.zzh.zza(zzfeu), 2));
            return;
        }
        this.zzh.zzb(zzfeu);
    }

    private final boolean zzh() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    String str = (String) zzba.zzc().zzb(zzbbm.zzbp);
                    zzt.zzp();
                    String zzn = zzs.zzn(this.zza);
                    boolean z2 = false;
                    if (!(str == null || zzn == null)) {
                        try {
                            z2 = Pattern.matches(str, zzn);
                        } catch (RuntimeException e2) {
                            zzt.zzo().zzu(e2, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzf = Boolean.valueOf(z2);
                }
            }
        }
        return this.zzf.booleanValue();
    }

    public final void onAdClicked() {
        if (this.zzd.zzaj) {
            zzg(zzf("click"));
        }
    }

    public final void zza(zze zze2) {
        zze zze3;
        if (this.zzg) {
            int i2 = zze2.zza;
            String str = zze2.zzb;
            if (zze2.zzc.equals(MobileAds.ERROR_DOMAIN) && (zze3 = zze2.zzd) != null && !zze3.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                zze zze4 = zze2.zzd;
                i2 = zze4.zza;
                str = zze4.zzb;
            }
            String zza2 = this.zzb.zza(str);
            zzfeu zzf2 = zzf("ifts");
            zzf2.zza("reason", "adapter");
            if (i2 >= 0) {
                zzf2.zza("arec", String.valueOf(i2));
            }
            if (zza2 != null) {
                zzf2.zza("areec", zza2);
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzb() {
        if (this.zzg) {
            zzfev zzfev = this.zzh;
            zzfeu zzf2 = zzf("ifts");
            zzf2.zza("reason", "blocked");
            zzfev.zzb(zzf2);
        }
    }

    public final void zzc(zzdev zzdev) {
        if (this.zzg) {
            zzfeu zzf2 = zzf("ifts");
            zzf2.zza("reason", "exception");
            if (!TextUtils.isEmpty(zzdev.getMessage())) {
                zzf2.zza("msg", zzdev.getMessage());
            }
            this.zzh.zzb(zzf2);
        }
    }

    public final void zzd() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_shown"));
        }
    }

    public final void zze() {
        if (zzh()) {
            this.zzh.zzb(zzf("adapter_impression"));
        }
    }

    public final void zzl() {
        if (zzh() || this.zzd.zzaj) {
            zzg(zzf("impression"));
        }
    }
}

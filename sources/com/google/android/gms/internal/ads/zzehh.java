package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.Iterator;

public final class zzehh implements zzecc {
    private final zzece zza;
    private final zzeci zzb;
    private final zzfel zzc;
    private final zzfwn zzd;

    public zzehh(zzfel zzfel, zzfwn zzfwn, zzece zzece, zzeci zzeci) {
        this.zzc = zzfel;
        this.zzd = zzfwn;
        this.zzb = zzeci;
        this.zza = zzece;
    }

    static final String zze(String str, int i2) {
        return "Error from: " + str + ", code: " + i2;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzecf zzecf;
        Iterator it2 = zzezn.zzu.iterator();
        while (true) {
            if (!it2.hasNext()) {
                zzecf = null;
                break;
            }
            try {
                zzecf = this.zza.zza((String) it2.next(), zzezn.zzw);
                break;
            } catch (zzfan unused) {
            }
        }
        if (zzecf == null) {
            return zzfwc.zzg(new zzefe("Unable to instantiate mediation adapter class."));
        }
        zzcaj zzcaj = new zzcaj();
        zzecf.zzc.zza(new zzehg(this, zzecf, zzcaj));
        if (zzezn.zzN) {
            Bundle bundle = zzezz.zza.zza.zzd.zzm;
            Class<AdMobAdapter> cls = AdMobAdapter.class;
            Bundle bundle2 = bundle.getBundle(cls.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(cls.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfel zzfel = this.zzc;
        return zzfdv.zzd(new zzehe(this, zzezz, zzezn, zzecf), this.zzd, zzfef.ADAPTER_LOAD_AD_SYN, zzfel).zzb(zzfef.ADAPTER_LOAD_AD_ACK).zzd(zzcaj).zzb(zzfef.ADAPTER_WRAP_ADAPTER).zze(new zzehf(this, zzezz, zzezn, zzecf)).zza();
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        return !zzezn.zzu.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzezz zzezz, zzezn zzezn, zzecf zzecf, Void voidR) throws Exception {
        return this.zzb.zza(zzezz, zzezn, zzecf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws Exception {
        this.zzb.zzb(zzezz, zzezn, zzecf);
    }
}

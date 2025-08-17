package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.zzl;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class zzefh implements zzecc {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzezn zzezn2 = zzezn;
        String optString = zzezn2.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfai zzfai = zzezz.zza.zza;
        zzfag zzfag = new zzfag();
        zzfag.zzp(zzfai);
        zzfag.zzs(optString);
        Bundle zzd = zzd(zzfai.zzd.zzm);
        Bundle zzd2 = zzd(zzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        zzd2.putInt("gw", 1);
        String optString2 = zzezn2.zzw.optString("mad_hac", (String) null);
        if (optString2 != null) {
            zzd2.putString("mad_hac", optString2);
        }
        String optString3 = zzezn2.zzw.optString("adJson", (String) null);
        if (optString3 != null) {
            zzd2.putString("_ad", optString3);
        }
        zzd2.putBoolean("_noRefresh", true);
        Iterator<String> keys = zzezn2.zzE.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString4 = zzezn2.zzE.optString(next, (String) null);
            if (next != null) {
                zzd2.putString(next, optString4);
            }
        }
        zzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzd2);
        zzl zzl = zzfai.zzd;
        zzl zzl2 = r5;
        zzl zzl3 = new zzl(zzl.zza, zzl.zzb, zzd2, zzl.zzd, zzl.zze, zzl.zzf, zzl.zzg, zzl.zzh, zzl.zzi, zzl.zzj, zzl.zzk, zzl.zzl, zzd, zzl.zzn, zzl.zzo, zzl.zzp, zzl.zzq, zzl.zzr, zzl.zzs, zzl.zzt, zzl.zzu, zzl.zzv, zzl.zzw, zzl.zzx);
        zzfag.zzE(zzl2);
        zzfai zzG = zzfag.zzG();
        Bundle bundle = new Bundle();
        zzezz zzezz2 = zzezz;
        zzezq zzezq = zzezz2.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList(zzezq.zza));
        bundle2.putInt("refresh_interval", zzezq.zzc);
        bundle2.putString("gws_query_id", zzezq.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzezz2.zza.zza.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        zzezn zzezn3 = zzezn;
        bundle3.putString("allocation_id", zzezn3.zzx);
        bundle3.putStringArrayList("click_urls", new ArrayList(zzezn3.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList(zzezn3.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList(zzezn3.zzq));
        bundle3.putStringArrayList("fill_urls", new ArrayList(zzezn3.zzn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList(zzezn3.zzh));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList(zzezn3.zzi));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList(zzezn3.zzj));
        bundle3.putString(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, zzezn3.zzk);
        bundle3.putString("valid_from_timestamp", zzezn3.zzl);
        bundle3.putBoolean("is_closable_area_disabled", zzezn3.zzQ);
        bundle3.putString("recursive_server_response_data", zzezn3.zzap);
        if (zzezn3.zzm != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzezn3.zzm.zzb);
            bundle4.putString("rb_type", zzezn3.zzm.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzG, bundle, zzezn3, zzezz2);
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        return !TextUtils.isEmpty(zzezn.zzw.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    /* access modifiers changed from: protected */
    public abstract zzfwm zzc(zzfai zzfai, Bundle bundle, zzezn zzezn, zzezz zzezz);
}

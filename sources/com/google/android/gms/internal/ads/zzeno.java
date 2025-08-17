package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;

public final class zzeno implements zzeqy {
    private final Context zza;
    private final zzfwn zzb;

    zzeno(Context context, zzfwn zzfwn) {
        this.zza = context;
        this.zzb = zzfwn;
    }

    public final int zza() {
        return 18;
    }

    public final zzfwm zzb() {
        return this.zzb.zzb(new zzenl(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzenn zzc() throws Exception {
        String str;
        Bundle bundle;
        zzt.zzp();
        Context context = this.zza;
        String str2 = "";
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzfP)).booleanValue()) {
            str = str2;
        } else {
            str = context.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzfR)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzt.zzp();
        Context context2 = this.zza;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzfQ)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i2 = 0; i2 < 4; i2++) {
                String str3 = strArr[i2];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzenn(str, str2, bundle, (zzenm) null);
    }
}

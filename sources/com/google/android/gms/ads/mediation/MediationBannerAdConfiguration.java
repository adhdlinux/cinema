package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;

public class MediationBannerAdConfiguration extends MediationAdConfiguration {
    private final AdSize zza;

    public MediationBannerAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z2, Location location, int i2, int i3, String str2, AdSize adSize, String str3) {
        super(context, str, bundle, bundle2, z2, location, i2, i3, str2, str3);
        this.zza = adSize;
    }

    public AdSize getAdSize() {
        return this.zza;
    }
}

package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzbef;

public class MediationNativeAdConfiguration extends MediationAdConfiguration {
    private final zzbef zza;

    public MediationNativeAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z2, Location location, int i2, int i3, String str2, String str3, zzbef zzbef) {
        super(context, str, bundle, bundle2, z2, location, i2, i3, str2, str3);
        this.zza = zzbef;
    }

    public NativeAdOptions getNativeAdOptions() {
        return zzbef.zza(this.zza);
    }
}

package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;

public final class zzk {
    private final zzam zza;
    private final zzv zzb;
    private final zzba zzc;

    public zzk(zzam zzam, zzv zzv, zzba zzba) {
        this.zza = zzam;
        this.zzb = zzv;
        this.zzc = zzba;
    }

    public final int getConsentStatus() {
        return this.zza.zza();
    }

    public final boolean isConsentFormAvailable() {
        return this.zzc.zzc();
    }

    public final void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zzb.zzc(activity, consentRequestParameters, consentInformation$OnConsentInfoUpdateSuccessListener, consentInformation$OnConsentInfoUpdateFailureListener);
    }

    public final void reset() {
        this.zzc.zzb((zzbc) null);
        this.zza.zzd();
    }
}

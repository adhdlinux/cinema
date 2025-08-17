package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;

public final /* synthetic */ class zzr implements Runnable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ ConsentInformation$OnConsentInfoUpdateSuccessListener zzb;

    public /* synthetic */ zzr(zzv zzv, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener) {
        this.zza = zzv;
    }

    public final void run() {
        this.zza.zza((ConsentInformation$OnConsentInfoUpdateSuccessListener) null);
    }
}

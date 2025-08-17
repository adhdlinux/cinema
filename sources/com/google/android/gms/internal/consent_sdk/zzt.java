package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;

public final /* synthetic */ class zzt implements Runnable {
    public final /* synthetic */ ConsentInformation$OnConsentInfoUpdateFailureListener zza;
    public final /* synthetic */ zzj zzb;

    public /* synthetic */ zzt(ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener, zzj zzj) {
        this.zzb = zzj;
    }

    public final void run() {
        this.zzb.zza();
        throw null;
    }
}

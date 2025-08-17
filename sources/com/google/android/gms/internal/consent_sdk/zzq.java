package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateFailureListener;
import com.google.android.ump.ConsentInformation$OnConsentInfoUpdateSuccessListener;
import com.google.android.ump.ConsentRequestParameters;

public final /* synthetic */ class zzq implements Runnable {
    public final /* synthetic */ zzv zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ ConsentRequestParameters zzc;
    public final /* synthetic */ ConsentInformation$OnConsentInfoUpdateSuccessListener zzd;
    public final /* synthetic */ ConsentInformation$OnConsentInfoUpdateFailureListener zze;

    public /* synthetic */ zzq(zzv zzv, Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation$OnConsentInfoUpdateSuccessListener consentInformation$OnConsentInfoUpdateSuccessListener, ConsentInformation$OnConsentInfoUpdateFailureListener consentInformation$OnConsentInfoUpdateFailureListener) {
        this.zza = zzv;
        this.zzb = activity;
    }

    public final void run() {
        this.zza.zzb(this.zzb, (ConsentRequestParameters) null, (ConsentInformation$OnConsentInfoUpdateSuccessListener) null, (ConsentInformation$OnConsentInfoUpdateFailureListener) null);
    }
}

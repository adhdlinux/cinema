package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;

final class zzax implements UserMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener {
    private final UserMessagingPlatform$OnConsentFormLoadSuccessListener zza;
    private final UserMessagingPlatform$OnConsentFormLoadFailureListener zzb;

    /* synthetic */ zzax(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener, zzav zzav) {
        this.zza = userMessagingPlatform$OnConsentFormLoadSuccessListener;
        this.zzb = userMessagingPlatform$OnConsentFormLoadFailureListener;
    }

    public final void onConsentFormLoadFailure(FormError formError) {
        this.zzb.onConsentFormLoadFailure(formError);
    }

    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        this.zza.onConsentFormLoadSuccess(consentForm);
    }
}

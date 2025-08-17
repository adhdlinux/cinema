package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadFailureListener;
import com.google.android.ump.UserMessagingPlatform$OnConsentFormLoadSuccessListener;
import java.util.concurrent.atomic.AtomicReference;

public final class zzba {
    private final zzcl<zzas> zza;
    private final AtomicReference<zzbc> zzb = new AtomicReference<>();

    zzba(zzcl<zzas> zzcl) {
        this.zza = zzcl;
    }

    public final void zza(UserMessagingPlatform$OnConsentFormLoadSuccessListener userMessagingPlatform$OnConsentFormLoadSuccessListener, UserMessagingPlatform$OnConsentFormLoadFailureListener userMessagingPlatform$OnConsentFormLoadFailureListener) {
        zzcd.zza();
        zzbc zzbc = this.zzb.get();
        if (zzbc == null) {
            userMessagingPlatform$OnConsentFormLoadFailureListener.onConsentFormLoadFailure(new zzj(3, "No available form can be built.").zza());
            return;
        }
        zzas zzb2 = this.zza.zzb();
        zzb2.zza(zzbc);
        zzb2.zzb().zza().zzb(userMessagingPlatform$OnConsentFormLoadSuccessListener, userMessagingPlatform$OnConsentFormLoadFailureListener);
    }

    public final void zzb(zzbc zzbc) {
        this.zzb.set(zzbc);
    }

    public final boolean zzc() {
        if (this.zzb.get() != null) {
            return true;
        }
        return false;
    }
}

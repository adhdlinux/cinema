package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    private final int zza;

    GooglePlayServicesAvailabilityException(int i2, String str, Intent intent) {
        super(str, intent);
        this.zza = i2;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}

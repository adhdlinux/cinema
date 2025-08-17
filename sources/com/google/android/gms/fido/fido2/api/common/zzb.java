package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;

final class zzb implements Parcelable.Creator {
    zzb() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return AttestationConveyancePreference.fromString(parcel.readString());
        } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new AttestationConveyancePreference[i2];
    }
}

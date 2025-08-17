package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaw implements Parcelable.Creator {
    zzaw() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return zzay.zza(parcel.readString());
        } catch (zzax e2) {
            throw new RuntimeException(e2);
        }
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzay[i2];
    }
}

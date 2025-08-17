package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;

final class zzp implements Parcelable.Creator {
    zzp() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return COSEAlgorithmIdentifier.fromCoseValue(parcel.readInt());
        } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new COSEAlgorithmIdentifier[i2];
    }
}

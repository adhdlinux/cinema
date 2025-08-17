package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;

final class zzw implements Parcelable.Creator {
    zzw() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        try {
            return ErrorCode.toErrorCode(parcel.readInt());
        } catch (ErrorCode.UnsupportedErrorCodeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ErrorCode[i2];
    }
}

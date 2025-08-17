package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class zzv implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j2 = Long.MAX_VALUE;
        String str = null;
        zzd zzd = null;
        int i2 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                j2 = SafeParcelReader.readLong(parcel, readHeader);
            } else if (fieldId == 2) {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId != 5) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new LastLocationRequest(j2, i2, z2, str, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LastLocationRequest[i2];
    }
}

package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zbb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                z2 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 2) {
                z3 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 3) {
                z4 = SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                i3 = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 1000) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i2 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new CredentialPickerConfig(i2, z2, z3, z4, i3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CredentialPickerConfig[i2];
    }
}

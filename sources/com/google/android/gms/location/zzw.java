package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzw implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j2 = 0;
        zzac[] zzacArr = null;
        int i2 = 1000;
        int i3 = 1;
        int i4 = 1;
        boolean z2 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    zzacArr = (zzac[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzac.CREATOR);
                    break;
                case 6:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new LocationAvailability(i2, i3, i4, j2, zzacArr, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationAvailability[i2];
    }
}

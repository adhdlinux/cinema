package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String[] strArr = null;
        long j2 = 0;
        long j3 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 6:
                    strArr = SafeParcelReader.createStringArray(parcel2, readHeader);
                    break;
                case 7:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 8:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new AdBreakInfo(j2, str, j3, z2, strArr, z3, z4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new AdBreakInfo[i2];
    }
}

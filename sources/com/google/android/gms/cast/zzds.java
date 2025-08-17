package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzds implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 6:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i7 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i8 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    i9 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new TextTrackStyle(f2, i2, i3, i4, i5, i6, i7, i8, str, i9, i10, str2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new TextTrackStyle[i2];
    }
}

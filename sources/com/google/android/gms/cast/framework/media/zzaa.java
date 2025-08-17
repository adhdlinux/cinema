package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzaa implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<String> arrayList = null;
        int[] iArr = null;
        String str = null;
        IBinder iBinder = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 3:
                    iArr = SafeParcelReader.createIntArray(parcel2, readHeader);
                    break;
                case 4:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 10:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 11:
                    i7 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 12:
                    i8 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    i9 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    i10 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 15:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 17:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 18:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 19:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 20:
                    i16 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 21:
                    i17 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 22:
                    i18 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 23:
                    i19 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 24:
                    i20 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 25:
                    i21 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 26:
                    i22 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 27:
                    i23 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 28:
                    i24 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 29:
                    i25 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 30:
                    i26 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 31:
                    i27 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 32:
                    i28 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 33:
                    iBinder = SafeParcelReader.readIBinder(parcel2, readHeader);
                    break;
                case 34:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 35:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new NotificationOptions(arrayList, iArr, j2, str, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, iBinder, z2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new NotificationOptions[i2];
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzbwq implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbwp(str, str2, z2, z3, arrayList, z4, z5, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbwp[i2];
    }
}

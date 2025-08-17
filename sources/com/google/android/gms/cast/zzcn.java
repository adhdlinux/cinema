package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzcn implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        ArrayList<String> arrayList = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 10:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaTrack(j2, i2, str2, str3, str4, str5, i3, arrayList, CastUtils.jsonStringToJsonObject(str));
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MediaTrack[i2];
    }
}

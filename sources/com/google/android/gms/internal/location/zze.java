package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zze implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        List zzk = zzds.zzk();
        String str = null;
        String str2 = null;
        String str3 = null;
        zzd zzd = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i3 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                case 8:
                    zzk = SafeParcelReader.createTypedList(parcel, readHeader, Feature.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzd(i2, i3, str, str2, str3, i4, zzk, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzd[i2];
    }
}

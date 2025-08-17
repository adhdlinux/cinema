package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzac implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        zzav zzav = null;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 3:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 4:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) SafeParcelReader.createParcelable(parcel2, readHeader, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    zzav = (zzav) SafeParcelReader.createParcelable(parcel2, readHeader, zzav.CREATOR);
                    break;
                case 8:
                    d3 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzab(d2, z2, i2, applicationMetadata, i3, zzav, d3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzab[i2];
    }
}

package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class zzj implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        long j2 = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        String str = null;
        zzd zzd = null;
        int i2 = 0;
        int i3 = 102;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 2:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 6:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel2, readHeader, WorkSource.CREATOR);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel2, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CurrentLocationRequest(j2, i2, i3, j3, z2, i4, str, workSource, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CurrentLocationRequest[i2];
    }
}

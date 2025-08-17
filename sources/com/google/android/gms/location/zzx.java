package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzd;

public final class zzx implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        long j2 = 3600000;
        long j3 = 600000;
        long j4 = 0;
        long j5 = Long.MAX_VALUE;
        long j6 = Long.MAX_VALUE;
        long j7 = -1;
        String str = null;
        zzd zzd = null;
        int i2 = 102;
        int i3 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        boolean z2 = false;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    j5 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 8:
                    j4 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 9:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    j6 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 11:
                    j7 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 13:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 15:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel2, readHeader, WorkSource.CREATOR);
                    break;
                case 17:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel2, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new LocationRequest(i2, j2, j3, j4, j5, j6, i3, f2, z2, j7, i4, i5, str, z3, workSource, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationRequest[i2];
    }
}

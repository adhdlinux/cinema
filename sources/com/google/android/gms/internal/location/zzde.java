package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public final class zzde implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LocationRequest locationRequest = null;
        ArrayList<ClientIdentity> arrayList = null;
        String str = null;
        String str2 = null;
        long j2 = Long.MAX_VALUE;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel2, readHeader, LocationRequest.CREATOR);
            } else if (fieldId != 5) {
                switch (fieldId) {
                    case 8:
                        z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 9:
                        z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 10:
                        str = SafeParcelReader.createString(parcel2, readHeader);
                        break;
                    case 11:
                        z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 12:
                        z5 = SafeParcelReader.readBoolean(parcel2, readHeader);
                        break;
                    case 13:
                        str2 = SafeParcelReader.createString(parcel2, readHeader);
                        break;
                    case 14:
                        j2 = SafeParcelReader.readLong(parcel2, readHeader);
                        break;
                    default:
                        SafeParcelReader.skipUnknownField(parcel2, readHeader);
                        break;
                }
            } else {
                arrayList = SafeParcelReader.createTypedList(parcel2, readHeader, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzdd(locationRequest, arrayList, z2, z3, str, z4, z5, str2, j2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzdd[i2];
    }
}

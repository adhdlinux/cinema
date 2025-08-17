package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzn implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzfh zzfh = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzc zzc = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        String str6 = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
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
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 4:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 6:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    zzfh = (zzfh) SafeParcelReader.createParcelable(parcel2, readHeader, zzfh.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.createParcelable(parcel2, readHeader, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 16:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 18:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    zzc = (zzc) SafeParcelReader.createParcelable(parcel2, readHeader, zzc.CREATOR);
                    break;
                case 20:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 22:
                    arrayList3 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 23:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 24:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzl(i2, j2, bundle, i3, arrayList, z2, i4, z3, str, zzfh, location, str2, bundle2, bundle3, arrayList2, str3, str4, z4, zzc, i5, str5, arrayList3, i6, str6);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzl[i2];
    }
}

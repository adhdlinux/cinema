package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzf implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        ArrayList<String> arrayList = null;
        LaunchOptions launchOptions = null;
        CastMediaOptions castMediaOptions = null;
        ArrayList<String> arrayList2 = null;
        double d2 = 0.0d;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i2 = 0;
        boolean z9 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 4:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    launchOptions = (LaunchOptions) SafeParcelReader.createParcelable(parcel2, readHeader, LaunchOptions.CREATOR);
                    break;
                case 6:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    castMediaOptions = (CastMediaOptions) SafeParcelReader.createParcelable(parcel2, readHeader, CastMediaOptions.CREATOR);
                    break;
                case 8:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 10:
                    z5 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    z6 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 12:
                    z7 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 13:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 14:
                    z8 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 15:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    z9 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new CastOptions(str, arrayList, z2, launchOptions, z3, castMediaOptions, z4, d2, z5, z6, z7, arrayList2, z8, i2, z9);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CastOptions[i2];
    }
}

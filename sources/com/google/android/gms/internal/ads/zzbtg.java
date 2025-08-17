package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzbtg implements Parcelable.Creator {
    public static final zzbtf zza(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundle = null;
        zzl zzl = null;
        zzq zzq = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzbzx zzbzx = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzbef zzbef = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzdu zzdu = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        ArrayList<String> arrayList6 = null;
        String str16 = null;
        zzbkr zzbkr = null;
        String str17 = null;
        Bundle bundle6 = null;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        boolean z4 = false;
        boolean z5 = false;
        int i8 = 0;
        boolean z6 = false;
        boolean z7 = false;
        int i9 = 0;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i2 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 3:
                    zzl = (zzl) SafeParcelReader.createParcelable(parcel2, readHeader, zzl.CREATOR);
                    break;
                case 4:
                    zzq = (zzq) SafeParcelReader.createParcelable(parcel2, readHeader, zzq.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.createParcelable(parcel2, readHeader, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.createParcelable(parcel2, readHeader, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    zzbzx = (zzbzx) SafeParcelReader.createParcelable(parcel2, readHeader, zzbzx.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 13:
                    i3 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 16:
                    z2 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    i4 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 19:
                    i5 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 20:
                    f2 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    j2 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 26:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 27:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 28:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 29:
                    zzbef = (zzbef) SafeParcelReader.createParcelable(parcel2, readHeader, zzbef.CREATOR);
                    break;
                case 30:
                    arrayList3 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 31:
                    j3 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 33:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 34:
                    f3 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 35:
                    i6 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 36:
                    i7 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 37:
                    z4 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 39:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 40:
                    z3 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 41:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 42:
                    z5 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 43:
                    i8 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 45:
                    str11 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 46:
                    zzdu = (zzdu) SafeParcelReader.createParcelable(parcel2, readHeader, zzdu.CREATOR);
                    break;
                case 47:
                    z6 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 49:
                    str12 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 50:
                    str13 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 51:
                    str14 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 52:
                    z7 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 53:
                    arrayList4 = SafeParcelReader.createIntegerList(parcel2, readHeader);
                    break;
                case 54:
                    str15 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 55:
                    arrayList5 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 56:
                    i9 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 57:
                    z8 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 58:
                    z9 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 59:
                    z10 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 60:
                    arrayList6 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 61:
                    str16 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 63:
                    zzbkr = (zzbkr) SafeParcelReader.createParcelable(parcel2, readHeader, zzbkr.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzbtf(i2, bundle, zzl, zzq, str, applicationInfo, packageInfo, str2, str3, str4, zzbzx, bundle2, i3, arrayList, bundle3, z2, i4, i5, f2, str5, j2, str6, arrayList2, str7, zzbef, arrayList3, j3, str8, f3, z3, i6, i7, z4, str9, str10, z5, i8, bundle4, str11, zzdu, z6, bundle5, str12, str13, str14, z7, arrayList4, str15, arrayList5, i9, z8, z9, z10, arrayList6, str16, zzbkr, str17, bundle6);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbtf[i2];
    }
}

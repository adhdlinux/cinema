package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

final class zzaeu implements Parcelable.Creator {
    zzaeu() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        readString.getClass();
        String readString2 = parcel.readString();
        String[] createStringArray = parcel.createStringArray();
        createStringArray.getClass();
        return new zzaev(readString, readString2, zzfsc.zzk(createStringArray));
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzaev[i2];
    }
}

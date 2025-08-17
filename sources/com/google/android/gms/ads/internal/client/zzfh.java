package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfh> CREATOR = new zzfi();
    @SafeParcelable.Field(id = 15)
    public final String zza;

    public zzfh(SearchAdRequest searchAdRequest) {
        this.zza = searchAdRequest.getQuery();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    zzfh(@SafeParcelable.Param(id = 15) String str) {
        this.zza = str;
    }
}

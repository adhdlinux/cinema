package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "IconAdOptionsParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzdu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdu> CREATOR = new zzdv();
    @SafeParcelable.Field(id = 2)
    public final int zza;

    @SafeParcelable.Constructor
    public zzdu(@SafeParcelable.Param(id = 2) int i2) {
        this.zza = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

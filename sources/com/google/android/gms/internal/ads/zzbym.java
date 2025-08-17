package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
public final class zzbym extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbym> CREATOR = new zzbyn();
    @SafeParcelable.Field(id = 1)
    @Deprecated
    public final String zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    public final zzq zzc;
    @SafeParcelable.Field(id = 4)
    public final zzl zzd;

    @SafeParcelable.Constructor
    public zzbym(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) zzq zzq, @SafeParcelable.Param(id = 4) zzl zzl) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzq;
        this.zzd = zzl;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

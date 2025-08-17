package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
public final class zzfks extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfks> CREATOR = new zzfkt();
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;
    @SafeParcelable.Field(id = 3)
    public final String zzc;
    @SafeParcelable.Field(id = 4)
    public final String zzd;
    @SafeParcelable.Field(id = 5)
    public final int zze;

    @SafeParcelable.Constructor
    zzfks(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) String str2) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = str;
        this.zzd = str2;
        this.zze = i4;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzfks(int i2, int i3, String str, String str2) {
        this(1, 1, i3 - 1, str, str2);
    }
}

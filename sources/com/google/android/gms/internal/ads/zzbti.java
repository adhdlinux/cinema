package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AdsServiceInputParcelCreator")
public final class zzbti extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbti> CREATOR = new zzbtj();
    @SafeParcelable.Field(id = 1)
    public final ApplicationInfo zza;
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @SafeParcelable.Field(id = 3)
    public final PackageInfo zzc;
    @SafeParcelable.Field(id = 4)
    public final String zzd;
    @SafeParcelable.Field(id = 5)
    public final int zze;
    @SafeParcelable.Field(id = 6)
    public final String zzf;
    @SafeParcelable.Field(id = 7)
    public final List zzg;
    @SafeParcelable.Field(id = 8)
    public final boolean zzh;
    @SafeParcelable.Field(id = 9)
    public final boolean zzi;

    @SafeParcelable.Constructor
    public zzbti(@SafeParcelable.Param(id = 1) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) PackageInfo packageInfo, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) String str3, @SafeParcelable.Param(id = 7) List list, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) boolean z3) {
        this.zzb = str;
        this.zza = applicationInfo;
        this.zzc = packageInfo;
        this.zzd = str2;
        this.zze = i2;
        this.zzf = str3;
        this.zzg = list;
        this.zzh = z2;
        this.zzi = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i2, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

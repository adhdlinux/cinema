package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzy();
    @SafeParcelable.VersionField(id = 1)
    final int zza;
    @SafeParcelable.Field(getter = "isLockScreenSolved", id = 2)
    private boolean zzb;
    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", id = 3)
    private long zzc;
    @SafeParcelable.Field(getter = "isChallengeAllowed", id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    DeviceMetaData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) long j2, @SafeParcelable.Param(id = 4) boolean z3) {
        this.zza = i2;
        this.zzb = z2;
        this.zzc = j2;
        this.zzd = z3;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzc;
    }

    public boolean isChallengeAllowed() {
        return this.zzd;
    }

    public boolean isLockScreenSolved() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

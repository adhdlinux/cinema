package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.UUID;

public final class zzac implements Parcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzab();
    public final UUID zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    private int zze;

    zzac(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzac)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzac zzac = (zzac) obj;
        if (!zzfj.zzC(this.zzb, zzac.zzb) || !zzfj.zzC(this.zzc, zzac.zzc) || !zzfj.zzC(this.zza, zzac.zza) || !Arrays.equals(this.zzd, zzac.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2;
        int i3 = this.zze;
        if (i3 != 0) {
            return i3;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int hashCode2 = ((((hashCode + i2) * 31) + this.zzc.hashCode()) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode2;
        return hashCode2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzac(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.zza = uuid;
        this.zzb = null;
        this.zzc = str2;
        this.zzd = bArr;
    }
}

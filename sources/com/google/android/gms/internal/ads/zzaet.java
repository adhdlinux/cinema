package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaet extends zzaen {
    public static final Parcelable.Creator<zzaet> CREATOR = new zzaes();
    public final String zza;
    public final byte[] zzb;

    zzaet(Parcel parcel) {
        super("PRIV");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaet.class == obj.getClass()) {
            zzaet zzaet = (zzaet) obj;
            if (!zzfj.zzC(this.zza, zzaet.zza) || !Arrays.equals(this.zzb, zzaet.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        String str = this.zza;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        return ((i2 + 527) * 31) + Arrays.hashCode(this.zzb);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        return str + ": owner=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzaet(String str, byte[] bArr) {
        super("PRIV");
        this.zza = str;
        this.zzb = bArr;
    }
}

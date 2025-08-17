package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzady extends zzaen {
    public static final Parcelable.Creator<zzady> CREATOR = new zzadx();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzady(Parcel parcel) {
        super("APIC");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzady.class == obj.getClass()) {
            zzady zzady = (zzady) obj;
            if (this.zzc != zzady.zzc || !zzfj.zzC(this.zza, zzady.zza) || !zzfj.zzC(this.zzb, zzady.zzb) || !Arrays.equals(this.zzd, zzady.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3 = this.zzc + 527;
        String str = this.zza;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = i3 * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((((i5 + i2) * 31) + i4) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        return str + ": mimeType=" + str2 + ", description=" + str3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzbt zzbt) {
        zzbt.zza(this.zzd, this.zzc);
    }

    public zzady(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.zza = str;
        this.zzb = str2;
        this.zzc = i2;
        this.zzd = bArr;
    }
}

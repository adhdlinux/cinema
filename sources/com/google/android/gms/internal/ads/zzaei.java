package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaei extends zzaen {
    public static final Parcelable.Creator<zzaei> CREATOR = new zzaeh();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    zzaei(Parcel parcel) {
        super("GEOB");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaei.class == obj.getClass()) {
            zzaei zzaei = (zzaei) obj;
            if (!zzfj.zzC(this.zza, zzaei.zza) || !zzfj.zzC(this.zzb, zzaei.zzb) || !zzfj.zzC(this.zzc, zzaei.zzc) || !Arrays.equals(this.zzd, zzaei.zzd)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        String str = this.zza;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i5 = i2 + 527;
        String str3 = this.zzc;
        if (str3 != null) {
            i4 = str3.hashCode();
        }
        return (((((i5 * 31) + i3) * 31) + i4) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = this.zzc;
        return str + ": mimeType=" + str2 + ", filename=" + str3 + ", description=" + str4;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzaei(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}

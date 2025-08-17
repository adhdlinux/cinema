package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzadw implements zzby {
    public static final Parcelable.Creator<zzadw> CREATOR = new zzadv();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzadw(int i2, String str, String str2, String str3, boolean z2, int i3) {
        boolean z3 = true;
        if (i3 != -1 && i3 <= 0) {
            z3 = false;
        }
        zzdy.zzd(z3);
        this.zza = i2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z2;
        this.zzf = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadw.class == obj.getClass()) {
            zzadw zzadw = (zzadw) obj;
            if (this.zza != zzadw.zza || !zzfj.zzC(this.zzb, zzadw.zzb) || !zzfj.zzC(this.zzc, zzadw.zzc) || !zzfj.zzC(this.zzd, zzadw.zzd) || this.zze != zzadw.zze || this.zzf != zzadw.zzf) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int i4 = this.zza + 527;
        String str = this.zzb;
        int i5 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = i4 * 31;
        String str2 = this.zzc;
        if (str2 != null) {
            i3 = str2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (((i6 + i2) * 31) + i3) * 31;
        String str3 = this.zzd;
        if (str3 != null) {
            i5 = str3.hashCode();
        }
        return ((((i7 + i5) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zzb;
        int i2 = this.zza;
        int i3 = this.zzf;
        return "IcyHeaders: name=\"" + str + "\", genre=\"" + str2 + "\", bitrate=" + i2 + ", metadataInterval=" + i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        boolean z2 = this.zze;
        int i3 = zzfj.zza;
        parcel.writeInt(z2 ? 1 : 0);
        parcel.writeInt(this.zzf);
    }

    public final void zza(zzbt zzbt) {
        String str = this.zzc;
        if (str != null) {
            zzbt.zzp(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzbt.zzi(str2);
        }
    }

    zzadw(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        int i2 = zzfj.zza;
        this.zze = parcel.readInt() != 0;
        this.zzf = parcel.readInt();
    }
}

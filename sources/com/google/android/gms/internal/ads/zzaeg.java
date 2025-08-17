package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzaeg extends zzaen {
    public static final Parcelable.Creator<zzaeg> CREATOR = new zzaef();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzaeg(Parcel parcel) {
        super("COMM");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaeg.class == obj.getClass()) {
            zzaeg zzaeg = (zzaeg) obj;
            if (!zzfj.zzC(this.zzb, zzaeg.zzb) || !zzfj.zzC(this.zza, zzaeg.zza) || !zzfj.zzC(this.zzc, zzaeg.zzc)) {
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
        return (((i5 * 31) + i3) * 31) + i4;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zza;
        String str3 = this.zzb;
        return str + ": language=" + str2 + ", description=" + str3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzaeg(String str, String str2, String str3) {
        super("COMM");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}

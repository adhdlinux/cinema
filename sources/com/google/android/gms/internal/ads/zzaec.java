package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzaec extends zzaen {
    public static final Parcelable.Creator<zzaec> CREATOR = new zzaeb();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzaen[] zzg;

    zzaec(Parcel parcel) {
        super("CHAP");
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzg = new zzaen[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            this.zzg[i3] = (zzaen) parcel.readParcelable(zzaen.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaec.class == obj.getClass()) {
            zzaec zzaec = (zzaec) obj;
            if (this.zzb == zzaec.zzb && this.zzc == zzaec.zzc && this.zzd == zzaec.zzd && this.zze == zzaec.zze && zzfj.zzC(this.zza, zzaec.zza) && Arrays.equals(this.zzg, zzaec.zzg)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = ((this.zzb + 527) * 31) + this.zzc;
        int i3 = (int) this.zzd;
        int i4 = (int) this.zze;
        String str = this.zza;
        return (((((i2 * 31) + i3) * 31) + i4) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzaen writeParcelable : this.zzg) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzaec(String str, int i2, int i3, long j2, long j3, zzaen[] zzaenArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j2;
        this.zze = j3;
        this.zzg = zzaenArr;
    }
}

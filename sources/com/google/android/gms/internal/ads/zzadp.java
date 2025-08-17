package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzadp implements zzby {
    public static final Parcelable.Creator<zzadp> CREATOR = new zzado();
    private static final zzam zzf;
    private static final zzam zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzak zzak = new zzak();
        zzak.zzS("application/id3");
        zzf = zzak.zzY();
        zzak zzak2 = new zzak();
        zzak2.zzS("application/x-scte35");
        zzg = zzak2.zzY();
    }

    zzadp(Parcel parcel) {
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.createByteArray();
    }

    public zzadp(String str, String str2, long j2, long j3, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadp.class == obj.getClass()) {
            zzadp zzadp = (zzadp) obj;
            if (this.zzc != zzadp.zzc || this.zzd != zzadp.zzd || !zzfj.zzC(this.zza, zzadp.zza) || !zzfj.zzC(this.zzb, zzadp.zzb) || !Arrays.equals(this.zze, zzadp.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3 = this.zzh;
        if (i3 != 0) {
            return i3;
        }
        String str = this.zza;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        long j2 = this.zzc;
        long j3 = this.zzd;
        int hashCode = ((((((((i2 + 527) * 31) + i4) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.zze);
        this.zzh = hashCode;
        return hashCode;
    }

    public final String toString() {
        String str = this.zza;
        long j2 = this.zzd;
        long j3 = this.zzc;
        String str2 = this.zzb;
        return "EMSG: scheme=" + str + ", id=" + j2 + ", durationMs=" + j3 + ", value=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}

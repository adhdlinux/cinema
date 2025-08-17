package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzads implements zzby {
    public static final Parcelable.Creator<zzads> CREATOR = new zzadr();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzads(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = bArr;
    }

    zzads(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i2 = zzfj.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }

    public static zzads zzb(zzfa zzfa) {
        int zze2 = zzfa.zze();
        String zzx = zzfa.zzx(zzfa.zze(), zzfot.zza);
        String zzx2 = zzfa.zzx(zzfa.zze(), zzfot.zzc);
        int zze3 = zzfa.zze();
        int zze4 = zzfa.zze();
        int zze5 = zzfa.zze();
        int zze6 = zzfa.zze();
        int zze7 = zzfa.zze();
        byte[] bArr = new byte[zze7];
        zzfa.zzB(bArr, 0, zze7);
        return new zzads(zze2, zzx, zzx2, zze3, zze4, zze5, zze6, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzads.class == obj.getClass()) {
            zzads zzads = (zzads) obj;
            if (this.zza == zzads.zza && this.zzb.equals(zzads.zzb) && this.zzc.equals(zzads.zzc) && this.zzd == zzads.zzd && this.zze == zzads.zze && this.zzf == zzads.zzf && this.zzg == zzads.zzg && Arrays.equals(this.zzh, zzads.zzh)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        return "Picture: mimeType=" + str + ", description=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzbt zzbt) {
        zzbt.zza(this.zzh, this.zza);
    }
}

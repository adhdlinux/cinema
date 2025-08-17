package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzaex extends zzaen {
    public static final Parcelable.Creator<zzaex> CREATOR = new zzaew();
    public final String zza;
    public final String zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzaex(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzfj.zza
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.zza = r0
            java.lang.String r3 = r3.readString()
            r2.zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaex.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaex.class == obj.getClass()) {
            zzaex zzaex = (zzaex) obj;
            if (!this.zzf.equals(zzaex.zzf) || !zzfj.zzC(this.zza, zzaex.zza) || !zzfj.zzC(this.zzb, zzaex.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int hashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        int i3 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i4 = hashCode * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((i4 + i2) * 31) + i3;
    }

    public final String toString() {
        String str = this.zzf;
        String str2 = this.zzb;
        return str + ": url=" + str2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzaex(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}

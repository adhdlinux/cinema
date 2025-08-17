package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbzx> CREATOR = new zzbzy();
    @SafeParcelable.Field(id = 2)
    public String zza;
    @SafeParcelable.Field(id = 3)
    public int zzb;
    @SafeParcelable.Field(id = 4)
    public int zzc;
    @SafeParcelable.Field(id = 5)
    public boolean zzd;
    @SafeParcelable.Field(id = 6)
    public boolean zze;

    public zzbzx(int i2, int i3, boolean z2, boolean z3) {
        this((int) ModuleDescriptor.MODULE_VERSION, i3, true, false, z3);
    }

    public static zzbzx zza() {
        return new zzbzx((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, (int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, true, false, false);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzbzx(int r9, int r10, boolean r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            if (r11 == 0) goto L_0x0005
            java.lang.String r12 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r12 = "1"
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "afma-sdk-a-v"
            r0.append(r1)
            r0.append(r9)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r10)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r3 = r0.toString()
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r13
            r2.<init>((java.lang.String) r3, (int) r4, (int) r5, (boolean) r6, (boolean) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzx.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    zzbzx(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z2;
        this.zze = z3;
    }
}

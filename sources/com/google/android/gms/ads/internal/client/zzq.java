package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(id = 2)
    public final String zza;
    @SafeParcelable.Field(id = 3)
    public final int zzb;
    @SafeParcelable.Field(id = 4)
    public final int zzc;
    @SafeParcelable.Field(id = 5)
    public final boolean zzd;
    @SafeParcelable.Field(id = 6)
    public final int zze;
    @SafeParcelable.Field(id = 7)
    public final int zzf;
    @SafeParcelable.Field(id = 8)
    public final zzq[] zzg;
    @SafeParcelable.Field(id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(id = 11)
    public boolean zzj;
    @SafeParcelable.Field(id = 12)
    public boolean zzk;
    @SafeParcelable.Field(id = 13)
    public boolean zzl;
    @SafeParcelable.Field(id = 14)
    public boolean zzm;
    @SafeParcelable.Field(id = 15)
    public boolean zzn;
    @SafeParcelable.Field(id = 16)
    public boolean zzo;

    public zzq() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzq[]) null, false, false, false, false, false, false, false, false);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return (int) (((float) zzf(displayMetrics)) * displayMetrics.density);
    }

    public static zzq zzb() {
        return new zzq("interstitial_mb", 0, 0, false, 0, 0, (zzq[]) null, false, false, false, false, true, false, false, false);
    }

    public static zzq zzc() {
        return new zzq("320x50_mb", 0, 0, false, 0, 0, (zzq[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzq zzd() {
        return new zzq("reward_mb", 0, 0, true, 0, 0, (zzq[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzq zze() {
        return new zzq(Constants.COLLATION_INVALID, 0, 0, false, 0, 0, (zzq[]) null, false, false, false, true, false, false, false, false);
    }

    private static int zzf(DisplayMetrics displayMetrics) {
        int i2 = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i2 <= 400) {
            return 32;
        }
        return i2 <= 720 ? 50 : 90;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeInt(parcel, 6, this.zze);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzg, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzl);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzq(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzq(android.content.Context r14, com.google.android.gms.ads.AdSize[] r15) {
        /*
            r13 = this;
            r13.<init>()
            r0 = 0
            r1 = r15[r0]
            r13.zzd = r0
            boolean r2 = r1.isFluid()
            r13.zzi = r2
            boolean r3 = com.google.android.gms.ads.zzb.zzf(r1)
            r13.zzm = r3
            boolean r3 = com.google.android.gms.ads.zzb.zzg(r1)
            r13.zzn = r3
            boolean r3 = com.google.android.gms.ads.zzb.zzh(r1)
            r13.zzo = r3
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.ads.AdSize r3 = com.google.android.gms.ads.AdSize.BANNER
            int r4 = r3.getWidth()
            r13.zze = r4
            int r3 = r3.getHeight()
            r13.zzb = r3
            goto L_0x005d
        L_0x0031:
            boolean r4 = r13.zzn
            if (r4 == 0) goto L_0x0042
            int r3 = r1.getWidth()
            r13.zze = r3
            int r3 = com.google.android.gms.ads.zzb.zza(r1)
            r13.zzb = r3
            goto L_0x005d
        L_0x0042:
            if (r3 == 0) goto L_0x0051
            int r3 = r1.getWidth()
            r13.zze = r3
            int r3 = com.google.android.gms.ads.zzb.zzb(r1)
            r13.zzb = r3
            goto L_0x005d
        L_0x0051:
            int r3 = r1.getWidth()
            r13.zze = r3
            int r3 = r1.getHeight()
            r13.zzb = r3
        L_0x005d:
            int r4 = r13.zze
            r5 = -1
            r6 = 1
            if (r4 != r5) goto L_0x0065
            r4 = 1
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            r5 = -2
            if (r3 != r5) goto L_0x006b
            r3 = 1
            goto L_0x006c
        L_0x006b:
            r3 = 0
        L_0x006c:
            android.content.res.Resources r5 = r14.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r4 == 0) goto L_0x0100
            com.google.android.gms.ads.internal.client.zzay.zzb()
            android.content.res.Resources r7 = r14.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            int r7 = r7.orientation
            r8 = 2
            if (r7 == r8) goto L_0x0087
            goto L_0x00e8
        L_0x0087:
            android.content.res.Resources r7 = r14.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r8 = r7.heightPixels
            float r8 = (float) r8
            float r7 = r7.density
            float r8 = r8 / r7
            int r7 = (int) r8
            r8 = 600(0x258, float:8.41E-43)
            if (r7 >= r8) goto L_0x00e8
            com.google.android.gms.ads.internal.client.zzay.zzb()
            android.content.res.Resources r7 = r14.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            java.lang.String r8 = "window"
            java.lang.Object r8 = r14.getSystemService(r8)
            android.view.WindowManager r8 = (android.view.WindowManager) r8
            if (r8 == 0) goto L_0x00e8
            android.view.Display r8 = r8.getDefaultDisplay()
            r8.getRealMetrics(r7)
            int r9 = r7.heightPixels
            int r10 = r7.widthPixels
            r8.getMetrics(r7)
            int r8 = r7.heightPixels
            int r7 = r7.widthPixels
            if (r8 != r9) goto L_0x00e8
            if (r7 != r10) goto L_0x00e8
            int r7 = r5.widthPixels
            com.google.android.gms.ads.internal.client.zzay.zzb()
            android.content.res.Resources r8 = r14.getResources()
            java.lang.String r9 = "dimen"
            java.lang.String r10 = "android"
            java.lang.String r11 = "navigation_bar_width"
            int r8 = r8.getIdentifier(r11, r9, r10)
            if (r8 <= 0) goto L_0x00e3
            android.content.res.Resources r9 = r14.getResources()
            int r8 = r9.getDimensionPixelSize(r8)
            goto L_0x00e4
        L_0x00e3:
            r8 = 0
        L_0x00e4:
            int r7 = r7 - r8
            r13.zzf = r7
            goto L_0x00ec
        L_0x00e8:
            int r7 = r5.widthPixels
            r13.zzf = r7
        L_0x00ec:
            float r8 = r5.density
            float r7 = (float) r7
            float r7 = r7 / r8
            double r7 = (double) r7
            int r9 = (int) r7
            double r10 = (double) r9
            double r7 = r7 - r10
            r10 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x010d
            int r9 = r9 + 1
            goto L_0x010d
        L_0x0100:
            int r9 = r13.zze
            com.google.android.gms.ads.internal.client.zzay.zzb()
            int r7 = r13.zze
            int r7 = com.google.android.gms.internal.ads.zzbzk.zzp(r5, r7)
            r13.zzf = r7
        L_0x010d:
            if (r3 == 0) goto L_0x0114
            int r7 = zzf(r5)
            goto L_0x0116
        L_0x0114:
            int r7 = r13.zzb
        L_0x0116:
            com.google.android.gms.ads.internal.client.zzay.zzb()
            int r5 = com.google.android.gms.internal.ads.zzbzk.zzp(r5, r7)
            r13.zzc = r5
            java.lang.String r5 = "_as"
            java.lang.String r8 = "x"
            if (r4 != 0) goto L_0x0159
            if (r3 == 0) goto L_0x0128
            goto L_0x0159
        L_0x0128:
            boolean r3 = r13.zzn
            if (r3 != 0) goto L_0x013d
            boolean r3 = r13.zzo
            if (r3 == 0) goto L_0x0131
            goto L_0x013d
        L_0x0131:
            if (r2 == 0) goto L_0x0136
            java.lang.String r1 = "320x50_mb"
            goto L_0x0156
        L_0x0136:
            java.lang.String r1 = r1.toString()
            r13.zza = r1
            goto L_0x0170
        L_0x013d:
            int r1 = r13.zze
            int r2 = r13.zzb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r1)
            r3.append(r8)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
        L_0x0156:
            r13.zza = r1
            goto L_0x0170
        L_0x0159:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r9)
            r1.append(r8)
            r1.append(r7)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r13.zza = r1
        L_0x0170:
            int r1 = r15.length
            if (r1 <= r6) goto L_0x0189
            com.google.android.gms.ads.internal.client.zzq[] r1 = new com.google.android.gms.ads.internal.client.zzq[r1]
            r13.zzg = r1
            r1 = 0
        L_0x0178:
            int r2 = r15.length
            if (r1 >= r2) goto L_0x018c
            com.google.android.gms.ads.internal.client.zzq[] r2 = r13.zzg
            com.google.android.gms.ads.internal.client.zzq r3 = new com.google.android.gms.ads.internal.client.zzq
            r4 = r15[r1]
            r3.<init>((android.content.Context) r14, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0178
        L_0x0189:
            r14 = 0
            r13.zzg = r14
        L_0x018c:
            r13.zzh = r0
            r13.zzj = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzq.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzq(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) int i4, @SafeParcelable.Param(id = 7) int i5, @SafeParcelable.Param(id = 8) zzq[] zzqArr, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 10) boolean z4, @SafeParcelable.Param(id = 11) boolean z5, @SafeParcelable.Param(id = 12) boolean z6, @SafeParcelable.Param(id = 13) boolean z7, @SafeParcelable.Param(id = 14) boolean z8, @SafeParcelable.Param(id = 15) boolean z9, @SafeParcelable.Param(id = 16) boolean z10) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = z2;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = zzqArr;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = z5;
        this.zzk = z6;
        this.zzl = z7;
        this.zzm = z8;
        this.zzn = z9;
        this.zzo = z10;
    }
}

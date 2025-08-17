package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzbef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbef> CREATOR = new zzbeg();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final boolean zzb;
    @SafeParcelable.Field(id = 3)
    public final int zzc;
    @SafeParcelable.Field(id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(id = 5)
    public final int zze;
    @SafeParcelable.Field(id = 6)
    public final zzfl zzf;
    @SafeParcelable.Field(id = 7)
    public final boolean zzg;
    @SafeParcelable.Field(id = 8)
    public final int zzh;
    @SafeParcelable.Field(id = 9)
    public final int zzi;
    @SafeParcelable.Field(id = 10)
    public final boolean zzj;

    @SafeParcelable.Constructor
    public zzbef(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) zzfl zzfl, @SafeParcelable.Param(id = 7) boolean z4, @SafeParcelable.Param(id = 8) int i5, @SafeParcelable.Param(id = 9) int i6, @SafeParcelable.Param(id = 10) boolean z5) {
        this.zza = i2;
        this.zzb = z2;
        this.zzc = i3;
        this.zzd = z3;
        this.zze = i4;
        this.zzf = zzfl;
        this.zzg = z4;
        this.zzh = i5;
        this.zzj = z5;
        this.zzi = i6;
    }

    public static NativeAdOptions zza(zzbef zzbef) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzbef == null) {
            return builder.build();
        }
        int i2 = zzbef.zza;
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbef.zzg);
                    builder.setMediaAspectRatio(zzbef.zzh);
                    builder.enableCustomClickGestureDirection(zzbef.zzi, zzbef.zzj);
                }
                builder.setReturnUrlsForImageAssets(zzbef.zzb);
                builder.setRequestMultipleImages(zzbef.zzd);
                return builder.build();
            }
            zzfl zzfl = zzbef.zzf;
            if (zzfl != null) {
                builder.setVideoOptions(new VideoOptions(zzfl));
            }
        }
        builder.setAdChoicesPlacement(zzbef.zze);
        builder.setReturnUrlsForImageAssets(zzbef.zzb);
        builder.setRequestMultipleImages(zzbef.zzd);
        return builder.build();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public zzbef(com.google.android.gms.ads.formats.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzfl(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio(), 0, false);
    }
}

package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzca;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbgh;
import com.google.android.gms.internal.ads.zzbgi;

@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
@Deprecated
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean zza;
    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzcb zzb;
    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    private final IBinder zzc;

    @Deprecated
    public static final class Builder {
        private ShouldDelayBannerRenderingListener zza;

        @KeepForSdk
        public Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zza = shouldDelayBannerRenderingListener;
            return this;
        }
    }

    @SafeParcelable.Constructor
    PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z2, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        zzcb zzcb;
        this.zza = z2;
        if (iBinder != null) {
            zzcb = zzca.zzd(iBinder);
        } else {
            zzcb = null;
        }
        this.zzb = zzcb;
        this.zzc = iBinder2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        zzcb zzcb = this.zzb;
        if (zzcb == null) {
            iBinder = null;
        } else {
            iBinder = zzcb.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzcb zza() {
        return this.zzb;
    }

    public final zzbgi zzb() {
        IBinder iBinder = this.zzc;
        if (iBinder == null) {
            return null;
        }
        return zzbgh.zzc(iBinder);
    }

    public final boolean zzc() {
        return this.zza;
    }
}

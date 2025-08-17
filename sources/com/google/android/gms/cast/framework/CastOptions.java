package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.cast.zzeq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "CastOptionsCreator")
@SafeParcelable.Reserved({1})
public class CastOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CastOptions> CREATOR = new zzf();
    @SafeParcelable.Field(getter = "getReceiverApplicationId", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getSupportedNamespaces", id = 3)
    private final List zzb;
    @SafeParcelable.Field(getter = "getStopReceiverApplicationWhenEndingSession", id = 4)
    private final boolean zzc;
    @SafeParcelable.Field(getter = "getLaunchOptions", id = 5)
    private LaunchOptions zzd;
    @SafeParcelable.Field(getter = "getResumeSavedSession", id = 6)
    private final boolean zze;
    @SafeParcelable.Field(getter = "getCastMediaOptions", id = 7)
    private final CastMediaOptions zzf;
    @SafeParcelable.Field(getter = "getEnableReconnectionService", id = 8)
    private final boolean zzg;
    @SafeParcelable.Field(getter = "getVolumeDeltaBeforeIceCreamSandwich", id = 9)
    private final double zzh;
    @SafeParcelable.Field(getter = "getEnableIpv6Support", id = 10)
    private final boolean zzi;
    @SafeParcelable.Field(getter = "getOutputSwitcherEnabled", id = 11)
    private final boolean zzj;
    @SafeParcelable.Field(getter = "isRemoteToLocalEnabled", id = 12)
    private final boolean zzk;
    @SafeParcelable.Field(getter = "getRouteDiscoveryReceiverApplicationIds", id = 13)
    private final List zzl;
    @SafeParcelable.Field(getter = "isSessionTransferEnabled", id = 14)
    private final boolean zzm;
    @SafeParcelable.Field(getter = "getPersistCastButtonEnabled", id = 15)
    private final int zzn;
    @SafeParcelable.Field(getter = "isResumeSessionAfterTransferEnabled", id = 16)
    private final boolean zzo;

    public static final class Builder {
        private String zza;
        private List zzb = new ArrayList();
        private boolean zzc;
        private LaunchOptions zzd = new LaunchOptions();
        private boolean zze = true;
        private zzeq zzf = null;
        private boolean zzg = true;
        private double zzh = 0.05000000074505806d;
        private boolean zzi = false;
        private final List zzj = new ArrayList();

        public CastOptions build() {
            Object obj;
            zzeq zzeq = this.zzf;
            if (zzeq != null) {
                obj = zzeq.zza();
            } else {
                obj = new CastMediaOptions.Builder().build();
            }
            return new CastOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (CastMediaOptions) obj, this.zzg, this.zzh, false, false, this.zzi, this.zzj, true, 0, false);
        }

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions) {
            this.zzf = zzeq.zzb(castMediaOptions);
            return this;
        }

        public Builder setEnableReconnectionService(boolean z2) {
            this.zzg = z2;
            return this;
        }

        public Builder setLaunchOptions(LaunchOptions launchOptions) {
            this.zzd = launchOptions;
            return this;
        }

        public Builder setReceiverApplicationId(String str) {
            this.zza = str;
            return this;
        }

        public Builder setRemoteToLocalEnabled(boolean z2) {
            this.zzi = z2;
            return this;
        }

        public Builder setResumeSavedSession(boolean z2) {
            this.zze = z2;
            return this;
        }

        public Builder setStopReceiverApplicationWhenEndingSession(boolean z2) {
            this.zzc = z2;
            return this;
        }

        public Builder setSupportedNamespaces(List<String> list) {
            this.zzb = list;
            return this;
        }

        @Deprecated
        public Builder setVolumeDeltaBeforeIceCreamSandwich(double d2) throws IllegalArgumentException {
            if (d2 <= 0.0d || d2 > 0.5d) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzh = d2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    CastOptions(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List list, @SafeParcelable.Param(id = 4) boolean z2, @SafeParcelable.Param(id = 5) LaunchOptions launchOptions, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) CastMediaOptions castMediaOptions, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) double d2, @SafeParcelable.Param(id = 10) boolean z5, @SafeParcelable.Param(id = 11) boolean z6, @SafeParcelable.Param(id = 12) boolean z7, @SafeParcelable.Param(id = 13) List list2, @SafeParcelable.Param(id = 14) boolean z8, @SafeParcelable.Param(id = 15) int i2, @SafeParcelable.Param(id = 16) boolean z9) {
        int i3;
        List list3 = list;
        this.zza = true == TextUtils.isEmpty(str) ? "" : str;
        if (list3 == null) {
            i3 = 0;
        } else {
            i3 = list.size();
        }
        ArrayList arrayList = new ArrayList(i3);
        this.zzb = arrayList;
        if (i3 > 0) {
            arrayList.addAll(list);
        }
        this.zzc = z2;
        this.zzd = launchOptions == null ? new LaunchOptions() : launchOptions;
        this.zze = z3;
        this.zzf = castMediaOptions;
        this.zzg = z4;
        this.zzh = d2;
        this.zzi = z5;
        this.zzj = z6;
        this.zzk = z7;
        this.zzl = list2;
        this.zzm = z8;
        this.zzn = i2;
        this.zzo = z9;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzf;
    }

    public boolean getEnableReconnectionService() {
        return this.zzg;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzd;
    }

    public String getReceiverApplicationId() {
        return this.zza;
    }

    public boolean getResumeSavedSession() {
        return this.zze;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzc;
    }

    public List<String> getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zzb);
    }

    @Deprecated
    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzh;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel, 3, getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel, 5, getLaunchOptions(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 6, getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel, 7, getCastMediaOptions(), i2, false);
        SafeParcelWriter.writeBoolean(parcel, 8, getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel, 9, getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeStringList(parcel, 13, Collections.unmodifiableList(this.zzl), false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzm);
        SafeParcelWriter.writeInt(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final List zza() {
        return Collections.unmodifiableList(this.zzl);
    }

    public final void zzb(LaunchOptions launchOptions) {
        this.zzd = launchOptions;
    }

    public final void zzc(String str) {
        this.zza = str;
    }

    public final boolean zzd() {
        return this.zzj;
    }

    @ShowFirstParty
    public final boolean zze() {
        return this.zzn == 1;
    }

    public final boolean zzf() {
        return this.zzk;
    }

    public final boolean zzg() {
        return this.zzo;
    }

    public final boolean zzh() {
        return this.zzm;
    }
}

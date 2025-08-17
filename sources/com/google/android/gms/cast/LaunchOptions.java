package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

@SafeParcelable.Class(creator = "LaunchOptionsCreator")
@SafeParcelable.Reserved({1})
public class LaunchOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzbw();
    @SafeParcelable.Field(getter = "getRelaunchIfRunning", id = 2)
    private boolean zza;
    @SafeParcelable.Field(getter = "getLanguage", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getAndroidReceiverCompatible", id = 4)
    private boolean zzc;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getCredentialsData", id = 5)
    public CredentialsData zzd;

    public static final class Builder {
        private final LaunchOptions zza;

        public Builder() {
            this.zza = new LaunchOptions();
        }

        public LaunchOptions build() {
            return this.zza;
        }

        public Builder setAndroidReceiverCompatible(boolean z2) {
            this.zza.zzb(z2);
            return this;
        }

        public Builder setCredentialsData(CredentialsData credentialsData) {
            this.zza.zzd = credentialsData;
            return this;
        }

        public Builder setLocale(Locale locale) {
            this.zza.setLanguage(CastUtils.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean z2) {
            this.zza.setRelaunchIfRunning(z2);
            return this;
        }

        public Builder(LaunchOptions launchOptions) {
            this.zza = new LaunchOptions(launchOptions.getRelaunchIfRunning(), launchOptions.getLanguage(), launchOptions.getAndroidReceiverCompatible(), launchOptions.getCredentialsData());
        }
    }

    public LaunchOptions() {
        this(false, CastUtils.zzb(Locale.getDefault()), false, (CredentialsData) null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        if (this.zza != launchOptions.zza || !CastUtils.zze(this.zzb, launchOptions.zzb) || this.zzc != launchOptions.zzc || !CastUtils.zze(this.zzd, launchOptions.zzd)) {
            return false;
        }
        return true;
    }

    public boolean getAndroidReceiverCompatible() {
        return this.zzc;
    }

    public CredentialsData getCredentialsData() {
        return this.zzd;
    }

    public String getLanguage() {
        return this.zzb;
    }

    public boolean getRelaunchIfRunning() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), this.zzb, Boolean.valueOf(this.zzc), this.zzd);
    }

    public void setLanguage(String str) {
        this.zzb = str;
    }

    public void setRelaunchIfRunning(boolean z2) {
        this.zza = z2;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s, androidReceiverCompatible: %b)", new Object[]{Boolean.valueOf(this.zza), this.zzb, Boolean.valueOf(this.zzc)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, getRelaunchIfRunning());
        SafeParcelWriter.writeString(parcel, 3, getLanguage(), false);
        SafeParcelWriter.writeBoolean(parcel, 4, getAndroidReceiverCompatible());
        SafeParcelWriter.writeParcelable(parcel, 5, getCredentialsData(), i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zzb(boolean z2) {
        this.zzc = z2;
    }

    @SafeParcelable.Constructor
    LaunchOptions(@SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) CredentialsData credentialsData) {
        this.zza = z2;
        this.zzb = str;
        this.zzc = z3;
        this.zzd = credentialsData;
    }
}

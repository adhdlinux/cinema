package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import org.checkerframework.dataflow.qual.Pure;

@SafeParcelable.Class(creator = "LastLocationRequestCreator")
public final class LastLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzv();
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)
    private final long zza;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.location.Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)
    private final int zzb;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 3)
    private final boolean zzc;
    @SafeParcelable.Field(getter = "getModuleId", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getImpersonation", id = 5)
    private final zzd zze;

    public static final class Builder {
        private long zza;
        private int zzb;
        private boolean zzc;
        private String zzd;
        private zzd zze;

        public Builder() {
            this.zza = Clock.MAX_TIME;
            this.zzb = 0;
            this.zzc = false;
            this.zzd = null;
            this.zze = null;
        }

        public Builder(LastLocationRequest lastLocationRequest) {
            this.zza = lastLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = lastLocationRequest.getGranularity();
            this.zzc = lastLocationRequest.zzc();
            this.zzd = lastLocationRequest.zzb();
            this.zze = lastLocationRequest.zza();
        }

        public LastLocationRequest build() {
            return new LastLocationRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
        }

        public Builder setGranularity(int i2) {
            zzo.zza(i2);
            this.zzb = i2;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z2;
            if (j2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "maxUpdateAgeMillis must be greater than 0");
            this.zza = j2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    LastLocationRequest(@SafeParcelable.Param(id = 1) long j2, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) zzd zzd2) {
        this.zza = j2;
        this.zzb = i2;
        this.zzc = z2;
        this.zzd = str;
        this.zze = zzd2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.zza == lastLocationRequest.zza && this.zzb == lastLocationRequest.zzb && this.zzc == lastLocationRequest.zzc && Objects.equal(this.zzd, lastLocationRequest.zzd) && Objects.equal(this.zze, lastLocationRequest.zze)) {
            return true;
        }
        return false;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Boolean.valueOf(this.zzc));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.zza != Clock.MAX_TIME) {
            sb.append("maxAge=");
            zzdj.zzb(this.zza, sb);
        }
        if (this.zzb != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzb));
        }
        if (this.zzc) {
            sb.append(", bypass");
        }
        if (this.zzd != null) {
            sb.append(", moduleId=");
            sb.append(this.zzd);
        }
        if (this.zze != null) {
            sb.append(", impersonation=");
            sb.append(this.zze);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final zzd zza() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public final String zzb() {
        return this.zzd;
    }

    @Pure
    public final boolean zzc() {
        return this.zzc;
    }
}

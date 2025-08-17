package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import org.checkerframework.dataflow.qual.Pure;

@SafeParcelable.Class(creator = "CurrentLocationRequestCreator")
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)
    private final long zza;
    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)
    private final int zzb;
    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 3)
    private final int zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 4)
    private final long zzd;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 5)
    private final boolean zze;
    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 7)
    private final int zzf;
    @SafeParcelable.Field(getter = "getModuleId", id = 8)
    private final String zzg;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 6)
    private final WorkSource zzh;
    @SafeParcelable.Field(getter = "getImpersonation", id = 9)
    private final zzd zzi;

    public static final class Builder {
        private long zza;
        private int zzb;
        private int zzc;
        private long zzd;
        private boolean zze;
        private int zzf;
        private String zzg;
        private WorkSource zzh;
        private zzd zzi;

        public Builder() {
            this.zza = 60000;
            this.zzb = 0;
            this.zzc = 102;
            this.zzd = Clock.MAX_TIME;
            this.zze = false;
            this.zzf = 0;
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
        }

        public Builder(CurrentLocationRequest currentLocationRequest) {
            this.zza = currentLocationRequest.getMaxUpdateAgeMillis();
            this.zzb = currentLocationRequest.getGranularity();
            this.zzc = currentLocationRequest.getPriority();
            this.zzd = currentLocationRequest.getDurationMillis();
            this.zze = currentLocationRequest.zze();
            this.zzf = currentLocationRequest.zza();
            this.zzg = currentLocationRequest.zzd();
            this.zzh = new WorkSource(currentLocationRequest.zzb());
            this.zzi = currentLocationRequest.zzc();
        }

        public CurrentLocationRequest build() {
            return new CurrentLocationRequest(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, new WorkSource(this.zzh), this.zzi);
        }

        public Builder setDurationMillis(long j2) {
            boolean z2;
            if (j2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "durationMillis must be greater than 0");
            this.zzd = j2;
            return this;
        }

        public Builder setGranularity(int i2) {
            zzo.zza(i2);
            this.zzb = i2;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "maxUpdateAgeMillis must be greater than or equal to 0");
            this.zza = j2;
            return this;
        }

        public Builder setPriority(int i2) {
            zzae.zza(i2);
            this.zzc = i2;
            return this;
        }
    }

    @SafeParcelable.Constructor
    CurrentLocationRequest(@SafeParcelable.Param(id = 1) long j2, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) long j3, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) String str, @SafeParcelable.Param(id = 6) WorkSource workSource, @SafeParcelable.Param(id = 9) zzd zzd2) {
        boolean z3 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        this.zza = j2;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j3;
        this.zze = z2;
        this.zzf = i4;
        this.zzg = str;
        this.zzh = workSource;
        this.zzi = zzd2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        if (this.zza == currentLocationRequest.zza && this.zzb == currentLocationRequest.zzb && this.zzc == currentLocationRequest.zzc && this.zzd == currentLocationRequest.zzd && this.zze == currentLocationRequest.zze && this.zzf == currentLocationRequest.zzf && Objects.equal(this.zzg, currentLocationRequest.zzg) && Objects.equal(this.zzh, currentLocationRequest.zzh) && Objects.equal(this.zzi, currentLocationRequest.zzi)) {
            return true;
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zzd;
    }

    @Pure
    public int getGranularity() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zza;
    }

    @Pure
    public int getPriority() {
        return this.zzc;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Long.valueOf(this.zzd));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentLocationRequest[");
        sb.append(zzae.zzb(this.zzc));
        if (this.zza != Clock.MAX_TIME) {
            sb.append(", maxAge=");
            zzdj.zzb(this.zza, sb);
        }
        if (this.zzd != Clock.MAX_TIME) {
            sb.append(", duration=");
            sb.append(this.zzd);
            sb.append("ms");
        }
        if (this.zzb != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzb));
        }
        if (this.zze) {
            sb.append(", bypass");
        }
        if (this.zzf != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.zzf));
        }
        if (this.zzg != null) {
            sb.append(", moduleId=");
            sb.append(this.zzg);
        }
        if (!WorkSourceUtil.isEmpty(this.zzh)) {
            sb.append(", workSource=");
            sb.append(this.zzh);
        }
        if (this.zzi != null) {
            sb.append(", impersonation=");
            sb.append(this.zzi);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeInt(parcel, 3, getPriority());
        SafeParcelWriter.writeLong(parcel, 4, getDurationMillis());
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzh, i2, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzf;
    }

    @Pure
    public final WorkSource zzb() {
        return this.zzh;
    }

    @Pure
    public final zzd zzc() {
        return this.zzi;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.zzg;
    }

    @Pure
    public final boolean zze() {
        return this.zze;
    }
}

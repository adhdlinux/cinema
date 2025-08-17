package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzd;
import com.google.android.gms.internal.location.zzdj;
import org.checkerframework.dataflow.qual.Pure;

@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 1)
    private int zza;
    @SafeParcelable.Field(defaultValue = "3600000", getter = "getIntervalMillis", id = 2)
    private long zzb;
    @SafeParcelable.Field(defaultValue = "600000", getter = "getMinUpdateIntervalMillis", id = 3)
    private long zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMaxUpdateDelayMillis", id = 8)
    private long zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 10)
    private long zze;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MAX_VALUE", getter = "getMaxUpdates", id = 6)
    private int zzf;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMinUpdateDistanceMeters", id = 7)
    private float zzg;
    @SafeParcelable.Field(defaultValue = "false", getter = "isWaitForAccurateLocation", id = 9)
    private boolean zzh;
    @SafeParcelable.Field(defaultValueUnchecked = "-1", getter = "getMaxUpdateAgeMillis", id = 11)
    private long zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 12)
    private final int zzj;
    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 13)
    private final int zzk;
    @SafeParcelable.Field(getter = "getModuleId", id = 14)
    private final String zzl;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 15)
    private final boolean zzm;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 16)
    private final WorkSource zzn;
    @SafeParcelable.Field(getter = "getImpersonation", id = 17)
    private final zzd zzo;

    /* JADX WARNING: Illegal instructions before constructor call */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LocationRequest() {
        /*
            r23 = this;
            r0 = r23
            android.os.WorkSource r1 = new android.os.WorkSource
            r21 = r1
            r1.<init>()
            r1 = 102(0x66, float:1.43E-43)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r4 = 600000(0x927c0, double:2.964394E-318)
            r6 = 0
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r12 = 2147483647(0x7fffffff, float:NaN)
            r13 = 0
            r14 = 1
            r15 = 3600000(0x36ee80, double:1.7786363E-317)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r22 = 0
            r0.<init>(r1, r2, r4, r6, r8, r10, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.LocationRequest.<init>():void");
    }

    @Deprecated
    public static LocationRequest create() {
        WorkSource workSource = r1;
        WorkSource workSource2 = new WorkSource();
        return new LocationRequest(102, 3600000, 600000, 0, Clock.MAX_TIME, Clock.MAX_TIME, Integer.MAX_VALUE, 0.0f, true, 3600000, 0, 0, (String) null, false, workSource, (zzd) null);
    }

    private static String zzf(long j2) {
        if (j2 == Clock.MAX_TIME) {
            return "∞";
        }
        return zzdj.zza(j2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && ((isPassive() || this.zzb == locationRequest.zzb) && this.zzc == locationRequest.zzc && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.zzd == locationRequest.zzd) && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && this.zzh == locationRequest.zzh && this.zzj == locationRequest.zzj && this.zzk == locationRequest.zzk && this.zzm == locationRequest.zzm && this.zzn.equals(locationRequest.zzn) && Objects.equal(this.zzl, locationRequest.zzl) && Objects.equal(this.zzo, locationRequest.zzo)))) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.zze;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.zze;
        long j3 = elapsedRealtime + j2;
        return ((elapsedRealtime ^ j3) & (j2 ^ j3)) < 0 ? Clock.MAX_TIME : j3;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.zzj;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.zzb;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.zzi;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.zzd;
    }

    @Pure
    public int getMaxUpdates() {
        return this.zzf;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.zzd, this.zzb);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.zzg;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.zzc;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.zza;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), this.zzn);
    }

    @Pure
    public boolean isBatched() {
        long j2 = this.zzd;
        return j2 > 0 && (j2 >> 1) >= this.zzb;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        return this.zza == 105;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzh;
    }

    @Deprecated
    public LocationRequest setExpirationDuration(long j2) {
        boolean z2;
        if (j2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "durationMillis must be greater than 0");
        this.zze = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setExpirationTime(long j2) {
        this.zze = Math.max(1, j2 - SystemClock.elapsedRealtime());
        return this;
    }

    @Deprecated
    public LocationRequest setFastestInterval(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "illegal fastest interval: %d", Long.valueOf(j2));
        this.zzc = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setInterval(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "intervalMillis must be greater than or equal to 0");
        long j3 = this.zzc;
        long j4 = this.zzb;
        if (j3 == j4 / 6) {
            this.zzc = j2 / 6;
        }
        if (this.zzi == j4) {
            this.zzi = j2;
        }
        this.zzb = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setMaxWaitTime(long j2) {
        boolean z2;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "illegal max wait time: %d", Long.valueOf(j2));
        this.zzd = j2;
        return this;
    }

    @Deprecated
    public LocationRequest setNumUpdates(int i2) {
        if (i2 > 0) {
            this.zzf = i2;
            return this;
        }
        throw new IllegalArgumentException("invalid numUpdates: " + i2);
    }

    @Deprecated
    public LocationRequest setPriority(int i2) {
        zzae.zza(i2);
        this.zza = i2;
        return this;
    }

    @Deprecated
    public LocationRequest setSmallestDisplacement(float f2) {
        if (f2 >= 0.0f) {
            this.zzg = f2;
            return this;
        }
        throw new IllegalArgumentException("invalid displacement: " + f2);
    }

    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z2) {
        this.zzh = z2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzae.zzb(this.zza));
        } else {
            sb.append("@");
            if (isBatched()) {
                zzdj.zzb(this.zzb, sb);
                sb.append("/");
                zzdj.zzb(this.zzd, sb);
            } else {
                zzdj.zzb(this.zzb, sb);
            }
            sb.append(" ");
            sb.append(zzae.zzb(this.zza));
        }
        if (isPassive() || this.zzc != this.zzb) {
            sb.append(", minUpdateInterval=");
            sb.append(zzf(this.zzc));
        }
        if (((double) this.zzg) > 0.0d) {
            sb.append(", minUpdateDistance=");
            sb.append(this.zzg);
        }
        if (!isPassive() ? this.zzi != this.zzb : this.zzi != Clock.MAX_TIME) {
            sb.append(", maxUpdateAge=");
            sb.append(zzf(this.zzi));
        }
        if (this.zze != Clock.MAX_TIME) {
            sb.append(", duration=");
            zzdj.zzb(this.zze, sb);
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.zzf);
        }
        if (this.zzk != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.zzk));
        }
        if (this.zzj != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.zzj));
        }
        if (this.zzh) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.zzm) {
            sb.append(", bypass");
        }
        if (this.zzl != null) {
            sb.append(", moduleId=");
            sb.append(this.zzl);
        }
        if (!WorkSourceUtil.isEmpty(this.zzn)) {
            sb.append(", ");
            sb.append(this.zzn);
        }
        if (this.zzo != null) {
            sb.append(", impersonation=");
            sb.append(this.zzo);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.zzk);
        SafeParcelWriter.writeString(parcel, 14, this.zzl, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 16, this.zzn, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.zzk;
    }

    @Pure
    public final WorkSource zzb() {
        return this.zzn;
    }

    @Pure
    public final zzd zzc() {
        return this.zzo;
    }

    @Deprecated
    @Pure
    public final String zzd() {
        return this.zzl;
    }

    @Pure
    public final boolean zze() {
        return this.zzm;
    }

    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;
        private int zza;
        private long zzb;
        private long zzc;
        private long zzd;
        private long zze;
        private int zzf;
        private float zzg;
        private boolean zzh;
        private long zzi;
        private int zzj;
        private int zzk;
        private String zzl;
        private boolean zzm;
        private WorkSource zzn;
        private zzd zzo;

        public Builder(int i2, long j2) {
            Preconditions.checkArgument(j2 >= 0, "intervalMillis must be greater than or equal to 0");
            zzae.zza(i2);
            this.zza = i2;
            this.zzb = j2;
            this.zzc = -1;
            this.zzd = 0;
            this.zze = Clock.MAX_TIME;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public LocationRequest build() {
            long j2;
            int i2 = this.zza;
            long j3 = this.zzb;
            long j4 = this.zzc;
            if (j4 == -1) {
                j4 = j3;
            } else if (i2 != 105) {
                j4 = Math.min(j4, j3);
            }
            long max = Math.max(this.zzd, this.zzb);
            long j5 = this.zze;
            int i3 = this.zzf;
            float f2 = this.zzg;
            boolean z2 = this.zzh;
            long j6 = this.zzi;
            if (j6 == -1) {
                j2 = this.zzb;
            } else {
                j2 = j6;
            }
            int i4 = this.zzj;
            int i5 = this.zzk;
            String str = this.zzl;
            boolean z3 = this.zzm;
            WorkSource workSource = r7;
            WorkSource workSource2 = new WorkSource(this.zzn);
            return new LocationRequest(i2, j3, j4, max, Clock.MAX_TIME, j5, i3, f2, z2, j2, i4, i5, str, z3, workSource, this.zzo);
        }

        public Builder setDurationMillis(long j2) {
            boolean z2;
            if (j2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "durationMillis must be greater than 0");
            this.zze = j2;
            return this;
        }

        public Builder setGranularity(int i2) {
            zzo.zza(i2);
            this.zzj = i2;
            return this;
        }

        public Builder setIntervalMillis(long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "intervalMillis must be greater than or equal to 0");
            this.zzb = j2;
            return this;
        }

        public Builder setMaxUpdateAgeMillis(long j2) {
            boolean z2 = true;
            if (j2 != -1 && j2 < 0) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.zzi = j2;
            return this;
        }

        public Builder setMaxUpdateDelayMillis(long j2) {
            boolean z2;
            if (j2 >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.zzd = j2;
            return this;
        }

        public Builder setMaxUpdates(int i2) {
            boolean z2;
            if (i2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "maxUpdates must be greater than 0");
            this.zzf = i2;
            return this;
        }

        public Builder setMinUpdateDistanceMeters(float f2) {
            boolean z2;
            if (f2 >= 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.zzg = f2;
            return this;
        }

        public Builder setMinUpdateIntervalMillis(long j2) {
            boolean z2 = true;
            if (j2 != -1 && j2 < 0) {
                z2 = false;
            }
            Preconditions.checkArgument(z2, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.zzc = j2;
            return this;
        }

        public Builder setPriority(int i2) {
            zzae.zza(i2);
            this.zza = i2;
            return this;
        }

        public Builder setWaitForAccurateLocation(boolean z2) {
            this.zzh = z2;
            return this;
        }

        public final Builder zza(boolean z2) {
            this.zzm = z2;
            return this;
        }

        @Deprecated
        public final Builder zzb(String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.zzl = str;
            }
            return this;
        }

        public final Builder zzc(int i2) {
            boolean z2;
            int i3;
            if (i2 == 0 || i2 == 1) {
                i3 = i2;
            } else {
                i3 = 2;
                if (i2 == 2) {
                    i2 = 2;
                } else {
                    i3 = i2;
                    z2 = false;
                    Preconditions.checkArgument(z2, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i2));
                    this.zzk = i3;
                    return this;
                }
            }
            z2 = true;
            Preconditions.checkArgument(z2, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i2));
            this.zzk = i3;
            return this;
        }

        public final Builder zzd(WorkSource workSource) {
            this.zzn = workSource;
            return this;
        }

        public Builder(long j2) {
            Preconditions.checkArgument(j2 >= 0, "intervalMillis must be greater than or equal to 0");
            this.zzb = j2;
            this.zza = 102;
            this.zzc = -1;
            this.zzd = 0;
            this.zze = Clock.MAX_TIME;
            this.zzf = Integer.MAX_VALUE;
            this.zzg = 0.0f;
            this.zzh = true;
            this.zzi = -1;
            this.zzj = 0;
            this.zzk = 0;
            this.zzl = null;
            this.zzm = false;
            this.zzn = null;
            this.zzo = null;
        }

        public Builder(LocationRequest locationRequest) {
            this.zza = locationRequest.getPriority();
            this.zzb = locationRequest.getIntervalMillis();
            this.zzc = locationRequest.getMinUpdateIntervalMillis();
            this.zzd = locationRequest.getMaxUpdateDelayMillis();
            this.zze = locationRequest.getDurationMillis();
            this.zzf = locationRequest.getMaxUpdates();
            this.zzg = locationRequest.getMinUpdateDistanceMeters();
            this.zzh = locationRequest.isWaitForAccurateLocation();
            this.zzi = locationRequest.getMaxUpdateAgeMillis();
            this.zzj = locationRequest.getGranularity();
            this.zzk = locationRequest.zza();
            this.zzl = locationRequest.zzd();
            this.zzm = locationRequest.zze();
            this.zzn = locationRequest.zzb();
            this.zzo = locationRequest.zzc();
        }
    }

    @SafeParcelable.Constructor
    LocationRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 8) long j4, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 5) long j5, @SafeParcelable.Param(id = 10) long j6, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) float f2, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 11) long j7, @SafeParcelable.Param(id = 12) int i4, @SafeParcelable.Param(id = 13) int i5, @SafeParcelable.Param(id = 14) String str, @SafeParcelable.Param(id = 15) boolean z3, @SafeParcelable.Param(id = 16) WorkSource workSource, @SafeParcelable.Param(id = 17) zzd zzd2) {
        long j8;
        this.zza = i2;
        long j9 = j2;
        this.zzb = j9;
        this.zzc = j3;
        this.zzd = j4;
        if (j5 == Clock.MAX_TIME) {
            j8 = j6;
        } else {
            j8 = Math.min(Math.max(1, j5 - SystemClock.elapsedRealtime()), j6);
        }
        this.zze = j8;
        this.zzf = i3;
        this.zzg = f2;
        this.zzh = z2;
        this.zzi = j7 != -1 ? j7 : j9;
        this.zzj = i4;
        this.zzk = i5;
        this.zzl = str;
        this.zzm = z3;
        this.zzn = workSource;
        this.zzo = zzd2;
    }
}

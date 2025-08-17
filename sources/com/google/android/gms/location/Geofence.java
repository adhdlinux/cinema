package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.location.zzdh;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zza = null;
        @TransitionTypes
        private int zzb = 0;
        private long zzc = Long.MIN_VALUE;
        private short zzd = -1;
        private double zze;
        private double zzf;
        private float zzg;
        private int zzh = 0;
        private int zzi = -1;

        public Geofence build() {
            if (this.zza != null) {
                int i2 = this.zzb;
                if (i2 == 0) {
                    throw new IllegalArgumentException("Transitions types not set.");
                } else if ((i2 & 4) != 0 && this.zzi < 0) {
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELL.");
                } else if (this.zzc == Long.MIN_VALUE) {
                    throw new IllegalArgumentException("Expiration not set.");
                } else if (this.zzd == -1) {
                    throw new IllegalArgumentException("Geofence region not set.");
                } else if (this.zzh >= 0) {
                    return new zzdh(this.zza, this.zzb, 1, this.zze, this.zzf, this.zzg, this.zzc, this.zzh, this.zzi);
                } else {
                    throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                }
            } else {
                throw new IllegalArgumentException("Request ID not set.");
            }
        }

        public Builder setCircularRegion(double d2, double d3, float f2) {
            boolean z2;
            boolean z3;
            boolean z4 = false;
            if (d2 < -90.0d || d2 > 90.0d) {
                z2 = false;
            } else {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "Invalid latitude: " + d2);
            if (d3 < -180.0d || d3 > 180.0d) {
                z3 = false;
            } else {
                z3 = true;
            }
            Preconditions.checkArgument(z3, "Invalid longitude: " + d3);
            if (f2 > 0.0f) {
                z4 = true;
            }
            Preconditions.checkArgument(z4, "Invalid radius: " + f2);
            this.zzd = 1;
            this.zze = d2;
            this.zzf = d3;
            this.zzg = f2;
            return this;
        }

        public Builder setExpirationDuration(long j2) {
            if (j2 < 0) {
                this.zzc = -1;
            } else {
                this.zzc = DefaultClock.getInstance().elapsedRealtime() + j2;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i2) {
            this.zzi = i2;
            return this;
        }

        public Builder setNotificationResponsiveness(int i2) {
            this.zzh = i2;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zza = (String) Preconditions.checkNotNull(str, "Request ID can't be set to null");
            return this;
        }

        public Builder setTransitionTypes(@TransitionTypes int i2) {
            this.zzb = i2;
            return this;
        }
    }

    public @interface GeofenceTransition {
    }

    public @interface TransitionTypes {
    }

    long getExpirationTime();

    double getLatitude();

    int getLoiteringDelay();

    double getLongitude();

    int getNotificationResponsiveness();

    float getRadius();

    String getRequestId();

    @TransitionTypes
    int getTransitionTypes();
}

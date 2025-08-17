package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SafeParcelable.Class(creator = "ActivityTransitionCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransition extends AbstractSafeParcelable {
    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)
    private final int zzb;

    public static class Builder {
        private int zza = -1;
        private int zzb = -1;

        public ActivityTransition build() {
            boolean z2;
            boolean z3 = true;
            if (this.zza != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkState(z2, "Activity type not set.");
            if (this.zzb == -1) {
                z3 = false;
            }
            Preconditions.checkState(z3, "Activity transition type not set.");
            return new ActivityTransition(this.zza, this.zzb);
        }

        public Builder setActivityTransition(int i2) {
            ActivityTransition.zza(i2);
            this.zzb = i2;
            return this;
        }

        public Builder setActivityType(int i2) {
            this.zza = i2;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    @SafeParcelable.Constructor
    ActivityTransition(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3) {
        this.zza = i2;
        this.zzb = i3;
    }

    public static void zza(int i2) {
        boolean z2 = false;
        if (i2 >= 0 && i2 <= 1) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "Transition type " + i2 + " is not valid.");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        if (this.zza == activityTransition.zza && this.zzb == activityTransition.zzb) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb));
    }

    public String toString() {
        int i2 = this.zza;
        int i3 = this.zzb;
        return "ActivityTransition [mActivityType=" + i2 + ", mTransitionType=" + i3 + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

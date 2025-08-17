package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.facebook.common.time.Clock;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.location.LocationRequest;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "LocationRequestInternalCreator")
@SafeParcelable.Reserved({2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1000})
@Deprecated
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 1)
    LocationRequest zza;

    @SafeParcelable.Constructor
    zzdd(@SafeParcelable.Param(id = 1) LocationRequest locationRequest, @SafeParcelable.RemovedParam(defaultValueUnchecked = "null", id = 5) List list, @SafeParcelable.RemovedParam(defaultValue = "false", id = 8) boolean z2, @SafeParcelable.RemovedParam(defaultValue = "false", id = 9) boolean z3, @SafeParcelable.RemovedParam(defaultValueUnchecked = "null", id = 10) String str, @SafeParcelable.RemovedParam(defaultValue = "false", id = 11) boolean z4, @SafeParcelable.RemovedParam(defaultValue = "false", id = 12) boolean z5, @SafeParcelable.RemovedParam(defaultValueUnchecked = "null", id = 13) String str2, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 14) long j2) {
        WorkSource workSource;
        LocationRequest.Builder builder = new LocationRequest.Builder(locationRequest);
        if (list != null) {
            if (list.isEmpty()) {
                workSource = null;
            } else {
                workSource = new WorkSource();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    ClientIdentity clientIdentity = (ClientIdentity) it2.next();
                    WorkSourceUtil.add(workSource, clientIdentity.uid, clientIdentity.packageName);
                }
            }
            builder.zzd(workSource);
        }
        if (z2) {
            builder.setGranularity(1);
        }
        if (z3) {
            builder.zzc(2);
        }
        if (str != null) {
            builder.zzb(str);
        } else if (str2 != null) {
            builder.zzb(str2);
        }
        if (z4) {
            builder.zza(true);
        }
        if (z5) {
            builder.setWaitForAccurateLocation(true);
        }
        if (j2 != Clock.MAX_TIME) {
            builder.setMaxUpdateAgeMillis(j2);
        }
        this.zza = builder.build();
    }

    @Deprecated
    public static zzdd zza(String str, LocationRequest locationRequest) {
        return new zzdd(locationRequest, (List) null, false, false, (String) null, false, false, (String) null, Clock.MAX_TIME);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdd) {
            return Objects.equal(this.zza, ((zzdd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

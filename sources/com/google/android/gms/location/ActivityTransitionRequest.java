package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@SafeParcelable.Class(creator = "ActivityTransitionRequestCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzh();
    public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zzg();
    @SafeParcelable.Field(getter = "getActivityTransitions", id = 1)
    private final List zza;
    @SafeParcelable.Field(getter = "getTag", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getClients", id = 3)
    private final List zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getContextAttributionTag", id = 4)
    private String zzd;

    public ActivityTransitionRequest(List<ActivityTransition> list) {
        this(list, (String) null, (List) null, (String) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (!Objects.equal(this.zza, activityTransitionRequest.zza) || !Objects.equal(this.zzb, activityTransitionRequest.zzb) || !Objects.equal(this.zzd, activityTransitionRequest.zzd) || !Objects.equal(this.zzc, activityTransitionRequest.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2;
        int i3;
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        int i4 = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = (hashCode + i2) * 31;
        List list = this.zzc;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (i5 + i3) * 31;
        String str2 = this.zzd;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return i6 + i4;
    }

    public void serializeToIntentExtra(Intent intent) {
        Preconditions.checkNotNull(intent);
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        String str = this.zzb;
        String valueOf2 = String.valueOf(this.zzc);
        String str2 = this.zzd;
        return "ActivityTransitionRequest [mTransitions=" + valueOf + ", mTag='" + str + "', mClients=" + valueOf2 + ", mAttributionTag=" + str2 + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ActivityTransitionRequest zza(String str) {
        this.zzd = str;
        return this;
    }

    @SafeParcelable.Constructor
    public ActivityTransitionRequest(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) List list2, @SafeParcelable.Param(id = 4) String str2) {
        List list3;
        Preconditions.checkNotNull(list, "transitions can't be null");
        Preconditions.checkArgument(list.size() > 0, "transitions can't be empty.");
        Preconditions.checkNotNull(list);
        TreeSet treeSet = new TreeSet(IS_SAME_TRANSITION);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it2.next();
            Preconditions.checkArgument(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", new Object[]{activityTransition}));
        }
        this.zza = Collections.unmodifiableList(list);
        this.zzb = str;
        if (list2 == null) {
            list3 = Collections.emptyList();
        } else {
            list3 = Collections.unmodifiableList(list2);
        }
        this.zzc = list3;
        this.zzd = str2;
    }
}

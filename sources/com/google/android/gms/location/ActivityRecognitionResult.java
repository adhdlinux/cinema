package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ActivityRecognitionResultCreator")
@SafeParcelable.Reserved({1000})
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzd();
    @SafeParcelable.Field(id = 1)
    List zza;
    @SafeParcelable.Field(id = 2)
    long zzb;
    @SafeParcelable.Field(id = 3)
    long zzc;
    @SafeParcelable.Field(id = 4)
    int zzd;
    @SafeParcelable.Field(id = 5)
    Bundle zze;

    @VisibleForTesting
    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j2, long j3) {
        this(Collections.singletonList(detectedActivity), j2, j3, 0, (Bundle) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.location.ActivityRecognitionResult extractResult(android.content.Intent r3) {
        /*
            boolean r0 = hasResult(r3)
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x002b
        L_0x0009:
            android.os.Bundle r0 = r3.getExtras()
            if (r0 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r2 = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT"
            java.lang.Object r0 = r0.get(r2)
            boolean r2 = r0 instanceof byte[]
            if (r2 == 0) goto L_0x0025
            byte[] r0 = (byte[]) r0
            android.os.Parcelable$Creator<com.google.android.gms.location.ActivityRecognitionResult> r2 = CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromBytes(r0, r2)
            com.google.android.gms.location.ActivityRecognitionResult r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0
            goto L_0x002b
        L_0x0025:
            boolean r2 = r0 instanceof com.google.android.gms.location.ActivityRecognitionResult
            if (r2 == 0) goto L_0x0007
            com.google.android.gms.location.ActivityRecognitionResult r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0
        L_0x002b:
            if (r0 == 0) goto L_0x002e
            return r0
        L_0x002e:
            java.util.List r3 = zza(r3)
            if (r3 == 0) goto L_0x0048
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x003b
            goto L_0x0048
        L_0x003b:
            int r0 = r3.size()
            int r0 = r0 + -1
            java.lang.Object r3 = r3.get(r0)
            com.google.android.gms.location.ActivityRecognitionResult r3 = (com.google.android.gms.location.ActivityRecognitionResult) r3
            return r3
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.extractResult(android.content.Intent):com.google.android.gms.location.ActivityRecognitionResult");
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List zza2 = zza(intent);
        if (zza2 == null || zza2.isEmpty()) {
            return false;
        }
        return true;
    }

    public static List zza(Intent intent) {
        if (intent != null && intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) {
            return SafeParcelableSerializer.deserializeIterableFromIntentExtra(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
        }
        return null;
    }

    private static boolean zzb(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            if (bundle2 == null) {
                return true;
            }
            return false;
        } else if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        } else {
            for (String next : bundle.keySet()) {
                if (!bundle2.containsKey(next)) {
                    return false;
                }
                Object obj = bundle.get(next);
                Object obj2 = bundle2.get(next);
                if (obj == null) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (obj instanceof Bundle) {
                    if (!zzb(bundle.getBundle(next), bundle2.getBundle(next))) {
                        return false;
                    }
                } else if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        int i2 = 0;
                        while (i2 < length) {
                            if (Objects.equal(Array.get(obj, i2), Array.get(obj2, i2))) {
                                i2++;
                            }
                        }
                        continue;
                    }
                    return false;
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            }
            return true;
        }
    }

    @ShowFirstParty
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.zzb == activityRecognitionResult.zzb && this.zzc == activityRecognitionResult.zzc && this.zzd == activityRecognitionResult.zzd && Objects.equal(this.zza, activityRecognitionResult.zza) && zzb(this.zze, activityRecognitionResult.zze)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getActivityConfidence(int i2) {
        for (DetectedActivity detectedActivity : this.zza) {
            if (detectedActivity.getType() == i2) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzc;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zza.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zza;
    }

    public long getTime() {
        return this.zzb;
    }

    @ShowFirstParty
    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zza, this.zze);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        long j2 = this.zzb;
        long j3 = this.zzc;
        return "ActivityRecognitionResult [probableActivities=" + valueOf + ", timeMillis=" + j2 + ", elapsedRealtimeMillis=" + j3 + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeBundle(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j2, long j3) {
        this(list, j2, j3, 0, (Bundle) null);
    }

    @ShowFirstParty
    @SafeParcelable.Constructor
    public ActivityRecognitionResult(@SafeParcelable.Param(id = 1) List list, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 3) long j3, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) Bundle bundle) {
        boolean z2 = true;
        Preconditions.checkArgument(list != null && list.size() > 0, "Must have at least 1 detected activity");
        Preconditions.checkArgument((j2 <= 0 || j3 <= 0) ? false : z2, "Must set times");
        this.zza = list;
        this.zzb = j2;
        this.zzc = j3;
        this.zzd = i2;
        this.zze = bundle;
    }
}

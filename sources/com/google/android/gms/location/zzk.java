package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

final class zzk implements Comparator {
    zzk() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        Preconditions.checkNotNull(detectedActivity);
        Preconditions.checkNotNull(detectedActivity2);
        int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
        if (compareTo == 0) {
            return Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType()));
        }
        return compareTo;
    }
}

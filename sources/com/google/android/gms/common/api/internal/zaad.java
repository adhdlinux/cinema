package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaad {
    /* access modifiers changed from: private */
    public final Map zaa = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */
    public final Map zab = Collections.synchronizedMap(new WeakHashMap());

    private final void zah(boolean z2, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.zaa) {
            hashMap = new HashMap(this.zaa);
        }
        synchronized (this.zab) {
            hashMap2 = new HashMap(this.zab);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zac(BasePendingResult basePendingResult, boolean z2) {
        this.zaa.put(basePendingResult, Boolean.valueOf(z2));
        basePendingResult.addStatusListener(new zaab(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final void zad(TaskCompletionSource taskCompletionSource, boolean z2) {
        this.zab.put(taskCompletionSource, Boolean.valueOf(z2));
        taskCompletionSource.getTask().addOnCompleteListener(new zaac(this, taskCompletionSource));
    }

    /* access modifiers changed from: package-private */
    public final void zae(int i2, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i2 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i2 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        zah(true, new Status(20, sb.toString()));
    }

    public final void zaf() {
        zah(false, GoogleApiManager.zaa);
    }

    /* access modifiers changed from: package-private */
    public final boolean zag() {
        return !this.zaa.isEmpty() || !this.zab.isEmpty();
    }
}

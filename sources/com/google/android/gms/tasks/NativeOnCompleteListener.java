package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long zza;

    @KeepForSdk
    public NativeOnCompleteListener(long j2) {
        this.zza = j2;
    }

    @KeepForSdk
    public static void createAndAddCallback(Task<Object> task, long j2) {
        task.addOnCompleteListener(new NativeOnCompleteListener(j2));
    }

    @KeepForSdk
    public native void nativeOnComplete(long j2, Object obj, boolean z2, boolean z3, String str);

    @KeepForSdk
    public void onComplete(Task<Object> task) {
        String str;
        Object obj;
        Exception exception;
        if (task.isSuccessful()) {
            obj = task.getResult();
            str = null;
        } else if (task.isCanceled() || (exception = task.getException()) == null) {
            obj = null;
            str = null;
        } else {
            str = exception.getMessage();
            obj = null;
        }
        nativeOnComplete(this.zza, obj, task.isSuccessful(), task.isCanceled(), str);
    }
}

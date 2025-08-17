package com.google.ar.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.annotations.UsedByNative;
import com.google.ar.core.exceptions.ResourceExhaustedException;
import com.google.ar.core.exceptions.UnavailableApkTooOldException;
import com.google.ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.ar.core.exceptions.UnavailableSdkTooOldException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"LongLogTag"})
@UsedByNative("arcoreapk.cc")
final class ArCoreApkJniAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f30224a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f30225b = 0;

    static {
        HashMap hashMap = new HashMap();
        f30224a = hashMap;
        hashMap.put(IllegalArgumentException.class, Integer.valueOf(ah.ERROR_INVALID_ARGUMENT.f30288b));
        hashMap.put(ResourceExhaustedException.class, Integer.valueOf(ah.ERROR_RESOURCE_EXHAUSTED.f30288b));
        hashMap.put(UnavailableArcoreNotInstalledException.class, Integer.valueOf(ah.UNAVAILABLE_ARCORE_NOT_INSTALLED.f30288b));
        hashMap.put(UnavailableDeviceNotCompatibleException.class, Integer.valueOf(ah.UNAVAILABLE_DEVICE_NOT_COMPATIBLE.f30288b));
        hashMap.put(UnavailableApkTooOldException.class, Integer.valueOf(ah.UNAVAILABLE_APK_TOO_OLD.f30288b));
        hashMap.put(UnavailableSdkTooOldException.class, Integer.valueOf(ah.UNAVAILABLE_SDK_TOO_OLD.f30288b));
        hashMap.put(UnavailableUserDeclinedInstallationException.class, Integer.valueOf(ah.UNAVAILABLE_USER_DECLINED_INSTALLATION.f30288b));
    }

    private ArCoreApkJniAdapter() {
    }

    private static int b(Throwable th) {
        Log.e("ARCore-ArCoreApkJniAdapter", "Exception details:", th);
        Map map = f30224a;
        Class<?> cls = th.getClass();
        if (map.containsKey(cls)) {
            return ((Integer) map.get(cls)).intValue();
        }
        return ah.ERROR_FATAL.f30288b;
    }

    @UsedByNative("arcoreapk.cc")
    static int checkAvailability(Context context) {
        try {
            return ArCoreApk.getInstance().checkAvailability(context).nativeCode;
        } catch (Throwable th) {
            b(th);
            return ArCoreApk.Availability.UNKNOWN_ERROR.nativeCode;
        }
    }

    @UsedByNative("arcoreapk.cc")
    static void checkAvailabilityAsync(Context context, long j2, long j3) {
        m mVar = new m(j2, j3);
        try {
            ArCoreApk.getInstance().checkAvailabilityAsync(context, mVar);
        } catch (Throwable th) {
            b(th);
            new Handler(Looper.getMainLooper()).post(new l(mVar));
        }
    }

    /* access modifiers changed from: private */
    public static native void nativeInvokeAvailabilityCallback(long j2, long j3, int i2);

    @UsedByNative("arcoreapk.cc")
    static int requestInstall(Activity activity, boolean z2, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z2).nativeCode;
            return ah.SUCCESS.f30288b;
        } catch (Throwable th) {
            return b(th);
        }
    }

    @UsedByNative("arcoreapk.cc")
    static int requestInstallCustom(Activity activity, boolean z2, int i2, int i3, int[] iArr) throws UnavailableDeviceNotCompatibleException, UnavailableUserDeclinedInstallationException {
        try {
            iArr[0] = ArCoreApk.getInstance().requestInstall(activity, z2, ArCoreApk.InstallBehavior.forNumber(i2), ArCoreApk.UserMessageType.forNumber(i3)).nativeCode;
            return ah.SUCCESS.f30288b;
        } catch (Throwable th) {
            return b(th);
        }
    }
}

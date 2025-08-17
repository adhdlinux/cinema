package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.os.BuildCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {

    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(Activity activity) {
            activity.finishAffinity();
        }

        static void b(Activity activity, Intent intent, int i2, Bundle bundle) {
            activity.startActivityForResult(intent, i2, bundle);
        }

        static void c(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        /* access modifiers changed from: package-private */
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        static void b(Activity activity, String[] strArr, int i2) {
            activity.requestPermissions(strArr, i2);
        }

        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class Api31Impl {
        private Api31Impl() {
        }

        static boolean a(Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(Activity activity, String str) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(packageManager, new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class Api32Impl {
        private Api32Impl() {
        }

        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i2);
    }

    static class SharedElementCallback21Impl extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final SharedElementCallback f2325a;

        SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
            this.f2325a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f2325a.b(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f2325a.c(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f2325a.d(list, map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f2325a.e(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f2325a.f(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f2325a.g(list, list2, list3);
        }

        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f2325a.h(list, list2, new f(onSharedElementsReadyListener));
        }
    }

    protected ActivityCompat() {
    }

    public static void b(Activity activity) {
        Api16Impl.a(activity);
    }

    public static void c(Activity activity) {
        Api21Impl.a(activity);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(Activity activity) {
        if (!activity.isFinishing() && !ActivityRecreator.i(activity)) {
            activity.recreate();
        }
    }

    public static void e(Activity activity) {
        Api21Impl.b(activity);
    }

    public static void f(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    public static void g(final Activity activity, String[] strArr, final int i2) {
        final String[] strArr2;
        HashSet hashSet = new HashSet();
        int i3 = 0;
        while (i3 < strArr.length) {
            if (!TextUtils.isEmpty(strArr[i3])) {
                if (!BuildCompat.d() && TextUtils.equals(strArr[i3], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i3));
                }
                i3++;
            } else {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            strArr2 = new String[(strArr.length - size)];
        } else {
            strArr2 = strArr;
        }
        if (size > 0) {
            if (size != strArr.length) {
                int i4 = 0;
                for (int i5 = 0; i5 < strArr.length; i5++) {
                    if (!hashSet.contains(Integer.valueOf(i5))) {
                        strArr2[i4] = strArr[i5];
                        i4++;
                    }
                }
            } else {
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i2);
            }
            Api23Impl.b(activity, strArr, i2);
        } else if (activity instanceof OnRequestPermissionsResultCallback) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int[] iArr = new int[strArr2.length];
                    PackageManager packageManager = activity.getPackageManager();
                    String packageName = activity.getPackageName();
                    int length = strArr2.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr[i2] = packageManager.checkPermission(strArr2[i2], packageName);
                    }
                    ((OnRequestPermissionsResultCallback) activity).onRequestPermissionsResult(i2, strArr2, iArr);
                }
            });
        }
    }

    public static void h(Activity activity, SharedElementCallback sharedElementCallback) {
        SharedElementCallback21Impl sharedElementCallback21Impl;
        if (sharedElementCallback != null) {
            sharedElementCallback21Impl = new SharedElementCallback21Impl(sharedElementCallback);
        } else {
            sharedElementCallback21Impl = null;
        }
        Api21Impl.c(activity, sharedElementCallback21Impl);
    }

    public static void i(Activity activity, SharedElementCallback sharedElementCallback) {
        SharedElementCallback21Impl sharedElementCallback21Impl;
        if (sharedElementCallback != null) {
            sharedElementCallback21Impl = new SharedElementCallback21Impl(sharedElementCallback);
        } else {
            sharedElementCallback21Impl = null;
        }
        Api21Impl.d(activity, sharedElementCallback21Impl);
    }

    public static boolean j(Activity activity, String str) {
        if (!BuildCompat.d() && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 32) {
            return Api32Impl.a(activity, str);
        }
        if (i2 == 31) {
            return Api31Impl.b(activity, str);
        }
        if (i2 >= 23) {
            return Api23Impl.c(activity, str);
        }
        return false;
    }

    public static void k(Activity activity, Intent intent, int i2, Bundle bundle) {
        Api16Impl.b(activity, intent, i2, bundle);
    }

    public static void l(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Api16Impl.c(activity, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public static void m(Activity activity) {
        Api21Impl.e(activity);
    }
}

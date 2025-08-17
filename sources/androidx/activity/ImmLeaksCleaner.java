package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.LifecycleEventObserver;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: c  reason: collision with root package name */
    private static int f25c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f26d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f27e;

    /* renamed from: f  reason: collision with root package name */
    private static Field f28f;

    /* renamed from: b  reason: collision with root package name */
    private Activity f29b;

    ImmLeaksCleaner(Activity activity) {
        this.f29b = activity;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void g() {
        Class<InputMethodManager> cls = InputMethodManager.class;
        try {
            f25c = 2;
            Field declaredField = cls.getDeclaredField("mServedView");
            f27e = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mNextServedView");
            f28f = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mH");
            f26d = declaredField3;
            declaredField3.setAccessible(true);
            f25c = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStateChanged(androidx.lifecycle.LifecycleOwner r3, androidx.lifecycle.Lifecycle.Event r4) {
        /*
            r2 = this;
            androidx.lifecycle.Lifecycle$Event r3 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY
            if (r4 == r3) goto L_0x0005
            return
        L_0x0005:
            int r3 = f25c
            if (r3 != 0) goto L_0x000c
            g()
        L_0x000c:
            int r3 = f25c
            r4 = 1
            if (r3 != r4) goto L_0x004e
            android.app.Activity r3 = r2.f29b
            java.lang.String r4 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            java.lang.reflect.Field r4 = f26d     // Catch:{ IllegalAccessException -> 0x004e }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalAccessException -> 0x004e }
            if (r4 != 0) goto L_0x0024
            return
        L_0x0024:
            monitor-enter(r4)
            java.lang.reflect.Field r0 = f27e     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            android.view.View r0 = (android.view.View) r0     // Catch:{ IllegalAccessException -> 0x004a, ClassCastException -> 0x0048 }
            if (r0 != 0) goto L_0x0031
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0031:
            boolean r0 = r0.isAttachedToWindow()     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0039
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0039:
            java.lang.reflect.Field r0 = f28f     // Catch:{ IllegalAccessException -> 0x0044 }
            r1 = 0
            r0.set(r3, r1)     // Catch:{ IllegalAccessException -> 0x0044 }
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            r3.isActive()
            goto L_0x004e
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r3 = move-exception
            goto L_0x004c
        L_0x0048:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004a:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            return
        L_0x004c:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r3
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ImmLeaksCleaner.onStateChanged(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Lifecycle$Event):void");
    }
}

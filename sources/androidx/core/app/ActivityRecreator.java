package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ActivityRecreator {

    /* renamed from: a  reason: collision with root package name */
    protected static final Class<?> f2326a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f2327b = b();

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f2328c = f();

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f2329d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f2330e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f2331f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f2332g = new Handler(Looper.getMainLooper());

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        Object f2339b;

        /* renamed from: c  reason: collision with root package name */
        private Activity f2340c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2341d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2342e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f2343f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f2344g = false;

        LifecycleCheckCallbacks(Activity activity) {
            this.f2340c = activity;
            this.f2341d = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f2340c == activity) {
                this.f2340c = null;
                this.f2343f = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f2343f && !this.f2344g && !this.f2342e && ActivityRecreator.h(this.f2339b, this.f2341d, activity)) {
                this.f2344g = true;
                this.f2339b = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f2340c == activity) {
                this.f2342e = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        f2326a = a2;
        f2329d = d(a2);
        f2330e = c(a2);
        f2331f = e(a2);
    }

    private ActivityRecreator() {
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        Class<Configuration> cls2 = Configuration.class;
        Class<List> cls3 = List.class;
        if (g() && cls != null) {
            try {
                Class cls4 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, cls3, cls3, Integer.TYPE, cls4, cls2, cls2, cls4, cls4});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            final Object obj2 = f2328c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i2) {
                    final Object obj3 = f2327b.get(activity);
                    f2332g.postAtFrontOfQueue(new Runnable() {
                        public void run() {
                            try {
                                Method method = ActivityRecreator.f2329d;
                                if (method != null) {
                                    method.invoke(obj3, new Object[]{obj2, Boolean.FALSE, "AppCompat recreation"});
                                    return;
                                }
                                ActivityRecreator.f2330e.invoke(obj3, new Object[]{obj2, Boolean.FALSE});
                            } catch (RuntimeException e2) {
                                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                                    throw e2;
                                }
                            } catch (Throwable th) {
                                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(Activity activity) {
        Object obj;
        final Application application;
        final LifecycleCheckCallbacks lifecycleCheckCallbacks;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f2331f == null) {
            return false;
        } else {
            if (f2330e == null && f2329d == null) {
                return false;
            }
            try {
                final Object obj2 = f2328c.get(activity);
                if (obj2 == null || (obj = f2327b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
                application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                Handler handler = f2332g;
                handler.post(new Runnable() {
                    public void run() {
                        LifecycleCheckCallbacks.this.f2339b = obj2;
                    }
                });
                if (g()) {
                    Method method = f2331f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() {
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}

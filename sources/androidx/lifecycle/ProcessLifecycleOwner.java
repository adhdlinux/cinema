package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ReportFragment;

public class ProcessLifecycleOwner implements LifecycleOwner {

    /* renamed from: j  reason: collision with root package name */
    private static final ProcessLifecycleOwner f3706j = new ProcessLifecycleOwner();

    /* renamed from: b  reason: collision with root package name */
    private int f3707b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f3708c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3709d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3710e = true;

    /* renamed from: f  reason: collision with root package name */
    private Handler f3711f;

    /* renamed from: g  reason: collision with root package name */
    private final LifecycleRegistry f3712g = new LifecycleRegistry(this);

    /* renamed from: h  reason: collision with root package name */
    private Runnable f3713h = new Runnable() {
        public void run() {
            ProcessLifecycleOwner.this.f();
            ProcessLifecycleOwner.this.g();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    ReportFragment.ActivityInitializationListener f3714i = new ReportFragment.ActivityInitializationListener() {
        public void onCreate() {
        }

        public void onResume() {
            ProcessLifecycleOwner.this.b();
        }

        public void onStart() {
            ProcessLifecycleOwner.this.c();
        }
    };

    static class Api29Impl {
        private Api29Impl() {
        }

        static void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    private ProcessLifecycleOwner() {
    }

    public static LifecycleOwner h() {
        return f3706j;
    }

    static void i(Context context) {
        f3706j.e(context);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int i2 = this.f3708c - 1;
        this.f3708c = i2;
        if (i2 == 0) {
            this.f3711f.postDelayed(this.f3713h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2 = this.f3708c + 1;
        this.f3708c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f3709d) {
            this.f3712g.h(Lifecycle.Event.ON_RESUME);
            this.f3709d = false;
            return;
        }
        this.f3711f.removeCallbacks(this.f3713h);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2 = this.f3707b + 1;
        this.f3707b = i2;
        if (i2 == 1 && this.f3710e) {
            this.f3712g.h(Lifecycle.Event.ON_START);
            this.f3710e = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f3707b--;
        g();
    }

    /* access modifiers changed from: package-private */
    public void e(Context context) {
        this.f3711f = new Handler();
        this.f3712g.h(Lifecycle.Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new EmptyActivityLifecycleCallbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (Build.VERSION.SDK_INT < 29) {
                    ReportFragment.f(activity).h(ProcessLifecycleOwner.this.f3714i);
                }
            }

            public void onActivityPaused(Activity activity) {
                ProcessLifecycleOwner.this.a();
            }

            public void onActivityPreCreated(Activity activity, Bundle bundle) {
                Api29Impl.a(activity, new EmptyActivityLifecycleCallbacks() {
                    public void onActivityPostResumed(Activity activity) {
                        ProcessLifecycleOwner.this.b();
                    }

                    public void onActivityPostStarted(Activity activity) {
                        ProcessLifecycleOwner.this.c();
                    }
                });
            }

            public void onActivityStopped(Activity activity) {
                ProcessLifecycleOwner.this.d();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.f3708c == 0) {
            this.f3709d = true;
            this.f3712g.h(Lifecycle.Event.ON_PAUSE);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.f3707b == 0 && this.f3709d) {
            this.f3712g.h(Lifecycle.Event.ON_STOP);
            this.f3710e = true;
        }
    }

    public Lifecycle getLifecycle() {
        return this.f3712g;
    }
}

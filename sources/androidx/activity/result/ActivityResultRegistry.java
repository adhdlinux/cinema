package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f57a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f58b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f59c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LifecycleContainer> f60d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f61e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, CallbackAndContract<?>> f62f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f63g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f64h = new Bundle();

    private static class CallbackAndContract<O> {

        /* renamed from: a  reason: collision with root package name */
        final ActivityResultCallback<O> f75a;

        /* renamed from: b  reason: collision with root package name */
        final ActivityResultContract<?, O> f76b;

        CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f75a = activityResultCallback;
            this.f76b = activityResultContract;
        }
    }

    private static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f77a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<LifecycleEventObserver> f78b = new ArrayList<>();

        LifecycleContainer(Lifecycle lifecycle) {
            this.f77a = lifecycle;
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleEventObserver lifecycleEventObserver) {
            this.f77a.a(lifecycleEventObserver);
            this.f78b.add(lifecycleEventObserver);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Iterator<LifecycleEventObserver> it2 = this.f78b.iterator();
            while (it2.hasNext()) {
                this.f77a.c(it2.next());
            }
            this.f78b.clear();
        }
    }

    private void a(int i2, String str) {
        this.f58b.put(Integer.valueOf(i2), str);
        this.f59c.put(str, Integer.valueOf(i2));
    }

    private <O> void d(String str, int i2, Intent intent, CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract == null || callbackAndContract.f75a == null || !this.f61e.contains(str)) {
            this.f63g.remove(str);
            this.f64h.putParcelable(str, new ActivityResult(i2, intent));
            return;
        }
        callbackAndContract.f75a.a(callbackAndContract.f76b.c(i2, intent));
        this.f61e.remove(str);
    }

    private int e() {
        int nextInt = this.f57a.nextInt(2147418112);
        while (true) {
            int i2 = nextInt + 65536;
            if (!this.f58b.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            nextInt = this.f57a.nextInt(2147418112);
        }
    }

    private void k(String str) {
        if (this.f59c.get(str) == null) {
            a(e(), str);
        }
    }

    public final boolean b(int i2, int i3, Intent intent) {
        String str = this.f58b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        d(str, i3, intent, this.f62f.get(str));
        return true;
    }

    public final <O> boolean c(int i2, @SuppressLint({"UnknownNullness"}) O o2) {
        ActivityResultCallback<O> activityResultCallback;
        String str = this.f58b.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = this.f62f.get(str);
        if (callbackAndContract == null || (activityResultCallback = callbackAndContract.f75a) == null) {
            this.f64h.remove(str);
            this.f63g.put(str, o2);
            return true;
        } else if (!this.f61e.remove(str)) {
            return true;
        } else {
            activityResultCallback.a(o2);
            return true;
        }
    }

    public abstract <I, O> void f(int i2, ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i3, ActivityOptionsCompat activityOptionsCompat);

    public final void g(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                this.f61e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f57a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f64h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                    String str = stringArrayList.get(i2);
                    if (this.f59c.containsKey(str)) {
                        Integer remove = this.f59c.remove(str);
                        if (!this.f64h.containsKey(str)) {
                            this.f58b.remove(remove);
                        }
                    }
                    a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
                }
            }
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f59c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f59c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f61e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f64h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f57a);
    }

    public final <I, O> ActivityResultLauncher<I> i(final String str, final ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        k(str);
        this.f62f.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (this.f63g.containsKey(str)) {
            Object obj = this.f63g.get(str);
            this.f63g.remove(str);
            activityResultCallback.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f64h.getParcelable(str);
        if (activityResult != null) {
            this.f64h.remove(str);
            activityResultCallback.a(activityResultContract.c(activityResult.c(), activityResult.b()));
        }
        return new ActivityResultLauncher<I>() {
            public void b(I i2, ActivityOptionsCompat activityOptionsCompat) {
                Integer num = ActivityResultRegistry.this.f59c.get(str);
                if (num != null) {
                    ActivityResultRegistry.this.f61e.add(str);
                    try {
                        ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i2, activityOptionsCompat);
                    } catch (Exception e2) {
                        ActivityResultRegistry.this.f61e.remove(str);
                        throw e2;
                    }
                } else {
                    throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                }
            }

            public void c() {
                ActivityResultRegistry.this.l(str);
            }
        };
    }

    public final <I, O> ActivityResultLauncher<I> j(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract<I, O> activityResultContract, final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.b().a(Lifecycle.State.STARTED)) {
            k(str);
            LifecycleContainer lifecycleContainer = this.f60d.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            lifecycleContainer.a(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f62f.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
                        if (ActivityResultRegistry.this.f63g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f63g.get(str);
                            ActivityResultRegistry.this.f63g.remove(str);
                            activityResultCallback.a(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f64h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f64h.remove(str);
                            activityResultCallback.a(activityResultContract.c(activityResult.c(), activityResult.b()));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f62f.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f60d.put(str, lifecycleContainer);
            return new ActivityResultLauncher<I>() {
                public void b(I i2, ActivityOptionsCompat activityOptionsCompat) {
                    Integer num = ActivityResultRegistry.this.f59c.get(str);
                    if (num != null) {
                        ActivityResultRegistry.this.f61e.add(str);
                        try {
                            ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i2, activityOptionsCompat);
                        } catch (Exception e2) {
                            ActivityResultRegistry.this.f61e.remove(str);
                            throw e2;
                        }
                    } else {
                        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i2 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    }
                }

                public void c() {
                    ActivityResultRegistry.this.l(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    /* access modifiers changed from: package-private */
    public final void l(String str) {
        Integer remove;
        if (!this.f61e.contains(str) && (remove = this.f59c.remove(str)) != null) {
            this.f58b.remove(remove);
        }
        this.f62f.remove(str);
        if (this.f63g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f63g.get(str));
            this.f63g.remove(str);
        }
        if (this.f64h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f64h.getParcelable(str));
            this.f64h.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.f60d.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.b();
            this.f60d.remove(str);
        }
    }
}

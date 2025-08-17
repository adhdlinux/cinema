package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {

    /* renamed from: j  reason: collision with root package name */
    private static final RequestManagerFactory f16985j = new RequestManagerFactory() {
        public RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private volatile RequestManager f16986b;

    /* renamed from: c  reason: collision with root package name */
    final Map<FragmentManager, RequestManagerFragment> f16987c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f16988d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f16989e;

    /* renamed from: f  reason: collision with root package name */
    private final RequestManagerFactory f16990f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayMap<View, Fragment> f16991g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f16992h = new ArrayMap<>();

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f16993i = new Bundle();

    public interface RequestManagerFactory {
        RequestManager a(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context);
    }

    public RequestManagerRetriever(RequestManagerFactory requestManagerFactory) {
        this.f16990f = requestManagerFactory == null ? f16985j : requestManagerFactory;
        this.f16989e = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    private static Activity b(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @Deprecated
    private RequestManager c(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z2) {
        RequestManagerFragment j2 = j(fragmentManager, fragment, z2);
        RequestManager e2 = j2.e();
        if (e2 != null) {
            return e2;
        }
        RequestManager a2 = this.f16990f.a(Glide.c(context), j2.c(), j2.f(), context);
        j2.k(a2);
        return a2;
    }

    private RequestManager h(Context context) {
        if (this.f16986b == null) {
            synchronized (this) {
                if (this.f16986b == null) {
                    this.f16986b = this.f16990f.a(Glide.c(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                }
            }
        }
        return this.f16986b;
    }

    private RequestManagerFragment j(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z2) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (requestManagerFragment == null && (requestManagerFragment = this.f16987c.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.j(fragment);
            if (z2) {
                requestManagerFragment.c().d();
            }
            this.f16987c.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f16989e.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    private SupportRequestManagerFragment l(androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.i0("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f16988d.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.P(fragment);
            if (z2) {
                supportRequestManagerFragment.H().d();
            }
            this.f16988d.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.n().e(supportRequestManagerFragment, "com.bumptech.glide.manager").i();
            this.f16989e.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private static boolean m(Context context) {
        Activity b2 = b(context);
        if (b2 == null || !b2.isFinishing()) {
            return true;
        }
        return false;
    }

    private RequestManager n(Context context, androidx.fragment.app.FragmentManager fragmentManager, Fragment fragment, boolean z2) {
        SupportRequestManagerFragment l2 = l(fragmentManager, fragment, z2);
        RequestManager J = l2.J();
        if (J != null) {
            return J;
        }
        RequestManager a2 = this.f16990f.a(Glide.c(context), l2.H(), l2.K(), context);
        l2.Q(a2);
        return a2;
    }

    public RequestManager d(Activity activity) {
        if (Util.o()) {
            return e(activity.getApplicationContext());
        }
        a(activity);
        return c(activity, activity.getFragmentManager(), (android.app.Fragment) null, m(activity));
    }

    public RequestManager e(Context context) {
        if (context != null) {
            if (Util.p() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return g((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return d((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return e(contextWrapper.getBaseContext());
                    }
                }
            }
            return h(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager f(Fragment fragment) {
        Preconditions.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.o()) {
            return e(fragment.getContext().getApplicationContext());
        }
        return n(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    public RequestManager g(FragmentActivity fragmentActivity) {
        if (Util.o()) {
            return e(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return n(fragmentActivity, fragmentActivity.getSupportFragmentManager(), (Fragment) null, m(fragmentActivity));
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int i2 = message.what;
        boolean z2 = true;
        if (i2 == 1) {
            obj3 = (FragmentManager) message.obj;
            obj4 = this.f16987c.remove(obj3);
        } else if (i2 != 2) {
            obj = null;
            z2 = false;
            obj2 = null;
            if (z2 && obj == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z2;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj4 = this.f16988d.remove(obj3);
        }
        Object obj5 = obj4;
        obj2 = obj3;
        obj = obj5;
        Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        return z2;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public RequestManagerFragment i(Activity activity) {
        return j(activity.getFragmentManager(), (android.app.Fragment) null, m(activity));
    }

    /* access modifiers changed from: package-private */
    public SupportRequestManagerFragment k(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return l(fragmentManager, (Fragment) null, m(context));
    }
}

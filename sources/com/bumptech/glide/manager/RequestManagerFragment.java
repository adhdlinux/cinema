package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private final ActivityFragmentLifecycle f16978b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManagerTreeNode f16979c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<RequestManagerFragment> f16980d;

    /* renamed from: e  reason: collision with root package name */
    private RequestManager f16981e;

    /* renamed from: f  reason: collision with root package name */
    private RequestManagerFragment f16982f;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f16983g;

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> a() {
            Set<RequestManagerFragment> b2 = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(b2.size());
            for (RequestManagerFragment next : b2) {
                if (next.e() != null) {
                    hashSet.add(next.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f16980d.add(requestManagerFragment);
    }

    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f16983g;
    }

    @TargetApi(17)
    private boolean g(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(Activity activity) {
        l();
        RequestManagerFragment i2 = Glide.c(activity).k().i(activity);
        this.f16982f = i2;
        if (!equals(i2)) {
            this.f16982f.a(this);
        }
    }

    private void i(RequestManagerFragment requestManagerFragment) {
        this.f16980d.remove(requestManagerFragment);
    }

    private void l() {
        RequestManagerFragment requestManagerFragment = this.f16982f;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            this.f16982f = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    public Set<RequestManagerFragment> b() {
        if (equals(this.f16982f)) {
            return Collections.unmodifiableSet(this.f16980d);
        }
        if (this.f16982f == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.f16982f.b()) {
            if (g(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public ActivityFragmentLifecycle c() {
        return this.f16978b;
    }

    public RequestManager e() {
        return this.f16981e;
    }

    public RequestManagerTreeNode f() {
        return this.f16979c;
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.f16983g = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(RequestManager requestManager) {
        this.f16981e = requestManager;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f16978b.c();
        l();
    }

    public void onDetach() {
        super.onDetach();
        l();
    }

    public void onStart() {
        super.onStart();
        this.f16978b.d();
    }

    public void onStop() {
        super.onStop();
        this.f16978b.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f16979c = new FragmentRequestManagerTreeNode();
        this.f16980d = new HashSet();
        this.f16978b = activityFragmentLifecycle;
    }
}

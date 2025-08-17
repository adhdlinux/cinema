package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private final ActivityFragmentLifecycle f16997b;

    /* renamed from: c  reason: collision with root package name */
    private final RequestManagerTreeNode f16998c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f16999d;

    /* renamed from: e  reason: collision with root package name */
    private SupportRequestManagerFragment f17000e;

    /* renamed from: f  reason: collision with root package name */
    private RequestManager f17001f;

    /* renamed from: g  reason: collision with root package name */
    private Fragment f17002g;

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> G = SupportRequestManagerFragment.this.G();
            HashSet hashSet = new HashSet(G.size());
            for (SupportRequestManagerFragment next : G) {
                if (next.J() != null) {
                    hashSet.add(next.J());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void F(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f16999d.add(supportRequestManagerFragment);
    }

    private Fragment I() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        return this.f17002g;
    }

    private static FragmentManager L(Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean M(Fragment fragment) {
        Fragment I = I();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(I)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void N(Context context, FragmentManager fragmentManager) {
        R();
        SupportRequestManagerFragment k2 = Glide.c(context).k().k(context, fragmentManager);
        this.f17000e = k2;
        if (!equals(k2)) {
            this.f17000e.F(this);
        }
    }

    private void O(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f16999d.remove(supportRequestManagerFragment);
    }

    private void R() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17000e;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.O(this);
            this.f17000e = null;
        }
    }

    /* access modifiers changed from: package-private */
    public Set<SupportRequestManagerFragment> G() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17000e;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f16999d);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.f17000e.G()) {
            if (M(next.I())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public ActivityFragmentLifecycle H() {
        return this.f16997b;
    }

    public RequestManager J() {
        return this.f17001f;
    }

    public RequestManagerTreeNode K() {
        return this.f16998c;
    }

    /* access modifiers changed from: package-private */
    public void P(Fragment fragment) {
        FragmentManager L;
        this.f17002g = fragment;
        if (fragment != null && fragment.getContext() != null && (L = L(fragment)) != null) {
            N(fragment.getContext(), L);
        }
    }

    public void Q(RequestManager requestManager) {
        this.f17001f = requestManager;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager L = L(this);
        if (L != null) {
            try {
                N(getContext(), L);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f16997b.c();
        R();
    }

    public void onDetach() {
        super.onDetach();
        this.f17002g = null;
        R();
    }

    public void onStart() {
        super.onStart();
        this.f16997b.d();
    }

    public void onStop() {
        super.onStop();
        this.f16997b.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + I() + "}";
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f16998c = new SupportFragmentRequestManagerTreeNode();
        this.f16999d = new HashSet();
        this.f16997b = activityFragmentLifecycle;
    }
}

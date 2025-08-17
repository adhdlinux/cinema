package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f3492a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentStore f3493b;

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f3494c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3495d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f3496e = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3499a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3499a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3499a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f3499a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f3499a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.AnonymousClass2.<clinit>():void");
        }
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.f3492a = fragmentLifecycleCallbacksDispatcher;
        this.f3493b = fragmentStore;
        this.f3494c = fragment;
    }

    private boolean l(View view) {
        if (view == this.f3494c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f3494c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f3494c.performSaveInstanceState(bundle);
        this.f3492a.j(this.f3494c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f3494c.mView != null) {
            t();
        }
        if (this.f3494c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.f3494c.mSavedViewState);
        }
        if (this.f3494c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.f3494c.mSavedViewRegistryState);
        }
        if (!this.f3494c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.f3494c.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f3494c);
        }
        Fragment fragment = this.f3494c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f3492a;
        Fragment fragment2 = this.f3494c;
        fragmentLifecycleCallbacksDispatcher.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int j2 = this.f3493b.j(this.f3494c);
        Fragment fragment = this.f3494c;
        fragment.mContainer.addView(fragment.mView, j2);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f3494c);
        }
        Fragment fragment = this.f3494c;
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        if (fragment2 != null) {
            FragmentStateManager m2 = this.f3493b.m(fragment2.mWho);
            if (m2 != null) {
                Fragment fragment3 = this.f3494c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                fragmentStateManager = m2;
            } else {
                throw new IllegalStateException("Fragment " + this.f3494c + " declared target fragment " + this.f3494c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = this.f3493b.m(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f3494c + " declared target fragment " + this.f3494c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (fragmentStateManager != null && (FragmentManager.P || fragmentStateManager.k().mState < 1)) {
            fragmentStateManager.m();
        }
        Fragment fragment4 = this.f3494c;
        fragment4.mHost = fragment4.mFragmentManager.u0();
        Fragment fragment5 = this.f3494c;
        fragment5.mParentFragment = fragment5.mFragmentManager.x0();
        this.f3492a.g(this.f3494c, false);
        this.f3494c.performAttach();
        this.f3492a.b(this.f3494c, false);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f3494c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int i2 = this.f3496e;
        int i3 = AnonymousClass2.f3499a[fragment2.mMaxState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                i2 = Math.min(i2, 5);
            } else if (i3 == 3) {
                i2 = Math.min(i2, 1);
            } else if (i3 != 4) {
                i2 = Math.min(i2, -1);
            } else {
                i2 = Math.min(i2, 0);
            }
        }
        Fragment fragment3 = this.f3494c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                i2 = Math.max(this.f3496e, 2);
                View view = this.f3494c.mView;
                if (view != null && view.getParent() == null) {
                    i2 = Math.min(i2, 2);
                }
            } else {
                i2 = this.f3496e < 4 ? Math.min(i2, fragment3.mState) : Math.min(i2, 1);
            }
        }
        if (!this.f3494c.mAdded) {
            i2 = Math.min(i2, 1);
        }
        if (!FragmentManager.P || (viewGroup = fragment.mContainer) == null) {
            lifecycleImpact = null;
        } else {
            lifecycleImpact = SpecialEffectsController.n(viewGroup, (fragment = this.f3494c).getParentFragmentManager()).l(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i2 = Math.min(i2, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i2 = Math.max(i2, 3);
        } else {
            Fragment fragment4 = this.f3494c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i2 = Math.min(i2, 1);
                } else {
                    i2 = Math.min(i2, -1);
                }
            }
        }
        Fragment fragment5 = this.f3494c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i2 = Math.min(i2, 4);
        }
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i2 + " for " + this.f3494c);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f3494c);
        }
        Fragment fragment = this.f3494c;
        if (!fragment.mIsCreated) {
            this.f3492a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.f3494c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f3492a;
            Fragment fragment3 = this.f3494c;
            fragmentLifecycleCallbacksDispatcher.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.f3494c.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r2v9, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r7 = this;
            androidx.fragment.app.Fragment r0 = r7.f3494c
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.G0(r0)
            java.lang.String r1 = "FragmentManager"
            if (r0 == 0) goto L_0x0026
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "moveto CREATE_VIEW: "
            r0.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f3494c
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L_0x0026:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.os.Bundle r2 = r0.mSavedFragmentState
            android.view.LayoutInflater r0 = r0.performGetLayoutInflater(r2)
            androidx.fragment.app.Fragment r2 = r7.f3494c
            android.view.ViewGroup r3 = r2.mContainer
            if (r3 == 0) goto L_0x0036
            goto L_0x00b6
        L_0x0036:
            int r3 = r2.mContainerId
            if (r3 == 0) goto L_0x00b5
            r4 = -1
            if (r3 == r4) goto L_0x0097
            androidx.fragment.app.FragmentManager r2 = r2.mFragmentManager
            androidx.fragment.app.FragmentContainer r2 = r2.o0()
            androidx.fragment.app.Fragment r3 = r7.f3494c
            int r3 = r3.mContainerId
            android.view.View r2 = r2.c(r3)
            r3 = r2
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            if (r3 != 0) goto L_0x00b6
            androidx.fragment.app.Fragment r2 = r7.f3494c
            boolean r4 = r2.mRestored
            if (r4 == 0) goto L_0x0057
            goto L_0x00b6
        L_0x0057:
            android.content.res.Resources r0 = r2.getResources()     // Catch:{ NotFoundException -> 0x0064 }
            androidx.fragment.app.Fragment r1 = r7.f3494c     // Catch:{ NotFoundException -> 0x0064 }
            int r1 = r1.mContainerId     // Catch:{ NotFoundException -> 0x0064 }
            java.lang.String r0 = r0.getResourceName(r1)     // Catch:{ NotFoundException -> 0x0064 }
            goto L_0x0066
        L_0x0064:
            java.lang.String r0 = "unknown"
        L_0x0066:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "No view found for id 0x"
            r2.append(r3)
            androidx.fragment.app.Fragment r3 = r7.f3494c
            int r3 = r3.mContainerId
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r3 = " ("
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ") for fragment "
            r2.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f3494c
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0097:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            androidx.fragment.app.Fragment r2 = r7.f3494c
            r1.append(r2)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b5:
            r3 = 0
        L_0x00b6:
            androidx.fragment.app.Fragment r2 = r7.f3494c
            r2.mContainer = r3
            android.os.Bundle r4 = r2.mSavedFragmentState
            r2.performCreateView(r0, r3, r4)
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            r2 = 2
            if (r0 == 0) goto L_0x0179
            r4 = 0
            r0.setSaveFromParentEnabled(r4)
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r5 = r0.mView
            int r6 = androidx.fragment.R$id.f3249a
            r5.setTag(r6, r0)
            if (r3 == 0) goto L_0x00d8
            r7.b()
        L_0x00d8:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            boolean r3 = r0.mHidden
            if (r3 == 0) goto L_0x00e5
            android.view.View r0 = r0.mView
            r3 = 8
            r0.setVisibility(r3)
        L_0x00e5:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            boolean r0 = androidx.core.view.ViewCompat.U(r0)
            if (r0 == 0) goto L_0x00f7
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            androidx.core.view.ViewCompat.o0(r0)
            goto L_0x0103
        L_0x00f7:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            androidx.fragment.app.FragmentStateManager$1 r3 = new androidx.fragment.app.FragmentStateManager$1
            r3.<init>(r0)
            r0.addOnAttachStateChangeListener(r3)
        L_0x0103:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            r0.performViewCreated()
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r0 = r7.f3492a
            androidx.fragment.app.Fragment r3 = r7.f3494c
            android.view.View r5 = r3.mView
            android.os.Bundle r6 = r3.mSavedFragmentState
            r0.m(r3, r5, r6, r4)
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            int r0 = r0.getVisibility()
            androidx.fragment.app.Fragment r3 = r7.f3494c
            android.view.View r3 = r3.mView
            float r3 = r3.getAlpha()
            boolean r5 = androidx.fragment.app.FragmentManager.P
            if (r5 == 0) goto L_0x016e
            androidx.fragment.app.Fragment r4 = r7.f3494c
            r4.setPostOnViewCreatedAlpha(r3)
            androidx.fragment.app.Fragment r3 = r7.f3494c
            android.view.ViewGroup r4 = r3.mContainer
            if (r4 == 0) goto L_0x0179
            if (r0 != 0) goto L_0x0179
            android.view.View r0 = r3.mView
            android.view.View r0 = r0.findFocus()
            if (r0 == 0) goto L_0x0165
            androidx.fragment.app.Fragment r3 = r7.f3494c
            r3.setFocusedView(r0)
            boolean r3 = androidx.fragment.app.FragmentManager.G0(r2)
            if (r3 == 0) goto L_0x0165
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestFocus: Saved focused view "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " for Fragment "
            r3.append(r0)
            androidx.fragment.app.Fragment r0 = r7.f3494c
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            android.util.Log.v(r1, r0)
        L_0x0165:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            android.view.View r0 = r0.mView
            r1 = 0
            r0.setAlpha(r1)
            goto L_0x0179
        L_0x016e:
            androidx.fragment.app.Fragment r1 = r7.f3494c
            if (r0 != 0) goto L_0x0177
            android.view.ViewGroup r0 = r1.mContainer
            if (r0 == 0) goto L_0x0177
            r4 = 1
        L_0x0177:
            r1.mIsNewlyAdded = r4
        L_0x0179:
            androidx.fragment.app.Fragment r0 = r7.f3494c
            r0.mState = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.f():void");
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean z2;
        boolean z3;
        Fragment f2;
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f3494c);
        }
        Fragment fragment = this.f3494c;
        boolean z4 = true;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2 || this.f3493b.o().p(this.f3494c)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            FragmentHostCallback<?> fragmentHostCallback = this.f3494c.mHost;
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z4 = this.f3493b.o().m();
            } else if (fragmentHostCallback.f() instanceof Activity) {
                z4 = true ^ ((Activity) fragmentHostCallback.f()).isChangingConfigurations();
            }
            if (z2 || z4) {
                this.f3493b.o().g(this.f3494c);
            }
            this.f3494c.performDestroy();
            this.f3492a.d(this.f3494c, false);
            for (FragmentStateManager next : this.f3493b.k()) {
                if (next != null) {
                    Fragment k2 = next.k();
                    if (this.f3494c.mWho.equals(k2.mTargetWho)) {
                        k2.mTarget = this.f3494c;
                        k2.mTargetWho = null;
                    }
                }
            }
            Fragment fragment2 = this.f3494c;
            String str = fragment2.mTargetWho;
            if (str != null) {
                fragment2.mTarget = this.f3493b.f(str);
            }
            this.f3493b.q(this);
            return;
        }
        String str2 = this.f3494c.mTargetWho;
        if (!(str2 == null || (f2 = this.f3493b.f(str2)) == null || !f2.mRetainInstance)) {
            this.f3494c.mTarget = f2;
        }
        this.f3494c.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        View view;
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f3494c);
        }
        Fragment fragment = this.f3494c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f3494c.performDestroyView();
        this.f3492a.n(this.f3494c, false);
        Fragment fragment2 = this.f3494c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.n(null);
        this.f3494c.mInLayout = false;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f3494c);
        }
        this.f3494c.performDetach();
        boolean z2 = false;
        this.f3492a.e(this.f3494c, false);
        Fragment fragment = this.f3494c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z2 = true;
        }
        if (z2 || this.f3493b.o().p(this.f3494c)) {
            if (FragmentManager.G0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f3494c);
            }
            this.f3494c.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        Fragment fragment = this.f3494c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.G0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f3494c);
            }
            Fragment fragment2 = this.f3494c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.f3494c.mSavedFragmentState);
            View view = this.f3494c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f3494c;
                fragment3.mView.setTag(R$id.f3249a, fragment3);
                Fragment fragment4 = this.f3494c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f3494c.performViewCreated();
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.f3492a;
                Fragment fragment5 = this.f3494c;
                fragmentLifecycleCallbacksDispatcher.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f3494c.mState = 2;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment k() {
        return this.f3494c;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f3495d) {
            boolean z2 = false;
            z2 = true;
            try {
                while (true) {
                    int d2 = d();
                    Fragment fragment = this.f3494c;
                    int i2 = fragment.mState;
                    if (d2 != i2) {
                        if (d2 <= i2) {
                            switch (i2 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f3494c.mState = z2 ? 1 : 0;
                                    break;
                                case 2:
                                    fragment.mInLayout = z2;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.G0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f3494c);
                                    }
                                    Fragment fragment2 = this.f3494c;
                                    if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        t();
                                    }
                                    Fragment fragment3 = this.f3494c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        SpecialEffectsController.n(viewGroup2, fragment3.getParentFragmentManager()).d(this);
                                    }
                                    this.f3494c.mState = 3;
                                    break;
                                case 4:
                                    w();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i2 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        SpecialEffectsController.n(viewGroup3, fragment.getParentFragmentManager()).b(SpecialEffectsController.Operation.State.b(this.f3494c.mView.getVisibility()), this);
                                    }
                                    this.f3494c.mState = 4;
                                    break;
                                case 5:
                                    v();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                    } else {
                        if (FragmentManager.P && fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                SpecialEffectsController n2 = SpecialEffectsController.n(viewGroup, fragment.getParentFragmentManager());
                                if (this.f3494c.mHidden) {
                                    n2.c(this);
                                } else {
                                    n2.e(this);
                                }
                            }
                            Fragment fragment4 = this.f3494c;
                            FragmentManager fragmentManager = fragment4.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.E0(fragment4);
                            }
                            Fragment fragment5 = this.f3494c;
                            fragment5.mHiddenChanged = z2;
                            fragment5.onHiddenChanged(fragment5.mHidden);
                        }
                        this.f3495d = z2;
                        return;
                    }
                }
            } finally {
                this.f3495d = z2;
            }
        } else if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f3494c);
        }
        this.f3494c.performPause();
        this.f3492a.f(this.f3494c, false);
    }

    /* access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f3494c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.f3494c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.f3494c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.f3494c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.f3494c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.f3494c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.f3494c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.f3494c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void p() {
        String str;
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f3494c);
        }
        View focusedView = this.f3494c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.G0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                if (requestFocus) {
                    str = "succeeded";
                } else {
                    str = "failed";
                }
                sb.append(str);
                sb.append(" on Fragment ");
                sb.append(this.f3494c);
                sb.append(" resulting in focused view ");
                sb.append(this.f3494c.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f3494c.setFocusedView((View) null);
        this.f3494c.performResume();
        this.f3492a.i(this.f3494c, false);
        Fragment fragment = this.f3494c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    /* access modifiers changed from: package-private */
    public Fragment.SavedState r() {
        Bundle q2;
        if (this.f3494c.mState <= -1 || (q2 = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(q2);
    }

    /* access modifiers changed from: package-private */
    public FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f3494c);
        Fragment fragment = this.f3494c;
        if (fragment.mState <= -1 || fragmentState.f3491n != null) {
            fragmentState.f3491n = fragment.mSavedFragmentState;
        } else {
            Bundle q2 = q();
            fragmentState.f3491n = q2;
            if (this.f3494c.mTargetWho != null) {
                if (q2 == null) {
                    fragmentState.f3491n = new Bundle();
                }
                fragmentState.f3491n.putString("android:target_state", this.f3494c.mTargetWho);
                int i2 = this.f3494c.mTargetRequestCode;
                if (i2 != 0) {
                    fragmentState.f3491n.putInt("android:target_req_state", i2);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f3494c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f3494c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f3494c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f3494c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f3494c.mSavedViewRegistryState = bundle;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i2) {
        this.f3496e = i2;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f3494c);
        }
        this.f3494c.performStart();
        this.f3492a.k(this.f3494c, false);
    }

    /* access modifiers changed from: package-private */
    public void w() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f3494c);
        }
        this.f3494c.performStop();
        this.f3492a.l(this.f3494c, false);
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.f3492a = fragmentLifecycleCallbacksDispatcher;
        this.f3493b = fragmentStore;
        Fragment a2 = fragmentFactory.a(classLoader, fragmentState.f3479b);
        this.f3494c = a2;
        Bundle bundle = fragmentState.f3488k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.setArguments(fragmentState.f3488k);
        a2.mWho = fragmentState.f3480c;
        a2.mFromLayout = fragmentState.f3481d;
        a2.mRestored = true;
        a2.mFragmentId = fragmentState.f3482e;
        a2.mContainerId = fragmentState.f3483f;
        a2.mTag = fragmentState.f3484g;
        a2.mRetainInstance = fragmentState.f3485h;
        a2.mRemoving = fragmentState.f3486i;
        a2.mDetached = fragmentState.f3487j;
        a2.mHidden = fragmentState.f3489l;
        a2.mMaxState = Lifecycle.State.values()[fragmentState.f3490m];
        Bundle bundle2 = fragmentState.f3491n;
        if (bundle2 != null) {
            a2.mSavedFragmentState = bundle2;
        } else {
            a2.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.f3492a = fragmentLifecycleCallbacksDispatcher;
        this.f3493b = fragmentStore;
        this.f3494c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f3491n;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}

package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    private static boolean O = false;
    static boolean P = true;
    private ActivityResultLauncher<IntentSenderRequest> A;
    private ActivityResultLauncher<String[]> B;
    ArrayDeque<LaunchedFragmentInfo> C = new ArrayDeque<>();
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private ArrayList<BackStackRecord> I;
    private ArrayList<Boolean> J;
    private ArrayList<Fragment> K;
    private ArrayList<StartEnterTransitionListener> L;
    private FragmentManagerViewModel M;
    private Runnable N = new Runnable() {
        public void run() {
            FragmentManager.this.b0(true);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<OpGenerator> f3411a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f3412b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final FragmentStore f3413c = new FragmentStore();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<BackStackRecord> f3414d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Fragment> f3415e;

    /* renamed from: f  reason: collision with root package name */
    private final FragmentLayoutInflaterFactory f3416f = new FragmentLayoutInflaterFactory(this);

    /* renamed from: g  reason: collision with root package name */
    private OnBackPressedDispatcher f3417g;

    /* renamed from: h  reason: collision with root package name */
    private final OnBackPressedCallback f3418h = new OnBackPressedCallback(false) {
        public void b() {
            FragmentManager.this.C0();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final AtomicInteger f3419i = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, Bundle> f3420j = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Map<String, Object> f3421k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<OnBackStackChangedListener> f3422l;

    /* renamed from: m  reason: collision with root package name */
    private Map<Fragment, HashSet<CancellationSignal>> f3423m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n  reason: collision with root package name */
    private final FragmentTransition.Callback f3424n = new FragmentTransition.Callback() {
        public void a(Fragment fragment, CancellationSignal cancellationSignal) {
            if (!cancellationSignal.b()) {
                FragmentManager.this.f1(fragment, cancellationSignal);
            }
        }

        public void b(Fragment fragment, CancellationSignal cancellationSignal) {
            FragmentManager.this.f(fragment, cancellationSignal);
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private final FragmentLifecycleCallbacksDispatcher f3425o = new FragmentLifecycleCallbacksDispatcher(this);

    /* renamed from: p  reason: collision with root package name */
    private final CopyOnWriteArrayList<FragmentOnAttachListener> f3426p = new CopyOnWriteArrayList<>();

    /* renamed from: q  reason: collision with root package name */
    int f3427q = -1;

    /* renamed from: r  reason: collision with root package name */
    private FragmentHostCallback<?> f3428r;

    /* renamed from: s  reason: collision with root package name */
    private FragmentContainer f3429s;

    /* renamed from: t  reason: collision with root package name */
    private Fragment f3430t;

    /* renamed from: u  reason: collision with root package name */
    Fragment f3431u;

    /* renamed from: v  reason: collision with root package name */
    private FragmentFactory f3432v = null;

    /* renamed from: w  reason: collision with root package name */
    private FragmentFactory f3433w = new FragmentFactory() {
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.u0().b(FragmentManager.this.u0().f(), str, (Bundle) null);
        }
    };

    /* renamed from: x  reason: collision with root package name */
    private SpecialEffectsControllerFactory f3434x = null;

    /* renamed from: y  reason: collision with root package name */
    private SpecialEffectsControllerFactory f3435y = new SpecialEffectsControllerFactory() {
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    };

    /* renamed from: z  reason: collision with root package name */
    private ActivityResultLauncher<Intent> f3436z;

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    class AnonymousClass6 implements LifecycleEventObserver {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3444b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Lifecycle f3445c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ FragmentManager f3446d;

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START && ((Bundle) this.f3446d.f3420j.get(this.f3444b)) != null) {
                throw null;
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                this.f3445c.c(this);
                this.f3446d.f3421k.remove(this.f3444b);
            }
        }
    }

    static class FragmentIntentSenderContract extends ActivityResultContract<IntentSenderRequest, ActivityResult> {
        FragmentIntentSenderContract() {
        }

        /* renamed from: d */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent b2 = intentSenderRequest.b();
            if (!(b2 == null || (bundleExtra = b2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                b2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (b2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.Builder(intentSenderRequest.e()).b((Intent) null).c(intentSenderRequest.d(), intentSenderRequest.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        /* renamed from: e */
        public ActivityResult c(int i2, Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }

    public static abstract class FragmentLifecycleCallbacks {
        @Deprecated
        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    interface OpGenerator {
        boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class PopBackStackState implements OpGenerator {

        /* renamed from: a  reason: collision with root package name */
        final String f3456a;

        /* renamed from: b  reason: collision with root package name */
        final int f3457b;

        /* renamed from: c  reason: collision with root package name */
        final int f3458c;

        PopBackStackState(String str, int i2, int i3) {
            this.f3456a = str;
            this.f3457b = i2;
            this.f3458c = i3;
        }

        public boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f3431u;
            if (fragment != null && this.f3457b < 0 && this.f3456a == null && fragment.getChildFragmentManager().Z0()) {
                return false;
            }
            return FragmentManager.this.b1(arrayList, arrayList2, this.f3456a, this.f3457b, this.f3458c);
        }
    }

    static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final boolean f3460a;

        /* renamed from: b  reason: collision with root package name */
        final BackStackRecord f3461b;

        /* renamed from: c  reason: collision with root package name */
        private int f3462c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z2) {
            this.f3460a = z2;
            this.f3461b = backStackRecord;
        }

        public void a() {
            this.f3462c++;
        }

        public void b() {
            int i2 = this.f3462c - 1;
            this.f3462c = i2;
            if (i2 == 0) {
                this.f3461b.f3264t.o1();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            BackStackRecord backStackRecord = this.f3461b;
            backStackRecord.f3264t.u(backStackRecord, this.f3460a, false, false);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            boolean z2;
            if (this.f3462c > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            for (Fragment next : this.f3461b.f3264t.t0()) {
                next.setOnStartEnterTransitionListener((Fragment.OnStartEnterTransitionListener) null);
                if (z2 && next.isPostponed()) {
                    next.startPostponedEnterTransition();
                }
            }
            BackStackRecord backStackRecord = this.f3461b;
            backStackRecord.f3264t.u(backStackRecord, this.f3460a, !z2, true);
        }

        public boolean e() {
            return this.f3462c == 0;
        }
    }

    static Fragment A0(View view) {
        Object tag = view.getTag(R$id.f3249a);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    static boolean G0(int i2) {
        return O || Log.isLoggable("FragmentManager", i2);
    }

    private boolean H0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.p();
    }

    private void M(Fragment fragment) {
        if (fragment != null && fragment.equals(g0(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    private void P0(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment i3 = arraySet.i(i2);
            if (!i3.mAdded) {
                View requireView = i3.requireView();
                i3.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void T(int i2) {
        try {
            this.f3412b = true;
            this.f3413c.d(i2);
            R0(i2, false);
            if (P) {
                for (SpecialEffectsController j2 : s()) {
                    j2.j();
                }
            }
            this.f3412b = false;
            b0(true);
        } catch (Throwable th) {
            this.f3412b = false;
            throw th;
        }
    }

    private void W() {
        if (this.H) {
            this.H = false;
            u1();
        }
    }

    private void Y() {
        if (P) {
            for (SpecialEffectsController j2 : s()) {
                j2.j();
            }
        } else if (!this.f3423m.isEmpty()) {
            for (Fragment next : this.f3423m.keySet()) {
                o(next);
                S0(next);
            }
        }
    }

    private void a0(boolean z2) {
        if (this.f3412b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f3428r == null) {
            if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() == this.f3428r.g().getLooper()) {
            if (!z2) {
                q();
            }
            if (this.I == null) {
                this.I = new ArrayList<>();
                this.J = new ArrayList<>();
            }
            this.f3412b = true;
            try {
                f0((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f3412b = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    private boolean a1(String str, int i2, int i3) {
        b0(false);
        a0(true);
        Fragment fragment = this.f3431u;
        if (fragment != null && i2 < 0 && str == null && fragment.getChildFragmentManager().Z0()) {
            return true;
        }
        boolean b12 = b1(this.I, this.J, str, i2, i3);
        if (b12) {
            this.f3412b = true;
            try {
                h1(this.I, this.J);
            } finally {
                r();
            }
        }
        x1();
        W();
        this.f3413c.b();
        return b12;
    }

    private int c1(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, ArraySet<Fragment> arraySet) {
        boolean z2;
        int i4 = i3;
        for (int i5 = i3 - 1; i5 >= i2; i5--) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            boolean booleanValue = arrayList2.get(i5).booleanValue();
            if (!backStackRecord.G() || backStackRecord.E(arrayList, i5 + 1, i3)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                if (this.L == null) {
                    this.L = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.L.add(startEnterTransitionListener);
                backStackRecord.I(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.z();
                } else {
                    backStackRecord.A(false);
                }
                i4--;
                if (i5 != i4) {
                    arrayList.remove(i5);
                    arrayList.add(i4, backStackRecord);
                }
                d(arraySet);
            }
        }
        return i4;
    }

    private void d(ArraySet<Fragment> arraySet) {
        int i2 = this.f3427q;
        if (i2 >= 1) {
            int min = Math.min(i2, 5);
            for (Fragment next : this.f3413c.n()) {
                if (next.mState < min) {
                    T0(next, min);
                    if (next.mView != null && !next.mHidden && next.mIsNewlyAdded) {
                        arraySet.add(next);
                    }
                }
            }
        }
    }

    private static void d0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        while (i2 < i3) {
            BackStackRecord backStackRecord = arrayList.get(i2);
            boolean z2 = true;
            if (arrayList2.get(i2).booleanValue()) {
                backStackRecord.v(-1);
                if (i2 != i3 - 1) {
                    z2 = false;
                }
                backStackRecord.A(z2);
            } else {
                backStackRecord.v(1);
                backStackRecord.z();
            }
            i2++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0(java.util.ArrayList<androidx.fragment.app.BackStackRecord> r18, java.util.ArrayList<java.lang.Boolean> r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            r15 = r18
            r5 = r19
            r4 = r20
            r3 = r21
            java.lang.Object r0 = r15.get(r4)
            androidx.fragment.app.BackStackRecord r0 = (androidx.fragment.app.BackStackRecord) r0
            boolean r2 = r0.f3528r
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r6.K = r0
            goto L_0x0021
        L_0x001e:
            r0.clear()
        L_0x0021:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            androidx.fragment.app.FragmentStore r1 = r6.f3413c
            java.util.List r1 = r1.n()
            r0.addAll(r1)
            androidx.fragment.app.Fragment r0 = r17.y0()
            r1 = 0
            r7 = r4
            r16 = 0
        L_0x0034:
            r14 = 1
            if (r7 >= r3) goto L_0x0065
            java.lang.Object r8 = r15.get(r7)
            androidx.fragment.app.BackStackRecord r8 = (androidx.fragment.app.BackStackRecord) r8
            java.lang.Object r9 = r5.get(r7)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0050
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.B(r9, r0)
            goto L_0x0056
        L_0x0050:
            java.util.ArrayList<androidx.fragment.app.Fragment> r9 = r6.K
            androidx.fragment.app.Fragment r0 = r8.J(r9, r0)
        L_0x0056:
            if (r16 != 0) goto L_0x0060
            boolean r8 = r8.f3519i
            if (r8 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r16 = 0
            goto L_0x0062
        L_0x0060:
            r16 = 1
        L_0x0062:
            int r7 = r7 + 1
            goto L_0x0034
        L_0x0065:
            java.util.ArrayList<androidx.fragment.app.Fragment> r0 = r6.K
            r0.clear()
            if (r2 != 0) goto L_0x00bd
            int r0 = r6.f3427q
            if (r0 < r14) goto L_0x00bd
            boolean r0 = P
            if (r0 == 0) goto L_0x00a4
            r0 = r4
        L_0x0075:
            if (r0 >= r3) goto L_0x00bd
            java.lang.Object r1 = r15.get(r0)
            androidx.fragment.app.BackStackRecord r1 = (androidx.fragment.app.BackStackRecord) r1
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op> r1 = r1.f3513c
            java.util.Iterator r1 = r1.iterator()
        L_0x0083:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x00a1
            java.lang.Object r7 = r1.next()
            androidx.fragment.app.FragmentTransaction$Op r7 = (androidx.fragment.app.FragmentTransaction.Op) r7
            androidx.fragment.app.Fragment r7 = r7.f3531b
            if (r7 == 0) goto L_0x0083
            androidx.fragment.app.FragmentManager r8 = r7.mFragmentManager
            if (r8 == 0) goto L_0x0083
            androidx.fragment.app.FragmentStateManager r7 = r6.w(r7)
            androidx.fragment.app.FragmentStore r8 = r6.f3413c
            r8.p(r7)
            goto L_0x0083
        L_0x00a1:
            int r0 = r0 + 1
            goto L_0x0075
        L_0x00a4:
            androidx.fragment.app.FragmentHostCallback<?> r0 = r6.f3428r
            android.content.Context r7 = r0.f()
            androidx.fragment.app.FragmentContainer r8 = r6.f3429s
            r13 = 0
            androidx.fragment.app.FragmentTransition$Callback r0 = r6.f3424n
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r21
            r1 = 1
            r14 = r0
            androidx.fragment.app.FragmentTransition.C(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00be
        L_0x00bd:
            r1 = 1
        L_0x00be:
            d0(r18, r19, r20, r21)
            boolean r0 = P
            if (r0 == 0) goto L_0x0143
            int r0 = r3 + -1
            java.lang.Object r0 = r5.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = r4
        L_0x00d2:
            if (r2 >= r3) goto L_0x011c
            java.lang.Object r7 = r15.get(r2)
            androidx.fragment.app.BackStackRecord r7 = (androidx.fragment.app.BackStackRecord) r7
            if (r0 == 0) goto L_0x00fb
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op> r8 = r7.f3513c
            int r8 = r8.size()
            int r8 = r8 - r1
        L_0x00e3:
            if (r8 < 0) goto L_0x0119
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op> r9 = r7.f3513c
            java.lang.Object r9 = r9.get(r8)
            androidx.fragment.app.FragmentTransaction$Op r9 = (androidx.fragment.app.FragmentTransaction.Op) r9
            androidx.fragment.app.Fragment r9 = r9.f3531b
            if (r9 == 0) goto L_0x00f8
            androidx.fragment.app.FragmentStateManager r9 = r6.w(r9)
            r9.m()
        L_0x00f8:
            int r8 = r8 + -1
            goto L_0x00e3
        L_0x00fb:
            java.util.ArrayList<androidx.fragment.app.FragmentTransaction$Op> r7 = r7.f3513c
            java.util.Iterator r7 = r7.iterator()
        L_0x0101:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0119
            java.lang.Object r8 = r7.next()
            androidx.fragment.app.FragmentTransaction$Op r8 = (androidx.fragment.app.FragmentTransaction.Op) r8
            androidx.fragment.app.Fragment r8 = r8.f3531b
            if (r8 == 0) goto L_0x0101
            androidx.fragment.app.FragmentStateManager r8 = r6.w(r8)
            r8.m()
            goto L_0x0101
        L_0x0119:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x011c:
            int r2 = r6.f3427q
            r6.R0(r2, r1)
            java.util.Set r1 = r6.t(r15, r4, r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0129:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x013f
            java.lang.Object r2 = r1.next()
            androidx.fragment.app.SpecialEffectsController r2 = (androidx.fragment.app.SpecialEffectsController) r2
            r2.r(r0)
            r2.p()
            r2.g()
            goto L_0x0129
        L_0x013f:
            r0 = r3
            r3 = r5
            goto L_0x0199
        L_0x0143:
            if (r2 == 0) goto L_0x0165
            androidx.collection.ArraySet r7 = new androidx.collection.ArraySet
            r7.<init>()
            r6.d(r7)
            r0 = r17
            r14 = 1
            r1 = r18
            r8 = r2
            r2 = r19
            r13 = r3
            r3 = r20
            r12 = r4
            r4 = r21
            r11 = r5
            r5 = r7
            int r0 = r0.c1(r1, r2, r3, r4, r5)
            r6.P0(r7)
            goto L_0x016b
        L_0x0165:
            r8 = r2
            r13 = r3
            r12 = r4
            r11 = r5
            r14 = 1
            r0 = r13
        L_0x016b:
            if (r0 == r12) goto L_0x0197
            if (r8 == 0) goto L_0x0197
            int r1 = r6.f3427q
            if (r1 < r14) goto L_0x018e
            androidx.fragment.app.FragmentHostCallback<?> r1 = r6.f3428r
            android.content.Context r7 = r1.f()
            androidx.fragment.app.FragmentContainer r8 = r6.f3429s
            r1 = 1
            androidx.fragment.app.FragmentTransition$Callback r2 = r6.f3424n
            r9 = r18
            r10 = r19
            r3 = r11
            r11 = r20
            r12 = r0
            r0 = r13
            r13 = r1
            r1 = 1
            r14 = r2
            androidx.fragment.app.FragmentTransition.C(r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0191
        L_0x018e:
            r3 = r11
            r0 = r13
            r1 = 1
        L_0x0191:
            int r2 = r6.f3427q
            r6.R0(r2, r1)
            goto L_0x0199
        L_0x0197:
            r3 = r11
            r0 = r13
        L_0x0199:
            r1 = r20
        L_0x019b:
            if (r1 >= r0) goto L_0x01bc
            java.lang.Object r2 = r15.get(r1)
            androidx.fragment.app.BackStackRecord r2 = (androidx.fragment.app.BackStackRecord) r2
            java.lang.Object r4 = r3.get(r1)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x01b6
            int r4 = r2.f3266v
            if (r4 < 0) goto L_0x01b6
            r4 = -1
            r2.f3266v = r4
        L_0x01b6:
            r2.H()
            int r1 = r1 + 1
            goto L_0x019b
        L_0x01bc:
            if (r16 == 0) goto L_0x01c1
            r17.j1()
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.e0(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private void f0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int i2;
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.L;
        if (arrayList3 == null) {
            i2 = 0;
        } else {
            i2 = arrayList3.size();
        }
        int i3 = 0;
        while (i3 < i2) {
            StartEnterTransitionListener startEnterTransitionListener = this.L.get(i3);
            if (arrayList != null && !startEnterTransitionListener.f3460a && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.f3461b)) != -1 && arrayList2 != null && arrayList2.get(indexOf2).booleanValue()) {
                this.L.remove(i3);
                i3--;
                i2--;
                startEnterTransitionListener.c();
            } else if (startEnterTransitionListener.e() || (arrayList != null && startEnterTransitionListener.f3461b.E(arrayList, 0, arrayList.size()))) {
                this.L.remove(i3);
                i3--;
                i2--;
                if (arrayList == null || startEnterTransitionListener.f3460a || (indexOf = arrayList.indexOf(startEnterTransitionListener.f3461b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.d();
                } else {
                    startEnterTransitionListener.c();
                }
            }
            i3++;
        }
    }

    private void h1(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                f0(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).f3528r) {
                        if (i3 != i2) {
                            e0(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).f3528r) {
                                i3++;
                            }
                        }
                        e0(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    e0(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    private void j1() {
        if (this.f3422l != null) {
            for (int i2 = 0; i2 < this.f3422l.size(); i2++) {
                this.f3422l.get(i2).onBackStackChanged();
            }
        }
    }

    private void k0() {
        if (P) {
            for (SpecialEffectsController k2 : s()) {
                k2.k();
            }
        } else if (this.L != null) {
            while (!this.L.isEmpty()) {
                this.L.remove(0).d();
            }
        }
    }

    private boolean l0(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f3411a) {
            if (this.f3411a.isEmpty()) {
                return false;
            }
            int size = this.f3411a.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                z2 |= this.f3411a.get(i2).a(arrayList, arrayList2);
            }
            this.f3411a.clear();
            this.f3428r.g().removeCallbacks(this.N);
            return z2;
        }
    }

    static int l1(int i2) {
        if (i2 == 4097) {
            return 8194;
        }
        if (i2 != 4099) {
            return i2 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private FragmentManagerViewModel n0(Fragment fragment) {
        return this.M.i(fragment);
    }

    private void o(Fragment fragment) {
        HashSet hashSet = this.f3423m.get(fragment);
        if (hashSet != null) {
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((CancellationSignal) it2.next()).a();
            }
            hashSet.clear();
            x(fragment);
            this.f3423m.remove(fragment);
        }
    }

    private void q() {
        if (L0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private ViewGroup q0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f3429s.d()) {
            View c2 = this.f3429s.c(fragment.mContainerId);
            if (c2 instanceof ViewGroup) {
                return (ViewGroup) c2;
            }
        }
        return null;
    }

    private void r() {
        this.f3412b = false;
        this.J.clear();
        this.I.clear();
    }

    private Set<SpecialEffectsController> s() {
        HashSet hashSet = new HashSet();
        for (FragmentStateManager k2 : this.f3413c.k()) {
            ViewGroup viewGroup = k2.k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, z0()));
            }
        }
        return hashSet;
    }

    private void s1(Fragment fragment) {
        ViewGroup q02 = q0(fragment);
        if (q02 != null && fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() > 0) {
            int i2 = R$id.f3251c;
            if (q02.getTag(i2) == null) {
                q02.setTag(i2, fragment);
            }
            ((Fragment) q02.getTag(i2)).setPopDirection(fragment.getPopDirection());
        }
    }

    private Set<SpecialEffectsController> t(ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i2 < i3) {
            Iterator<FragmentTransaction.Op> it2 = arrayList.get(i2).f3513c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = it2.next().f3531b;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i2++;
        }
        return hashSet;
    }

    private void u1() {
        for (FragmentStateManager W0 : this.f3413c.k()) {
            W0(W0);
        }
    }

    private void v(final Fragment fragment) {
        int i2;
        Animator animator;
        if (fragment.mView != null) {
            FragmentAnim.AnimationOrAnimator c2 = FragmentAnim.c(this.f3428r.f(), fragment, !fragment.mHidden, fragment.getPopDirection());
            if (c2 == null || (animator = c2.f3387b) == null) {
                if (c2 != null) {
                    fragment.mView.startAnimation(c2.f3386a);
                    c2.f3386a.start();
                }
                if (!fragment.mHidden || fragment.isHideReplaced()) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                fragment.mView.setVisibility(i2);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            } else {
                animator.setTarget(fragment.mView);
                if (!fragment.mHidden) {
                    fragment.mView.setVisibility(0);
                } else if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = fragment.mContainer;
                    final View view = fragment.mView;
                    viewGroup.startViewTransition(view);
                    c2.f3387b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            Fragment fragment = fragment;
                            View view = fragment.mView;
                            if (view != null && fragment.mHidden) {
                                view.setVisibility(8);
                            }
                        }
                    });
                }
                c2.f3387b.start();
            }
        }
        E0(fragment);
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    private void v1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback<?> fragmentHostCallback = this.f3428r;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.h("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        } else {
            try {
                X("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e3) {
                Log.e("FragmentManager", "Failed dumping state", e3);
            }
        }
        throw runtimeException;
    }

    private void x(Fragment fragment) {
        fragment.performDestroyView();
        this.f3425o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.n(null);
        fragment.mInLayout = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (m0() <= 0) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (J0(r3.f3430t) == false) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r0.f(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r0 = r3.f3418h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x1() {
        /*
            r3 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r0 = r3.f3411a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$OpGenerator> r1 = r3.f3411a     // Catch:{ all -> 0x002a }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != 0) goto L_0x0013
            androidx.activity.OnBackPressedCallback r1 = r3.f3418h     // Catch:{ all -> 0x002a }
            r1.f(r2)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            androidx.activity.OnBackPressedCallback r0 = r3.f3418h
            int r1 = r3.m0()
            if (r1 <= 0) goto L_0x0025
            androidx.fragment.app.Fragment r1 = r3.f3430t
            boolean r1 = r3.J0(r1)
            if (r1 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = 0
        L_0x0026:
            r0.f(r2)
            return
        L_0x002a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.x1():void");
    }

    /* access modifiers changed from: package-private */
    public void A() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(0);
    }

    /* access modifiers changed from: package-private */
    public void B(Configuration configuration) {
        for (Fragment next : this.f3413c.n()) {
            if (next != null) {
                next.performConfigurationChanged(configuration);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ViewModelStore B0(Fragment fragment) {
        return this.M.l(fragment);
    }

    /* access modifiers changed from: package-private */
    public boolean C(MenuItem menuItem) {
        if (this.f3427q < 1) {
            return false;
        }
        for (Fragment next : this.f3413c.n()) {
            if (next != null && next.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void C0() {
        b0(true);
        if (this.f3418h.c()) {
            Z0();
        } else {
            this.f3417g.f();
        }
    }

    /* access modifiers changed from: package-private */
    public void D() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(1);
    }

    /* access modifiers changed from: package-private */
    public void D0(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            s1(fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean E(Menu menu, MenuInflater menuInflater) {
        if (this.f3427q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment next : this.f3413c.n()) {
            if (next != null && I0(next) && next.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                z2 = true;
            }
        }
        if (this.f3415e != null) {
            for (int i2 = 0; i2 < this.f3415e.size(); i2++) {
                Fragment fragment = this.f3415e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment)) {
                    fragment.onDestroyOptionsMenu();
                }
            }
        }
        this.f3415e = arrayList;
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void E0(Fragment fragment) {
        if (fragment.mAdded && H0(fragment)) {
            this.D = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void F() {
        this.G = true;
        b0(true);
        Y();
        T(-1);
        this.f3428r = null;
        this.f3429s = null;
        this.f3430t = null;
        if (this.f3417g != null) {
            this.f3418h.d();
            this.f3417g = null;
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.f3436z;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
            this.A.c();
            this.B.c();
        }
    }

    public boolean F0() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void G() {
        T(1);
    }

    /* access modifiers changed from: package-private */
    public void H() {
        for (Fragment next : this.f3413c.n()) {
            if (next != null) {
                next.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I(boolean z2) {
        for (Fragment next : this.f3413c.n()) {
            if (next != null) {
                next.performMultiWindowModeChanged(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    /* access modifiers changed from: package-private */
    public void J(Fragment fragment) {
        Iterator<FragmentOnAttachListener> it2 = this.f3426p.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, fragment);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean J0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.y0()) || !J0(fragmentManager.f3430t)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean K(MenuItem menuItem) {
        if (this.f3427q < 1) {
            return false;
        }
        for (Fragment next : this.f3413c.n()) {
            if (next != null && next.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean K0(int i2) {
        return this.f3427q >= i2;
    }

    /* access modifiers changed from: package-private */
    public void L(Menu menu) {
        if (this.f3427q >= 1) {
            for (Fragment next : this.f3413c.n()) {
                if (next != null) {
                    next.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public boolean L0() {
        return this.E || this.F;
    }

    /* access modifiers changed from: package-private */
    public void M0(Fragment fragment, String[] strArr, int i2) {
        if (this.B != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            this.B.a(strArr);
            return;
        }
        this.f3428r.k(fragment, strArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void N() {
        T(5);
    }

    /* access modifiers changed from: package-private */
    public void N0(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.f3436z != null) {
            this.C.addLast(new LaunchedFragmentInfo(fragment.mWho, i2));
            if (!(intent == null || bundle == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            this.f3436z.a(intent);
            return;
        }
        this.f3428r.n(fragment, intent, i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z2) {
        for (Fragment next : this.f3413c.n()) {
            if (next != null) {
                next.performPictureInPictureModeChanged(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void O0(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        Fragment fragment2 = fragment;
        Bundle bundle2 = bundle;
        if (this.A != null) {
            if (bundle2 != null) {
                if (intent == null) {
                    intent2 = new Intent();
                    intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                } else {
                    intent2 = intent;
                }
                if (G0(2)) {
                    Log.v("FragmentManager", "ActivityOptions " + bundle2 + " were added to fillInIntent " + intent2 + " for fragment " + fragment);
                }
                intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle2);
            } else {
                intent2 = intent;
            }
            IntentSender intentSender2 = intentSender;
            IntentSenderRequest a2 = new IntentSenderRequest.Builder(intentSender).b(intent2).c(i4, i3).a();
            int i6 = i2;
            this.C.addLast(new LaunchedFragmentInfo(fragment2.mWho, i2));
            if (G0(2)) {
                Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
            }
            this.A.a(a2);
            return;
        }
        IntentSender intentSender3 = intentSender;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        this.f3428r.o(fragment, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    /* access modifiers changed from: package-private */
    public boolean P(Menu menu) {
        boolean z2 = false;
        if (this.f3427q < 1) {
            return false;
        }
        for (Fragment next : this.f3413c.n()) {
            if (next != null && I0(next) && next.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void Q() {
        x1();
        M(this.f3431u);
    }

    /* access modifiers changed from: package-private */
    public void Q0(Fragment fragment) {
        if (this.f3413c.c(fragment.mWho)) {
            S0(fragment);
            View view = fragment.mView;
            if (!(view == null || !fragment.mIsNewlyAdded || fragment.mContainer == null)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    view.setAlpha(f2);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                FragmentAnim.AnimationOrAnimator c2 = FragmentAnim.c(this.f3428r.f(), fragment, true, fragment.getPopDirection());
                if (c2 != null) {
                    Animation animation = c2.f3386a;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        c2.f3387b.setTarget(fragment.mView);
                        c2.f3387b.start();
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                v(fragment);
            }
        } else if (G0(3)) {
            Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f3427q + "since it is not added to " + this);
        }
    }

    /* access modifiers changed from: package-private */
    public void R() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(7);
    }

    /* access modifiers changed from: package-private */
    public void R0(int i2, boolean z2) {
        FragmentHostCallback<?> fragmentHostCallback;
        boolean z3;
        if (this.f3428r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.f3427q) {
            this.f3427q = i2;
            if (P) {
                this.f3413c.r();
            } else {
                for (Fragment Q0 : this.f3413c.n()) {
                    Q0(Q0);
                }
                for (FragmentStateManager next : this.f3413c.k()) {
                    Fragment k2 = next.k();
                    if (!k2.mIsNewlyAdded) {
                        Q0(k2);
                    }
                    if (!k2.mRemoving || k2.isInBackStack()) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        this.f3413c.q(next);
                    }
                }
            }
            u1();
            if (this.D && (fragmentHostCallback = this.f3428r) != null && this.f3427q == 7) {
                fragmentHostCallback.p();
                this.D = false;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void S() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(5);
    }

    /* access modifiers changed from: package-private */
    public void S0(Fragment fragment) {
        T0(fragment, this.f3427q);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != 5) goto L_0x0165;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0161  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T0(androidx.fragment.app.Fragment r11, int r12) {
        /*
            r10 = this;
            androidx.fragment.app.FragmentStore r0 = r10.f3413c
            java.lang.String r1 = r11.mWho
            androidx.fragment.app.FragmentStateManager r0 = r0.m(r1)
            r1 = 1
            if (r0 != 0) goto L_0x0017
            androidx.fragment.app.FragmentStateManager r0 = new androidx.fragment.app.FragmentStateManager
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r2 = r10.f3425o
            androidx.fragment.app.FragmentStore r3 = r10.f3413c
            r0.<init>(r2, r3, r11)
            r0.u(r1)
        L_0x0017:
            boolean r2 = r11.mFromLayout
            r3 = 2
            if (r2 == 0) goto L_0x0028
            boolean r2 = r11.mInLayout
            if (r2 == 0) goto L_0x0028
            int r2 = r11.mState
            if (r2 != r3) goto L_0x0028
            int r12 = java.lang.Math.max(r12, r3)
        L_0x0028:
            int r2 = r0.d()
            int r12 = java.lang.Math.min(r12, r2)
            int r2 = r11.mState
            r4 = 3
            java.lang.String r5 = "FragmentManager"
            r6 = -1
            r7 = 5
            r8 = 4
            if (r2 > r12) goto L_0x007c
            if (r2 >= r12) goto L_0x0047
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3423m
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0047
            r10.o(r11)
        L_0x0047:
            int r2 = r11.mState
            if (r2 == r6) goto L_0x0057
            if (r2 == 0) goto L_0x005c
            if (r2 == r1) goto L_0x0061
            if (r2 == r3) goto L_0x006b
            if (r2 == r8) goto L_0x0070
            if (r2 == r7) goto L_0x0075
            goto L_0x0165
        L_0x0057:
            if (r12 <= r6) goto L_0x005c
            r0.c()
        L_0x005c:
            if (r12 <= 0) goto L_0x0061
            r0.e()
        L_0x0061:
            if (r12 <= r6) goto L_0x0066
            r0.j()
        L_0x0066:
            if (r12 <= r1) goto L_0x006b
            r0.f()
        L_0x006b:
            if (r12 <= r3) goto L_0x0070
            r0.a()
        L_0x0070:
            if (r12 <= r8) goto L_0x0075
            r0.v()
        L_0x0075:
            if (r12 <= r7) goto L_0x0165
            r0.p()
            goto L_0x0165
        L_0x007c:
            if (r2 <= r12) goto L_0x0165
            if (r2 == 0) goto L_0x015e
            if (r2 == r1) goto L_0x0150
            if (r2 == r3) goto L_0x00c6
            if (r2 == r8) goto L_0x0097
            if (r2 == r7) goto L_0x0092
            r9 = 7
            if (r2 == r9) goto L_0x008d
            goto L_0x0165
        L_0x008d:
            if (r12 >= r9) goto L_0x0092
            r0.n()
        L_0x0092:
            if (r12 >= r7) goto L_0x0097
            r0.w()
        L_0x0097:
            if (r12 >= r8) goto L_0x00c6
            boolean r2 = G0(r4)
            if (r2 == 0) goto L_0x00b3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "movefrom ACTIVITY_CREATED: "
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r5, r2)
        L_0x00b3:
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x00c6
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.f3428r
            boolean r2 = r2.l(r11)
            if (r2 == 0) goto L_0x00c6
            android.util.SparseArray<android.os.Parcelable> r2 = r11.mSavedViewState
            if (r2 != 0) goto L_0x00c6
            r0.t()
        L_0x00c6:
            if (r12 >= r3) goto L_0x0150
            android.view.View r2 = r11.mView
            if (r2 == 0) goto L_0x0145
            android.view.ViewGroup r7 = r11.mContainer
            if (r7 == 0) goto L_0x0145
            r7.endViewTransition(r2)
            android.view.View r2 = r11.mView
            r2.clearAnimation()
            boolean r2 = r11.isRemovingParent()
            if (r2 != 0) goto L_0x0145
            int r2 = r10.f3427q
            r7 = 0
            if (r2 <= r6) goto L_0x0105
            boolean r2 = r10.G
            if (r2 != 0) goto L_0x0105
            android.view.View r2 = r11.mView
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0105
            float r2 = r11.mPostponedAlpha
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0105
            androidx.fragment.app.FragmentHostCallback<?> r2 = r10.f3428r
            android.content.Context r2 = r2.f()
            r6 = 0
            boolean r8 = r11.getPopDirection()
            androidx.fragment.app.FragmentAnim$AnimationOrAnimator r2 = androidx.fragment.app.FragmentAnim.c(r2, r11, r6, r8)
            goto L_0x0106
        L_0x0105:
            r2 = 0
        L_0x0106:
            r11.mPostponedAlpha = r7
            android.view.ViewGroup r6 = r11.mContainer
            android.view.View r7 = r11.mView
            if (r2 == 0) goto L_0x0113
            androidx.fragment.app.FragmentTransition$Callback r8 = r10.f3424n
            androidx.fragment.app.FragmentAnim.a(r11, r2, r8)
        L_0x0113:
            r6.removeView(r7)
            boolean r2 = G0(r3)
            if (r2 == 0) goto L_0x0140
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Removing view "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " for fragment "
            r2.append(r3)
            r2.append(r11)
            java.lang.String r3 = " from container "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.v(r5, r2)
        L_0x0140:
            android.view.ViewGroup r2 = r11.mContainer
            if (r6 == r2) goto L_0x0145
            return
        L_0x0145:
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3423m
            java.lang.Object r2 = r2.get(r11)
            if (r2 != 0) goto L_0x0150
            r0.h()
        L_0x0150:
            if (r12 >= r1) goto L_0x015e
            java.util.Map<androidx.fragment.app.Fragment, java.util.HashSet<androidx.core.os.CancellationSignal>> r2 = r10.f3423m
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L_0x015b
            goto L_0x015f
        L_0x015b:
            r0.g()
        L_0x015e:
            r1 = r12
        L_0x015f:
            if (r1 >= 0) goto L_0x0164
            r0.i()
        L_0x0164:
            r12 = r1
        L_0x0165:
            int r0 = r11.mState
            if (r0 == r12) goto L_0x0197
            boolean r0 = G0(r4)
            if (r0 == 0) goto L_0x0195
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "moveToState: Fragment state for "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r1 = " not updated inline; expected state "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r1 = " found "
            r0.append(r1)
            int r1 = r11.mState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r5, r0)
        L_0x0195:
            r11.mState = r12
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.T0(androidx.fragment.app.Fragment, int):void");
    }

    /* access modifiers changed from: package-private */
    public void U() {
        this.F = true;
        this.M.o(true);
        T(4);
    }

    /* access modifiers changed from: package-private */
    public void U0() {
        if (this.f3428r != null) {
            this.E = false;
            this.F = false;
            this.M.o(false);
            for (Fragment next : this.f3413c.n()) {
                if (next != null) {
                    next.noteStateNotSaved();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void V() {
        T(2);
    }

    /* access modifiers changed from: package-private */
    public void V0(FragmentContainerView fragmentContainerView) {
        View view;
        for (FragmentStateManager next : this.f3413c.k()) {
            Fragment k2 = next.k();
            if (k2.mContainerId == fragmentContainerView.getId() && (view = k2.mView) != null && view.getParent() == null) {
                k2.mContainer = fragmentContainerView;
                next.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void W0(FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (!k2.mDeferStart) {
            return;
        }
        if (this.f3412b) {
            this.H = true;
            return;
        }
        k2.mDeferStart = false;
        if (P) {
            fragmentStateManager.m();
        } else {
            S0(k2);
        }
    }

    public void X(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f3413c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f3415e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f3415e.get(i2).toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.f3414d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                BackStackRecord backStackRecord = this.f3414d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.x(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3419i.get());
        synchronized (this.f3411a) {
            int size3 = this.f3411a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i4 = 0; i4 < size3; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f3411a.get(i4));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3428r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3429s);
        if (this.f3430t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3430t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3427q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public void X0() {
        Z(new PopBackStackState((String) null, -1, 0), false);
    }

    public void Y0(int i2, int i3) {
        if (i2 >= 0) {
            Z(new PopBackStackState((String) null, i2, i3), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i2);
    }

    /* access modifiers changed from: package-private */
    public void Z(OpGenerator opGenerator, boolean z2) {
        if (!z2) {
            if (this.f3428r != null) {
                q();
            } else if (this.G) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
        }
        synchronized (this.f3411a) {
            if (this.f3428r != null) {
                this.f3411a.add(opGenerator);
                o1();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public boolean Z0() {
        return a1((String) null, -1, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean b0(boolean z2) {
        a0(z2);
        boolean z3 = false;
        while (l0(this.I, this.J)) {
            z3 = true;
            this.f3412b = true;
            try {
                h1(this.I, this.J);
            } finally {
                r();
            }
        }
        x1();
        W();
        this.f3413c.b();
        return z3;
    }

    /* access modifiers changed from: package-private */
    public boolean b1(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        int i4;
        ArrayList<BackStackRecord> arrayList3 = this.f3414d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f3414d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    BackStackRecord backStackRecord = this.f3414d.get(size2);
                    if ((str != null && str.equals(backStackRecord.C())) || (i2 >= 0 && i2 == backStackRecord.f3266v)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.f3414d.get(size2);
                        if ((str == null || !str.equals(backStackRecord2.C())) && (i2 < 0 || i2 != backStackRecord2.f3266v)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            } else {
                i4 = -1;
            }
            if (i4 == this.f3414d.size() - 1) {
                return false;
            }
            for (int size3 = this.f3414d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.f3414d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c0(OpGenerator opGenerator, boolean z2) {
        if (!z2 || (this.f3428r != null && !this.G)) {
            a0(z2);
            if (opGenerator.a(this.I, this.J)) {
                this.f3412b = true;
                try {
                    h1(this.I, this.J);
                } finally {
                    r();
                }
            }
            x1();
            W();
            this.f3413c.b();
        }
    }

    public void d1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            v1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    /* access modifiers changed from: package-private */
    public void e(BackStackRecord backStackRecord) {
        if (this.f3414d == null) {
            this.f3414d = new ArrayList<>();
        }
        this.f3414d.add(backStackRecord);
    }

    public void e1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z2) {
        this.f3425o.o(fragmentLifecycleCallbacks, z2);
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment, CancellationSignal cancellationSignal) {
        if (this.f3423m.get(fragment) == null) {
            this.f3423m.put(fragment, new HashSet());
        }
        this.f3423m.get(fragment).add(cancellationSignal);
    }

    /* access modifiers changed from: package-private */
    public void f1(Fragment fragment, CancellationSignal cancellationSignal) {
        HashSet hashSet = this.f3423m.get(fragment);
        if (hashSet != null && hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            this.f3423m.remove(fragment);
            if (fragment.mState < 5) {
                x(fragment);
                S0(fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager g(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager w2 = w(fragment);
        fragment.mFragmentManager = this;
        this.f3413c.p(w2);
        if (!fragment.mDetached) {
            this.f3413c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (H0(fragment)) {
                this.D = true;
            }
        }
        return w2;
    }

    /* access modifiers changed from: package-private */
    public Fragment g0(String str) {
        return this.f3413c.f(str);
    }

    /* access modifiers changed from: package-private */
    public void g1(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.f3413c.s(fragment);
            if (H0(fragment)) {
                this.D = true;
            }
            fragment.mRemoving = true;
            s1(fragment);
        }
    }

    public void h(FragmentOnAttachListener fragmentOnAttachListener) {
        this.f3426p.add(fragmentOnAttachListener);
    }

    public Fragment h0(int i2) {
        return this.f3413c.g(i2);
    }

    public void i(OnBackStackChangedListener onBackStackChangedListener) {
        if (this.f3422l == null) {
            this.f3422l = new ArrayList<>();
        }
        this.f3422l.add(onBackStackChangedListener);
    }

    public Fragment i0(String str) {
        return this.f3413c.h(str);
    }

    /* access modifiers changed from: package-private */
    public void i1(Fragment fragment) {
        this.M.n(fragment);
    }

    /* access modifiers changed from: package-private */
    public void j(Fragment fragment) {
        this.M.f(fragment);
    }

    /* access modifiers changed from: package-private */
    public Fragment j0(String str) {
        return this.f3413c.i(str);
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f3419i.getAndIncrement();
    }

    /* access modifiers changed from: package-private */
    public void k1(Parcelable parcelable) {
        FragmentStateManager fragmentStateManager;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f3463b != null) {
                this.f3413c.t();
                Iterator<FragmentState> it2 = fragmentManagerState.f3463b.iterator();
                while (it2.hasNext()) {
                    FragmentState next = it2.next();
                    if (next != null) {
                        Fragment h2 = this.M.h(next.f3480c);
                        if (h2 != null) {
                            if (G0(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + h2);
                            }
                            fragmentStateManager = new FragmentStateManager(this.f3425o, this.f3413c, h2, next);
                        } else {
                            fragmentStateManager = new FragmentStateManager(this.f3425o, this.f3413c, this.f3428r.f().getClassLoader(), r0(), next);
                        }
                        Fragment k2 = fragmentStateManager.k();
                        k2.mFragmentManager = this;
                        if (G0(2)) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + k2.mWho + "): " + k2);
                        }
                        fragmentStateManager.o(this.f3428r.f().getClassLoader());
                        this.f3413c.p(fragmentStateManager);
                        fragmentStateManager.u(this.f3427q);
                    }
                }
                for (Fragment next2 : this.M.k()) {
                    if (!this.f3413c.c(next2.mWho)) {
                        if (G0(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next2 + " that was not found in the set of active Fragments " + fragmentManagerState.f3463b);
                        }
                        this.M.n(next2);
                        next2.mFragmentManager = this;
                        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.f3425o, this.f3413c, next2);
                        fragmentStateManager2.u(1);
                        fragmentStateManager2.m();
                        next2.mRemoving = true;
                        fragmentStateManager2.m();
                    }
                }
                this.f3413c.u(fragmentManagerState.f3464c);
                if (fragmentManagerState.f3465d != null) {
                    this.f3414d = new ArrayList<>(fragmentManagerState.f3465d.length);
                    int i2 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.f3465d;
                        if (i2 >= backStackStateArr.length) {
                            break;
                        }
                        BackStackRecord b2 = backStackStateArr[i2].b(this);
                        if (G0(2)) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + b2.f3266v + "): " + b2);
                            PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                            b2.y("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f3414d.add(b2);
                        i2++;
                    }
                } else {
                    this.f3414d = null;
                }
                this.f3419i.set(fragmentManagerState.f3466e);
                String str = fragmentManagerState.f3467f;
                if (str != null) {
                    Fragment g02 = g0(str);
                    this.f3431u = g02;
                    M(g02);
                }
                ArrayList<String> arrayList = fragmentManagerState.f3468g;
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Bundle bundle = fragmentManagerState.f3469h.get(i3);
                        bundle.setClassLoader(this.f3428r.f().getClassLoader());
                        this.f3420j.put(arrayList.get(i3), bundle);
                    }
                }
                this.C = new ArrayDeque<>(fragmentManagerState.f3470i);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: androidx.activity.OnBackPressedDispatcherOwner} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: androidx.fragment.app.Fragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: androidx.fragment.app.Fragment} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(androidx.fragment.app.FragmentHostCallback<?> r3, androidx.fragment.app.FragmentContainer r4, final androidx.fragment.app.Fragment r5) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentHostCallback<?> r0 = r2.f3428r
            if (r0 != 0) goto L_0x0108
            r2.f3428r = r3
            r2.f3429s = r4
            r2.f3430t = r5
            if (r5 == 0) goto L_0x0015
            androidx.fragment.app.FragmentManager$8 r4 = new androidx.fragment.app.FragmentManager$8
            r4.<init>(r5)
            r2.h(r4)
            goto L_0x001f
        L_0x0015:
            boolean r4 = r3 instanceof androidx.fragment.app.FragmentOnAttachListener
            if (r4 == 0) goto L_0x001f
            r4 = r3
            androidx.fragment.app.FragmentOnAttachListener r4 = (androidx.fragment.app.FragmentOnAttachListener) r4
            r2.h(r4)
        L_0x001f:
            androidx.fragment.app.Fragment r4 = r2.f3430t
            if (r4 == 0) goto L_0x0026
            r2.x1()
        L_0x0026:
            boolean r4 = r3 instanceof androidx.activity.OnBackPressedDispatcherOwner
            if (r4 == 0) goto L_0x003b
            r4 = r3
            androidx.activity.OnBackPressedDispatcherOwner r4 = (androidx.activity.OnBackPressedDispatcherOwner) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f3417g = r0
            if (r5 == 0) goto L_0x0036
            r4 = r5
        L_0x0036:
            androidx.activity.OnBackPressedCallback r1 = r2.f3418h
            r0.b(r4, r1)
        L_0x003b:
            if (r5 == 0) goto L_0x0046
            androidx.fragment.app.FragmentManager r3 = r5.mFragmentManager
            androidx.fragment.app.FragmentManagerViewModel r3 = r3.n0(r5)
            r2.M = r3
            goto L_0x005f
        L_0x0046:
            boolean r4 = r3 instanceof androidx.lifecycle.ViewModelStoreOwner
            if (r4 == 0) goto L_0x0057
            androidx.lifecycle.ViewModelStoreOwner r3 = (androidx.lifecycle.ViewModelStoreOwner) r3
            androidx.lifecycle.ViewModelStore r3 = r3.getViewModelStore()
            androidx.fragment.app.FragmentManagerViewModel r3 = androidx.fragment.app.FragmentManagerViewModel.j(r3)
            r2.M = r3
            goto L_0x005f
        L_0x0057:
            androidx.fragment.app.FragmentManagerViewModel r3 = new androidx.fragment.app.FragmentManagerViewModel
            r4 = 0
            r3.<init>(r4)
            r2.M = r3
        L_0x005f:
            androidx.fragment.app.FragmentManagerViewModel r3 = r2.M
            boolean r4 = r2.L0()
            r3.o(r4)
            androidx.fragment.app.FragmentStore r3 = r2.f3413c
            androidx.fragment.app.FragmentManagerViewModel r4 = r2.M
            r3.x(r4)
            androidx.fragment.app.FragmentHostCallback<?> r3 = r2.f3428r
            boolean r4 = r3 instanceof androidx.activity.result.ActivityResultRegistryOwner
            if (r4 == 0) goto L_0x0107
            androidx.activity.result.ActivityResultRegistryOwner r3 = (androidx.activity.result.ActivityResultRegistryOwner) r3
            androidx.activity.result.ActivityResultRegistry r3 = r3.getActivityResultRegistry()
            if (r5 == 0) goto L_0x0091
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r5.mWho
            r4.append(r5)
            java.lang.String r5 = ":"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = ""
        L_0x0093:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "FragmentManager:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartActivityForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult r0 = new androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult
            r0.<init>()
            androidx.fragment.app.FragmentManager$9 r1 = new androidx.fragment.app.FragmentManager$9
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.i(r5, r0, r1)
            r2.f3436z = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r0 = "StartIntentSenderForResult"
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            androidx.fragment.app.FragmentManager$FragmentIntentSenderContract r0 = new androidx.fragment.app.FragmentManager$FragmentIntentSenderContract
            r0.<init>()
            androidx.fragment.app.FragmentManager$10 r1 = new androidx.fragment.app.FragmentManager$10
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r5 = r3.i(r5, r0, r1)
            r2.A = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            java.lang.String r4 = "RequestPermissions"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions r5 = new androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
            r5.<init>()
            androidx.fragment.app.FragmentManager$11 r0 = new androidx.fragment.app.FragmentManager$11
            r0.<init>()
            androidx.activity.result.ActivityResultLauncher r3 = r3.i(r4, r5, r0)
            r2.B = r3
        L_0x0107:
            return
        L_0x0108:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.l(androidx.fragment.app.FragmentHostCallback, androidx.fragment.app.FragmentContainer, androidx.fragment.app.Fragment):void");
    }

    /* access modifiers changed from: package-private */
    public void m(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.f3413c.a(fragment);
                if (G0(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (H0(fragment)) {
                    this.D = true;
                }
            }
        }
    }

    public int m0() {
        ArrayList<BackStackRecord> arrayList = this.f3414d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public Parcelable m1() {
        int size;
        k0();
        Y();
        b0(true);
        this.E = true;
        this.M.o(true);
        ArrayList<FragmentState> v2 = this.f3413c.v();
        BackStackState[] backStackStateArr = null;
        if (v2.isEmpty()) {
            if (G0(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        ArrayList<String> w2 = this.f3413c.w();
        ArrayList<BackStackRecord> arrayList = this.f3414d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.f3414d.get(i2));
                if (G0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f3414d.get(i2));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f3463b = v2;
        fragmentManagerState.f3464c = w2;
        fragmentManagerState.f3465d = backStackStateArr;
        fragmentManagerState.f3466e = this.f3419i.get();
        Fragment fragment = this.f3431u;
        if (fragment != null) {
            fragmentManagerState.f3467f = fragment.mWho;
        }
        fragmentManagerState.f3468g.addAll(this.f3420j.keySet());
        fragmentManagerState.f3469h.addAll(this.f3420j.values());
        fragmentManagerState.f3470i = new ArrayList<>(this.C);
        return fragmentManagerState;
    }

    public FragmentTransaction n() {
        return new BackStackRecord(this);
    }

    public Fragment.SavedState n1(Fragment fragment) {
        FragmentStateManager m2 = this.f3413c.m(fragment.mWho);
        if (m2 == null || !m2.k().equals(fragment)) {
            v1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return m2.r();
    }

    /* access modifiers changed from: package-private */
    public FragmentContainer o0() {
        return this.f3429s;
    }

    /* access modifiers changed from: package-private */
    public void o1() {
        boolean z2;
        synchronized (this.f3411a) {
            ArrayList<StartEnterTransitionListener> arrayList = this.L;
            boolean z3 = false;
            if (arrayList == null || arrayList.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (this.f3411a.size() == 1) {
                z3 = true;
            }
            if (z2 || z3) {
                this.f3428r.g().removeCallbacks(this.N);
                this.f3428r.g().post(this.N);
                x1();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        boolean z2 = false;
        for (Fragment next : this.f3413c.l()) {
            if (next != null) {
                z2 = H0(next);
                continue;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public Fragment p0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment g02 = g0(string);
        if (g02 == null) {
            v1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return g02;
    }

    /* access modifiers changed from: package-private */
    public void p1(Fragment fragment, boolean z2) {
        ViewGroup q02 = q0(fragment);
        if (q02 != null && (q02 instanceof FragmentContainerView)) {
            ((FragmentContainerView) q02).setDrawDisappearingViewsLast(!z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void q1(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(g0(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public FragmentFactory r0() {
        FragmentFactory fragmentFactory = this.f3432v;
        if (fragmentFactory != null) {
            return fragmentFactory;
        }
        Fragment fragment = this.f3430t;
        if (fragment != null) {
            return fragment.mFragmentManager.r0();
        }
        return this.f3433w;
    }

    /* access modifiers changed from: package-private */
    public void r1(Fragment fragment) {
        if (fragment == null || (fragment.equals(g0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f3431u;
            this.f3431u = fragment;
            M(fragment2);
            M(this.f3431u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* access modifiers changed from: package-private */
    public FragmentStore s0() {
        return this.f3413c;
    }

    public List<Fragment> t0() {
        return this.f3413c.n();
    }

    /* access modifiers changed from: package-private */
    public void t1(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f3430t;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3430t)));
            sb.append("}");
        } else {
            FragmentHostCallback<?> fragmentHostCallback = this.f3428r;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3428r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void u(BackStackRecord backStackRecord, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            backStackRecord.A(z4);
        } else {
            backStackRecord.z();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.f3427q >= 1) {
            FragmentTransition.C(this.f3428r.f(), this.f3429s, arrayList, arrayList2, 0, 1, true, this.f3424n);
        }
        if (z4) {
            R0(this.f3427q, true);
        }
        for (Fragment next : this.f3413c.l()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && backStackRecord.D(next.mContainerId)) {
                float f2 = next.mPostponedAlpha;
                if (f2 > 0.0f) {
                    next.mView.setAlpha(f2);
                }
                if (z4) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public FragmentHostCallback<?> u0() {
        return this.f3428r;
    }

    /* access modifiers changed from: package-private */
    public LayoutInflater.Factory2 v0() {
        return this.f3416f;
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager w(Fragment fragment) {
        FragmentStateManager m2 = this.f3413c.m(fragment.mWho);
        if (m2 != null) {
            return m2;
        }
        FragmentStateManager fragmentStateManager = new FragmentStateManager(this.f3425o, this.f3413c, fragment);
        fragmentStateManager.o(this.f3428r.f().getClassLoader());
        fragmentStateManager.u(this.f3427q);
        return fragmentStateManager;
    }

    /* access modifiers changed from: package-private */
    public FragmentLifecycleCallbacksDispatcher w0() {
        return this.f3425o;
    }

    public void w1(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.f3425o.p(fragmentLifecycleCallbacks);
    }

    /* access modifiers changed from: package-private */
    public Fragment x0() {
        return this.f3430t;
    }

    /* access modifiers changed from: package-private */
    public void y(Fragment fragment) {
        if (G0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (G0(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.f3413c.s(fragment);
                if (H0(fragment)) {
                    this.D = true;
                }
                s1(fragment);
            }
        }
    }

    public Fragment y0() {
        return this.f3431u;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        this.E = false;
        this.F = false;
        this.M.o(false);
        T(4);
    }

    /* access modifiers changed from: package-private */
    public SpecialEffectsControllerFactory z0() {
        SpecialEffectsControllerFactory specialEffectsControllerFactory = this.f3434x;
        if (specialEffectsControllerFactory != null) {
            return specialEffectsControllerFactory;
        }
        Fragment fragment = this.f3430t;
        if (fragment != null) {
            return fragment.mFragmentManager.z0();
        }
        return this.f3435y;
    }

    @SuppressLint({"BanParcelableUsage"})
    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new Parcelable.Creator<LaunchedFragmentInfo>() {
            /* renamed from: a */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* renamed from: b */
            public LaunchedFragmentInfo[] newArray(int i2) {
                return new LaunchedFragmentInfo[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        String f3454b;

        /* renamed from: c  reason: collision with root package name */
        int f3455c;

        LaunchedFragmentInfo(String str, int i2) {
            this.f3454b = str;
            this.f3455c = i2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3454b);
            parcel.writeInt(this.f3455c);
        }

        LaunchedFragmentInfo(Parcel parcel) {
            this.f3454b = parcel.readString();
            this.f3455c = parcel.readInt();
        }
    }
}

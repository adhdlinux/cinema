package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class FragmentTransition {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3538a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    static final FragmentTransitionImpl f3539b = new FragmentTransitionCompat21();

    /* renamed from: c  reason: collision with root package name */
    static final FragmentTransitionImpl f3540c = x();

    interface Callback {
        void a(Fragment fragment, CancellationSignal cancellationSignal);

        void b(Fragment fragment, CancellationSignal cancellationSignal);
    }

    static class FragmentContainerTransition {

        /* renamed from: a  reason: collision with root package name */
        public Fragment f3575a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3576b;

        /* renamed from: c  reason: collision with root package name */
        public BackStackRecord f3577c;

        /* renamed from: d  reason: collision with root package name */
        public Fragment f3578d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3579e;

        /* renamed from: f  reason: collision with root package name */
        public BackStackRecord f3580f;

        FragmentContainerTransition() {
        }
    }

    private FragmentTransition() {
    }

    private static void A(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z2, BackStackRecord backStackRecord) {
        String str;
        ArrayList<String> arrayList = backStackRecord.f3526p;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (z2) {
                str = backStackRecord.f3527q.get(0);
            } else {
                str = backStackRecord.f3526p.get(0);
            }
            View view = arrayMap.get(str);
            fragmentTransitionImpl.v(obj, view);
            if (obj2 != null) {
                fragmentTransitionImpl.v(obj2, view);
            }
        }
    }

    static void B(ArrayList<View> arrayList, int i2) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i2);
            }
        }
    }

    static void C(Context context, FragmentContainer fragmentContainer, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3, boolean z2, Callback callback) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i4 = i2; i4 < i3; i4++) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue()) {
                e(backStackRecord, sparseArray, z2);
            } else {
                c(backStackRecord, sparseArray, z2);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i5 = 0; i5 < size; i5++) {
                int keyAt = sparseArray.keyAt(i5);
                ArrayMap<String, String> d2 = d(keyAt, arrayList, arrayList2, i2, i3);
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i5);
                if (fragmentContainer.d() && (viewGroup = (ViewGroup) fragmentContainer.c(keyAt)) != null) {
                    if (z2) {
                        o(viewGroup, fragmentContainerTransition, view, d2, callback);
                    } else {
                        n(viewGroup, fragmentContainerTransition, view, d2, callback);
                    }
                }
            }
        }
    }

    private static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View n2 = arrayMap.n(size);
            if (collection.contains(ViewCompat.M(n2))) {
                arrayList.add(n2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0039, code lost:
        if (r0.mAdded != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006e, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x008a, code lost:
        if (r0.mHidden == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x008c, code lost:
        r9 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(androidx.fragment.app.BackStackRecord r8, androidx.fragment.app.FragmentTransaction.Op r9, android.util.SparseArray<androidx.fragment.app.FragmentTransition.FragmentContainerTransition> r10, boolean r11, boolean r12) {
        /*
            androidx.fragment.app.Fragment r0 = r9.f3531b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            int r1 = r0.mContainerId
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            if (r11 == 0) goto L_0x0013
            int[] r2 = f3538a
            int r9 = r9.f3530a
            r9 = r2[r9]
            goto L_0x0015
        L_0x0013:
            int r9 = r9.f3530a
        L_0x0015:
            r2 = 0
            r3 = 1
            if (r9 == r3) goto L_0x007f
            r4 = 3
            if (r9 == r4) goto L_0x0057
            r4 = 4
            if (r9 == r4) goto L_0x003f
            r4 = 5
            if (r9 == r4) goto L_0x002d
            r4 = 6
            if (r9 == r4) goto L_0x0057
            r4 = 7
            if (r9 == r4) goto L_0x007f
            r9 = 0
            r3 = 0
        L_0x002a:
            r4 = 0
            goto L_0x0092
        L_0x002d:
            if (r12 == 0) goto L_0x003c
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x008e
            goto L_0x008c
        L_0x003c:
            boolean r9 = r0.mHidden
            goto L_0x008f
        L_0x003f:
            if (r12 == 0) goto L_0x004e
            boolean r9 = r0.mHiddenChanged
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 == 0) goto L_0x0070
        L_0x004d:
            goto L_0x006e
        L_0x004e:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x004d
        L_0x0057:
            if (r12 == 0) goto L_0x0072
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x0070
            android.view.View r9 = r0.mView
            if (r9 == 0) goto L_0x0070
            int r9 = r9.getVisibility()
            if (r9 != 0) goto L_0x0070
            float r9 = r0.mPostponedAlpha
            r4 = 0
            int r9 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0070
        L_0x006e:
            r9 = 1
            goto L_0x007b
        L_0x0070:
            r9 = 0
            goto L_0x007b
        L_0x0072:
            boolean r9 = r0.mAdded
            if (r9 == 0) goto L_0x0070
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x0070
            goto L_0x006e
        L_0x007b:
            r4 = r9
            r9 = 1
            r3 = 0
            goto L_0x0092
        L_0x007f:
            if (r12 == 0) goto L_0x0084
            boolean r9 = r0.mIsNewlyAdded
            goto L_0x008f
        L_0x0084:
            boolean r9 = r0.mAdded
            if (r9 != 0) goto L_0x008e
            boolean r9 = r0.mHidden
            if (r9 != 0) goto L_0x008e
        L_0x008c:
            r9 = 1
            goto L_0x008f
        L_0x008e:
            r9 = 0
        L_0x008f:
            r2 = r9
            r9 = 0
            goto L_0x002a
        L_0x0092:
            java.lang.Object r5 = r10.get(r1)
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r5 = (androidx.fragment.app.FragmentTransition.FragmentContainerTransition) r5
            if (r2 == 0) goto L_0x00a4
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r5 = p(r5, r10, r1)
            r5.f3575a = r0
            r5.f3576b = r11
            r5.f3577c = r8
        L_0x00a4:
            r2 = 0
            if (r12 != 0) goto L_0x00c5
            if (r3 == 0) goto L_0x00c5
            if (r5 == 0) goto L_0x00b1
            androidx.fragment.app.Fragment r3 = r5.f3578d
            if (r3 != r0) goto L_0x00b1
            r5.f3578d = r2
        L_0x00b1:
            boolean r3 = r8.f3528r
            if (r3 != 0) goto L_0x00c5
            androidx.fragment.app.FragmentManager r3 = r8.f3264t
            androidx.fragment.app.FragmentStateManager r6 = r3.w(r0)
            androidx.fragment.app.FragmentStore r7 = r3.s0()
            r7.p(r6)
            r3.S0(r0)
        L_0x00c5:
            if (r4 == 0) goto L_0x00d7
            if (r5 == 0) goto L_0x00cd
            androidx.fragment.app.Fragment r3 = r5.f3578d
            if (r3 != 0) goto L_0x00d7
        L_0x00cd:
            androidx.fragment.app.FragmentTransition$FragmentContainerTransition r5 = p(r5, r10, r1)
            r5.f3578d = r0
            r5.f3579e = r11
            r5.f3580f = r8
        L_0x00d7:
            if (r12 != 0) goto L_0x00e3
            if (r9 == 0) goto L_0x00e3
            if (r5 == 0) goto L_0x00e3
            androidx.fragment.app.Fragment r8 = r5.f3575a
            if (r8 != r0) goto L_0x00e3
            r5.f3575a = r2
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTransition.b(androidx.fragment.app.BackStackRecord, androidx.fragment.app.FragmentTransaction$Op, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z2) {
        int size = backStackRecord.f3513c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(backStackRecord, backStackRecord.f3513c.get(i2), sparseArray, false, z2);
        }
    }

    private static ArrayMap<String, String> d(int i2, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i3, int i4) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            BackStackRecord backStackRecord = arrayList.get(i5);
            if (backStackRecord.D(i2)) {
                boolean booleanValue = arrayList2.get(i5).booleanValue();
                ArrayList<String> arrayList5 = backStackRecord.f3526p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.f3526p;
                        arrayList4 = backStackRecord.f3527q;
                    } else {
                        ArrayList<String> arrayList6 = backStackRecord.f3526p;
                        arrayList3 = backStackRecord.f3527q;
                        arrayList4 = arrayList6;
                    }
                    for (int i6 = 0; i6 < size; i6++) {
                        String str = arrayList4.get(i6);
                        String str2 = arrayList3.get(i6);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    public static void e(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z2) {
        if (backStackRecord.f3264t.o0().d()) {
            for (int size = backStackRecord.f3513c.size() - 1; size >= 0; size--) {
                b(backStackRecord, backStackRecord.f3513c.get(size), sparseArray, true, z2);
            }
        }
    }

    static void f(Fragment fragment, Fragment fragment2, boolean z2, ArrayMap<String, View> arrayMap, boolean z3) {
        SharedElementCallback sharedElementCallback;
        int i2;
        if (z2) {
            sharedElementCallback = fragment2.getEnterTransitionCallback();
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
        }
        if (sharedElementCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (arrayMap == null) {
                i2 = 0;
            } else {
                i2 = arrayMap.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList2.add(arrayMap.j(i3));
                arrayList.add(arrayMap.n(i3));
            }
            if (z3) {
                sharedElementCallback.g(arrayList2, arrayList, (List<View>) null);
            } else {
                sharedElementCallback.f(arrayList2, arrayList, (List<View>) null);
            }
        }
    }

    private static boolean g(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!fragmentTransitionImpl.e(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static ArrayMap<String, View> h(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        String q2;
        Fragment fragment = fragmentContainerTransition.f3575a;
        View view = fragment.getView();
        if (arrayMap.isEmpty() || obj == null || view == null) {
            arrayMap.clear();
            return null;
        }
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.j(arrayMap2, view);
        BackStackRecord backStackRecord = fragmentContainerTransition.f3577c;
        if (fragmentContainerTransition.f3576b) {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.f3526p;
        } else {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.f3527q;
        }
        if (arrayList != null) {
            arrayMap2.r(arrayList);
            arrayMap2.r(arrayMap.values());
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.d(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view2 = arrayMap2.get(str);
                if (view2 == null) {
                    String q3 = q(arrayMap, str);
                    if (q3 != null) {
                        arrayMap.remove(q3);
                    }
                } else if (!str.equals(ViewCompat.M(view2)) && (q2 = q(arrayMap, str)) != null) {
                    arrayMap.put(q2, ViewCompat.M(view2));
                }
            }
        } else {
            y(arrayMap, arrayMap2);
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> i(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback sharedElementCallback;
        ArrayList<String> arrayList;
        if (arrayMap.isEmpty() || obj == null) {
            arrayMap.clear();
            return null;
        }
        Fragment fragment = fragmentContainerTransition.f3578d;
        ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
        fragmentTransitionImpl.j(arrayMap2, fragment.requireView());
        BackStackRecord backStackRecord = fragmentContainerTransition.f3580f;
        if (fragmentContainerTransition.f3579e) {
            sharedElementCallback = fragment.getEnterTransitionCallback();
            arrayList = backStackRecord.f3527q;
        } else {
            sharedElementCallback = fragment.getExitTransitionCallback();
            arrayList = backStackRecord.f3526p;
        }
        if (arrayList != null) {
            arrayMap2.r(arrayList);
        }
        if (sharedElementCallback != null) {
            sharedElementCallback.d(arrayList, arrayMap2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = arrayMap2.get(str);
                if (view == null) {
                    arrayMap.remove(str);
                } else if (!str.equals(ViewCompat.M(view))) {
                    arrayMap.put(ViewCompat.M(view), arrayMap.remove(str));
                }
            }
        } else {
            arrayMap.r(arrayMap2.keySet());
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f3539b;
        if (fragmentTransitionImpl != null && g(fragmentTransitionImpl, arrayList)) {
            return fragmentTransitionImpl;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f3540c;
        if (fragmentTransitionImpl2 != null && g(fragmentTransitionImpl2, arrayList)) {
            return fragmentTransitionImpl2;
        }
        if (fragmentTransitionImpl == null && fragmentTransitionImpl2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    static ArrayList<View> k(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.b(obj, arrayList2);
        return arrayList2;
    }

    private static Object l(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Object obj4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.f3575a;
        Fragment fragment2 = fragmentContainerTransition2.f3578d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = fragmentContainerTransition2.f3576b;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            obj3 = null;
        } else {
            obj3 = u(fragmentTransitionImpl2, fragment, fragment2, z2);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> i2 = i(fragmentTransitionImpl2, arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            obj4 = null;
        } else {
            arrayList3.addAll(i2.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z2, i2, true);
        if (obj4 != null) {
            rect = new Rect();
            fragmentTransitionImpl2.z(obj4, view, arrayList3);
            A(fragmentTransitionImpl, obj4, obj2, i2, fragmentContainerTransition2.f3579e, fragmentContainerTransition2.f3580f);
            if (obj5 != null) {
                fragmentTransitionImpl2.u(obj5, rect);
            }
        } else {
            rect = null;
        }
        final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
        final ArrayMap<String, String> arrayMap3 = arrayMap;
        final Object obj6 = obj4;
        final FragmentContainerTransition fragmentContainerTransition3 = fragmentContainerTransition;
        AnonymousClass6 r13 = r0;
        final ArrayList<View> arrayList4 = arrayList2;
        final View view2 = view;
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z3 = z2;
        final ArrayList<View> arrayList5 = arrayList;
        final Object obj7 = obj;
        final Rect rect2 = rect;
        AnonymousClass6 r02 = new Runnable() {
            public void run() {
                ArrayMap<String, View> h2 = FragmentTransition.h(FragmentTransitionImpl.this, arrayMap3, obj6, fragmentContainerTransition3);
                if (h2 != null) {
                    arrayList4.addAll(h2.values());
                    arrayList4.add(view2);
                }
                FragmentTransition.f(fragment3, fragment4, z3, h2, false);
                Object obj = obj6;
                if (obj != null) {
                    FragmentTransitionImpl.this.A(obj, arrayList5, arrayList4);
                    View t2 = FragmentTransition.t(h2, fragmentContainerTransition3, obj7, z3);
                    if (t2 != null) {
                        FragmentTransitionImpl.this.k(t2, rect2);
                    }
                }
            }
        };
        OneShotPreDrawListener.a(viewGroup, r13);
        return obj4;
    }

    private static Object m(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        Object obj4;
        final Rect rect;
        final View view2;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        View view3 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        ArrayList<View> arrayList3 = arrayList;
        ArrayList<View> arrayList4 = arrayList2;
        Object obj5 = obj;
        Fragment fragment = fragmentContainerTransition2.f3575a;
        Fragment fragment2 = fragmentContainerTransition2.f3578d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z2 = fragmentContainerTransition2.f3576b;
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = u(fragmentTransitionImpl, fragment, fragment2, z2);
        }
        ArrayMap<String, View> i2 = i(fragmentTransitionImpl, arrayMap2, obj3, fragmentContainerTransition2);
        ArrayMap<String, View> h2 = h(fragmentTransitionImpl, arrayMap2, obj3, fragmentContainerTransition2);
        if (arrayMap.isEmpty()) {
            if (i2 != null) {
                i2.clear();
            }
            if (h2 != null) {
                h2.clear();
            }
            obj4 = null;
        } else {
            a(arrayList3, i2, arrayMap.keySet());
            a(arrayList4, h2, arrayMap.values());
            obj4 = obj3;
        }
        if (obj5 == null && obj2 == null && obj4 == null) {
            return null;
        }
        f(fragment, fragment2, z2, i2, true);
        if (obj4 != null) {
            arrayList4.add(view3);
            fragmentTransitionImpl.z(obj4, view3, arrayList3);
            A(fragmentTransitionImpl, obj4, obj2, i2, fragmentContainerTransition2.f3579e, fragmentContainerTransition2.f3580f);
            Rect rect2 = new Rect();
            View t2 = t(h2, fragmentContainerTransition2, obj5, z2);
            if (t2 != null) {
                fragmentTransitionImpl.u(obj5, rect2);
            }
            rect = rect2;
            view2 = t2;
        } else {
            view2 = null;
            rect = null;
        }
        final Fragment fragment3 = fragment;
        final Fragment fragment4 = fragment2;
        final boolean z3 = z2;
        final ArrayMap<String, View> arrayMap3 = h2;
        final FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
        OneShotPreDrawListener.a(viewGroup, new Runnable() {
            public void run() {
                FragmentTransition.f(Fragment.this, fragment4, z3, arrayMap3, false);
                View view = view2;
                if (view != null) {
                    fragmentTransitionImpl3.k(view, rect);
                }
            }
        });
        return obj4;
    }

    private static void n(ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, Callback callback) {
        Object obj;
        ViewGroup viewGroup2 = viewGroup;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        ArrayMap<String, String> arrayMap2 = arrayMap;
        final Callback callback2 = callback;
        Fragment fragment = fragmentContainerTransition2.f3575a;
        final Fragment fragment2 = fragmentContainerTransition2.f3578d;
        FragmentTransitionImpl j2 = j(fragment2, fragment);
        if (j2 != null) {
            boolean z2 = fragmentContainerTransition2.f3576b;
            boolean z3 = fragmentContainerTransition2.f3579e;
            Object r2 = r(j2, fragment, z2);
            Object s2 = s(j2, fragment2, z3);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = arrayList;
            Object obj2 = s2;
            FragmentTransitionImpl fragmentTransitionImpl = j2;
            Object l2 = l(j2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList, arrayList2, r2, obj2);
            Object obj3 = r2;
            if (obj3 == null && l2 == null) {
                obj = obj2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = obj2;
            }
            ArrayList arrayList4 = arrayList3;
            ArrayList<View> k2 = k(fragmentTransitionImpl, obj, fragment2, arrayList4, view2);
            if (k2 == null || k2.isEmpty()) {
                obj = null;
            }
            Object obj4 = obj;
            fragmentTransitionImpl.a(obj3, view2);
            Object v2 = v(fragmentTransitionImpl, obj3, obj4, l2, fragment, fragmentContainerTransition2.f3576b);
            if (!(fragment2 == null || k2 == null || (k2.size() <= 0 && arrayList4.size() <= 0))) {
                final CancellationSignal cancellationSignal = new CancellationSignal();
                callback2.b(fragment2, cancellationSignal);
                fragmentTransitionImpl.w(fragment2, v2, cancellationSignal, new Runnable() {
                    public void run() {
                        Callback.this.a(fragment2, cancellationSignal);
                    }
                });
            }
            if (v2 != null) {
                ArrayList arrayList5 = new ArrayList();
                FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
                fragmentTransitionImpl2.t(v2, obj3, arrayList5, obj4, k2, l2, arrayList2);
                z(fragmentTransitionImpl2, viewGroup, fragment, view, arrayList2, obj3, arrayList5, obj4, k2);
                ViewGroup viewGroup3 = viewGroup;
                FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl;
                ArrayList arrayList6 = arrayList2;
                fragmentTransitionImpl3.x(viewGroup3, arrayList6, arrayMap2);
                fragmentTransitionImpl3.c(viewGroup3, v2);
                fragmentTransitionImpl3.s(viewGroup3, arrayList6, arrayMap2);
            }
        }
    }

    private static void o(ViewGroup viewGroup, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap, Callback callback) {
        Object obj;
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        View view2 = view;
        Callback callback2 = callback;
        Fragment fragment = fragmentContainerTransition2.f3575a;
        final Fragment fragment2 = fragmentContainerTransition2.f3578d;
        FragmentTransitionImpl j2 = j(fragment2, fragment);
        if (j2 != null) {
            boolean z2 = fragmentContainerTransition2.f3576b;
            boolean z3 = fragmentContainerTransition2.f3579e;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Object r2 = r(j2, fragment, z2);
            Object s2 = s(j2, fragment2, z3);
            ArrayList arrayList3 = arrayList2;
            Object m2 = m(j2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, r2, s2);
            Object obj2 = r2;
            if (obj2 == null && m2 == null) {
                obj = s2;
                if (obj == null) {
                    return;
                }
            } else {
                obj = s2;
            }
            ArrayList<View> k2 = k(j2, obj, fragment2, arrayList3, view2);
            ArrayList<View> k3 = k(j2, obj2, fragment, arrayList, view2);
            B(k3, 4);
            Fragment fragment3 = fragment;
            ArrayList<View> arrayList4 = k2;
            Object v2 = v(j2, obj2, obj, m2, fragment3, z2);
            if (!(fragment2 == null || arrayList4 == null || (arrayList4.size() <= 0 && arrayList3.size() <= 0))) {
                final CancellationSignal cancellationSignal = new CancellationSignal();
                final Callback callback3 = callback;
                callback3.b(fragment2, cancellationSignal);
                j2.w(fragment2, v2, cancellationSignal, new Runnable() {
                    public void run() {
                        Callback.this.a(fragment2, cancellationSignal);
                    }
                });
            }
            if (v2 != null) {
                w(j2, obj, fragment2, arrayList4);
                ArrayList<String> o2 = j2.o(arrayList);
                FragmentTransitionImpl fragmentTransitionImpl = j2;
                fragmentTransitionImpl.t(v2, obj2, k3, obj, arrayList4, m2, arrayList);
                ViewGroup viewGroup2 = viewGroup;
                j2.c(viewGroup2, v2);
                fragmentTransitionImpl.y(viewGroup2, arrayList3, arrayList, o2, arrayMap);
                B(k3, 0);
                j2.A(m2, arrayList3, arrayList);
            }
        }
    }

    private static FragmentContainerTransition p(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i2) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i2, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    static String q(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(arrayMap.n(i2))) {
                return arrayMap.j(i2);
            }
        }
        return null;
    }

    private static Object r(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z2) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z2) {
            obj = fragment.getReenterTransition();
        } else {
            obj = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.g(obj);
    }

    private static Object s(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z2) {
        Object obj;
        if (fragment == null) {
            return null;
        }
        if (z2) {
            obj = fragment.getReturnTransition();
        } else {
            obj = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.g(obj);
    }

    static View t(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z2) {
        ArrayList<String> arrayList;
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.f3577c;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.f3526p) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z2) {
            str = backStackRecord.f3526p.get(0);
        } else {
            str = backStackRecord.f3527q.get(0);
        }
        return arrayMap.get(str);
    }

    private static Object u(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z2) {
        Object obj;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z2) {
            obj = fragment2.getSharedElementReturnTransition();
        } else {
            obj = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.B(fragmentTransitionImpl.g(obj));
    }

    private static Object v(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z2) {
        boolean z3;
        if (obj == null || obj2 == null || fragment == null) {
            z3 = true;
        } else if (z2) {
            z3 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z3 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z3) {
            return fragmentTransitionImpl.n(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.m(obj2, obj, obj3);
    }

    private static void w(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.r(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.a(fragment.mContainer, new Runnable() {
                public void run() {
                    FragmentTransition.B(arrayList, 4);
                }
            });
        }
    }

    private static FragmentTransitionImpl x() {
        try {
            return FragmentTransitionSupport.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static void y(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.n(size))) {
                arrayMap.l(size);
            }
        }
    }

    private static void z(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        final Object obj3 = obj;
        final FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        final View view2 = view;
        final Fragment fragment2 = fragment;
        final ArrayList<View> arrayList4 = arrayList;
        final ArrayList<View> arrayList5 = arrayList2;
        final ArrayList<View> arrayList6 = arrayList3;
        final Object obj4 = obj2;
        ViewGroup viewGroup2 = viewGroup;
        OneShotPreDrawListener.a(viewGroup, new Runnable() {
            public void run() {
                Object obj = obj3;
                if (obj != null) {
                    fragmentTransitionImpl2.p(obj, view2);
                    arrayList5.addAll(FragmentTransition.k(fragmentTransitionImpl2, obj3, fragment2, arrayList4, view2));
                }
                if (arrayList6 != null) {
                    if (obj4 != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(view2);
                        fragmentTransitionImpl2.q(obj4, arrayList6, arrayList);
                    }
                    arrayList6.clear();
                    arrayList6.add(view2);
                }
            }
        });
    }
}

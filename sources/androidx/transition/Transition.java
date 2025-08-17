package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class Transition implements Cloneable {
    private static final int[] I = {2, 1, 3, 4};
    private static final PathMotion J = new PathMotion() {
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> K = new ThreadLocal<>();
    private boolean A = false;
    private boolean B = false;
    private ArrayList<TransitionListener> C = null;
    private ArrayList<Animator> D = new ArrayList<>();
    TransitionPropagation E;
    private EpicenterCallback F;
    private ArrayMap<String, String> G;
    private PathMotion H = J;

    /* renamed from: b  reason: collision with root package name */
    private String f11739b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    private long f11740c = -1;

    /* renamed from: d  reason: collision with root package name */
    long f11741d = -1;

    /* renamed from: e  reason: collision with root package name */
    private TimeInterpolator f11742e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<Integer> f11743f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<View> f11744g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f11745h = null;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<Class> f11746i = null;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<Integer> f11747j = null;

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<View> f11748k = null;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<Class> f11749l = null;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList<String> f11750m = null;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<Integer> f11751n = null;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<View> f11752o = null;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<Class> f11753p = null;

    /* renamed from: q  reason: collision with root package name */
    private TransitionValuesMaps f11754q = new TransitionValuesMaps();

    /* renamed from: r  reason: collision with root package name */
    private TransitionValuesMaps f11755r = new TransitionValuesMaps();

    /* renamed from: s  reason: collision with root package name */
    TransitionSet f11756s = null;

    /* renamed from: t  reason: collision with root package name */
    private int[] f11757t = I;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<TransitionValues> f11758u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<TransitionValues> f11759v;

    /* renamed from: w  reason: collision with root package name */
    private ViewGroup f11760w = null;

    /* renamed from: x  reason: collision with root package name */
    boolean f11761x = false;

    /* renamed from: y  reason: collision with root package name */
    ArrayList<Animator> f11762y = new ArrayList<>();

    /* renamed from: z  reason: collision with root package name */
    private int f11763z = 0;

    private static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        View f11767a;

        /* renamed from: b  reason: collision with root package name */
        String f11768b;

        /* renamed from: c  reason: collision with root package name */
        TransitionValues f11769c;

        /* renamed from: d  reason: collision with root package name */
        WindowIdImpl f11770d;

        /* renamed from: e  reason: collision with root package name */
        Transition f11771e;

        AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.f11767a = view;
            this.f11768b = str;
            this.f11769c = transitionValues;
            this.f11770d = windowIdImpl;
            this.f11771e = transition;
        }
    }

    public static abstract class EpicenterCallback {
    }

    public interface TransitionListener {
        void a(Transition transition);

        void b(Transition transition);

        void c(Transition transition);

        void d(Transition transition);
    }

    private static boolean G(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f11787a.get(str);
        Object obj2 = transitionValues2.f11787a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void H(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && F(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && F(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.f11758u.add(transitionValues);
                    this.f11759v.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void I(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        View view;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View j2 = arrayMap.j(size);
            if (!(j2 == null || !F(j2) || (remove = arrayMap2.remove(j2)) == null || (view = remove.f11788b) == null || !F(view))) {
                this.f11758u.add(arrayMap.l(size));
                this.f11759v.add(remove);
            }
        }
    }

    private void J(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View f2;
        int n2 = longSparseArray.n();
        for (int i2 = 0; i2 < n2; i2++) {
            View o2 = longSparseArray.o(i2);
            if (o2 != null && F(o2) && (f2 = longSparseArray2.f(longSparseArray.j(i2))) != null && F(f2)) {
                TransitionValues transitionValues = arrayMap.get(o2);
                TransitionValues transitionValues2 = arrayMap2.get(f2);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.f11758u.add(transitionValues);
                    this.f11759v.add(transitionValues2);
                    arrayMap.remove(o2);
                    arrayMap2.remove(f2);
                }
            }
        }
    }

    private void K(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View n2 = arrayMap3.n(i2);
            if (n2 != null && F(n2) && (view = arrayMap4.get(arrayMap3.j(i2))) != null && F(view)) {
                TransitionValues transitionValues = arrayMap.get(n2);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.f11758u.add(transitionValues);
                    this.f11759v.add(transitionValues2);
                    arrayMap.remove(n2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void L(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) transitionValuesMaps.f11790a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) transitionValuesMaps2.f11790a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f11757t;
            if (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 == 1) {
                    I(arrayMap, arrayMap2);
                } else if (i3 == 2) {
                    K(arrayMap, arrayMap2, transitionValuesMaps.f11793d, transitionValuesMaps2.f11793d);
                } else if (i3 == 3) {
                    H(arrayMap, arrayMap2, transitionValuesMaps.f11791b, transitionValuesMaps2.f11791b);
                } else if (i3 == 4) {
                    J(arrayMap, arrayMap2, transitionValuesMaps.f11792c, transitionValuesMaps2.f11792c);
                }
                i2++;
            } else {
                c(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private void R(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    Transition.this.f11762y.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.f11762y.add(animator);
                }
            });
            e(animator);
        }
    }

    private void c(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i2 = 0; i2 < arrayMap.size(); i2++) {
            TransitionValues n2 = arrayMap.n(i2);
            if (F(n2.f11788b)) {
                this.f11758u.add(n2);
                this.f11759v.add((Object) null);
            }
        }
        for (int i3 = 0; i3 < arrayMap2.size(); i3++) {
            TransitionValues n3 = arrayMap2.n(i3);
            if (F(n3.f11788b)) {
                this.f11759v.add(n3);
                this.f11758u.add((Object) null);
            }
        }
    }

    private static void d(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f11790a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f11791b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f11791b.put(id, (Object) null);
            } else {
                transitionValuesMaps.f11791b.put(id, view);
            }
        }
        String M = ViewCompat.M(view);
        if (M != null) {
            if (transitionValuesMaps.f11793d.containsKey(M)) {
                transitionValuesMaps.f11793d.put(M, null);
            } else {
                transitionValuesMaps.f11793d.put(M, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f11792c.h(itemIdAtPosition) >= 0) {
                    View f2 = transitionValuesMaps.f11792c.f(itemIdAtPosition);
                    if (f2 != null) {
                        ViewCompat.B0(f2, false);
                        transitionValuesMaps.f11792c.k(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.B0(view, true);
                transitionValuesMaps.f11792c.k(itemIdAtPosition, view);
            }
        }
    }

    private void g(View view, boolean z2) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.f11747j;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.f11748k;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class> arrayList3 = this.f11749l;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.f11749l.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues();
                        transitionValues.f11788b = view;
                        if (z2) {
                            i(transitionValues);
                        } else {
                            f(transitionValues);
                        }
                        transitionValues.f11789c.add(this);
                        h(transitionValues);
                        if (z2) {
                            d(this.f11754q, view, transitionValues);
                        } else {
                            d(this.f11755r, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f11751n;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.f11752o;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class> arrayList6 = this.f11753p;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i3 = 0;
                                    while (i3 < size2) {
                                        if (!this.f11753p.get(i3).isInstance(view)) {
                                            i3++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                    g(viewGroup.getChildAt(i4), z2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static ArrayMap<Animator, AnimationInfo> w() {
        ArrayMap<Animator, AnimationInfo> arrayMap = K.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        K.set(arrayMap2);
        return arrayMap2;
    }

    public List<Class> A() {
        return this.f11746i;
    }

    public List<View> B() {
        return this.f11744g;
    }

    public String[] C() {
        return null;
    }

    public TransitionValues D(View view, boolean z2) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.f11756s;
        if (transitionSet != null) {
            return transitionSet.D(view, z2);
        }
        if (z2) {
            transitionValuesMaps = this.f11754q;
        } else {
            transitionValuesMaps = this.f11755r;
        }
        return transitionValuesMaps.f11790a.get(view);
    }

    public boolean E(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] C2 = C();
        if (C2 != null) {
            int length = C2.length;
            int i2 = 0;
            while (i2 < length) {
                if (!G(transitionValues, transitionValues2, C2[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String G2 : transitionValues.f11787a.keySet()) {
            if (G(transitionValues, transitionValues2, G2)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean F(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f11747j;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f11748k;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.f11749l;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.f11749l.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f11750m != null && ViewCompat.M(view) != null && this.f11750m.contains(ViewCompat.M(view))) {
            return false;
        }
        if ((this.f11743f.size() == 0 && this.f11744g.size() == 0 && (((arrayList = this.f11746i) == null || arrayList.isEmpty()) && ((arrayList2 = this.f11745h) == null || arrayList2.isEmpty()))) || this.f11743f.contains(Integer.valueOf(id)) || this.f11744g.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f11745h;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.M(view))) {
            return true;
        }
        if (this.f11746i != null) {
            for (int i3 = 0; i3 < this.f11746i.size(); i3++) {
                if (this.f11746i.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void M(View view) {
        if (!this.B) {
            ArrayMap<Animator, AnimationInfo> w2 = w();
            int size = w2.size();
            WindowIdImpl e2 = ViewUtils.e(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                AnimationInfo n2 = w2.n(i2);
                if (n2.f11767a != null && e2.equals(n2.f11770d)) {
                    AnimatorUtils.b(w2.j(i2));
                }
            }
            ArrayList<TransitionListener> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size2 = arrayList2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((TransitionListener) arrayList2.get(i3)).c(this);
                }
            }
            this.A = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void N(ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        boolean z2;
        this.f11758u = new ArrayList<>();
        this.f11759v = new ArrayList<>();
        L(this.f11754q, this.f11755r);
        ArrayMap<Animator, AnimationInfo> w2 = w();
        int size = w2.size();
        WindowIdImpl e2 = ViewUtils.e(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator j2 = w2.j(i2);
            if (!(j2 == null || (animationInfo = w2.get(j2)) == null || animationInfo.f11767a == null || !e2.equals(animationInfo.f11770d))) {
                TransitionValues transitionValues = animationInfo.f11769c;
                View view = animationInfo.f11767a;
                TransitionValues D2 = D(view, true);
                TransitionValues s2 = s(view, true);
                if (!(D2 == null && s2 == null) && animationInfo.f11771e.E(transitionValues, s2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (j2.isRunning() || j2.isStarted()) {
                        j2.cancel();
                    } else {
                        w2.remove(j2);
                    }
                }
            }
        }
        n(viewGroup, this.f11754q, this.f11755r, this.f11758u, this.f11759v);
        S();
    }

    public Transition O(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.C;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.C.size() == 0) {
            this.C = null;
        }
        return this;
    }

    public Transition P(View view) {
        this.f11744g.remove(view);
        return this;
    }

    public void Q(View view) {
        if (this.A) {
            if (!this.B) {
                ArrayMap<Animator, AnimationInfo> w2 = w();
                int size = w2.size();
                WindowIdImpl e2 = ViewUtils.e(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    AnimationInfo n2 = w2.n(i2);
                    if (n2.f11767a != null && e2.equals(n2.f11770d)) {
                        AnimatorUtils.c(w2.j(i2));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.C;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.C.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((TransitionListener) arrayList2.get(i3)).a(this);
                    }
                }
            }
            this.A = false;
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        Z();
        ArrayMap<Animator, AnimationInfo> w2 = w();
        Iterator<Animator> it2 = this.D.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (w2.containsKey(next)) {
                Z();
                R(next, w2);
            }
        }
        this.D.clear();
        o();
    }

    public Transition T(long j2) {
        this.f11741d = j2;
        return this;
    }

    public void U(EpicenterCallback epicenterCallback) {
        this.F = epicenterCallback;
    }

    public Transition V(TimeInterpolator timeInterpolator) {
        this.f11742e = timeInterpolator;
        return this;
    }

    public void W(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.H = J;
        } else {
            this.H = pathMotion;
        }
    }

    public void X(TransitionPropagation transitionPropagation) {
        this.E = transitionPropagation;
    }

    public Transition Y(long j2) {
        this.f11740c = j2;
        return this;
    }

    /* access modifiers changed from: protected */
    public void Z() {
        if (this.f11763z == 0) {
            ArrayList<TransitionListener> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList2.get(i2)).b(this);
                }
            }
            this.B = false;
        }
        this.f11763z++;
    }

    public Transition a(TransitionListener transitionListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(transitionListener);
        return this;
    }

    /* access modifiers changed from: package-private */
    public String a0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f11741d != -1) {
            str2 = str2 + "dur(" + this.f11741d + ") ";
        }
        if (this.f11740c != -1) {
            str2 = str2 + "dly(" + this.f11740c + ") ";
        }
        if (this.f11742e != null) {
            str2 = str2 + "interp(" + this.f11742e + ") ";
        }
        if (this.f11743f.size() <= 0 && this.f11744g.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f11743f.size() > 0) {
            for (int i2 = 0; i2 < this.f11743f.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f11743f.get(i2);
            }
        }
        if (this.f11744g.size() > 0) {
            for (int i3 = 0; i3 < this.f11744g.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f11744g.get(i3);
            }
        }
        return str3 + ")";
    }

    public Transition b(View view) {
        this.f11744g.add(view);
        return this;
    }

    /* access modifiers changed from: protected */
    public void e(Animator animator) {
        if (animator == null) {
            o();
            return;
        }
        if (p() >= 0) {
            animator.setDuration(p());
        }
        if (x() >= 0) {
            animator.setStartDelay(x());
        }
        if (r() != null) {
            animator.setInterpolator(r());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.o();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    public abstract void f(TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void h(TransitionValues transitionValues) {
        String[] b2;
        if (this.E != null && !transitionValues.f11787a.isEmpty() && (b2 = this.E.b()) != null) {
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= b2.length) {
                    z2 = true;
                    break;
                } else if (!transitionValues.f11787a.containsKey(b2[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                this.E.a(transitionValues);
            }
        }
    }

    public abstract void i(TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void j(ViewGroup viewGroup, boolean z2) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        k(z2);
        if ((this.f11743f.size() > 0 || this.f11744g.size() > 0) && (((arrayList = this.f11745h) == null || arrayList.isEmpty()) && ((arrayList2 = this.f11746i) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.f11743f.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.f11743f.get(i2).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues();
                    transitionValues.f11788b = findViewById;
                    if (z2) {
                        i(transitionValues);
                    } else {
                        f(transitionValues);
                    }
                    transitionValues.f11789c.add(this);
                    h(transitionValues);
                    if (z2) {
                        d(this.f11754q, findViewById, transitionValues);
                    } else {
                        d(this.f11755r, findViewById, transitionValues);
                    }
                }
            }
            for (int i3 = 0; i3 < this.f11744g.size(); i3++) {
                View view = this.f11744g.get(i3);
                TransitionValues transitionValues2 = new TransitionValues();
                transitionValues2.f11788b = view;
                if (z2) {
                    i(transitionValues2);
                } else {
                    f(transitionValues2);
                }
                transitionValues2.f11789c.add(this);
                h(transitionValues2);
                if (z2) {
                    d(this.f11754q, view, transitionValues2);
                } else {
                    d(this.f11755r, view, transitionValues2);
                }
            }
        } else {
            g(viewGroup, z2);
        }
        if (!z2 && (arrayMap = this.G) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList3.add(this.f11754q.f11793d.remove(this.G.j(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList3.get(i5);
                if (view2 != null) {
                    this.f11754q.f11793d.put(this.G.n(i5), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(boolean z2) {
        if (z2) {
            this.f11754q.f11790a.clear();
            this.f11754q.f11791b.clear();
            this.f11754q.f11792c.b();
            return;
        }
        this.f11755r.f11790a.clear();
        this.f11755r.f11791b.clear();
        this.f11755r.f11792c.b();
    }

    /* renamed from: l */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.D = new ArrayList<>();
            transition.f11754q = new TransitionValuesMaps();
            transition.f11755r = new TransitionValuesMaps();
            transition.f11758u = null;
            transition.f11759v = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator m(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void n(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i2;
        boolean z2;
        Animator m2;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> w2 = w();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j2 = Clock.MAX_TIME;
        int i3 = 0;
        while (i3 < size) {
            TransitionValues transitionValues3 = arrayList.get(i3);
            TransitionValues transitionValues4 = arrayList2.get(i3);
            if (transitionValues3 != null && !transitionValues3.f11789c.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f11789c.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null)) {
                if (transitionValues3 == null || transitionValues4 == null || E(transitionValues3, transitionValues4)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (m2 = m(viewGroup2, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.f11788b;
                        String[] C2 = C();
                        if (view != null && C2 != null && C2.length > 0) {
                            transitionValues2 = new TransitionValues();
                            transitionValues2.f11788b = view;
                            Animator animator3 = m2;
                            i2 = size;
                            TransitionValues transitionValues5 = transitionValuesMaps2.f11790a.get(view);
                            if (transitionValues5 != null) {
                                int i4 = 0;
                                while (i4 < C2.length) {
                                    Map<String, Object> map = transitionValues2.f11787a;
                                    String str = C2[i4];
                                    map.put(str, transitionValues5.f11787a.get(str));
                                    i4++;
                                    ArrayList<TransitionValues> arrayList3 = arrayList2;
                                    C2 = C2;
                                }
                            }
                            int size2 = w2.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                AnimationInfo animationInfo = w2.get(w2.j(i5));
                                if (animationInfo.f11769c != null && animationInfo.f11767a == view && animationInfo.f11768b.equals(t()) && animationInfo.f11769c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i2 = size;
                            animator2 = m2;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i2 = size;
                        view = transitionValues3.f11788b;
                        animator = m2;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.E;
                        if (transitionPropagation != null) {
                            long c2 = transitionPropagation.c(viewGroup2, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.D.size(), (int) c2);
                            j2 = Math.min(c2, j2);
                        }
                        w2.put(animator, new AnimationInfo(view, t(), this, ViewUtils.e(viewGroup), transitionValues));
                        this.D.add(animator);
                        j2 = j2;
                    }
                    i3++;
                    size = i2;
                }
            }
            i2 = size;
            i3++;
            size = i2;
        }
        if (j2 != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator4 = this.D.get(sparseIntArray.keyAt(i6));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i6)) - j2) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o() {
        int i2 = this.f11763z - 1;
        this.f11763z = i2;
        if (i2 == 0) {
            ArrayList<TransitionListener> arrayList = this.C;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.C.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((TransitionListener) arrayList2.get(i3)).d(this);
                }
            }
            for (int i4 = 0; i4 < this.f11754q.f11792c.n(); i4++) {
                View o2 = this.f11754q.f11792c.o(i4);
                if (o2 != null) {
                    ViewCompat.B0(o2, false);
                }
            }
            for (int i5 = 0; i5 < this.f11755r.f11792c.n(); i5++) {
                View o3 = this.f11755r.f11792c.o(i5);
                if (o3 != null) {
                    ViewCompat.B0(o3, false);
                }
            }
            this.B = true;
        }
    }

    public long p() {
        return this.f11741d;
    }

    public EpicenterCallback q() {
        return this.F;
    }

    public TimeInterpolator r() {
        return this.f11742e;
    }

    /* access modifiers changed from: package-private */
    public TransitionValues s(View view, boolean z2) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.f11756s;
        if (transitionSet != null) {
            return transitionSet.s(view, z2);
        }
        if (z2) {
            arrayList = this.f11758u;
        } else {
            arrayList = this.f11759v;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i2);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.f11788b == view) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return null;
        }
        if (z2) {
            arrayList2 = this.f11759v;
        } else {
            arrayList2 = this.f11758u;
        }
        return arrayList2.get(i2);
    }

    public String t() {
        return this.f11739b;
    }

    public String toString() {
        return a0("");
    }

    public PathMotion u() {
        return this.H;
    }

    public TransitionPropagation v() {
        return this.E;
    }

    public long x() {
        return this.f11740c;
    }

    public List<Integer> y() {
        return this.f11743f;
    }

    public List<String> z() {
        return this.f11745h;
    }
}

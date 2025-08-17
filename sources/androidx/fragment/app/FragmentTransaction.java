package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class FragmentTransaction {

    /* renamed from: a  reason: collision with root package name */
    private final FragmentFactory f3511a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassLoader f3512b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Op> f3513c;

    /* renamed from: d  reason: collision with root package name */
    int f3514d;

    /* renamed from: e  reason: collision with root package name */
    int f3515e;

    /* renamed from: f  reason: collision with root package name */
    int f3516f;

    /* renamed from: g  reason: collision with root package name */
    int f3517g;

    /* renamed from: h  reason: collision with root package name */
    int f3518h;

    /* renamed from: i  reason: collision with root package name */
    boolean f3519i;

    /* renamed from: j  reason: collision with root package name */
    boolean f3520j;

    /* renamed from: k  reason: collision with root package name */
    String f3521k;

    /* renamed from: l  reason: collision with root package name */
    int f3522l;

    /* renamed from: m  reason: collision with root package name */
    CharSequence f3523m;

    /* renamed from: n  reason: collision with root package name */
    int f3524n;

    /* renamed from: o  reason: collision with root package name */
    CharSequence f3525o;

    /* renamed from: p  reason: collision with root package name */
    ArrayList<String> f3526p;

    /* renamed from: q  reason: collision with root package name */
    ArrayList<String> f3527q;

    /* renamed from: r  reason: collision with root package name */
    boolean f3528r;

    /* renamed from: s  reason: collision with root package name */
    ArrayList<Runnable> f3529s;

    static final class Op {

        /* renamed from: a  reason: collision with root package name */
        int f3530a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f3531b;

        /* renamed from: c  reason: collision with root package name */
        int f3532c;

        /* renamed from: d  reason: collision with root package name */
        int f3533d;

        /* renamed from: e  reason: collision with root package name */
        int f3534e;

        /* renamed from: f  reason: collision with root package name */
        int f3535f;

        /* renamed from: g  reason: collision with root package name */
        Lifecycle.State f3536g;

        /* renamed from: h  reason: collision with root package name */
        Lifecycle.State f3537h;

        Op() {
        }

        Op(int i2, Fragment fragment) {
            this.f3530a = i2;
            this.f3531b = fragment;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            this.f3536g = state;
            this.f3537h = state;
        }

        Op(int i2, Fragment fragment, Lifecycle.State state) {
            this.f3530a = i2;
            this.f3531b = fragment;
            this.f3536g = fragment.mMaxState;
            this.f3537h = state;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.f3513c = new ArrayList<>();
        this.f3520j = true;
        this.f3528r = false;
        this.f3511a = null;
        this.f3512b = null;
    }

    public FragmentTransaction b(int i2, Fragment fragment) {
        m(i2, fragment, (String) null, 1);
        return this;
    }

    public FragmentTransaction c(int i2, Fragment fragment, String str) {
        m(i2, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public FragmentTransaction d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.mContainer = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public FragmentTransaction e(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void f(Op op) {
        this.f3513c.add(op);
        op.f3532c = this.f3514d;
        op.f3533d = this.f3515e;
        op.f3534e = this.f3516f;
        op.f3535f = this.f3517g;
    }

    public FragmentTransaction g(String str) {
        if (this.f3520j) {
            this.f3519i = true;
            this.f3521k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public FragmentTransaction l() {
        if (!this.f3519i) {
            this.f3520j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 == null || str.equals(str2)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 != -1) {
                int i4 = fragment.mFragmentId;
                if (i4 == 0 || i4 == i2) {
                    fragment.mFragmentId = i2;
                    fragment.mContainerId = i2;
                } else {
                    throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
                }
            } else {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
        }
        f(new Op(i3, fragment));
    }

    public boolean n() {
        return this.f3513c.isEmpty();
    }

    public FragmentTransaction o(Fragment fragment) {
        f(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction p(int i2, Fragment fragment) {
        return q(i2, fragment, (String) null);
    }

    public FragmentTransaction q(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            m(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public FragmentTransaction r(int i2, int i3, int i4, int i5) {
        this.f3514d = i2;
        this.f3515e = i3;
        this.f3516f = i4;
        this.f3517g = i5;
        return this;
    }

    public FragmentTransaction s(Fragment fragment, Lifecycle.State state) {
        f(new Op(10, fragment, state));
        return this;
    }

    public FragmentTransaction t(boolean z2) {
        this.f3528r = z2;
        return this;
    }

    public FragmentTransaction u(int i2) {
        this.f3518h = i2;
        return this;
    }

    FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.f3513c = new ArrayList<>();
        this.f3520j = true;
        this.f3528r = false;
        this.f3511a = fragmentFactory;
        this.f3512b = classLoader;
    }
}

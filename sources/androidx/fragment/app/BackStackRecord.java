package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements FragmentManager.OpGenerator {

    /* renamed from: t  reason: collision with root package name */
    final FragmentManager f3264t;

    /* renamed from: u  reason: collision with root package name */
    boolean f3265u;

    /* renamed from: v  reason: collision with root package name */
    int f3266v;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    BackStackRecord(androidx.fragment.app.FragmentManager r3) {
        /*
            r2 = this;
            androidx.fragment.app.FragmentFactory r0 = r3.r0()
            androidx.fragment.app.FragmentHostCallback r1 = r3.u0()
            if (r1 == 0) goto L_0x0017
            androidx.fragment.app.FragmentHostCallback r1 = r3.u0()
            android.content.Context r1 = r1.f()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r2.<init>(r0, r1)
            r0 = -1
            r2.f3266v = r0
            r2.f3264t = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.<init>(androidx.fragment.app.FragmentManager):void");
    }

    private static boolean F(FragmentTransaction.Op op) {
        Fragment fragment = op.f3531b;
        if (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z2) {
        for (int size = this.f3513c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.f3513c.get(size);
            Fragment fragment = op.f3531b;
            if (fragment != null) {
                fragment.setPopDirection(true);
                fragment.setNextTransition(FragmentManager.l1(this.f3518h));
                fragment.setSharedElementNames(this.f3527q, this.f3526p);
            }
            switch (op.f3530a) {
                case 1:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, true);
                    this.f3264t.g1(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.g(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.t1(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, true);
                    this.f3264t.D0(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.m(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, true);
                    this.f3264t.y(fragment);
                    break;
                case 8:
                    this.f3264t.r1((Fragment) null);
                    break;
                case 9:
                    this.f3264t.r1(fragment);
                    break;
                case 10:
                    this.f3264t.q1(fragment, op.f3536g);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f3530a);
            }
            if (!this.f3528r && op.f3530a != 3 && fragment != null && !FragmentManager.P) {
                this.f3264t.Q0(fragment);
            }
        }
        if (!this.f3528r && z2 && !FragmentManager.P) {
            FragmentManager fragmentManager = this.f3264t;
            fragmentManager.R0(fragmentManager.f3427q, true);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment B(ArrayList<Fragment> arrayList, Fragment fragment) {
        ArrayList<Fragment> arrayList2 = arrayList;
        Fragment fragment2 = fragment;
        int i2 = 0;
        while (i2 < this.f3513c.size()) {
            FragmentTransaction.Op op = this.f3513c.get(i2);
            int i3 = op.f3530a;
            if (i3 != 1) {
                if (i3 == 2) {
                    Fragment fragment3 = op.f3531b;
                    int i4 = fragment3.mContainerId;
                    boolean z2 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList2.get(size);
                        if (fragment4.mContainerId == i4) {
                            if (fragment4 == fragment3) {
                                z2 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f3513c.add(i2, new FragmentTransaction.Op(9, fragment4));
                                    i2++;
                                    fragment2 = null;
                                }
                                FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, fragment4);
                                op2.f3532c = op.f3532c;
                                op2.f3534e = op.f3534e;
                                op2.f3533d = op.f3533d;
                                op2.f3535f = op.f3535f;
                                this.f3513c.add(i2, op2);
                                arrayList2.remove(fragment4);
                                i2++;
                            }
                        }
                    }
                    if (z2) {
                        this.f3513c.remove(i2);
                        i2--;
                    } else {
                        op.f3530a = 1;
                        arrayList2.add(fragment3);
                    }
                } else if (i3 == 3 || i3 == 6) {
                    arrayList2.remove(op.f3531b);
                    Fragment fragment5 = op.f3531b;
                    if (fragment5 == fragment2) {
                        this.f3513c.add(i2, new FragmentTransaction.Op(9, fragment5));
                        i2++;
                        fragment2 = null;
                    }
                } else if (i3 != 7) {
                    if (i3 == 8) {
                        this.f3513c.add(i2, new FragmentTransaction.Op(9, fragment2));
                        i2++;
                        fragment2 = op.f3531b;
                    }
                }
                i2++;
            }
            arrayList2.add(op.f3531b);
            i2++;
        }
        return fragment2;
    }

    public String C() {
        return this.f3521k;
    }

    /* access modifiers changed from: package-private */
    public boolean D(int i2) {
        int i3;
        int size = this.f3513c.size();
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f3513c.get(i4).f3531b;
            if (fragment != null) {
                i3 = fragment.mContainerId;
            } else {
                i3 = 0;
            }
            if (i3 != 0 && i3 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean E(ArrayList<BackStackRecord> arrayList, int i2, int i3) {
        int i4;
        int i5;
        if (i3 == i2) {
            return false;
        }
        int size = this.f3513c.size();
        int i6 = -1;
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = this.f3513c.get(i7).f3531b;
            if (fragment != null) {
                i4 = fragment.mContainerId;
            } else {
                i4 = 0;
            }
            if (!(i4 == 0 || i4 == i6)) {
                for (int i8 = i2; i8 < i3; i8++) {
                    BackStackRecord backStackRecord = arrayList.get(i8);
                    int size2 = backStackRecord.f3513c.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        Fragment fragment2 = backStackRecord.f3513c.get(i9).f3531b;
                        if (fragment2 != null) {
                            i5 = fragment2.mContainerId;
                        } else {
                            i5 = 0;
                        }
                        if (i5 == i4) {
                            return true;
                        }
                    }
                }
                i6 = i4;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        for (int i2 = 0; i2 < this.f3513c.size(); i2++) {
            if (F(this.f3513c.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public void H() {
        if (this.f3529s != null) {
            for (int i2 = 0; i2 < this.f3529s.size(); i2++) {
                this.f3529s.get(i2).run();
            }
            this.f3529s = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void I(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i2 = 0; i2 < this.f3513c.size(); i2++) {
            FragmentTransaction.Op op = this.f3513c.get(i2);
            if (F(op)) {
                op.f3531b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment J(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f3513c.size() - 1; size >= 0; size--) {
            FragmentTransaction.Op op = this.f3513c.get(size);
            int i2 = op.f3530a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.f3531b;
                            break;
                        case 10:
                            op.f3537h = op.f3536g;
                            break;
                    }
                }
                arrayList.add(op.f3531b);
            }
            arrayList.remove(op.f3531b);
        }
        return fragment;
    }

    public boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3519i) {
            return true;
        }
        this.f3264t.e(this);
        return true;
    }

    public int h() {
        return w(false);
    }

    public int i() {
        return w(true);
    }

    public void j() {
        l();
        this.f3264t.c0(this, false);
    }

    public void k() {
        l();
        this.f3264t.c0(this, true);
    }

    /* access modifiers changed from: package-private */
    public void m(int i2, Fragment fragment, String str, int i3) {
        super.m(i2, fragment, str, i3);
        fragment.mFragmentManager = this.f3264t;
    }

    public boolean n() {
        return this.f3513c.isEmpty();
    }

    public FragmentTransaction o(Fragment fragment) {
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (fragmentManager == null || fragmentManager == this.f3264t) {
            return super.o(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public FragmentTransaction s(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.f3264t) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f3264t);
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        } else if (state != Lifecycle.State.DESTROYED) {
            return super.s(fragment, state);
        } else {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3266v >= 0) {
            sb.append(" #");
            sb.append(this.f3266v);
        }
        if (this.f3521k != null) {
            sb.append(" ");
            sb.append(this.f3521k);
        }
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void v(int i2) {
        if (this.f3519i) {
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i2);
            }
            int size = this.f3513c.size();
            for (int i3 = 0; i3 < size; i3++) {
                FragmentTransaction.Op op = this.f3513c.get(i3);
                Fragment fragment = op.f3531b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i2;
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f3531b + " to " + op.f3531b.mBackStackNesting);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int w(boolean z2) {
        if (!this.f3265u) {
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                x("  ", printWriter);
                printWriter.close();
            }
            this.f3265u = true;
            if (this.f3519i) {
                this.f3266v = this.f3264t.k();
            } else {
                this.f3266v = -1;
            }
            this.f3264t.Z(this, z2);
            return this.f3266v;
        }
        throw new IllegalStateException("commit already called");
    }

    public void x(String str, PrintWriter printWriter) {
        y(str, printWriter, true);
    }

    public void y(String str, PrintWriter printWriter, boolean z2) {
        String str2;
        if (z2) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3521k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3266v);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3265u);
            if (this.f3518h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3518h));
            }
            if (!(this.f3514d == 0 && this.f3515e == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3514d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3515e));
            }
            if (!(this.f3516f == 0 && this.f3517g == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3516f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3517g));
            }
            if (!(this.f3522l == 0 && this.f3523m == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3522l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3523m);
            }
            if (!(this.f3524n == 0 && this.f3525o == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3524n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3525o);
            }
        }
        if (!this.f3513c.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.f3513c.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.f3513c.get(i2);
                switch (op.f3530a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        str2 = "cmd=" + op.f3530a;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(op.f3531b);
                if (z2) {
                    if (!(op.f3532c == 0 && op.f3533d == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.f3532c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.f3533d));
                    }
                    if (op.f3534e != 0 || op.f3535f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.f3534e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.f3535f));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z() {
        int size = this.f3513c.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransaction.Op op = this.f3513c.get(i2);
            Fragment fragment = op.f3531b;
            if (fragment != null) {
                fragment.setPopDirection(false);
                fragment.setNextTransition(this.f3518h);
                fragment.setSharedElementNames(this.f3526p, this.f3527q);
            }
            switch (op.f3530a) {
                case 1:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, false);
                    this.f3264t.g(fragment);
                    break;
                case 3:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.g1(fragment);
                    break;
                case 4:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.D0(fragment);
                    break;
                case 5:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, false);
                    this.f3264t.t1(fragment);
                    break;
                case 6:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.y(fragment);
                    break;
                case 7:
                    fragment.setAnimations(op.f3532c, op.f3533d, op.f3534e, op.f3535f);
                    this.f3264t.p1(fragment, false);
                    this.f3264t.m(fragment);
                    break;
                case 8:
                    this.f3264t.r1(fragment);
                    break;
                case 9:
                    this.f3264t.r1((Fragment) null);
                    break;
                case 10:
                    this.f3264t.q1(fragment, op.f3537h);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f3530a);
            }
            if (!this.f3528r && op.f3530a != 1 && fragment != null && !FragmentManager.P) {
                this.f3264t.Q0(fragment);
            }
        }
        if (!this.f3528r && !FragmentManager.P) {
            FragmentManager fragmentManager = this.f3264t;
            fragmentManager.R0(fragmentManager.f3427q, true);
        }
    }
}

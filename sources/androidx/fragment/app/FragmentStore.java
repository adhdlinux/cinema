package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class FragmentStore {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f3507a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, FragmentStateManager> f3508b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private FragmentManagerViewModel f3509c;

    FragmentStore() {
    }

    /* access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (!this.f3507a.contains(fragment)) {
            synchronized (this.f3507a) {
                this.f3507a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f3508b.values().removeAll(Collections.singleton((Object) null));
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f3508b.get(str) != null;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                next.u(i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f3508b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager next : this.f3508b.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment k2 = next.k();
                    printWriter.println(k2);
                    k2.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f3507a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f3507a.get(i2).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment f(String str) {
        FragmentStateManager fragmentStateManager = this.f3508b.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.k();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment g(int i2) {
        for (int size = this.f3507a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f3507a.get(size);
            if (fragment != null && fragment.mFragmentId == i2) {
                return fragment;
            }
        }
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                if (k2.mFragmentId == i2) {
                    return k2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f3507a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f3507a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                if (str.equals(k2.mTag)) {
                    return k2;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment findFragmentByWho;
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null && (findFragmentByWho = next.k().findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int j(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.f3507a.indexOf(fragment);
        for (int i2 = indexOf - 1; i2 >= 0; i2--) {
            Fragment fragment2 = this.f3507a.get(i2);
            if (fragment2.mContainer == viewGroup && (view2 = fragment2.mView) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.f3507a.size()) {
                return -1;
            }
            Fragment fragment3 = this.f3507a.get(indexOf);
            if (fragment3.mContainer == viewGroup && (view = fragment3.mView) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<FragmentStateManager> k() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> l() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                arrayList.add(next.k());
            } else {
                arrayList.add((Object) null);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public FragmentStateManager m(String str) {
        return this.f3508b.get(str);
    }

    /* access modifiers changed from: package-private */
    public List<Fragment> n() {
        ArrayList arrayList;
        if (this.f3507a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f3507a) {
            arrayList = new ArrayList(this.f3507a);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public FragmentManagerViewModel o() {
        return this.f3509c;
    }

    /* access modifiers changed from: package-private */
    public void p(FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (!c(k2.mWho)) {
            this.f3508b.put(k2.mWho, fragmentStateManager);
            if (k2.mRetainInstanceChangedWhileDetached) {
                if (k2.mRetainInstance) {
                    this.f3509c.f(k2);
                } else {
                    this.f3509c.n(k2);
                }
                k2.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Added fragment to active set " + k2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void q(FragmentStateManager fragmentStateManager) {
        Fragment k2 = fragmentStateManager.k();
        if (k2.mRetainInstance) {
            this.f3509c.n(k2);
        }
        if (this.f3508b.put(k2.mWho, (Object) null) != null && FragmentManager.G0(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + k2);
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        boolean z2;
        Iterator<Fragment> it2 = this.f3507a.iterator();
        while (it2.hasNext()) {
            FragmentStateManager fragmentStateManager = this.f3508b.get(it2.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.m();
            }
        }
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                next.m();
                Fragment k2 = next.k();
                if (!k2.mRemoving || k2.isInBackStack()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    q(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(Fragment fragment) {
        synchronized (this.f3507a) {
            this.f3507a.remove(fragment);
        }
        fragment.mAdded = false;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.f3508b.clear();
    }

    /* access modifiers changed from: package-private */
    public void u(List<String> list) {
        this.f3507a.clear();
        if (list != null) {
            for (String next : list) {
                Fragment f2 = f(next);
                if (f2 != null) {
                    if (FragmentManager.G0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: added (" + next + "): " + f2);
                    }
                    a(f2);
                } else {
                    throw new IllegalStateException("No instantiated fragment for (" + next + ")");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<FragmentState> v() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.f3508b.size());
        for (FragmentStateManager next : this.f3508b.values()) {
            if (next != null) {
                Fragment k2 = next.k();
                FragmentState s2 = next.s();
                arrayList.add(s2);
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "Saved state of " + k2 + ": " + s2.f3491n);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> w() {
        synchronized (this.f3507a) {
            if (this.f3507a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f3507a.size());
            Iterator<Fragment> it2 = this.f3507a.iterator();
            while (it2.hasNext()) {
                Fragment next = it2.next();
                arrayList.add(next.mWho);
                if (FragmentManager.G0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.mWho + "): " + next);
                }
            }
            return arrayList;
        }
    }

    /* access modifiers changed from: package-private */
    public void x(FragmentManagerViewModel fragmentManagerViewModel) {
        this.f3509c = fragmentManagerViewModel;
    }
}

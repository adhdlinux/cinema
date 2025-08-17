package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.e;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

final class FragmentManagerViewModel extends ViewModel {

    /* renamed from: k  reason: collision with root package name */
    private static final ViewModelProvider.Factory f3471k = new ViewModelProvider.Factory() {
        public /* synthetic */ ViewModel a(Class cls, CreationExtras creationExtras) {
            return e.b(this, cls, creationExtras);
        }

        public <T extends ViewModel> T b(Class<T> cls) {
            return new FragmentManagerViewModel(true);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Fragment> f3472d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, FragmentManagerViewModel> f3473e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, ViewModelStore> f3474f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3475g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3476h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3477i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3478j = false;

    FragmentManagerViewModel(boolean z2) {
        this.f3475g = z2;
    }

    static FragmentManagerViewModel j(ViewModelStore viewModelStore) {
        return (FragmentManagerViewModel) new ViewModelProvider(viewModelStore, f3471k).a(FragmentManagerViewModel.class);
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f3476h = true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || FragmentManagerViewModel.class != obj.getClass()) {
            return false;
        }
        FragmentManagerViewModel fragmentManagerViewModel = (FragmentManagerViewModel) obj;
        if (!this.f3472d.equals(fragmentManagerViewModel.f3472d) || !this.f3473e.equals(fragmentManagerViewModel.f3473e) || !this.f3474f.equals(fragmentManagerViewModel.f3474f)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (this.f3478j) {
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (!this.f3472d.containsKey(fragment.mWho)) {
            this.f3472d.put(fragment.mWho, fragment);
            if (FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(Fragment fragment) {
        if (FragmentManager.G0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        FragmentManagerViewModel fragmentManagerViewModel = this.f3473e.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            fragmentManagerViewModel.d();
            this.f3473e.remove(fragment.mWho);
        }
        ViewModelStore viewModelStore = this.f3474f.get(fragment.mWho);
        if (viewModelStore != null) {
            viewModelStore.a();
            this.f3474f.remove(fragment.mWho);
        }
    }

    /* access modifiers changed from: package-private */
    public Fragment h(String str) {
        return this.f3472d.get(str);
    }

    public int hashCode() {
        return (((this.f3472d.hashCode() * 31) + this.f3473e.hashCode()) * 31) + this.f3474f.hashCode();
    }

    /* access modifiers changed from: package-private */
    public FragmentManagerViewModel i(Fragment fragment) {
        FragmentManagerViewModel fragmentManagerViewModel = this.f3473e.get(fragment.mWho);
        if (fragmentManagerViewModel != null) {
            return fragmentManagerViewModel;
        }
        FragmentManagerViewModel fragmentManagerViewModel2 = new FragmentManagerViewModel(this.f3475g);
        this.f3473e.put(fragment.mWho, fragmentManagerViewModel2);
        return fragmentManagerViewModel2;
    }

    /* access modifiers changed from: package-private */
    public Collection<Fragment> k() {
        return new ArrayList(this.f3472d.values());
    }

    /* access modifiers changed from: package-private */
    public ViewModelStore l(Fragment fragment) {
        ViewModelStore viewModelStore = this.f3474f.get(fragment.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f3474f.put(fragment.mWho, viewModelStore2);
        return viewModelStore2;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f3476h;
    }

    /* access modifiers changed from: package-private */
    public void n(Fragment fragment) {
        boolean z2;
        if (!this.f3478j) {
            if (this.f3472d.remove(fragment.mWho) != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && FragmentManager.G0(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
            }
        } else if (FragmentManager.G0(2)) {
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
        }
    }

    /* access modifiers changed from: package-private */
    public void o(boolean z2) {
        this.f3478j = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean p(Fragment fragment) {
        if (!this.f3472d.containsKey(fragment.mWho)) {
            return true;
        }
        if (this.f3475g) {
            return this.f3476h;
        }
        return !this.f3477i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it2 = this.f3472d.values().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it3 = this.f3473e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it4 = this.f3474f.keySet().iterator();
        while (it4.hasNext()) {
            sb.append(it4.next());
            if (it4.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}

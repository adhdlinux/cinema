package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ViewModelStore {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, ViewModel> f3770a = new HashMap<>();

    public final void a() {
        for (ViewModel a2 : this.f3770a.values()) {
            a2.a();
        }
        this.f3770a.clear();
    }

    /* access modifiers changed from: package-private */
    public final ViewModel b(String str) {
        return this.f3770a.get(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f3770a.keySet());
    }

    /* access modifiers changed from: package-private */
    public final void d(String str, ViewModel viewModel) {
        ViewModel put = this.f3770a.put(str, viewModel);
        if (put != null) {
            put.d();
        }
    }
}

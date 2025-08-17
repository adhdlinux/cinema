package androidx.lifecycle;

import java.util.LinkedHashMap;
import java.util.Map;

public final class SavedStateHandlesVM extends ViewModel {

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, SavedStateHandle> f3740d = new LinkedHashMap();

    public final Map<String, SavedStateHandle> f() {
        return this.f3740d;
    }
}

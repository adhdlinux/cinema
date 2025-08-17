package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class SavedStateHandle {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f3720f = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Class<? extends Object>[] f3721g = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, Object> f3722a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, SavedStateRegistry.SavedStateProvider> f3723b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f3724c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, MutableStateFlow<Object>> f3725d;

    /* renamed from: e  reason: collision with root package name */
    private final SavedStateRegistry.SavedStateProvider f3726e;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SavedStateHandle a(Bundle bundle, Bundle bundle2) {
            boolean z2;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
                int i2 = 0;
                if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int size = parcelableArrayList.size();
                    while (i2 < size) {
                        Object obj = parcelableArrayList.get(i2);
                        if (obj != null) {
                            linkedHashMap.put((String) obj, parcelableArrayList2.get(i2));
                            i2++;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                    return new SavedStateHandle(linkedHashMap);
                }
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            } else if (bundle2 == null) {
                return new SavedStateHandle();
            } else {
                HashMap hashMap = new HashMap();
                for (String next : bundle2.keySet()) {
                    Intrinsics.e(next, "key");
                    hashMap.put(next, bundle2.get(next));
                }
                return new SavedStateHandle(hashMap);
            }
        }

        public final boolean b(Object obj) {
            if (obj == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.f3721g) {
                Intrinsics.c(cls);
                if (cls.isInstance(obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    public SavedStateHandle(Map<String, ? extends Object> map) {
        Intrinsics.f(map, "initialState");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3722a = linkedHashMap;
        this.f3723b = new LinkedHashMap();
        this.f3724c = new LinkedHashMap();
        this.f3725d = new LinkedHashMap();
        this.f3726e = new d(this);
        linkedHashMap.putAll(map);
    }

    public static final SavedStateHandle c(Bundle bundle, Bundle bundle2) {
        return f3720f.a(bundle, bundle2);
    }

    /* access modifiers changed from: private */
    public static final Bundle e(SavedStateHandle savedStateHandle) {
        Intrinsics.f(savedStateHandle, "this$0");
        for (Map.Entry entry : MapsKt__MapsKt.u(savedStateHandle.f3723b).entrySet()) {
            savedStateHandle.f((String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).b());
        }
        Set<String> keySet = savedStateHandle.f3722a.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String next : keySet) {
            arrayList.add(next);
            arrayList2.add(savedStateHandle.f3722a.get(next));
        }
        return BundleKt.a(TuplesKt.a("keys", arrayList), TuplesKt.a("values", arrayList2));
    }

    public final SavedStateRegistry.SavedStateProvider d() {
        return this.f3726e;
    }

    public final <T> void f(String str, T t2) {
        MutableLiveData mutableLiveData;
        Intrinsics.f(str, "key");
        if (f3720f.b(t2)) {
            Object obj = this.f3724c.get(str);
            if (obj instanceof MutableLiveData) {
                mutableLiveData = (MutableLiveData) obj;
            } else {
                mutableLiveData = null;
            }
            if (mutableLiveData != null) {
                mutableLiveData.n(t2);
            } else {
                this.f3722a.put(str, t2);
            }
            MutableStateFlow mutableStateFlow = this.f3725d.get(str);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t2);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't put value with type ");
        Intrinsics.c(t2);
        sb.append(t2.getClass());
        sb.append(" into saved state");
        throw new IllegalArgumentException(sb.toString());
    }

    public SavedStateHandle() {
        this.f3722a = new LinkedHashMap();
        this.f3723b = new LinkedHashMap();
        this.f3724c = new LinkedHashMap();
        this.f3725d = new LinkedHashMap();
        this.f3726e = new d(this);
    }
}

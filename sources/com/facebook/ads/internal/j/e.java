package com.facebook.ads.internal.j;

import com.facebook.ads.internal.j.d;
import com.facebook.ads.internal.j.f;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class e<T extends f, E extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<E>, List<WeakReference<T>>> f20235a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Queue<E> f20236b = new ArrayDeque();

    private void a(List<WeakReference<T>> list) {
        if (list != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                WeakReference weakReference = list.get(i3);
                if (weakReference.get() != null) {
                    list.set(i2, weakReference);
                    i2++;
                }
            }
            for (int size = list.size() - 1; size >= i2; size--) {
                list.remove(size);
            }
        }
    }

    private void b(E e2) {
        List list;
        Map<Class<E>, List<WeakReference<T>>> map = this.f20235a;
        if (map != null && (list = map.get(e2.getClass())) != null) {
            a(list);
            if (!list.isEmpty()) {
                for (WeakReference weakReference : new ArrayList(list)) {
                    f fVar = (f) weakReference.get();
                    if (fVar != null && fVar.b(e2)) {
                        fVar.a(e2);
                    }
                }
            }
        }
    }

    public synchronized void a(E e2) {
        if (this.f20236b.isEmpty()) {
            this.f20236b.add(e2);
            while (!this.f20236b.isEmpty()) {
                b((d) this.f20236b.peek());
                this.f20236b.remove();
            }
        } else {
            this.f20236b.add(e2);
        }
    }

    public synchronized void a(T... tArr) {
        if (tArr != null) {
            for (T a2 : tArr) {
                a(a2);
            }
        }
    }

    public synchronized boolean a(T t2) {
        if (t2 == null) {
            return false;
        }
        Class a2 = t2.a();
        if (this.f20235a.get(a2) == null) {
            this.f20235a.put(a2, new ArrayList());
        }
        List list = this.f20235a.get(a2);
        a(list);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((WeakReference) list.get(i2)).get() == t2) {
                return false;
            }
        }
        return list.add(new WeakReference(t2));
    }

    public synchronized void b(T... tArr) {
        if (tArr != null) {
            for (T b2 : tArr) {
                b(b2);
            }
        }
    }

    public synchronized boolean b(T t2) {
        if (t2 == null) {
            return false;
        }
        List list = this.f20235a.get(t2.a());
        if (list == null) {
            return false;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((WeakReference) list.get(i2)).get() == t2) {
                ((WeakReference) list.get(i2)).clear();
                return true;
            }
        }
        return false;
    }
}

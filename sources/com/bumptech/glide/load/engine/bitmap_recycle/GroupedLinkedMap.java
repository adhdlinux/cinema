package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedEntry<K, V> f16584a = new LinkedEntry<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<K, LinkedEntry<K, V>> f16585b = new HashMap();

    private static class LinkedEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f16586a;

        /* renamed from: b  reason: collision with root package name */
        private List<V> f16587b;

        /* renamed from: c  reason: collision with root package name */
        LinkedEntry<K, V> f16588c;

        /* renamed from: d  reason: collision with root package name */
        LinkedEntry<K, V> f16589d;

        LinkedEntry() {
            this((Object) null);
        }

        public void a(V v2) {
            if (this.f16587b == null) {
                this.f16587b = new ArrayList();
            }
            this.f16587b.add(v2);
        }

        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.f16587b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.f16587b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        LinkedEntry(K k2) {
            this.f16589d = this;
            this.f16588c = this;
            this.f16586a = k2;
        }
    }

    GroupedLinkedMap() {
    }

    private void b(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f16584a;
        linkedEntry.f16589d = linkedEntry2;
        linkedEntry.f16588c = linkedEntry2.f16588c;
        g(linkedEntry);
    }

    private void c(LinkedEntry<K, V> linkedEntry) {
        e(linkedEntry);
        LinkedEntry<K, V> linkedEntry2 = this.f16584a;
        linkedEntry.f16589d = linkedEntry2.f16589d;
        linkedEntry.f16588c = linkedEntry2;
        g(linkedEntry);
    }

    private static <K, V> void e(LinkedEntry<K, V> linkedEntry) {
        LinkedEntry<K, V> linkedEntry2 = linkedEntry.f16589d;
        linkedEntry2.f16588c = linkedEntry.f16588c;
        linkedEntry.f16588c.f16589d = linkedEntry2;
    }

    private static <K, V> void g(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.f16588c.f16589d = linkedEntry;
        linkedEntry.f16589d.f16588c = linkedEntry;
    }

    public V a(K k2) {
        LinkedEntry linkedEntry = this.f16585b.get(k2);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k2);
            this.f16585b.put(k2, linkedEntry);
        } else {
            k2.a();
        }
        b(linkedEntry);
        return linkedEntry.b();
    }

    public void d(K k2, V v2) {
        LinkedEntry linkedEntry = this.f16585b.get(k2);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k2);
            c(linkedEntry);
            this.f16585b.put(k2, linkedEntry);
        } else {
            k2.a();
        }
        linkedEntry.a(v2);
    }

    public V f() {
        for (LinkedEntry<K, V> linkedEntry = this.f16584a.f16589d; !linkedEntry.equals(this.f16584a); linkedEntry = linkedEntry.f16589d) {
            V b2 = linkedEntry.b();
            if (b2 != null) {
                return b2;
            }
            e(linkedEntry);
            this.f16585b.remove(linkedEntry.f16586a);
            ((Poolable) linkedEntry.f16586a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry<K, V> linkedEntry = this.f16584a.f16588c;
        boolean z2 = false;
        while (!linkedEntry.equals(this.f16584a)) {
            sb.append('{');
            sb.append(linkedEntry.f16586a);
            sb.append(':');
            sb.append(linkedEntry.c());
            sb.append("}, ");
            linkedEntry = linkedEntry.f16588c;
            z2 = true;
        }
        if (z2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}

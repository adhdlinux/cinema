package androidx.arch.core.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    Entry<K, V> f1568b;

    /* renamed from: c  reason: collision with root package name */
    private Entry<K, V> f1569c;

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<SupportRemove<K, V>, Boolean> f1570d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private int f1571e = 0;

    static class AscendingIterator<K, V> extends ListIterator<K, V> {
        AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.f1575e;
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> c(Entry<K, V> entry) {
            return entry.f1574d;
        }
    }

    private static class DescendingIterator<K, V> extends ListIterator<K, V> {
        DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> b(Entry<K, V> entry) {
            return entry.f1574d;
        }

        /* access modifiers changed from: package-private */
        public Entry<K, V> c(Entry<K, V> entry) {
            return entry.f1575e;
        }
    }

    static class Entry<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        final K f1572b;

        /* renamed from: c  reason: collision with root package name */
        final V f1573c;

        /* renamed from: d  reason: collision with root package name */
        Entry<K, V> f1574d;

        /* renamed from: e  reason: collision with root package name */
        Entry<K, V> f1575e;

        Entry(K k2, V v2) {
            this.f1572b = k2;
            this.f1573c = v2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (!this.f1572b.equals(entry.f1572b) || !this.f1573c.equals(entry.f1573c)) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f1572b;
        }

        public V getValue() {
            return this.f1573c;
        }

        public int hashCode() {
            return this.f1572b.hashCode() ^ this.f1573c.hashCode();
        }

        public V setValue(V v2) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f1572b + "=" + this.f1573c;
        }
    }

    private class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: b  reason: collision with root package name */
        private Entry<K, V> f1576b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1577c = true;

        IteratorWithAdditions() {
        }

        public void a(Entry<K, V> entry) {
            boolean z2;
            Entry<K, V> entry2 = this.f1576b;
            if (entry == entry2) {
                Entry<K, V> entry3 = entry2.f1575e;
                this.f1576b = entry3;
                if (entry3 == null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f1577c = z2;
            }
        }

        /* renamed from: b */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry;
            if (this.f1577c) {
                this.f1577c = false;
                this.f1576b = SafeIterableMap.this.f1568b;
            } else {
                Entry<K, V> entry2 = this.f1576b;
                if (entry2 != null) {
                    entry = entry2.f1574d;
                } else {
                    entry = null;
                }
                this.f1576b = entry;
            }
            return this.f1576b;
        }

        public boolean hasNext() {
            if (!this.f1577c) {
                Entry<K, V> entry = this.f1576b;
                if (entry == null || entry.f1574d == null) {
                    return false;
                }
                return true;
            } else if (SafeIterableMap.this.f1568b != null) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {

        /* renamed from: b  reason: collision with root package name */
        Entry<K, V> f1579b;

        /* renamed from: c  reason: collision with root package name */
        Entry<K, V> f1580c;

        ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            this.f1579b = entry2;
            this.f1580c = entry;
        }

        private Entry<K, V> e() {
            Entry<K, V> entry = this.f1580c;
            Entry<K, V> entry2 = this.f1579b;
            if (entry == entry2 || entry2 == null) {
                return null;
            }
            return c(entry);
        }

        public void a(Entry<K, V> entry) {
            if (this.f1579b == entry && entry == this.f1580c) {
                this.f1580c = null;
                this.f1579b = null;
            }
            Entry<K, V> entry2 = this.f1579b;
            if (entry2 == entry) {
                this.f1579b = b(entry2);
            }
            if (this.f1580c == entry) {
                this.f1580c = e();
            }
        }

        /* access modifiers changed from: package-private */
        public abstract Entry<K, V> b(Entry<K, V> entry);

        /* access modifiers changed from: package-private */
        public abstract Entry<K, V> c(Entry<K, V> entry);

        /* renamed from: d */
        public Map.Entry<K, V> next() {
            Entry<K, V> entry = this.f1580c;
            this.f1580c = e();
            return entry;
        }

        public boolean hasNext() {
            return this.f1580c != null;
        }
    }

    interface SupportRemove<K, V> {
        void a(Entry<K, V> entry);
    }

    public Map.Entry<K, V> a() {
        return this.f1568b;
    }

    /* access modifiers changed from: protected */
    public Entry<K, V> b(K k2) {
        Entry<K, V> entry = this.f1568b;
        while (entry != null && !entry.f1572b.equals(k2)) {
            entry = entry.f1574d;
        }
        return entry;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions c() {
        SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions();
        this.f1570d.put(iteratorWithAdditions, Boolean.FALSE);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> d() {
        return this.f1569c;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f1569c, this.f1568b);
        this.f1570d.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    /* access modifiers changed from: protected */
    public Entry<K, V> e(K k2, V v2) {
        Entry<K, V> entry = new Entry<>(k2, v2);
        this.f1571e++;
        Entry<K, V> entry2 = this.f1569c;
        if (entry2 == null) {
            this.f1568b = entry;
            this.f1569c = entry;
            return entry;
        }
        entry2.f1574d = entry;
        entry.f1575e = entry2;
        this.f1569c = entry;
        return entry;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SafeIterableMap)) {
            return false;
        }
        SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
        if (size() != safeIterableMap.size()) {
            return false;
        }
        Iterator it2 = iterator();
        Iterator it3 = safeIterableMap.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            Object next = it3.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (it2.hasNext() || it3.hasNext()) {
            return false;
        }
        return true;
    }

    public V g(K k2, V v2) {
        Entry b2 = b(k2);
        if (b2 != null) {
            return b2.f1573c;
        }
        e(k2, v2);
        return null;
    }

    public V h(K k2) {
        Entry b2 = b(k2);
        if (b2 == null) {
            return null;
        }
        this.f1571e--;
        if (!this.f1570d.isEmpty()) {
            for (SupportRemove<K, V> a2 : this.f1570d.keySet()) {
                a2.a(b2);
            }
        }
        Entry<K, V> entry = b2.f1575e;
        if (entry != null) {
            entry.f1574d = b2.f1574d;
        } else {
            this.f1568b = b2.f1574d;
        }
        Entry<K, V> entry2 = b2.f1574d;
        if (entry2 != null) {
            entry2.f1575e = entry;
        } else {
            this.f1569c = entry;
        }
        b2.f1574d = null;
        b2.f1575e = null;
        return b2.f1573c;
    }

    public int hashCode() {
        Iterator it2 = iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += ((Map.Entry) it2.next()).hashCode();
        }
        return i2;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f1568b, this.f1569c);
        this.f1570d.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public int size() {
        return this.f1571e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            sb.append(((Map.Entry) it2.next()).toString());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

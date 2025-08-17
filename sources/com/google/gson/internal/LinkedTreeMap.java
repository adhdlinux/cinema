package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: j  reason: collision with root package name */
    private static final Comparator<Comparable> f30955j = new Comparator<Comparable>() {
        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<? super K> f30956b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f30957c;

    /* renamed from: d  reason: collision with root package name */
    Node<K, V> f30958d;

    /* renamed from: e  reason: collision with root package name */
    int f30959e;

    /* renamed from: f  reason: collision with root package name */
    int f30960f;

    /* renamed from: g  reason: collision with root package name */
    final Node<K, V> f30961g;

    /* renamed from: h  reason: collision with root package name */
    private LinkedTreeMap<K, V>.EntrySet f30962h;

    /* renamed from: i  reason: collision with root package name */
    private LinkedTreeMap<K, V>.KeySet f30963i;

    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.d((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                /* renamed from: b */
                public Map.Entry<K, V> next() {
                    return a();
                }
            };
        }

        public boolean remove(Object obj) {
            Node d2;
            if (!(obj instanceof Map.Entry) || (d2 = LinkedTreeMap.this.d((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.g(d2, true);
            return true;
        }

        public int size() {
            return LinkedTreeMap.this.f30959e;
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }

        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() {
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                public K next() {
                    return a().f30977g;
                }
            };
        }

        public boolean remove(Object obj) {
            return LinkedTreeMap.this.h(obj) != null;
        }

        public int size() {
            return LinkedTreeMap.this.f30959e;
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f30968b;

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f30969c = null;

        /* renamed from: d  reason: collision with root package name */
        int f30970d;

        LinkedTreeMapIterator() {
            this.f30968b = LinkedTreeMap.this.f30961g.f30975e;
            this.f30970d = LinkedTreeMap.this.f30960f;
        }

        /* access modifiers changed from: package-private */
        public final Node<K, V> a() {
            Node<K, V> node = this.f30968b;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.f30961g) {
                throw new NoSuchElementException();
            } else if (linkedTreeMap.f30960f == this.f30970d) {
                this.f30968b = node.f30975e;
                this.f30969c = node;
                return node;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean hasNext() {
            return this.f30968b != LinkedTreeMap.this.f30961g;
        }

        public final void remove() {
            Node<K, V> node = this.f30969c;
            if (node != null) {
                LinkedTreeMap.this.g(node, true);
                this.f30969c = null;
                this.f30970d = LinkedTreeMap.this.f30960f;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(f30955j, true);
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void f(Node<K, V> node, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        while (node != null) {
            Node<K, V> node2 = node.f30973c;
            Node<K, V> node3 = node.f30974d;
            int i6 = 0;
            if (node2 != null) {
                i2 = node2.f30980j;
            } else {
                i2 = 0;
            }
            if (node3 != null) {
                i3 = node3.f30980j;
            } else {
                i3 = 0;
            }
            int i7 = i2 - i3;
            if (i7 == -2) {
                Node<K, V> node4 = node3.f30973c;
                Node<K, V> node5 = node3.f30974d;
                if (node5 != null) {
                    i5 = node5.f30980j;
                } else {
                    i5 = 0;
                }
                if (node4 != null) {
                    i6 = node4.f30980j;
                }
                int i8 = i6 - i5;
                if (i8 == -1 || (i8 == 0 && !z2)) {
                    j(node);
                } else {
                    k(node3);
                    j(node);
                }
                if (z2) {
                    return;
                }
            } else if (i7 == 2) {
                Node<K, V> node6 = node2.f30973c;
                Node<K, V> node7 = node2.f30974d;
                if (node7 != null) {
                    i4 = node7.f30980j;
                } else {
                    i4 = 0;
                }
                if (node6 != null) {
                    i6 = node6.f30980j;
                }
                int i9 = i6 - i4;
                if (i9 == 1 || (i9 == 0 && !z2)) {
                    k(node);
                } else {
                    j(node2);
                    k(node);
                }
                if (z2) {
                    return;
                }
            } else if (i7 == 0) {
                node.f30980j = i2 + 1;
                if (z2) {
                    return;
                }
            } else {
                node.f30980j = Math.max(i2, i3) + 1;
                if (!z2) {
                    return;
                }
            }
            node = node.f30972b;
        }
    }

    private void i(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.f30972b;
        node.f30972b = null;
        if (node2 != null) {
            node2.f30972b = node3;
        }
        if (node3 == null) {
            this.f30958d = node2;
        } else if (node3.f30973c == node) {
            node3.f30973c = node2;
        } else {
            node3.f30974d = node2;
        }
    }

    private void j(Node<K, V> node) {
        int i2;
        int i3;
        Node<K, V> node2 = node.f30973c;
        Node<K, V> node3 = node.f30974d;
        Node<K, V> node4 = node3.f30973c;
        Node<K, V> node5 = node3.f30974d;
        node.f30974d = node4;
        if (node4 != null) {
            node4.f30972b = node;
        }
        i(node, node3);
        node3.f30973c = node;
        node.f30972b = node3;
        int i4 = 0;
        if (node2 != null) {
            i2 = node2.f30980j;
        } else {
            i2 = 0;
        }
        if (node4 != null) {
            i3 = node4.f30980j;
        } else {
            i3 = 0;
        }
        int max = Math.max(i2, i3) + 1;
        node.f30980j = max;
        if (node5 != null) {
            i4 = node5.f30980j;
        }
        node3.f30980j = Math.max(max, i4) + 1;
    }

    private void k(Node<K, V> node) {
        int i2;
        int i3;
        Node<K, V> node2 = node.f30973c;
        Node<K, V> node3 = node.f30974d;
        Node<K, V> node4 = node2.f30973c;
        Node<K, V> node5 = node2.f30974d;
        node.f30973c = node5;
        if (node5 != null) {
            node5.f30972b = node;
        }
        i(node, node2);
        node2.f30974d = node;
        node.f30972b = node2;
        int i4 = 0;
        if (node3 != null) {
            i2 = node3.f30980j;
        } else {
            i2 = 0;
        }
        if (node5 != null) {
            i3 = node5.f30980j;
        } else {
            i3 = 0;
        }
        int max = Math.max(i2, i3) + 1;
        node.f30980j = max;
        if (node4 != null) {
            i4 = node4.f30980j;
        }
        node2.f30980j = Math.max(max, i4) + 1;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> b(K k2, boolean z2) {
        int i2;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.f30956b;
        Node<K, V> node3 = this.f30958d;
        if (node3 != null) {
            if (comparator == f30955j) {
                comparable = (Comparable) k2;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i2 = comparable.compareTo(node3.f30977g);
                } else {
                    i2 = comparator.compare(k2, node3.f30977g);
                }
                if (i2 == 0) {
                    return node3;
                }
                if (i2 < 0) {
                    node2 = node3.f30973c;
                } else {
                    node2 = node3.f30974d;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i2 = 0;
        }
        if (!z2) {
            return null;
        }
        Node<K, V> node4 = this.f30961g;
        if (node3 != null) {
            node = new Node<>(this.f30957c, node3, k2, node4, node4.f30976f);
            if (i2 < 0) {
                node3.f30973c = node;
            } else {
                node3.f30974d = node;
            }
            f(node3, true);
        } else if (comparator != f30955j || (k2 instanceof Comparable)) {
            node = new Node<>(this.f30957c, node3, k2, node4, node4.f30976f);
            this.f30958d = node;
        } else {
            throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
        }
        this.f30959e++;
        this.f30960f++;
        return node;
    }

    public void clear() {
        this.f30958d = null;
        this.f30959e = 0;
        this.f30960f++;
        Node<K, V> node = this.f30961g;
        node.f30976f = node;
        node.f30975e = node;
    }

    public boolean containsKey(Object obj) {
        return e(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> d(Map.Entry<?, ?> entry) {
        boolean z2;
        Node<K, V> e2 = e(entry.getKey());
        if (e2 == null || !a(e2.f30979i, entry.getValue())) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return e2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> e(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.f30962h;
        if (entrySet != null) {
            return entrySet;
        }
        LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
        this.f30962h = entrySet2;
        return entrySet2;
    }

    /* access modifiers changed from: package-private */
    public void g(Node<K, V> node, boolean z2) {
        Node<K, V> node2;
        int i2;
        if (z2) {
            Node<K, V> node3 = node.f30976f;
            node3.f30975e = node.f30975e;
            node.f30975e.f30976f = node3;
        }
        Node<K, V> node4 = node.f30973c;
        Node<K, V> node5 = node.f30974d;
        Node<K, V> node6 = node.f30972b;
        int i3 = 0;
        if (node4 == null || node5 == null) {
            if (node4 != null) {
                i(node, node4);
                node.f30973c = null;
            } else if (node5 != null) {
                i(node, node5);
                node.f30974d = null;
            } else {
                i(node, (Node<K, V>) null);
            }
            f(node6, false);
            this.f30959e--;
            this.f30960f++;
            return;
        }
        if (node4.f30980j > node5.f30980j) {
            node2 = node4.b();
        } else {
            node2 = node5.a();
        }
        g(node2, false);
        Node<K, V> node7 = node.f30973c;
        if (node7 != null) {
            i2 = node7.f30980j;
            node2.f30973c = node7;
            node7.f30972b = node2;
            node.f30973c = null;
        } else {
            i2 = 0;
        }
        Node<K, V> node8 = node.f30974d;
        if (node8 != null) {
            i3 = node8.f30980j;
            node2.f30974d = node8;
            node8.f30972b = node2;
            node.f30974d = null;
        }
        node2.f30980j = Math.max(i2, i3) + 1;
        i(node, node2);
    }

    public V get(Object obj) {
        Node e2 = e(obj);
        if (e2 != null) {
            return e2.f30979i;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Node<K, V> h(Object obj) {
        Node<K, V> e2 = e(obj);
        if (e2 != null) {
            g(e2, true);
        }
        return e2;
    }

    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.f30963i;
        if (keySet != null) {
            return keySet;
        }
        LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
        this.f30963i = keySet2;
        return keySet2;
    }

    public V put(K k2, V v2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        } else if (v2 != null || this.f30957c) {
            Node b2 = b(k2, true);
            V v3 = b2.f30979i;
            b2.f30979i = v2;
            return v3;
        } else {
            throw new NullPointerException("value == null");
        }
    }

    public V remove(Object obj) {
        Node h2 = h(obj);
        if (h2 != null) {
            return h2.f30979i;
        }
        return null;
    }

    public int size() {
        return this.f30959e;
    }

    public LinkedTreeMap(boolean z2) {
        this(f30955j, z2);
    }

    public LinkedTreeMap(Comparator<? super K> comparator, boolean z2) {
        this.f30959e = 0;
        this.f30960f = 0;
        this.f30956b = comparator == null ? f30955j : comparator;
        this.f30957c = z2;
        this.f30961g = new Node<>(z2);
    }

    static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        Node<K, V> f30972b;

        /* renamed from: c  reason: collision with root package name */
        Node<K, V> f30973c;

        /* renamed from: d  reason: collision with root package name */
        Node<K, V> f30974d;

        /* renamed from: e  reason: collision with root package name */
        Node<K, V> f30975e;

        /* renamed from: f  reason: collision with root package name */
        Node<K, V> f30976f;

        /* renamed from: g  reason: collision with root package name */
        final K f30977g;

        /* renamed from: h  reason: collision with root package name */
        final boolean f30978h;

        /* renamed from: i  reason: collision with root package name */
        V f30979i;

        /* renamed from: j  reason: collision with root package name */
        int f30980j;

        Node(boolean z2) {
            this.f30977g = null;
            this.f30978h = z2;
            this.f30976f = this;
            this.f30975e = this;
        }

        public Node<K, V> a() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f30973c; node2 != null; node2 = node2.f30973c) {
                node = node2;
            }
            return node;
        }

        public Node<K, V> b() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.f30974d; node2 != null; node2 = node2.f30974d) {
                node = node2;
            }
            return node;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0031 A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r0 = r3.f30977g
                if (r0 != 0) goto L_0x0012
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x0032
                goto L_0x001c
            L_0x0012:
                java.lang.Object r2 = r4.getKey()
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0032
            L_0x001c:
                V r0 = r3.f30979i
                if (r0 != 0) goto L_0x0027
                java.lang.Object r4 = r4.getValue()
                if (r4 != 0) goto L_0x0032
                goto L_0x0031
            L_0x0027:
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r0.equals(r4)
                if (r4 == 0) goto L_0x0032
            L_0x0031:
                r1 = 1
            L_0x0032:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.f30977g;
        }

        public V getValue() {
            return this.f30979i;
        }

        public int hashCode() {
            K k2 = this.f30977g;
            int i2 = 0;
            int hashCode = k2 == null ? 0 : k2.hashCode();
            V v2 = this.f30979i;
            if (v2 != null) {
                i2 = v2.hashCode();
            }
            return hashCode ^ i2;
        }

        public V setValue(V v2) {
            if (v2 != null || this.f30978h) {
                V v3 = this.f30979i;
                this.f30979i = v2;
                return v3;
            }
            throw new NullPointerException("value == null");
        }

        public String toString() {
            return this.f30977g + "=" + this.f30979i;
        }

        Node(boolean z2, Node<K, V> node, K k2, Node<K, V> node2, Node<K, V> node3) {
            this.f30972b = node;
            this.f30977g = k2;
            this.f30978h = z2;
            this.f30980j = 1;
            this.f30975e = node2;
            this.f30976f = node3;
            node3.f30975e = this;
            node2.f30976f = this;
        }
    }
}

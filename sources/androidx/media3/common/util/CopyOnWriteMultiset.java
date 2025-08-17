package androidx.media3.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CopyOnWriteMultiset<E> implements Iterable<E> {

    /* renamed from: b  reason: collision with root package name */
    private final Object f4625b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Map<E, Integer> f4626c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Set<E> f4627d = Collections.emptySet();

    /* renamed from: e  reason: collision with root package name */
    private List<E> f4628e = Collections.emptyList();

    public void a(E e2) {
        synchronized (this.f4625b) {
            ArrayList arrayList = new ArrayList(this.f4628e);
            arrayList.add(e2);
            this.f4628e = Collections.unmodifiableList(arrayList);
            Integer num = this.f4626c.get(e2);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f4627d);
                hashSet.add(e2);
                this.f4627d = Collections.unmodifiableSet(hashSet);
            }
            Map<E, Integer> map = this.f4626c;
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            map.put(e2, Integer.valueOf(i2));
        }
    }

    public int b(E e2) {
        int i2;
        synchronized (this.f4625b) {
            if (this.f4626c.containsKey(e2)) {
                i2 = this.f4626c.get(e2).intValue();
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(E r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f4625b
            monitor-enter(r0)
            java.util.Map<E, java.lang.Integer> r1 = r4.f4626c     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x004c }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x000f:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004c }
            java.util.List<E> r3 = r4.f4628e     // Catch:{ all -> 0x004c }
            r2.<init>(r3)     // Catch:{ all -> 0x004c }
            r2.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.List r2 = java.util.Collections.unmodifiableList(r2)     // Catch:{ all -> 0x004c }
            r4.f4628e = r2     // Catch:{ all -> 0x004c }
            int r2 = r1.intValue()     // Catch:{ all -> 0x004c }
            r3 = 1
            if (r2 != r3) goto L_0x003c
            java.util.Map<E, java.lang.Integer> r1 = r4.f4626c     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x004c }
            java.util.Set<E> r2 = r4.f4627d     // Catch:{ all -> 0x004c }
            r1.<init>(r2)     // Catch:{ all -> 0x004c }
            r1.remove(r5)     // Catch:{ all -> 0x004c }
            java.util.Set r5 = java.util.Collections.unmodifiableSet(r1)     // Catch:{ all -> 0x004c }
            r4.f4627d = r5     // Catch:{ all -> 0x004c }
            goto L_0x004a
        L_0x003c:
            java.util.Map<E, java.lang.Integer> r2 = r4.f4626c     // Catch:{ all -> 0x004c }
            int r1 = r1.intValue()     // Catch:{ all -> 0x004c }
            int r1 = r1 - r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004c }
            r2.put(r5, r1)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            return
        L_0x004c:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.CopyOnWriteMultiset.c(java.lang.Object):void");
    }

    public Set<E> f() {
        Set<E> set;
        synchronized (this.f4625b) {
            set = this.f4627d;
        }
        return set;
    }

    public Iterator<E> iterator() {
        Iterator<E> it2;
        synchronized (this.f4625b) {
            it2 = this.f4628e.iterator();
        }
        return it2;
    }
}

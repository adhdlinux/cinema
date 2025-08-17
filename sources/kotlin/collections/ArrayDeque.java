package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f40311e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f40312f = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    private int f40313b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f40314c = f40312f;

    /* renamed from: d  reason: collision with root package name */
    private int f40315d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(int i2, int i3) {
            int i4 = i2 + (i2 >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            return i4 - 2147483639 > 0 ? i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i4;
        }
    }

    private final void d(int i2, Collection<? extends E> collection) {
        Iterator<? extends E> it2 = collection.iterator();
        int length = this.f40314c.length;
        while (i2 < length && it2.hasNext()) {
            this.f40314c[i2] = it2.next();
            i2++;
        }
        int i3 = this.f40313b;
        for (int i4 = 0; i4 < i3 && it2.hasNext(); i4++) {
            this.f40314c[i4] = it2.next();
        }
        this.f40315d = size() + collection.size();
    }

    private final void e(int i2) {
        Object[] objArr = new Object[i2];
        Object[] objArr2 = this.f40314c;
        ArraysKt___ArraysJvmKt.f(objArr2, objArr, 0, this.f40313b, objArr2.length);
        Object[] objArr3 = this.f40314c;
        int length = objArr3.length;
        int i3 = this.f40313b;
        ArraysKt___ArraysJvmKt.f(objArr3, objArr, length - i3, 0, i3);
        this.f40313b = 0;
        this.f40314c = objArr;
    }

    private final int g(int i2) {
        return i2 == 0 ? ArraysKt___ArraysKt.y(this.f40314c) : i2 - 1;
    }

    private final void h(int i2) {
        if (i2 >= 0) {
            Object[] objArr = this.f40314c;
            if (i2 > objArr.length) {
                if (objArr == f40312f) {
                    this.f40314c = new Object[RangesKt___RangesKt.b(i2, 10)];
                } else {
                    e(f40311e.a(objArr.length, i2));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final int i(int i2) {
        if (i2 == ArraysKt___ArraysKt.y(this.f40314c)) {
            return 0;
        }
        return i2 + 1;
    }

    private final int j(int i2) {
        return i2 < 0 ? i2 + this.f40314c.length : i2;
    }

    private final int k(int i2) {
        Object[] objArr = this.f40314c;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public int a() {
        return this.f40315d;
    }

    public boolean add(E e2) {
        addLast(e2);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        Intrinsics.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        h(size() + collection.size());
        d(k(this.f40313b + size()), collection);
        return true;
    }

    public final void addFirst(E e2) {
        h(size() + 1);
        int g2 = g(this.f40313b);
        this.f40313b = g2;
        this.f40314c[g2] = e2;
        this.f40315d = size() + 1;
    }

    public final void addLast(E e2) {
        h(size() + 1);
        this.f40314c[k(this.f40313b + size())] = e2;
        this.f40315d = size() + 1;
    }

    public E b(int i2) {
        AbstractList.f40302b.b(i2, size());
        if (i2 == CollectionsKt__CollectionsKt.h(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        int k2 = k(this.f40313b + i2);
        E e2 = this.f40314c[k2];
        if (i2 < (size() >> 1)) {
            int i3 = this.f40313b;
            if (k2 >= i3) {
                Object[] objArr = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr, objArr, i3 + 1, i3, k2);
            } else {
                Object[] objArr2 = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr2, objArr2, 1, 0, k2);
                Object[] objArr3 = this.f40314c;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i4 = this.f40313b;
                ArraysKt___ArraysJvmKt.f(objArr3, objArr3, i4 + 1, i4, objArr3.length - 1);
            }
            Object[] objArr4 = this.f40314c;
            int i5 = this.f40313b;
            objArr4[i5] = null;
            this.f40313b = i(i5);
        } else {
            int k3 = k(this.f40313b + CollectionsKt__CollectionsKt.h(this));
            if (k2 <= k3) {
                Object[] objArr5 = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr5, objArr5, k2, k2 + 1, k3 + 1);
            } else {
                Object[] objArr6 = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr6, objArr6, k2, k2 + 1, objArr6.length);
                Object[] objArr7 = this.f40314c;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.f(objArr7, objArr7, 0, 1, k3 + 1);
            }
            this.f40314c[k3] = null;
        }
        this.f40315d = size() - 1;
        return e2;
    }

    public void clear() {
        int k2 = k(this.f40313b + size());
        int i2 = this.f40313b;
        if (i2 < k2) {
            ArraysKt___ArraysJvmKt.k(this.f40314c, null, i2, k2);
        } else if (!isEmpty()) {
            Object[] objArr = this.f40314c;
            ArraysKt___ArraysJvmKt.k(objArr, null, this.f40313b, objArr.length);
            ArraysKt___ArraysJvmKt.k(this.f40314c, null, 0, k2);
        }
        this.f40313b = 0;
        this.f40315d = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public E get(int i2) {
        AbstractList.f40302b.b(i2, size());
        return this.f40314c[k(this.f40313b + i2)];
    }

    public int indexOf(Object obj) {
        int i2;
        int k2 = k(this.f40313b + size());
        int i3 = this.f40313b;
        if (i3 < k2) {
            while (i3 < k2) {
                if (Intrinsics.a(obj, this.f40314c[i3])) {
                    i2 = this.f40313b;
                } else {
                    i3++;
                }
            }
            return -1;
        } else if (i3 < k2) {
            return -1;
        } else {
            int length = this.f40314c.length;
            while (true) {
                if (i3 >= length) {
                    int i4 = 0;
                    while (i4 < k2) {
                        if (Intrinsics.a(obj, this.f40314c[i4])) {
                            i3 = i4 + this.f40314c.length;
                            i2 = this.f40313b;
                        } else {
                            i4++;
                        }
                    }
                    return -1;
                } else if (Intrinsics.a(obj, this.f40314c[i3])) {
                    i2 = this.f40313b;
                    break;
                } else {
                    i3++;
                }
            }
        }
        return i3 - i2;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final E l() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public int lastIndexOf(Object obj) {
        int i2;
        int i3;
        int k2 = k(this.f40313b + size());
        int i4 = this.f40313b;
        if (i4 < k2) {
            i2 = k2 - 1;
            if (i4 <= i2) {
                while (!Intrinsics.a(obj, this.f40314c[i2])) {
                    if (i2 != i4) {
                        i2--;
                    }
                }
                i3 = this.f40313b;
            }
            return -1;
        }
        if (i4 > k2) {
            int i5 = k2 - 1;
            while (true) {
                if (-1 >= i5) {
                    int y2 = ArraysKt___ArraysKt.y(this.f40314c);
                    int i6 = this.f40313b;
                    if (i6 <= y2) {
                        while (!Intrinsics.a(obj, this.f40314c[i2])) {
                            if (i2 != i6) {
                                y2 = i2 - 1;
                            }
                        }
                        i3 = this.f40313b;
                    }
                } else if (Intrinsics.a(obj, this.f40314c[i5])) {
                    i2 = i5 + this.f40314c.length;
                    i3 = this.f40313b;
                    break;
                } else {
                    i5--;
                }
            }
        }
        return -1;
        return i2 - i3;
    }

    public final E m() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0096
            java.lang.Object[] r0 = r11.f40314c
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0096
        L_0x0019:
            int r0 = r11.f40313b
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.k(r0)
            int r3 = r11.f40313b
            r4 = 0
            if (r3 >= r0) goto L_0x0049
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0043
            java.lang.Object[] r6 = r11.f40314c
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003f
            java.lang.Object[] r7 = r11.f40314c
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x0040
        L_0x003f:
            r1 = 1
        L_0x0040:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0043:
            java.lang.Object[] r12 = r11.f40314c
            kotlin.collections.ArraysKt___ArraysJvmKt.k(r12, r4, r5, r0)
            goto L_0x008b
        L_0x0049:
            java.lang.Object[] r5 = r11.f40314c
            int r5 = r5.length
            r6 = r3
            r7 = 0
        L_0x004e:
            if (r3 >= r5) goto L_0x0069
            java.lang.Object[] r8 = r11.f40314c
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0065
            java.lang.Object[] r8 = r11.f40314c
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            int r3 = r3 + 1
            goto L_0x004e
        L_0x0069:
            int r3 = r11.k(r6)
            r5 = r3
        L_0x006e:
            if (r1 >= r0) goto L_0x008a
            java.lang.Object[] r3 = r11.f40314c
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0086
            java.lang.Object[] r3 = r11.f40314c
            r3[r5] = r6
            int r5 = r11.i(r5)
            goto L_0x0087
        L_0x0086:
            r7 = 1
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x006e
        L_0x008a:
            r1 = r7
        L_0x008b:
            if (r1 == 0) goto L_0x0096
            int r12 = r11.f40313b
            int r5 = r5 - r12
            int r12 = r11.j(r5)
            r11.f40315d = r12
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.removeAll(java.util.Collection):boolean");
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.f40314c;
            int i2 = this.f40313b;
            E e2 = eArr[i2];
            eArr[i2] = null;
            this.f40313b = i(i2);
            this.f40315d = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int k2 = k(this.f40313b + CollectionsKt__CollectionsKt.h(this));
            E[] eArr = this.f40314c;
            E e2 = eArr[k2];
            eArr[k2] = null;
            this.f40315d = size() - 1;
            return e2;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.Intrinsics.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0093
            java.lang.Object[] r0 = r11.f40314c
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0093
        L_0x0019:
            int r0 = r11.f40313b
            int r3 = r11.size()
            int r0 = r0 + r3
            int r0 = r11.k(r0)
            int r3 = r11.f40313b
            r4 = 0
            if (r3 >= r0) goto L_0x0048
            r5 = r3
        L_0x002a:
            if (r3 >= r0) goto L_0x0042
            java.lang.Object[] r6 = r11.f40314c
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x003e
            java.lang.Object[] r7 = r11.f40314c
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003f
        L_0x003e:
            r1 = 1
        L_0x003f:
            int r3 = r3 + 1
            goto L_0x002a
        L_0x0042:
            java.lang.Object[] r12 = r11.f40314c
            kotlin.collections.ArraysKt___ArraysJvmKt.k(r12, r4, r5, r0)
            goto L_0x0088
        L_0x0048:
            java.lang.Object[] r5 = r11.f40314c
            int r5 = r5.length
            r6 = r3
            r7 = 0
        L_0x004d:
            if (r3 >= r5) goto L_0x0067
            java.lang.Object[] r8 = r11.f40314c
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x0063
            java.lang.Object[] r8 = r11.f40314c
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0064
        L_0x0063:
            r7 = 1
        L_0x0064:
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0067:
            int r3 = r11.k(r6)
            r5 = r3
        L_0x006c:
            if (r1 >= r0) goto L_0x0087
            java.lang.Object[] r3 = r11.f40314c
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x0083
            java.lang.Object[] r3 = r11.f40314c
            r3[r5] = r6
            int r5 = r11.i(r5)
            goto L_0x0084
        L_0x0083:
            r7 = 1
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x006c
        L_0x0087:
            r1 = r7
        L_0x0088:
            if (r1 == 0) goto L_0x0093
            int r12 = r11.f40313b
            int r5 = r5 - r12
            int r12 = r11.j(r5)
            r11.f40315d = r12
        L_0x0093:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.ArrayDeque.retainAll(java.util.Collection):boolean");
    }

    public E set(int i2, E e2) {
        AbstractList.f40302b.b(i2, size());
        int k2 = k(this.f40313b + i2);
        E[] eArr = this.f40314c;
        E e3 = eArr[k2];
        eArr[k2] = e2;
        return e3;
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.f(tArr, "array");
        if (tArr.length < size()) {
            tArr = ArraysKt__ArraysJVMKt.a(tArr, size());
        }
        int k2 = k(this.f40313b + size());
        int i2 = this.f40313b;
        if (i2 < k2) {
            ArraysKt___ArraysJvmKt.h(this.f40314c, tArr, 0, i2, k2, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f40314c;
            ArraysKt___ArraysJvmKt.f(objArr, tArr, 0, this.f40313b, objArr.length);
            Object[] objArr2 = this.f40314c;
            ArraysKt___ArraysJvmKt.f(objArr2, tArr, objArr2.length - this.f40313b, 0, k2);
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        return tArr;
    }

    public void add(int i2, E e2) {
        AbstractList.f40302b.c(i2, size());
        if (i2 == size()) {
            addLast(e2);
        } else if (i2 == 0) {
            addFirst(e2);
        } else {
            h(size() + 1);
            int k2 = k(this.f40313b + i2);
            if (i2 < ((size() + 1) >> 1)) {
                int g2 = g(k2);
                int g3 = g(this.f40313b);
                int i3 = this.f40313b;
                if (g2 >= i3) {
                    Object[] objArr = this.f40314c;
                    objArr[g3] = objArr[i3];
                    ArraysKt___ArraysJvmKt.f(objArr, objArr, i3, i3 + 1, g2 + 1);
                } else {
                    Object[] objArr2 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr2, objArr2, i3 - 1, i3, objArr2.length);
                    Object[] objArr3 = this.f40314c;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    ArraysKt___ArraysJvmKt.f(objArr3, objArr3, 0, 1, g2 + 1);
                }
                this.f40314c[g2] = e2;
                this.f40313b = g3;
            } else {
                int k3 = k(this.f40313b + size());
                if (k2 < k3) {
                    Object[] objArr4 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr4, objArr4, k2 + 1, k2, k3);
                } else {
                    Object[] objArr5 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr5, objArr5, 1, 0, k3);
                    Object[] objArr6 = this.f40314c;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    ArraysKt___ArraysJvmKt.f(objArr6, objArr6, k2 + 1, k2, objArr6.length - 1);
                }
                this.f40314c[k2] = e2;
            }
            this.f40315d = size() + 1;
        }
    }

    public boolean addAll(int i2, Collection<? extends E> collection) {
        Intrinsics.f(collection, "elements");
        AbstractList.f40302b.c(i2, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i2 == size()) {
            return addAll(collection);
        }
        h(size() + collection.size());
        int k2 = k(this.f40313b + size());
        int k3 = k(this.f40313b + i2);
        int size = collection.size();
        if (i2 < ((size() + 1) >> 1)) {
            int i3 = this.f40313b;
            int i4 = i3 - size;
            if (k3 < i3) {
                Object[] objArr = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr, objArr, i4, i3, objArr.length);
                if (size >= k3) {
                    Object[] objArr2 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr2, objArr2, objArr2.length - size, 0, k3);
                } else {
                    Object[] objArr3 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr4, objArr4, 0, size, k3);
                }
            } else if (i4 >= 0) {
                Object[] objArr5 = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr5, objArr5, i4, i3, k3);
            } else {
                Object[] objArr6 = this.f40314c;
                i4 += objArr6.length;
                int i5 = k3 - i3;
                int length = objArr6.length - i4;
                if (length >= i5) {
                    ArraysKt___ArraysJvmKt.f(objArr6, objArr6, i4, i3, k3);
                } else {
                    ArraysKt___ArraysJvmKt.f(objArr6, objArr6, i4, i3, i3 + length);
                    Object[] objArr7 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr7, objArr7, 0, this.f40313b + length, k3);
                }
            }
            this.f40313b = i4;
            d(j(k3 - size), collection);
        } else {
            int i6 = k3 + size;
            if (k3 < k2) {
                int i7 = size + k2;
                Object[] objArr8 = this.f40314c;
                if (i7 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.f(objArr8, objArr8, i6, k3, k2);
                } else if (i6 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.f(objArr8, objArr8, i6 - objArr8.length, k3, k2);
                } else {
                    int length2 = k2 - (i7 - objArr8.length);
                    ArraysKt___ArraysJvmKt.f(objArr8, objArr8, 0, length2, k2);
                    Object[] objArr9 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr9, objArr9, i6, k3, length2);
                }
            } else {
                Object[] objArr10 = this.f40314c;
                ArraysKt___ArraysJvmKt.f(objArr10, objArr10, size, 0, k2);
                Object[] objArr11 = this.f40314c;
                if (i6 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.f(objArr11, objArr11, i6 - objArr11.length, k3, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.f(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f40314c;
                    ArraysKt___ArraysJvmKt.f(objArr12, objArr12, i6, k3, objArr12.length - size);
                }
            }
            d(k3, collection);
        }
        return true;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}

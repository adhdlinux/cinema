package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Diagonal> f11083a = new Comparator<Diagonal>() {
        /* renamed from: a */
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f11086a - diagonal2.f11086a;
        }
    };

    public static abstract class Callback {
        public abstract boolean a(int i2, int i3);

        public abstract boolean b(int i2, int i3);

        public Object c(int i2, int i3) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    static class CenteredArray {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f11084a;

        /* renamed from: b  reason: collision with root package name */
        private final int f11085b;

        CenteredArray(int i2) {
            int[] iArr = new int[i2];
            this.f11084a = iArr;
            this.f11085b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f11084a;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            return this.f11084a[i2 + this.f11085b];
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            this.f11084a[i2 + this.f11085b] = i3;
        }
    }

    static class Diagonal {

        /* renamed from: a  reason: collision with root package name */
        public final int f11086a;

        /* renamed from: b  reason: collision with root package name */
        public final int f11087b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11088c;

        Diagonal(int i2, int i3, int i4) {
            this.f11086a = i2;
            this.f11087b = i3;
            this.f11088c = i4;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f11086a + this.f11088c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f11087b + this.f11088c;
        }
    }

    public static class DiffResult {

        /* renamed from: a  reason: collision with root package name */
        private final List<Diagonal> f11089a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f11090b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f11091c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f11092d;

        /* renamed from: e  reason: collision with root package name */
        private final int f11093e;

        /* renamed from: f  reason: collision with root package name */
        private final int f11094f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f11095g;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z2) {
            this.f11089a = list;
            this.f11090b = iArr;
            this.f11091c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f11092d = callback;
            this.f11093e = callback.e();
            this.f11094f = callback.d();
            this.f11095g = z2;
            a();
            e();
        }

        private void a() {
            Diagonal diagonal;
            if (this.f11089a.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.f11089a.get(0);
            }
            if (!(diagonal != null && diagonal.f11086a == 0 && diagonal.f11087b == 0)) {
                this.f11089a.add(0, new Diagonal(0, 0, 0));
            }
            this.f11089a.add(new Diagonal(this.f11093e, this.f11094f, 0));
        }

        private void d(int i2) {
            int i3;
            int size = this.f11089a.size();
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                Diagonal diagonal = this.f11089a.get(i5);
                while (i4 < diagonal.f11087b) {
                    if (this.f11091c[i4] != 0 || !this.f11092d.b(i2, i4)) {
                        i4++;
                    } else {
                        if (this.f11092d.a(i2, i4)) {
                            i3 = 8;
                        } else {
                            i3 = 4;
                        }
                        this.f11090b[i2] = (i4 << 4) | i3;
                        this.f11091c[i4] = (i2 << 4) | i3;
                        return;
                    }
                }
                i4 = diagonal.b();
            }
        }

        private void e() {
            int i2;
            for (Diagonal next : this.f11089a) {
                for (int i3 = 0; i3 < next.f11088c; i3++) {
                    int i4 = next.f11086a + i3;
                    int i5 = next.f11087b + i3;
                    if (this.f11092d.a(i4, i5)) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    this.f11090b[i4] = (i5 << 4) | i2;
                    this.f11091c[i5] = (i4 << 4) | i2;
                }
            }
            if (this.f11095g) {
                f();
            }
        }

        private void f() {
            int i2 = 0;
            for (Diagonal next : this.f11089a) {
                while (i2 < next.f11086a) {
                    if (this.f11090b[i2] == 0) {
                        d(i2);
                    }
                    i2++;
                }
                i2 = next.a();
            }
        }

        private static PostponedUpdate g(Collection<PostponedUpdate> collection, int i2, boolean z2) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    postponedUpdate = null;
                    break;
                }
                postponedUpdate = it2.next();
                if (postponedUpdate.f11096a == i2 && postponedUpdate.f11098c == z2) {
                    it2.remove();
                    break;
                }
            }
            while (it2.hasNext()) {
                PostponedUpdate next = it2.next();
                if (z2) {
                    next.f11097b--;
                } else {
                    next.f11097b++;
                }
            }
            return postponedUpdate;
        }

        public void b(ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i2;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i3 = this.f11093e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i4 = this.f11093e;
            int i5 = this.f11094f;
            for (int size = this.f11089a.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.f11089a.get(size);
                int a2 = diagonal.a();
                int b2 = diagonal.b();
                while (true) {
                    if (i4 <= a2) {
                        break;
                    }
                    i4--;
                    int i6 = this.f11090b[i4];
                    if ((i6 & 12) != 0) {
                        int i7 = i6 >> 4;
                        PostponedUpdate g2 = g(arrayDeque, i7, false);
                        if (g2 != null) {
                            int i8 = (i3 - g2.f11097b) - 1;
                            batchingListUpdateCallback.d(i4, i8);
                            if ((i6 & 4) != 0) {
                                batchingListUpdateCallback.c(i8, 1, this.f11092d.c(i4, i7));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i4, (i3 - i4) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.b(i4, 1);
                        i3--;
                    }
                }
                while (i5 > b2) {
                    i5--;
                    int i9 = this.f11091c[i5];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        PostponedUpdate g3 = g(arrayDeque, i10, true);
                        if (g3 == null) {
                            arrayDeque.add(new PostponedUpdate(i5, i3 - i4, false));
                        } else {
                            batchingListUpdateCallback.d((i3 - g3.f11097b) - 1, i4);
                            if ((i9 & 4) != 0) {
                                batchingListUpdateCallback.c(i4, 1, this.f11092d.c(i10, i5));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.a(i4, 1);
                        i3++;
                    }
                }
                int i11 = diagonal.f11086a;
                int i12 = diagonal.f11087b;
                for (i2 = 0; i2 < diagonal.f11088c; i2++) {
                    if ((this.f11090b[i11] & 15) == 2) {
                        batchingListUpdateCallback.c(i11, 1, this.f11092d.c(i11, i12));
                    }
                    i11++;
                    i12++;
                }
                i4 = diagonal.f11086a;
                i5 = diagonal.f11087b;
            }
            batchingListUpdateCallback.e();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new AdapterListUpdateCallback(adapter));
        }
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean a(T t2, T t3);

        public abstract boolean b(T t2, T t3);

        public Object c(T t2, T t3) {
            return null;
        }
    }

    private static class PostponedUpdate {

        /* renamed from: a  reason: collision with root package name */
        int f11096a;

        /* renamed from: b  reason: collision with root package name */
        int f11097b;

        /* renamed from: c  reason: collision with root package name */
        boolean f11098c;

        PostponedUpdate(int i2, int i3, boolean z2) {
            this.f11096a = i2;
            this.f11097b = i3;
            this.f11098c = z2;
        }
    }

    static class Range {

        /* renamed from: a  reason: collision with root package name */
        int f11099a;

        /* renamed from: b  reason: collision with root package name */
        int f11100b;

        /* renamed from: c  reason: collision with root package name */
        int f11101c;

        /* renamed from: d  reason: collision with root package name */
        int f11102d;

        public Range() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f11102d - this.f11101c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f11100b - this.f11099a;
        }

        public Range(int i2, int i3, int i4, int i5) {
            this.f11099a = i2;
            this.f11100b = i3;
            this.f11101c = i4;
            this.f11102d = i5;
        }
    }

    static class Snake {

        /* renamed from: a  reason: collision with root package name */
        public int f11103a;

        /* renamed from: b  reason: collision with root package name */
        public int f11104b;

        /* renamed from: c  reason: collision with root package name */
        public int f11105c;

        /* renamed from: d  reason: collision with root package name */
        public int f11106d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11107e;

        Snake() {
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return Math.min(this.f11105c - this.f11103a, this.f11106d - this.f11104b);
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f11106d - this.f11104b != this.f11105c - this.f11103a;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f11106d - this.f11104b > this.f11105c - this.f11103a;
        }

        /* access modifiers changed from: package-private */
        public Diagonal d() {
            if (!b()) {
                int i2 = this.f11103a;
                return new Diagonal(i2, this.f11104b, this.f11105c - i2);
            } else if (this.f11107e) {
                return new Diagonal(this.f11103a, this.f11104b, a());
            } else {
                if (c()) {
                    return new Diagonal(this.f11103a, this.f11104b + 1, a());
                }
                return new Diagonal(this.f11103a + 1, this.f11104b, a());
            }
        }
    }

    private DiffUtil() {
    }

    private static Snake a(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        if ((range.b() - range.a()) % 2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int b2 = range.b() - range.a();
        int i7 = -i2;
        int i8 = i7;
        while (i8 <= i2) {
            if (i8 == i7 || (i8 != i2 && centeredArray2.b(i8 + 1) < centeredArray2.b(i8 - 1))) {
                i4 = centeredArray2.b(i8 + 1);
                i3 = i4;
            } else {
                i4 = centeredArray2.b(i8 - 1);
                i3 = i4 - 1;
            }
            int i9 = range.f11102d - ((range.f11100b - i3) - i8);
            if (i2 == 0 || i3 != i4) {
                i5 = i9;
            } else {
                i5 = i9 + 1;
            }
            while (i3 > range.f11099a && i9 > range.f11101c && callback.b(i3 - 1, i9 - 1)) {
                i3--;
                i9--;
            }
            centeredArray2.c(i8, i3);
            if (!z2 || (i6 = b2 - i8) < i7 || i6 > i2 || centeredArray.b(i6) < i3) {
                i8 += 2;
            } else {
                Snake snake = new Snake();
                snake.f11103a = i3;
                snake.f11104b = i9;
                snake.f11105c = i4;
                snake.f11106d = i5;
                snake.f11107e = true;
                return snake;
            }
        }
        return null;
    }

    public static DiffResult b(Callback callback) {
        return c(callback, true);
    }

    public static DiffResult c(Callback callback, boolean z2) {
        Range range;
        int e2 = callback.e();
        int d2 = callback.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, e2, 0, d2));
        int i2 = ((((e2 + d2) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i2);
        CenteredArray centeredArray2 = new CenteredArray(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake e3 = e(range2, callback, centeredArray, centeredArray2);
            if (e3 != null) {
                if (e3.a() > 0) {
                    arrayList.add(e3.d());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.f11099a = range2.f11099a;
                range.f11101c = range2.f11101c;
                range.f11100b = e3.f11103a;
                range.f11102d = e3.f11104b;
                arrayList2.add(range);
                range2.f11100b = range2.f11100b;
                range2.f11102d = range2.f11102d;
                range2.f11099a = e3.f11105c;
                range2.f11101c = e3.f11106d;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, f11083a);
        return new DiffResult(callback, arrayList, centeredArray.a(), centeredArray2.a(), z2);
    }

    private static Snake d(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z2 = true;
        if (Math.abs(range.b() - range.a()) % 2 != 1) {
            z2 = false;
        }
        int b2 = range.b() - range.a();
        int i7 = -i2;
        int i8 = i7;
        while (i8 <= i2) {
            if (i8 == i7 || (i8 != i2 && centeredArray.b(i8 + 1) > centeredArray.b(i8 - 1))) {
                i4 = centeredArray.b(i8 + 1);
                i3 = i4;
            } else {
                i4 = centeredArray.b(i8 - 1);
                i3 = i4 + 1;
            }
            int i9 = (range.f11101c + (i3 - range.f11099a)) - i8;
            if (i2 == 0 || i3 != i4) {
                i5 = i9;
            } else {
                i5 = i9 - 1;
            }
            while (i3 < range.f11100b && i9 < range.f11102d && callback.b(i3, i9)) {
                i3++;
                i9++;
            }
            centeredArray.c(i8, i3);
            if (!z2 || (i6 = b2 - i8) < i7 + 1 || i6 > i2 - 1 || centeredArray2.b(i6) > i3) {
                i8 += 2;
            } else {
                Snake snake = new Snake();
                snake.f11103a = i4;
                snake.f11104b = i5;
                snake.f11105c = i3;
                snake.f11106d = i9;
                snake.f11107e = false;
                return snake;
            }
        }
        return null;
    }

    private static Snake e(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.b() >= 1 && range.a() >= 1) {
            int b2 = ((range.b() + range.a()) + 1) / 2;
            centeredArray.c(1, range.f11099a);
            centeredArray2.c(1, range.f11100b);
            for (int i2 = 0; i2 < b2; i2++) {
                Snake d2 = d(range, callback, centeredArray, centeredArray2, i2);
                if (d2 != null) {
                    return d2;
                }
                Snake a2 = a(range, callback, centeredArray, centeredArray2, i2);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }
}

package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    static final ThreadLocal<GapWorker> f11143f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    static Comparator<Task> f11144g = new Comparator<Task>() {
        /* renamed from: a */
        public int compare(Task task, Task task2) {
            boolean z2;
            boolean z3;
            RecyclerView recyclerView = task.f11156d;
            if (recyclerView == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (task2.f11156d == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 == z3) {
                boolean z4 = task.f11153a;
                if (z4 == task2.f11153a) {
                    int i2 = task2.f11154b - task.f11154b;
                    if (i2 != 0) {
                        return i2;
                    }
                    int i3 = task.f11155c - task2.f11155c;
                    if (i3 != 0) {
                        return i3;
                    }
                    return 0;
                } else if (z4) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (recyclerView == null) {
                return 1;
            } else {
                return -1;
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f11145b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f11146c;

    /* renamed from: d  reason: collision with root package name */
    long f11147d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Task> f11148e = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* renamed from: a  reason: collision with root package name */
        int f11149a;

        /* renamed from: b  reason: collision with root package name */
        int f11150b;

        /* renamed from: c  reason: collision with root package name */
        int[] f11151c;

        /* renamed from: d  reason: collision with root package name */
        int f11152d;

        LayoutPrefetchRegistryImpl() {
        }

        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f11152d * 2;
                int[] iArr = this.f11151c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f11151c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 2)];
                    this.f11151c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f11151c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f11152d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            int[] iArr = this.f11151c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f11152d = 0;
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView, boolean z2) {
            this.f11152d = 0;
            int[] iArr = this.f11151c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z2) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f11149a, this.f11150b, recyclerView.mState, this);
                }
                int i2 = this.f11152d;
                if (i2 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i2;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z2;
                    recyclerView.mRecycler.P();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(int i2) {
            if (this.f11151c != null) {
                int i3 = this.f11152d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f11151c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3) {
            this.f11149a = i2;
            this.f11150b = i3;
        }
    }

    static class Task {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11153a;

        /* renamed from: b  reason: collision with root package name */
        public int f11154b;

        /* renamed from: c  reason: collision with root package name */
        public int f11155c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f11156d;

        /* renamed from: e  reason: collision with root package name */
        public int f11157e;

        Task() {
        }

        public void a() {
            this.f11153a = false;
            this.f11154b = 0;
            this.f11155c = 0;
            this.f11156d = null;
            this.f11157e = 0;
        }
    }

    GapWorker() {
    }

    private void b() {
        Task task;
        boolean z2;
        int size = this.f11145b.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f11145b.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f11152d;
            }
        }
        this.f11148e.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f11145b.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.f11149a) + Math.abs(layoutPrefetchRegistryImpl.f11150b);
                for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.f11152d * 2; i6 += 2) {
                    if (i4 >= this.f11148e.size()) {
                        task = new Task();
                        this.f11148e.add(task);
                    } else {
                        task = this.f11148e.get(i4);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f11151c;
                    int i7 = iArr[i6 + 1];
                    if (i7 <= abs) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    task.f11153a = z2;
                    task.f11154b = abs;
                    task.f11155c = i7;
                    task.f11156d = recyclerView2;
                    task.f11157e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f11148e, f11144g);
    }

    private void c(Task task, long j2) {
        long j3;
        if (task.f11153a) {
            j3 = Clock.MAX_TIME;
        } else {
            j3 = j2;
        }
        RecyclerView.ViewHolder i2 = i(task.f11156d, task.f11157e, j3);
        if (i2 != null && i2.mNestedRecyclerView != null && i2.isBound() && !i2.isInvalid()) {
            h(i2.mNestedRecyclerView.get(), j2);
        }
    }

    private void d(long j2) {
        int i2 = 0;
        while (i2 < this.f11148e.size()) {
            Task task = this.f11148e.get(i2);
            if (task.f11156d != null) {
                c(task, j2);
                task.a();
                i2++;
            } else {
                return;
            }
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int j2 = recyclerView.mChildHelper.j();
        for (int i3 = 0; i3 < j2; i3++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.c(recyclerView, true);
            if (layoutPrefetchRegistryImpl.f11152d != 0) {
                try {
                    TraceCompat.a("RV Nested Prefetch");
                    recyclerView.mState.f(recyclerView.mAdapter);
                    for (int i2 = 0; i2 < layoutPrefetchRegistryImpl.f11152d * 2; i2 += 2) {
                        i(recyclerView, layoutPrefetchRegistryImpl.f11151c[i2], j2);
                    }
                } finally {
                    TraceCompat.b();
                }
            }
        }
    }

    private RecyclerView.ViewHolder i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder N = recycler.N(i2, false, j2);
            if (N != null) {
                if (!N.isBound() || N.isInvalid()) {
                    recycler.a(N, false);
                } else {
                    recycler.G(N.itemView);
                }
            }
            return N;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f11145b.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f11146c == 0) {
            this.f11146c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f11145b.remove(recyclerView);
    }

    public void run() {
        try {
            TraceCompat.a("RV Prefetch");
            if (!this.f11145b.isEmpty()) {
                int size = this.f11145b.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f11145b.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j2) + this.f11147d);
                    this.f11146c = 0;
                    TraceCompat.b();
                }
            }
        } finally {
            this.f11146c = 0;
            TraceCompat.b();
        }
    }
}

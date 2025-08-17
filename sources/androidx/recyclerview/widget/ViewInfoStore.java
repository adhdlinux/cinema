package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.RecyclerView;

class ViewInfoStore {

    /* renamed from: a  reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> f11376a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    final LongSparseArray<RecyclerView.ViewHolder> f11377b = new LongSparseArray<>();

    static class InfoRecord {

        /* renamed from: d  reason: collision with root package name */
        static Pools$Pool<InfoRecord> f11378d = new Pools$SimplePool(20);

        /* renamed from: a  reason: collision with root package name */
        int f11379a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f11380b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.ItemAnimator.ItemHolderInfo f11381c;

        private InfoRecord() {
        }

        static void a() {
            do {
            } while (f11378d.acquire() != null);
        }

        static InfoRecord b() {
            InfoRecord acquire = f11378d.acquire();
            if (acquire == null) {
                return new InfoRecord();
            }
            return acquire;
        }

        static void c(InfoRecord infoRecord) {
            infoRecord.f11379a = 0;
            infoRecord.f11380b = null;
            infoRecord.f11381c = null;
            f11378d.release(infoRecord);
        }
    }

    interface ProcessCallback {
        void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    ViewInfoStore() {
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i2) {
        InfoRecord n2;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int g2 = this.f11376a.g(viewHolder);
        if (g2 >= 0 && (n2 = this.f11376a.n(g2)) != null) {
            int i3 = n2.f11379a;
            if ((i3 & i2) != 0) {
                int i4 = (~i2) & i3;
                n2.f11379a = i4;
                if (i2 == 4) {
                    itemHolderInfo = n2.f11380b;
                } else if (i2 == 8) {
                    itemHolderInfo = n2.f11381c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i4 & 12) == 0) {
                    this.f11376a.l(g2);
                    InfoRecord.c(n2);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f11376a.put(viewHolder, infoRecord);
        }
        infoRecord.f11379a |= 2;
        infoRecord.f11380b = itemHolderInfo;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f11376a.put(viewHolder, infoRecord);
        }
        infoRecord.f11379a |= 1;
    }

    /* access modifiers changed from: package-private */
    public void c(long j2, RecyclerView.ViewHolder viewHolder) {
        this.f11377b.k(j2, viewHolder);
    }

    /* access modifiers changed from: package-private */
    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f11376a.put(viewHolder, infoRecord);
        }
        infoRecord.f11381c = itemHolderInfo;
        infoRecord.f11379a |= 8;
    }

    /* access modifiers changed from: package-private */
    public void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.b();
            this.f11376a.put(viewHolder, infoRecord);
        }
        infoRecord.f11380b = itemHolderInfo;
        infoRecord.f11379a |= 4;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f11376a.clear();
        this.f11377b.b();
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ViewHolder g(long j2) {
        return this.f11377b.f(j2);
    }

    /* access modifiers changed from: package-private */
    public boolean h(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null || (infoRecord.f11379a & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean i(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord == null || (infoRecord.f11379a & 4) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        InfoRecord.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    /* access modifiers changed from: package-private */
    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    /* access modifiers changed from: package-private */
    public void o(ProcessCallback processCallback) {
        for (int size = this.f11376a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder j2 = this.f11376a.j(size);
            InfoRecord l2 = this.f11376a.l(size);
            int i2 = l2.f11379a;
            if ((i2 & 3) == 3) {
                processCallback.b(j2);
            } else if ((i2 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = l2.f11380b;
                if (itemHolderInfo == null) {
                    processCallback.b(j2);
                } else {
                    processCallback.c(j2, itemHolderInfo, l2.f11381c);
                }
            } else if ((i2 & 14) == 14) {
                processCallback.a(j2, l2.f11380b, l2.f11381c);
            } else if ((i2 & 12) == 12) {
                processCallback.d(j2, l2.f11380b, l2.f11381c);
            } else if ((i2 & 4) != 0) {
                processCallback.c(j2, l2.f11380b, (RecyclerView.ItemAnimator.ItemHolderInfo) null);
            } else if ((i2 & 8) != 0) {
                processCallback.a(j2, l2.f11380b, l2.f11381c);
            }
            InfoRecord.c(l2);
        }
    }

    /* access modifiers changed from: package-private */
    public void p(RecyclerView.ViewHolder viewHolder) {
        InfoRecord infoRecord = this.f11376a.get(viewHolder);
        if (infoRecord != null) {
            infoRecord.f11379a &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public void q(RecyclerView.ViewHolder viewHolder) {
        int n2 = this.f11377b.n() - 1;
        while (true) {
            if (n2 < 0) {
                break;
            } else if (viewHolder == this.f11377b.o(n2)) {
                this.f11377b.m(n2);
                break;
            } else {
                n2--;
            }
        }
        InfoRecord remove = this.f11376a.remove(viewHolder);
        if (remove != null) {
            InfoRecord.c(remove);
        }
    }
}

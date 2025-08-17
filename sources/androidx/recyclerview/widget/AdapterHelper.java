package androidx.recyclerview.widget;

import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

final class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Pools$Pool<UpdateOp> f10984a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<UpdateOp> f10985b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<UpdateOp> f10986c;

    /* renamed from: d  reason: collision with root package name */
    final Callback f10987d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f10988e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f10989f;

    /* renamed from: g  reason: collision with root package name */
    final OpReorderer f10990g;

    /* renamed from: h  reason: collision with root package name */
    private int f10991h;

    interface Callback {
        void a(int i2, int i3);

        void b(UpdateOp updateOp);

        void c(UpdateOp updateOp);

        void d(int i2, int i3);

        void e(int i2, int i3, Object obj);

        RecyclerView.ViewHolder f(int i2);

        void g(int i2, int i3);

        void h(int i2, int i3);
    }

    static final class UpdateOp {

        /* renamed from: a  reason: collision with root package name */
        int f10992a;

        /* renamed from: b  reason: collision with root package name */
        int f10993b;

        /* renamed from: c  reason: collision with root package name */
        Object f10994c;

        /* renamed from: d  reason: collision with root package name */
        int f10995d;

        UpdateOp(int i2, int i3, int i4, Object obj) {
            this.f10992a = i2;
            this.f10993b = i3;
            this.f10995d = i4;
            this.f10994c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i2 = this.f10992a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i2 = this.f10992a;
            if (i2 != updateOp.f10992a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f10995d - this.f10993b) == 1 && this.f10995d == updateOp.f10993b && this.f10993b == updateOp.f10995d) {
                return true;
            }
            if (this.f10995d != updateOp.f10995d || this.f10993b != updateOp.f10993b) {
                return false;
            }
            Object obj2 = this.f10994c;
            if (obj2 != null) {
                if (!obj2.equals(updateOp.f10994c)) {
                    return false;
                }
            } else if (updateOp.f10994c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f10992a * 31) + this.f10993b) * 31) + this.f10995d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f10993b + "c:" + this.f10995d + ",p:" + this.f10994c + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private void c(UpdateOp updateOp) {
        v(updateOp);
    }

    private void d(UpdateOp updateOp) {
        v(updateOp);
    }

    private void f(UpdateOp updateOp) {
        char c2;
        boolean z2;
        boolean z3;
        int i2 = updateOp.f10993b;
        int i3 = updateOp.f10995d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f10987d.f(i4) != null || h(i4)) {
                if (c3 == 0) {
                    k(a(2, i2, i5, (Object) null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    v(a(2, i2, i5, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 0;
            }
            if (z2) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != updateOp.f10995d) {
            b(updateOp);
            updateOp = a(2, i2, i5, (Object) null);
        }
        if (c3 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private void g(UpdateOp updateOp) {
        int i2 = updateOp.f10993b;
        int i3 = updateOp.f10995d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f10987d.f(i2) != null || h(i2)) {
                if (c2 == 0) {
                    k(a(4, i4, i5, updateOp.f10994c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    v(a(4, i4, i5, updateOp.f10994c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != updateOp.f10995d) {
            Object obj = updateOp.f10994c;
            b(updateOp);
            updateOp = a(4, i4, i5, obj);
        }
        if (c2 == 0) {
            k(updateOp);
        } else {
            v(updateOp);
        }
    }

    private boolean h(int i2) {
        int size = this.f10986c.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f10986c.get(i3);
            int i4 = updateOp.f10992a;
            if (i4 == 8) {
                if (n(updateOp.f10995d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = updateOp.f10993b;
                int i6 = updateOp.f10995d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(UpdateOp updateOp) {
        int i2;
        boolean z2;
        int i3 = updateOp.f10992a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z3 = z(updateOp.f10993b, i3);
        int i4 = updateOp.f10993b;
        int i5 = updateOp.f10992a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i6 = 1;
        for (int i7 = 1; i7 < updateOp.f10995d; i7++) {
            int z4 = z(updateOp.f10993b + (i2 * i7), updateOp.f10992a);
            int i8 = updateOp.f10992a;
            if (i8 == 2 ? z4 != z3 : !(i8 == 4 && z4 == z3 + 1)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                i6++;
            } else {
                UpdateOp a2 = a(i8, z3, i6, updateOp.f10994c);
                l(a2, i4);
                b(a2);
                if (updateOp.f10992a == 4) {
                    i4 += i6;
                }
                z3 = z4;
                i6 = 1;
            }
        }
        Object obj = updateOp.f10994c;
        b(updateOp);
        if (i6 > 0) {
            UpdateOp a3 = a(updateOp.f10992a, z3, i6, obj);
            l(a3, i4);
            b(a3);
        }
    }

    private void v(UpdateOp updateOp) {
        this.f10986c.add(updateOp);
        int i2 = updateOp.f10992a;
        if (i2 == 1) {
            this.f10987d.g(updateOp.f10993b, updateOp.f10995d);
        } else if (i2 == 2) {
            this.f10987d.d(updateOp.f10993b, updateOp.f10995d);
        } else if (i2 == 4) {
            this.f10987d.e(updateOp.f10993b, updateOp.f10995d, updateOp.f10994c);
        } else if (i2 == 8) {
            this.f10987d.a(updateOp.f10993b, updateOp.f10995d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    private int z(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f10986c.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f10986c.get(size);
            int i6 = updateOp.f10992a;
            if (i6 == 8) {
                int i7 = updateOp.f10993b;
                int i8 = updateOp.f10995d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            updateOp.f10993b = i7 + 1;
                            updateOp.f10995d = i8 + 1;
                        } else if (i3 == 2) {
                            updateOp.f10993b = i7 - 1;
                            updateOp.f10995d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        updateOp.f10995d = i8 + 1;
                    } else if (i3 == 2) {
                        updateOp.f10995d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        updateOp.f10993b = i7 + 1;
                    } else if (i3 == 2) {
                        updateOp.f10993b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = updateOp.f10993b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= updateOp.f10995d;
                    } else if (i6 == 2) {
                        i2 += updateOp.f10995d;
                    }
                } else if (i3 == 1) {
                    updateOp.f10993b = i9 + 1;
                } else if (i3 == 2) {
                    updateOp.f10993b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f10986c.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f10986c.get(size2);
            if (updateOp2.f10992a == 8) {
                int i10 = updateOp2.f10995d;
                if (i10 == updateOp2.f10993b || i10 < 0) {
                    this.f10986c.remove(size2);
                    b(updateOp2);
                }
            } else if (updateOp2.f10995d <= 0) {
                this.f10986c.remove(size2);
                b(updateOp2);
            }
        }
        return i2;
    }

    public UpdateOp a(int i2, int i3, int i4, Object obj) {
        UpdateOp acquire = this.f10984a.acquire();
        if (acquire == null) {
            return new UpdateOp(i2, i3, i4, obj);
        }
        acquire.f10992a = i2;
        acquire.f10993b = i3;
        acquire.f10995d = i4;
        acquire.f10994c = obj;
        return acquire;
    }

    public void b(UpdateOp updateOp) {
        if (!this.f10989f) {
            updateOp.f10994c = null;
            this.f10984a.release(updateOp);
        }
    }

    public int e(int i2) {
        int size = this.f10985b.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f10985b.get(i3);
            int i4 = updateOp.f10992a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = updateOp.f10993b;
                    if (i5 <= i2) {
                        int i6 = updateOp.f10995d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = updateOp.f10993b;
                    if (i7 == i2) {
                        i2 = updateOp.f10995d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (updateOp.f10995d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (updateOp.f10993b <= i2) {
                i2 += updateOp.f10995d;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int size = this.f10986c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f10987d.c(this.f10986c.get(i2));
        }
        x(this.f10986c);
        this.f10991h = 0;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f10985b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f10985b.get(i2);
            int i3 = updateOp.f10992a;
            if (i3 == 1) {
                this.f10987d.c(updateOp);
                this.f10987d.g(updateOp.f10993b, updateOp.f10995d);
            } else if (i3 == 2) {
                this.f10987d.c(updateOp);
                this.f10987d.h(updateOp.f10993b, updateOp.f10995d);
            } else if (i3 == 4) {
                this.f10987d.c(updateOp);
                this.f10987d.e(updateOp.f10993b, updateOp.f10995d, updateOp.f10994c);
            } else if (i3 == 8) {
                this.f10987d.c(updateOp);
                this.f10987d.a(updateOp.f10993b, updateOp.f10995d);
            }
            Runnable runnable = this.f10988e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f10985b);
        this.f10991h = 0;
    }

    /* access modifiers changed from: package-private */
    public void l(UpdateOp updateOp, int i2) {
        this.f10987d.b(updateOp);
        int i3 = updateOp.f10992a;
        if (i3 == 2) {
            this.f10987d.h(i2, updateOp.f10995d);
        } else if (i3 == 4) {
            this.f10987d.e(i2, updateOp.f10995d, updateOp.f10994c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int m(int i2) {
        return n(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public int n(int i2, int i3) {
        int size = this.f10986c.size();
        while (i3 < size) {
            UpdateOp updateOp = this.f10986c.get(i3);
            int i4 = updateOp.f10992a;
            if (i4 == 8) {
                int i5 = updateOp.f10993b;
                if (i5 == i2) {
                    i2 = updateOp.f10995d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (updateOp.f10995d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = updateOp.f10993b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = updateOp.f10995d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += updateOp.f10995d;
                }
            }
            i3++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean o(int i2) {
        return (i2 & this.f10991h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f10985b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return !this.f10986c.isEmpty() && !this.f10985b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f10985b.add(a(4, i2, i3, obj));
        this.f10991h |= 4;
        if (this.f10985b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f10985b.add(a(1, i2, i3, (Object) null));
        this.f10991h |= 1;
        if (this.f10985b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f10985b.add(a(8, i2, i3, (Object) null));
            this.f10991h |= 8;
            if (this.f10985b.size() == 1) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f10985b.add(a(2, i2, i3, (Object) null));
        this.f10991h |= 2;
        if (this.f10985b.size() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void w() {
        this.f10990g.b(this.f10985b);
        int size = this.f10985b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f10985b.get(i2);
            int i3 = updateOp.f10992a;
            if (i3 == 1) {
                c(updateOp);
            } else if (i3 == 2) {
                f(updateOp);
            } else if (i3 == 4) {
                g(updateOp);
            } else if (i3 == 8) {
                d(updateOp);
            }
            Runnable runnable = this.f10988e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f10985b.clear();
    }

    /* access modifiers changed from: package-private */
    public void x(List<UpdateOp> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            b(list.get(i2));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void y() {
        x(this.f10985b);
        x(this.f10986c);
        this.f10991h = 0;
    }

    AdapterHelper(Callback callback, boolean z2) {
        this.f10984a = new Pools$SimplePool(30);
        this.f10985b = new ArrayList<>();
        this.f10986c = new ArrayList<>();
        this.f10991h = 0;
        this.f10987d = callback;
        this.f10989f = z2;
        this.f10990g = new OpReorderer(this);
    }
}

package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f7487a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7488b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f7489c;

    /* renamed from: d  reason: collision with root package name */
    private int f7490d;

    /* renamed from: e  reason: collision with root package name */
    private int f7491e;

    /* renamed from: f  reason: collision with root package name */
    private int f7492f;

    /* renamed from: g  reason: collision with root package name */
    private Allocation[] f7493g;

    public DefaultAllocator(boolean z2, int i2) {
        this(z2, i2, 0);
    }

    public synchronized Allocation a() {
        Allocation allocation;
        this.f7491e++;
        int i2 = this.f7492f;
        if (i2 > 0) {
            Allocation[] allocationArr = this.f7493g;
            int i3 = i2 - 1;
            this.f7492f = i3;
            allocation = (Allocation) Assertions.f(allocationArr[i3]);
            this.f7493g[this.f7492f] = null;
        } else {
            allocation = new Allocation(new byte[this.f7488b], 0);
            int i4 = this.f7491e;
            Allocation[] allocationArr2 = this.f7493g;
            if (i4 > allocationArr2.length) {
                this.f7493g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
            }
        }
        return allocation;
    }

    public synchronized void b() {
        int i2 = 0;
        int max = Math.max(0, Util.k(this.f7490d, this.f7488b) - this.f7491e);
        int i3 = this.f7492f;
        if (max < i3) {
            if (this.f7489c != null) {
                int i4 = i3 - 1;
                while (i2 <= i4) {
                    Allocation allocation = (Allocation) Assertions.f(this.f7493g[i2]);
                    if (allocation.f7480a == this.f7489c) {
                        i2++;
                    } else {
                        Allocation allocation2 = (Allocation) Assertions.f(this.f7493g[i4]);
                        if (allocation2.f7480a != this.f7489c) {
                            i4--;
                        } else {
                            Allocation[] allocationArr = this.f7493g;
                            allocationArr[i2] = allocation2;
                            allocationArr[i4] = allocation;
                            i4--;
                            i2++;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.f7492f) {
                    return;
                }
            }
            Arrays.fill(this.f7493g, max, this.f7492f, (Object) null);
            this.f7492f = max;
        }
    }

    public int c() {
        return this.f7488b;
    }

    public synchronized void d(Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            Allocation[] allocationArr = this.f7493g;
            int i2 = this.f7492f;
            this.f7492f = i2 + 1;
            allocationArr[i2] = allocationNode.a();
            this.f7491e--;
            allocationNode = allocationNode.next();
        }
        notifyAll();
    }

    public synchronized void e(Allocation allocation) {
        Allocation[] allocationArr = this.f7493g;
        int i2 = this.f7492f;
        this.f7492f = i2 + 1;
        allocationArr[i2] = allocation;
        this.f7491e--;
        notifyAll();
    }

    public synchronized int f() {
        return this.f7491e * this.f7488b;
    }

    public synchronized void g() {
        if (this.f7487a) {
            h(0);
        }
    }

    public synchronized void h(int i2) {
        boolean z2;
        if (i2 < this.f7490d) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f7490d = i2;
        if (z2) {
            b();
        }
    }

    public DefaultAllocator(boolean z2, int i2, int i3) {
        boolean z3 = true;
        Assertions.a(i2 > 0);
        Assertions.a(i3 < 0 ? false : z3);
        this.f7487a = z2;
        this.f7488b = i2;
        this.f7492f = i3;
        this.f7493g = new Allocation[(i3 + 100)];
        if (i3 > 0) {
            this.f7489c = new byte[(i3 * i2)];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f7493g[i4] = new Allocation(this.f7489c, i4 * i2);
            }
            return;
        }
        this.f7489c = null;
    }
}

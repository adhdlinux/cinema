package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f28360a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28361b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f28362c;

    /* renamed from: d  reason: collision with root package name */
    private int f28363d;

    /* renamed from: e  reason: collision with root package name */
    private int f28364e;

    /* renamed from: f  reason: collision with root package name */
    private int f28365f;

    /* renamed from: g  reason: collision with root package name */
    private Allocation[] f28366g;

    public DefaultAllocator(boolean z2, int i2) {
        this(z2, i2, 0);
    }

    public synchronized Allocation a() {
        Allocation allocation;
        this.f28364e++;
        int i2 = this.f28365f;
        if (i2 > 0) {
            Allocation[] allocationArr = this.f28366g;
            int i3 = i2 - 1;
            this.f28365f = i3;
            allocation = (Allocation) Assertions.e(allocationArr[i3]);
            this.f28366g[this.f28365f] = null;
        } else {
            allocation = new Allocation(new byte[this.f28361b], 0);
            int i4 = this.f28364e;
            Allocation[] allocationArr2 = this.f28366g;
            if (i4 > allocationArr2.length) {
                this.f28366g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
            }
        }
        return allocation;
    }

    public synchronized void b() {
        int i2 = 0;
        int max = Math.max(0, Util.l(this.f28363d, this.f28361b) - this.f28364e);
        int i3 = this.f28365f;
        if (max < i3) {
            if (this.f28362c != null) {
                int i4 = i3 - 1;
                while (i2 <= i4) {
                    Allocation allocation = (Allocation) Assertions.e(this.f28366g[i2]);
                    if (allocation.f28307a == this.f28362c) {
                        i2++;
                    } else {
                        Allocation allocation2 = (Allocation) Assertions.e(this.f28366g[i4]);
                        if (allocation2.f28307a != this.f28362c) {
                            i4--;
                        } else {
                            Allocation[] allocationArr = this.f28366g;
                            allocationArr[i2] = allocation2;
                            allocationArr[i4] = allocation;
                            i4--;
                            i2++;
                        }
                    }
                }
                max = Math.max(max, i2);
                if (max >= this.f28365f) {
                    return;
                }
            }
            Arrays.fill(this.f28366g, max, this.f28365f, (Object) null);
            this.f28365f = max;
        }
    }

    public int c() {
        return this.f28361b;
    }

    public synchronized void d(Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            Allocation[] allocationArr = this.f28366g;
            int i2 = this.f28365f;
            this.f28365f = i2 + 1;
            allocationArr[i2] = allocationNode.a();
            this.f28364e--;
            allocationNode = allocationNode.next();
        }
        notifyAll();
    }

    public synchronized void e(Allocation allocation) {
        Allocation[] allocationArr = this.f28366g;
        int i2 = this.f28365f;
        this.f28365f = i2 + 1;
        allocationArr[i2] = allocation;
        this.f28364e--;
        notifyAll();
    }

    public synchronized int f() {
        return this.f28364e * this.f28361b;
    }

    public synchronized void g() {
        if (this.f28360a) {
            h(0);
        }
    }

    public synchronized void h(int i2) {
        boolean z2;
        if (i2 < this.f28363d) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f28363d = i2;
        if (z2) {
            b();
        }
    }

    public DefaultAllocator(boolean z2, int i2, int i3) {
        boolean z3 = true;
        Assertions.a(i2 > 0);
        Assertions.a(i3 < 0 ? false : z3);
        this.f28360a = z2;
        this.f28361b = i2;
        this.f28365f = i3;
        this.f28366g = new Allocation[(i3 + 100)];
        if (i3 > 0) {
            this.f28362c = new byte[(i3 * i2)];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f28366g[i4] = new Allocation(this.f28362c, i4 * i2);
            }
            return;
        }
        this.f28362c = null;
    }
}

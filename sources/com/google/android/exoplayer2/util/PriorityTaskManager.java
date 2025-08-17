package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {

    /* renamed from: a  reason: collision with root package name */
    private final Object f28771a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f28772b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f28773c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i2, int i3) {
            super("Priority too low [priority=" + i2 + ", highest=" + i3 + "]");
        }
    }

    public void a(int i2) {
        synchronized (this.f28771a) {
            this.f28772b.add(Integer.valueOf(i2));
            this.f28773c = Math.max(this.f28773c, i2);
        }
    }

    public void b(int i2) throws InterruptedException {
        synchronized (this.f28771a) {
            while (this.f28773c != i2) {
                this.f28771a.wait();
            }
        }
    }

    public void c(int i2) throws PriorityTooLowException {
        synchronized (this.f28771a) {
            if (this.f28773c != i2) {
                throw new PriorityTooLowException(i2, this.f28773c);
            }
        }
    }

    public void d(int i2) {
        int i3;
        synchronized (this.f28771a) {
            this.f28772b.remove(Integer.valueOf(i2));
            if (this.f28772b.isEmpty()) {
                i3 = Integer.MIN_VALUE;
            } else {
                i3 = ((Integer) Util.j(this.f28772b.peek())).intValue();
            }
            this.f28773c = i3;
            this.f28771a.notifyAll();
        }
    }
}

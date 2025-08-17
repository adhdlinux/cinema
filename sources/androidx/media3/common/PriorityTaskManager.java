package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {

    /* renamed from: a  reason: collision with root package name */
    private final Object f4332a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f4333b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f4334c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i2, int i3) {
            super("Priority too low [priority=" + i2 + ", highest=" + i3 + "]");
        }
    }

    public void a(int i2) {
        synchronized (this.f4332a) {
            this.f4333b.add(Integer.valueOf(i2));
            this.f4334c = Math.max(this.f4334c, i2);
        }
    }

    public void b(int i2) throws PriorityTooLowException {
        synchronized (this.f4332a) {
            if (this.f4334c != i2) {
                throw new PriorityTooLowException(i2, this.f4334c);
            }
        }
    }

    public void c(int i2) {
        int i3;
        synchronized (this.f4332a) {
            this.f4333b.remove(Integer.valueOf(i2));
            if (this.f4333b.isEmpty()) {
                i3 = Integer.MIN_VALUE;
            } else {
                i3 = ((Integer) Util.i(this.f4333b.peek())).intValue();
            }
            this.f4334c = i3;
            this.f4332a.notifyAll();
        }
    }
}

package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {

            /* renamed from: a  reason: collision with root package name */
            private final CopyOnWriteArrayList<HandlerAndListener> f28314a = new CopyOnWriteArrayList<>();

            private static final class HandlerAndListener {
                /* access modifiers changed from: private */

                /* renamed from: a  reason: collision with root package name */
                public final Handler f28315a;
                /* access modifiers changed from: private */

                /* renamed from: b  reason: collision with root package name */
                public final EventListener f28316b;
                /* access modifiers changed from: private */

                /* renamed from: c  reason: collision with root package name */
                public boolean f28317c;

                public HandlerAndListener(Handler handler, EventListener eventListener) {
                    this.f28315a = handler;
                    this.f28316b = eventListener;
                }

                public void d() {
                    this.f28317c = true;
                }
            }

            public void b(Handler handler, EventListener eventListener) {
                Assertions.e(handler);
                Assertions.e(eventListener);
                e(eventListener);
                this.f28314a.add(new HandlerAndListener(handler, eventListener));
            }

            public void c(int i2, long j2, long j3) {
                Iterator<HandlerAndListener> it2 = this.f28314a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (!next.f28317c) {
                        next.f28315a.post(new a(next, i2, j2, j3));
                    }
                }
            }

            public void e(EventListener eventListener) {
                Iterator<HandlerAndListener> it2 = this.f28314a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (next.f28316b == eventListener) {
                        next.d();
                        this.f28314a.remove(next);
                    }
                }
            }
        }

        void p(int i2, long j2, long j3);
    }

    long a();

    TransferListener b();

    long c();

    void e(EventListener eventListener);

    void g(Handler handler, EventListener eventListener);
}

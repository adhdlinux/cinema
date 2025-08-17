package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {

            /* renamed from: a  reason: collision with root package name */
            private final CopyOnWriteArrayList<HandlerAndListener> f7482a = new CopyOnWriteArrayList<>();

            private static final class HandlerAndListener {
                /* access modifiers changed from: private */

                /* renamed from: a  reason: collision with root package name */
                public final Handler f7483a;
                /* access modifiers changed from: private */

                /* renamed from: b  reason: collision with root package name */
                public final EventListener f7484b;
                /* access modifiers changed from: private */

                /* renamed from: c  reason: collision with root package name */
                public boolean f7485c;

                public HandlerAndListener(Handler handler, EventListener eventListener) {
                    this.f7483a = handler;
                    this.f7484b = eventListener;
                }

                public void d() {
                    this.f7485c = true;
                }
            }

            public void b(Handler handler, EventListener eventListener) {
                Assertions.f(handler);
                Assertions.f(eventListener);
                e(eventListener);
                this.f7482a.add(new HandlerAndListener(handler, eventListener));
            }

            public void c(int i2, long j2, long j3) {
                Iterator<HandlerAndListener> it2 = this.f7482a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (!next.f7485c) {
                        next.f7483a.post(new a(next, i2, j2, j3));
                    }
                }
            }

            public void e(EventListener eventListener) {
                Iterator<HandlerAndListener> it2 = this.f7482a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (next.f7484b == eventListener) {
                        next.d();
                        this.f7482a.remove(next);
                    }
                }
            }
        }

        void p(int i2, long j2, long j3);
    }

    long a();

    TransferListener b();

    long c();

    void d(EventListener eventListener);

    void e(Handler handler, EventListener eventListener);
}

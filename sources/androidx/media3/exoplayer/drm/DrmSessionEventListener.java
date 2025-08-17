package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DrmSessionEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f6222a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6223b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f6224c;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f6225a;

            /* renamed from: b  reason: collision with root package name */
            public DrmSessionEventListener f6226b;

            public ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f6225a = handler;
                this.f6226b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.y(this.f6222a, this.f6223b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.M(this.f6222a, this.f6223b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.T(this.f6222a, this.f6223b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(DrmSessionEventListener drmSessionEventListener, int i2) {
            drmSessionEventListener.K(this.f6222a, this.f6223b);
            drmSessionEventListener.z(this.f6222a, this.f6223b, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.N(this.f6222a, this.f6223b, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.Y(this.f6222a, this.f6223b);
        }

        public void g(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.f(handler);
            Assertions.f(drmSessionEventListener);
            this.f6224c.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void h() {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new p(this, next.f6226b));
            }
        }

        public void i() {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new o(this, next.f6226b));
            }
        }

        public void j() {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new n(this, next.f6226b));
            }
        }

        public void k(int i2) {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new k(this, next.f6226b, i2));
            }
        }

        public void l(Exception exc) {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new m(this, next.f6226b, exc));
            }
        }

        public void m() {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6225a, new l(this, next.f6226b));
            }
        }

        public void t(DrmSessionEventListener drmSessionEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f6224c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f6226b == drmSessionEventListener) {
                    this.f6224c.remove(next);
                }
            }
        }

        public EventDispatcher u(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f6224c, i2, mediaPeriodId);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f6224c = copyOnWriteArrayList;
            this.f6222a = i2;
            this.f6223b = mediaPeriodId;
        }
    }

    @Deprecated
    void K(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void M(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void N(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void T(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void Y(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void y(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void z(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3);
}

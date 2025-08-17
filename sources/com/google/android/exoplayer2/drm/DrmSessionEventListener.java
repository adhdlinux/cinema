package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DrmSessionEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f24085a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f24086b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f24087c;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f24088a;

            /* renamed from: b  reason: collision with root package name */
            public DrmSessionEventListener f24089b;

            public ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f24088a = handler;
                this.f24089b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.E(this.f24085a, this.f24086b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.y(this.f24085a, this.f24086b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.J(this.f24085a, this.f24086b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(DrmSessionEventListener drmSessionEventListener, int i2) {
            drmSessionEventListener.z(this.f24085a, this.f24086b);
            drmSessionEventListener.G(this.f24085a, this.f24086b, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.C(this.f24085a, this.f24086b, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.H(this.f24085a, this.f24086b);
        }

        public void g(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.e(handler);
            Assertions.e(drmSessionEventListener);
            this.f24087c.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void h() {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new o(this, next.f24089b));
            }
        }

        public void i() {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new n(this, next.f24089b));
            }
        }

        public void j() {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new p(this, next.f24089b));
            }
        }

        public void k(int i2) {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new m(this, next.f24089b, i2));
            }
        }

        public void l(Exception exc) {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new l(this, next.f24089b, exc));
            }
        }

        public void m() {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f24088a, new k(this, next.f24089b));
            }
        }

        public void t(DrmSessionEventListener drmSessionEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f24087c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f24089b == drmSessionEventListener) {
                    this.f24087c.remove(next);
                }
            }
        }

        public EventDispatcher u(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f24087c, i2, mediaPeriodId);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f24087c = copyOnWriteArrayList;
            this.f24085a = i2;
            this.f24086b = mediaPeriodId;
        }
    }

    void C(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void E(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3);

    void H(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void J(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    void y(int i2, MediaSource.MediaPeriodId mediaPeriodId);

    @Deprecated
    void z(int i2, MediaSource.MediaPeriodId mediaPeriodId);
}

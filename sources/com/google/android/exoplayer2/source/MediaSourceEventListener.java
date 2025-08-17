package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f25798a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f25799b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f25800c;

        /* renamed from: d  reason: collision with root package name */
        private final long f25801d;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f25802a;

            /* renamed from: b  reason: collision with root package name */
            public MediaSourceEventListener f25803b;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f25802a = handler;
                this.f25803b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null, 0);
        }

        private long h(long j2) {
            long i12 = Util.i1(j2);
            if (i12 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f25801d + i12;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.r(this.f25798a, this.f25799b, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.u(this.f25798a, this.f25799b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.F(this.f25798a, this.f25799b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            mediaSourceEventListener.I(this.f25798a, this.f25799b, loadEventInfo, mediaLoadData, iOException, z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.v(this.f25798a, this.f25799b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.B(this.f25798a, mediaPeriodId, mediaLoadData);
        }

        public void A(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            B(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, h(j2), h(j3)));
        }

        public void B(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new i(this, next.f25803b, loadEventInfo, mediaLoadData));
            }
        }

        public void C(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f25803b == mediaSourceEventListener) {
                    this.f25800c.remove(next);
                }
            }
        }

        public void D(int i2, long j2, long j3) {
            long j4 = j2;
            E(new MediaLoadData(1, i2, (Format) null, 3, (Object) null, h(j2), h(j3)));
        }

        public void E(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.e(this.f25799b);
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new n(this, next.f25803b, mediaPeriodId, mediaLoadData));
            }
        }

        public EventDispatcher F(int i2, MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            return new EventDispatcher(this.f25800c, i2, mediaPeriodId, j2);
        }

        public void g(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.e(handler);
            Assertions.e(mediaSourceEventListener);
            this.f25800c.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void i(int i2, Format format, int i3, Object obj, long j2) {
            j(new MediaLoadData(1, i2, format, i3, obj, h(j2), -9223372036854775807L));
        }

        public void j(MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new j(this, next.f25803b, mediaLoadData));
            }
        }

        public void q(LoadEventInfo loadEventInfo, int i2) {
            r(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            s(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, h(j2), h(j3)));
        }

        public void s(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new m(this, next.f25803b, loadEventInfo, mediaLoadData));
            }
        }

        public void t(LoadEventInfo loadEventInfo, int i2) {
            u(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            v(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, h(j2), h(j3)));
        }

        public void v(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new l(this, next.f25803b, loadEventInfo, mediaLoadData));
            }
        }

        public void w(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, IOException iOException, boolean z2) {
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            y(loadEventInfo, new MediaLoadData(i2, i3, format, i4, obj, h(j2), h(j3)), iOException, z2);
        }

        public void x(LoadEventInfo loadEventInfo, int i2, IOException iOException, boolean z2) {
            w(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, iOException, z2);
        }

        public void y(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            Iterator<ListenerAndHandler> it2 = this.f25800c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.O0(next.f25802a, new k(this, next.f25803b, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        public void z(LoadEventInfo loadEventInfo, int i2) {
            A(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            this.f25800c = copyOnWriteArrayList;
            this.f25798a = i2;
            this.f25799b = mediaPeriodId;
            this.f25801d = j2;
        }
    }

    void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void F(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void I(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    void r(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);
}

package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f6976a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f6977b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f6978c;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f6979a;

            /* renamed from: b  reason: collision with root package name */
            public MediaSourceEventListener f6980b;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f6979a = handler;
                this.f6980b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.S(this.f6976a, this.f6977b, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.O(this.f6976a, this.f6977b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.R(this.f6976a, this.f6977b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            mediaSourceEventListener.J(this.f6976a, this.f6977b, loadEventInfo, mediaLoadData, iOException, z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.v(this.f6976a, this.f6977b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.u(this.f6976a, mediaPeriodId, mediaLoadData);
        }

        public void A(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new l(this, next.f6980b, loadEventInfo, mediaLoadData));
            }
        }

        public void B(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f6980b == mediaSourceEventListener) {
                    this.f6978c.remove(next);
                }
            }
        }

        public void C(int i2, long j2, long j3) {
            D(new MediaLoadData(1, i2, (Format) null, 3, (Object) null, Util.t1(j2), Util.t1(j3)));
        }

        public void D(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.f(this.f6977b);
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new p(this, next.f6980b, mediaPeriodId, mediaLoadData));
            }
        }

        public EventDispatcher E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f6978c, i2, mediaPeriodId);
        }

        public void g(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.f(handler);
            Assertions.f(mediaSourceEventListener);
            this.f6978c.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void h(int i2, Format format, int i3, Object obj, long j2) {
            i(new MediaLoadData(1, i2, format, i3, obj, Util.t1(j2), -9223372036854775807L));
        }

        public void i(MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new m(this, next.f6980b, mediaLoadData));
            }
        }

        public void p(LoadEventInfo loadEventInfo, int i2) {
            q(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void q(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.t1(j2), Util.t1(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            r(loadEventInfo, mediaLoadData);
        }

        public void r(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new n(this, next.f6980b, loadEventInfo, mediaLoadData));
            }
        }

        public void s(LoadEventInfo loadEventInfo, int i2) {
            t(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void t(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.t1(j2), Util.t1(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            u(loadEventInfo, mediaLoadData);
        }

        public void u(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new q(this, next.f6980b, loadEventInfo, mediaLoadData));
            }
        }

        public void v(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, IOException iOException, boolean z2) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.t1(j2), Util.t1(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            x(loadEventInfo, mediaLoadData, iOException, z2);
        }

        public void w(LoadEventInfo loadEventInfo, int i2, IOException iOException, boolean z2) {
            v(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, iOException, z2);
        }

        public void x(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            Iterator<ListenerAndHandler> it2 = this.f6978c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.Y0(next.f6979a, new o(this, next.f6980b, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        public void y(LoadEventInfo loadEventInfo, int i2) {
            z(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L);
        }

        public void z(LoadEventInfo loadEventInfo, int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.t1(j2), Util.t1(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            A(loadEventInfo, mediaLoadData);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f6978c = copyOnWriteArrayList;
            this.f6976a = i2;
            this.f6977b = mediaPeriodId;
        }
    }

    void J(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    void O(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void S(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);
}

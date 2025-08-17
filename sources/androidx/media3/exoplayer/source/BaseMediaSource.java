package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseMediaSource implements MediaSource {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<MediaSource.MediaSourceCaller> f6810a = new ArrayList<>(1);

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<MediaSource.MediaSourceCaller> f6811b = new HashSet<>(1);

    /* renamed from: c  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f6812c = new MediaSourceEventListener.EventDispatcher();

    /* renamed from: d  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f6813d = new DrmSessionEventListener.EventDispatcher();

    /* renamed from: e  reason: collision with root package name */
    private Looper f6814e;

    /* renamed from: f  reason: collision with root package name */
    private Timeline f6815f;

    /* renamed from: g  reason: collision with root package name */
    private PlayerId f6816g;

    /* access modifiers changed from: protected */
    public final void A(Timeline timeline) {
        this.f6815f = timeline;
        Iterator<MediaSource.MediaSourceCaller> it2 = this.f6810a.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, timeline);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void B();

    public /* synthetic */ boolean d() {
        return j.b(this);
    }

    public /* synthetic */ Timeline e() {
        return j.a(this);
    }

    public final void f(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.f(handler);
        Assertions.f(mediaSourceEventListener);
        this.f6812c.g(handler, mediaSourceEventListener);
    }

    public final void g(MediaSourceEventListener mediaSourceEventListener) {
        this.f6812c.B(mediaSourceEventListener);
    }

    public final void j(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.f(handler);
        Assertions.f(drmSessionEventListener);
        this.f6813d.g(handler, drmSessionEventListener);
    }

    public final void k(DrmSessionEventListener drmSessionEventListener) {
        this.f6813d.t(drmSessionEventListener);
    }

    public final void m(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId) {
        boolean z2;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f6814e;
        if (looper == null || looper == myLooper) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f6816g = playerId;
        Timeline timeline = this.f6815f;
        this.f6810a.add(mediaSourceCaller);
        if (this.f6814e == null) {
            this.f6814e = myLooper;
            this.f6811b.add(mediaSourceCaller);
            z(transferListener);
        } else if (timeline != null) {
            n(mediaSourceCaller);
            mediaSourceCaller.a(this, timeline);
        }
    }

    public final void n(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.f(this.f6814e);
        boolean isEmpty = this.f6811b.isEmpty();
        this.f6811b.add(mediaSourceCaller);
        if (isEmpty) {
            w();
        }
    }

    public /* synthetic */ void o(MediaItem mediaItem) {
        j.c(this, mediaItem);
    }

    public final void p(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.f6810a.remove(mediaSourceCaller);
        if (this.f6810a.isEmpty()) {
            this.f6814e = null;
            this.f6815f = null;
            this.f6816g = null;
            this.f6811b.clear();
            B();
            return;
        }
        q(mediaSourceCaller);
    }

    public final void q(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z2 = !this.f6811b.isEmpty();
        this.f6811b.remove(mediaSourceCaller);
        if (z2 && this.f6811b.isEmpty()) {
            v();
        }
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher r(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f6813d.u(i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher s(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f6813d.u(0, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher t(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f6812c.E(i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher u(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f6812c.E(0, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    /* access modifiers changed from: protected */
    public void w() {
    }

    /* access modifiers changed from: protected */
    public final PlayerId x() {
        return (PlayerId) Assertions.j(this.f6816g);
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return !this.f6811b.isEmpty();
    }

    /* access modifiers changed from: protected */
    public abstract void z(TransferListener transferListener);
}

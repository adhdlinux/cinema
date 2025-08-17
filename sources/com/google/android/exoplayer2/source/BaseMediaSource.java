package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseMediaSource implements MediaSource {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<MediaSource.MediaSourceCaller> f25686b = new ArrayList<>(1);

    /* renamed from: c  reason: collision with root package name */
    private final HashSet<MediaSource.MediaSourceCaller> f25687c = new HashSet<>(1);

    /* renamed from: d  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f25688d = new MediaSourceEventListener.EventDispatcher();

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f25689e = new DrmSessionEventListener.EventDispatcher();

    /* renamed from: f  reason: collision with root package name */
    private Looper f25690f;

    /* renamed from: g  reason: collision with root package name */
    private Timeline f25691g;

    /* renamed from: h  reason: collision with root package name */
    private PlayerId f25692h;

    /* access modifiers changed from: protected */
    public final PlayerId A() {
        return (PlayerId) Assertions.i(this.f25692h);
    }

    /* access modifiers changed from: protected */
    public final boolean B() {
        return !this.f25687c.isEmpty();
    }

    /* access modifiers changed from: protected */
    public abstract void C(TransferListener transferListener);

    /* access modifiers changed from: protected */
    public final void D(Timeline timeline) {
        this.f25691g = timeline;
        Iterator<MediaSource.MediaSourceCaller> it2 = this.f25686b.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, timeline);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void E();

    public /* synthetic */ boolean d() {
        return h.b(this);
    }

    public /* synthetic */ Timeline e() {
        return h.a(this);
    }

    public final void g(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.f25686b.remove(mediaSourceCaller);
        if (this.f25686b.isEmpty()) {
            this.f25690f = null;
            this.f25691g = null;
            this.f25692h = null;
            this.f25687c.clear();
            E();
            return;
        }
        n(mediaSourceCaller);
    }

    public final void i(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.e(handler);
        Assertions.e(mediaSourceEventListener);
        this.f25688d.g(handler, mediaSourceEventListener);
    }

    public final void j(MediaSourceEventListener mediaSourceEventListener) {
        this.f25688d.C(mediaSourceEventListener);
    }

    public final void k(MediaSource.MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId) {
        boolean z2;
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f25690f;
        if (looper == null || looper == myLooper) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f25692h = playerId;
        Timeline timeline = this.f25691g;
        this.f25686b.add(mediaSourceCaller);
        if (this.f25690f == null) {
            this.f25690f = myLooper;
            this.f25687c.add(mediaSourceCaller);
            C(transferListener);
        } else if (timeline != null) {
            m(mediaSourceCaller);
            mediaSourceCaller.a(this, timeline);
        }
    }

    public final void m(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.e(this.f25690f);
        boolean isEmpty = this.f25687c.isEmpty();
        this.f25687c.add(mediaSourceCaller);
        if (isEmpty) {
            z();
        }
    }

    public final void n(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z2 = !this.f25687c.isEmpty();
        this.f25687c.remove(mediaSourceCaller);
        if (z2 && this.f25687c.isEmpty()) {
            y();
        }
    }

    public final void o(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.e(handler);
        Assertions.e(drmSessionEventListener);
        this.f25689e.g(handler, drmSessionEventListener);
    }

    public final void r(DrmSessionEventListener drmSessionEventListener) {
        this.f25689e.t(drmSessionEventListener);
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher s(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f25689e.u(i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher u(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f25689e.u(0, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher v(int i2, MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        return this.f25688d.F(i2, mediaPeriodId, j2);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher w(MediaSource.MediaPeriodId mediaPeriodId) {
        return this.f25688d.F(0, mediaPeriodId, 0);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher x(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        Assertions.e(mediaPeriodId);
        return this.f25688d.F(0, mediaPeriodId, j2);
    }

    /* access modifiers changed from: protected */
    public void y() {
    }

    /* access modifiers changed from: protected */
    public void z() {
    }
}

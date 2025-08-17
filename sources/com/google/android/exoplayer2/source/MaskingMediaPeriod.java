package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f25765b;

    /* renamed from: c  reason: collision with root package name */
    private final long f25766c;

    /* renamed from: d  reason: collision with root package name */
    private final Allocator f25767d;

    /* renamed from: e  reason: collision with root package name */
    private MediaSource f25768e;

    /* renamed from: f  reason: collision with root package name */
    private MediaPeriod f25769f;

    /* renamed from: g  reason: collision with root package name */
    private MediaPeriod.Callback f25770g;

    /* renamed from: h  reason: collision with root package name */
    private PrepareListener f25771h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f25772i;

    /* renamed from: j  reason: collision with root package name */
    private long f25773j = -9223372036854775807L;

    public interface PrepareListener {
        void a(MediaSource.MediaPeriodId mediaPeriodId);

        void b(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException);
    }

    public MaskingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        this.f25765b = mediaPeriodId;
        this.f25767d = allocator;
        this.f25766c = j2;
    }

    private long u(long j2) {
        long j3 = this.f25773j;
        return j3 != -9223372036854775807L ? j3 : j2;
    }

    public long b() {
        return ((MediaPeriod) Util.j(this.f25769f)).b();
    }

    public boolean c() {
        MediaPeriod mediaPeriod = this.f25769f;
        return mediaPeriod != null && mediaPeriod.c();
    }

    public long e() {
        return ((MediaPeriod) Util.j(this.f25769f)).e();
    }

    public void f(long j2) {
        ((MediaPeriod) Util.j(this.f25769f)).f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        return ((MediaPeriod) Util.j(this.f25769f)).g(j2, seekParameters);
    }

    public boolean h(long j2) {
        MediaPeriod mediaPeriod = this.f25769f;
        return mediaPeriod != null && mediaPeriod.h(j2);
    }

    public long i(long j2) {
        return ((MediaPeriod) Util.j(this.f25769f)).i(j2);
    }

    public long j() {
        return ((MediaPeriod) Util.j(this.f25769f)).j();
    }

    public void l() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f25769f;
            if (mediaPeriod != null) {
                mediaPeriod.l();
                return;
            }
            MediaSource mediaSource = this.f25768e;
            if (mediaSource != null) {
                mediaSource.c();
            }
        } catch (IOException e2) {
            PrepareListener prepareListener = this.f25771h;
            if (prepareListener == null) {
                throw e2;
            } else if (!this.f25772i) {
                this.f25772i = true;
                prepareListener.b(this.f25765b, e2);
            }
        }
    }

    public void m(MediaSource.MediaPeriodId mediaPeriodId) {
        long u2 = u(this.f25766c);
        MediaPeriod f2 = ((MediaSource) Assertions.e(this.f25768e)).f(mediaPeriodId, this.f25767d, u2);
        this.f25769f = f2;
        if (this.f25770g != null) {
            f2.r(this, u2);
        }
    }

    public TrackGroupArray n() {
        return ((MediaPeriod) Util.j(this.f25769f)).n();
    }

    public void o(long j2, boolean z2) {
        ((MediaPeriod) Util.j(this.f25769f)).o(j2, z2);
    }

    public void p(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.j(this.f25770g)).p(this);
        PrepareListener prepareListener = this.f25771h;
        if (prepareListener != null) {
            prepareListener.a(this.f25765b);
        }
    }

    public long q() {
        return this.f25773j;
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f25770g = callback;
        MediaPeriod mediaPeriod = this.f25769f;
        if (mediaPeriod != null) {
            mediaPeriod.r(this, u(this.f25766c));
        }
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        long j3;
        long j4 = this.f25773j;
        if (j4 == -9223372036854775807L || j2 != this.f25766c) {
            j3 = j2;
        } else {
            this.f25773j = -9223372036854775807L;
            j3 = j4;
        }
        return ((MediaPeriod) Util.j(this.f25769f)).s(exoTrackSelectionArr, zArr, sampleStreamArr, zArr2, j3);
    }

    public long t() {
        return this.f25766c;
    }

    /* renamed from: v */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Util.j(this.f25770g)).d(this);
    }

    public void w(long j2) {
        this.f25773j = j2;
    }

    public void x() {
        if (this.f25769f != null) {
            ((MediaSource) Assertions.e(this.f25768e)).l(this.f25769f);
        }
    }

    public void y(MediaSource mediaSource) {
        boolean z2;
        if (this.f25768e == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f25768e = mediaSource;
    }
}

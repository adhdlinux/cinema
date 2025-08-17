package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;
import java.util.ArrayList;

final class SsMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<SsChunkSource>> {

    /* renamed from: b  reason: collision with root package name */
    private final SsChunkSource.Factory f27095b;

    /* renamed from: c  reason: collision with root package name */
    private final TransferListener f27096c;

    /* renamed from: d  reason: collision with root package name */
    private final LoaderErrorThrower f27097d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionManager f27098e;

    /* renamed from: f  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f27099f;

    /* renamed from: g  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f27100g;

    /* renamed from: h  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f27101h;

    /* renamed from: i  reason: collision with root package name */
    private final Allocator f27102i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackGroupArray f27103j;

    /* renamed from: k  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f27104k;

    /* renamed from: l  reason: collision with root package name */
    private MediaPeriod.Callback f27105l;

    /* renamed from: m  reason: collision with root package name */
    private SsManifest f27106m;

    /* renamed from: n  reason: collision with root package name */
    private ChunkSampleStream<SsChunkSource>[] f27107n;

    /* renamed from: o  reason: collision with root package name */
    private SequenceableLoader f27108o;

    public SsMediaPeriod(SsManifest ssManifest, SsChunkSource.Factory factory, TransferListener transferListener, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, LoaderErrorThrower loaderErrorThrower, Allocator allocator) {
        this.f27106m = ssManifest;
        this.f27095b = factory;
        this.f27096c = transferListener;
        this.f27097d = loaderErrorThrower;
        this.f27098e = drmSessionManager;
        this.f27099f = eventDispatcher;
        this.f27100g = loadErrorHandlingPolicy;
        this.f27101h = eventDispatcher2;
        this.f27102i = allocator;
        this.f27104k = compositeSequenceableLoaderFactory;
        this.f27103j = q(ssManifest, drmSessionManager);
        ChunkSampleStream<SsChunkSource>[] t2 = t(0);
        this.f27107n = t2;
        this.f27108o = compositeSequenceableLoaderFactory.a(t2);
    }

    private ChunkSampleStream<SsChunkSource> m(ExoTrackSelection exoTrackSelection, long j2) {
        int c2 = this.f27103j.c(exoTrackSelection.h());
        return new ChunkSampleStream(this.f27106m.f27139f[c2].f27145a, (int[]) null, (Format[]) null, this.f27095b.a(this.f27097d, this.f27106m, c2, exoTrackSelection, this.f27096c), this, this.f27102i, j2, this.f27098e, this.f27099f, this.f27100g, this.f27101h);
    }

    private static TrackGroupArray q(SsManifest ssManifest, DrmSessionManager drmSessionManager) {
        TrackGroup[] trackGroupArr = new TrackGroup[ssManifest.f27139f.length];
        int i2 = 0;
        while (true) {
            SsManifest.StreamElement[] streamElementArr = ssManifest.f27139f;
            if (i2 >= streamElementArr.length) {
                return new TrackGroupArray(trackGroupArr);
            }
            Format[] formatArr = streamElementArr[i2].f27154j;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i3 = 0; i3 < formatArr.length; i3++) {
                Format format = formatArr[i3];
                formatArr2[i3] = format.c(drmSessionManager.a(format));
            }
            trackGroupArr[i2] = new TrackGroup(Integer.toString(i2), formatArr2);
            i2++;
        }
    }

    private static ChunkSampleStream<SsChunkSource>[] t(int i2) {
        return new ChunkSampleStream[i2];
    }

    public long b() {
        return this.f27108o.b();
    }

    public boolean c() {
        return this.f27108o.c();
    }

    public long e() {
        return this.f27108o.e();
    }

    public void f(long j2) {
        this.f27108o.f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream<SsChunkSource> chunkSampleStream : this.f27107n) {
            if (chunkSampleStream.f26089b == 2) {
                return chunkSampleStream.g(j2, seekParameters);
            }
        }
        return j2;
    }

    public boolean h(long j2) {
        return this.f27108o.h(j2);
    }

    public long i(long j2) {
        for (ChunkSampleStream<SsChunkSource> R : this.f27107n) {
            R.R(j2);
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() throws IOException {
        this.f27097d.a();
    }

    public TrackGroupArray n() {
        return this.f27103j;
    }

    public void o(long j2, boolean z2) {
        for (ChunkSampleStream<SsChunkSource> o2 : this.f27107n) {
            o2.o(j2, z2);
        }
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f27105l = callback;
        callback.p(this);
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        ExoTrackSelection exoTrackSelection;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
            if (chunkSampleStream != null) {
                ChunkSampleStream chunkSampleStream2 = chunkSampleStream;
                if (exoTrackSelectionArr[i2] == null || !zArr[i2]) {
                    chunkSampleStream2.O();
                    sampleStreamArr[i2] = null;
                } else {
                    ((SsChunkSource) chunkSampleStream2.D()).b(exoTrackSelectionArr[i2]);
                    arrayList.add(chunkSampleStream2);
                }
            }
            if (sampleStreamArr[i2] == null && (exoTrackSelection = exoTrackSelectionArr[i2]) != null) {
                ChunkSampleStream<SsChunkSource> m2 = m(exoTrackSelection, j2);
                arrayList.add(m2);
                sampleStreamArr[i2] = m2;
                zArr2[i2] = true;
            }
        }
        ChunkSampleStream<SsChunkSource>[] t2 = t(arrayList.size());
        this.f27107n = t2;
        arrayList.toArray(t2);
        this.f27108o = this.f27104k.a(this.f27107n);
        return j2;
    }

    /* renamed from: u */
    public void d(ChunkSampleStream<SsChunkSource> chunkSampleStream) {
        this.f27105l.d(this);
    }

    public void v() {
        for (ChunkSampleStream<SsChunkSource> O : this.f27107n) {
            O.O();
        }
        this.f27105l = null;
    }

    public void w(SsManifest ssManifest) {
        this.f27106m = ssManifest;
        for (ChunkSampleStream<SsChunkSource> D : this.f27107n) {
            D.D().e(ssManifest);
        }
        this.f27105l.d(this);
    }
}

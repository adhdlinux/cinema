package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkHolder;
import com.google.android.exoplayer2.source.chunk.ContainerMediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.List;

public class DefaultSsChunkSource implements SsChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final LoaderErrorThrower f27084a;

    /* renamed from: b  reason: collision with root package name */
    private final int f27085b;

    /* renamed from: c  reason: collision with root package name */
    private final ChunkExtractor[] f27086c;

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f27087d;

    /* renamed from: e  reason: collision with root package name */
    private ExoTrackSelection f27088e;

    /* renamed from: f  reason: collision with root package name */
    private SsManifest f27089f;

    /* renamed from: g  reason: collision with root package name */
    private int f27090g;

    /* renamed from: h  reason: collision with root package name */
    private IOException f27091h;

    public static final class Factory implements SsChunkSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f27092a;

        public Factory(DataSource.Factory factory) {
            this.f27092a = factory;
        }

        public SsChunkSource a(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, TransferListener transferListener) {
            DataSource a2 = this.f27092a.a();
            if (transferListener != null) {
                a2.p(transferListener);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i2, exoTrackSelection, a2);
        }
    }

    private static final class StreamElementIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final SsManifest.StreamElement f27093e;

        /* renamed from: f  reason: collision with root package name */
        private final int f27094f;

        public StreamElementIterator(SsManifest.StreamElement streamElement, int i2, int i3) {
            super((long) i3, (long) (streamElement.f27155k - 1));
            this.f27093e = streamElement;
            this.f27094f = i2;
        }

        public long a() {
            c();
            return this.f27093e.e((int) d());
        }

        public long b() {
            return a() + this.f27093e.c((int) d());
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, DataSource dataSource) {
        TrackEncryptionBox[] trackEncryptionBoxArr;
        int i3;
        SsManifest ssManifest2 = ssManifest;
        int i4 = i2;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.f27084a = loaderErrorThrower;
        this.f27089f = ssManifest2;
        this.f27085b = i4;
        this.f27088e = exoTrackSelection2;
        this.f27087d = dataSource;
        SsManifest.StreamElement streamElement = ssManifest2.f27139f[i4];
        this.f27086c = new ChunkExtractor[exoTrackSelection.length()];
        int i5 = 0;
        while (i5 < this.f27086c.length) {
            int c2 = exoTrackSelection2.c(i5);
            Format format = streamElement.f27154j[c2];
            if (format.f23074p != null) {
                trackEncryptionBoxArr = ((SsManifest.ProtectionElement) Assertions.e(ssManifest2.f27138e)).f27144c;
            } else {
                trackEncryptionBoxArr = null;
            }
            int i6 = streamElement.f27145a;
            if (i6 == 2) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            int i7 = i5;
            Track track = r7;
            Track track2 = new Track(c2, i6, streamElement.f27147c, -9223372036854775807L, ssManifest2.f27140g, format, 0, trackEncryptionBoxArr, i3, (long[]) null, (long[]) null);
            this.f27086c[i7] = new BundledChunkExtractor(new FragmentedMp4Extractor(3, (TimestampAdjuster) null, track), streamElement.f27145a, format);
            i5 = i7 + 1;
        }
    }

    private static MediaChunk k(Format format, DataSource dataSource, Uri uri, int i2, long j2, long j3, long j4, int i3, Object obj, ChunkExtractor chunkExtractor) {
        DataSource dataSource2 = dataSource;
        long j5 = j3;
        long j6 = j4;
        int i4 = i3;
        Object obj2 = obj;
        DataSpec dataSpec = r0;
        DataSpec dataSpec2 = new DataSpec(uri);
        return new ContainerMediaChunk(dataSource2, dataSpec, format, i4, obj2, j2, j5, j6, -9223372036854775807L, (long) i2, 1, j2, chunkExtractor);
    }

    private long l(long j2) {
        SsManifest ssManifest = this.f27089f;
        if (!ssManifest.f27137d) {
            return -9223372036854775807L;
        }
        SsManifest.StreamElement streamElement = ssManifest.f27139f[this.f27085b];
        int i2 = streamElement.f27155k - 1;
        return (streamElement.e(i2) + streamElement.c(i2)) - j2;
    }

    public void a() throws IOException {
        IOException iOException = this.f27091h;
        if (iOException == null) {
            this.f27084a.a();
            return;
        }
        throw iOException;
    }

    public void b(ExoTrackSelection exoTrackSelection) {
        this.f27088e = exoTrackSelection;
    }

    public int c(long j2, List<? extends MediaChunk> list) {
        if (this.f27091h != null || this.f27088e.length() < 2) {
            return list.size();
        }
        return this.f27088e.j(j2, list);
    }

    public boolean d(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f27091h != null) {
            return false;
        }
        return this.f27088e.q(j2, chunk, list);
    }

    public void e(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.f27089f.f27139f;
        int i2 = this.f27085b;
        SsManifest.StreamElement streamElement = streamElementArr[i2];
        int i3 = streamElement.f27155k;
        SsManifest.StreamElement streamElement2 = ssManifest.f27139f[i2];
        if (i3 == 0 || streamElement2.f27155k == 0) {
            this.f27090g += i3;
        } else {
            int i4 = i3 - 1;
            long e2 = streamElement.e(i4) + streamElement.c(i4);
            long e3 = streamElement2.e(0);
            if (e2 <= e3) {
                this.f27090g += i3;
            } else {
                this.f27090g += streamElement.d(e3);
            }
        }
        this.f27089f = ssManifest;
    }

    public void f(Chunk chunk) {
    }

    public long g(long j2, SeekParameters seekParameters) {
        long j3;
        SsManifest.StreamElement streamElement = this.f27089f.f27139f[this.f27085b];
        int d2 = streamElement.d(j2);
        long e2 = streamElement.e(d2);
        if (e2 >= j2 || d2 >= streamElement.f27155k - 1) {
            j3 = e2;
        } else {
            j3 = streamElement.e(d2 + 1);
        }
        return seekParameters.a(j2, e2, j3);
    }

    public boolean h(Chunk chunk, boolean z2, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection d2 = loadErrorHandlingPolicy.d(TrackSelectionUtil.c(this.f27088e), loadErrorInfo);
        if (z2 && d2 != null && d2.f28456a == 2) {
            ExoTrackSelection exoTrackSelection = this.f27088e;
            if (exoTrackSelection.o(exoTrackSelection.r(chunk.f26081d), d2.f28457b)) {
                return true;
            }
        }
        return false;
    }

    public final void j(long j2, long j3, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i2;
        long j4 = j3;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.f27091h == null) {
            SsManifest ssManifest = this.f27089f;
            SsManifest.StreamElement streamElement = ssManifest.f27139f[this.f27085b];
            if (streamElement.f27155k == 0) {
                chunkHolder2.f26088b = !ssManifest.f27137d;
                return;
            }
            if (list.isEmpty()) {
                i2 = streamElement.d(j4);
                List<? extends MediaChunk> list2 = list;
            } else {
                i2 = (int) (((MediaChunk) list.get(list.size() - 1)).g() - ((long) this.f27090g));
                if (i2 < 0) {
                    this.f27091h = new BehindLiveWindowException();
                    return;
                }
            }
            if (i2 >= streamElement.f27155k) {
                chunkHolder2.f26088b = !this.f27089f.f27137d;
                return;
            }
            long j5 = j4 - j2;
            long l2 = l(j2);
            int length = this.f27088e.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            for (int i3 = 0; i3 < length; i3++) {
                mediaChunkIteratorArr[i3] = new StreamElementIterator(streamElement, this.f27088e.c(i3), i2);
            }
            this.f27088e.s(j2, j5, l2, list, mediaChunkIteratorArr);
            long e2 = streamElement.e(i2);
            long c2 = e2 + streamElement.c(i2);
            if (!list.isEmpty()) {
                j4 = -9223372036854775807L;
            }
            long j6 = j4;
            int i4 = i2 + this.f27090g;
            int a2 = this.f27088e.a();
            ChunkExtractor chunkExtractor = this.f27086c[a2];
            Uri a3 = streamElement.a(this.f27088e.c(a2), i2);
            chunkHolder2.f26087a = k(this.f27088e.l(), this.f27087d, a3, i4, e2, c2, j6, this.f27088e.m(), this.f27088e.e(), chunkExtractor);
        }
    }

    public void release() {
        for (ChunkExtractor release : this.f27086c) {
            release.release();
        }
    }
}

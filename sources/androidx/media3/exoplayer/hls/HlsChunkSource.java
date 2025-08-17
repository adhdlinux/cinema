package androidx.media3.exoplayer.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.DataChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.BaseTrackSelection;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.common.callercontext.ContextChain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.http2.Http2;

class HlsChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final HlsExtractorFactory f6302a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f6303b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f6304c;

    /* renamed from: d  reason: collision with root package name */
    private final TimestampAdjusterProvider f6305d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f6306e;

    /* renamed from: f  reason: collision with root package name */
    private final Format[] f6307f;

    /* renamed from: g  reason: collision with root package name */
    private final HlsPlaylistTracker f6308g;

    /* renamed from: h  reason: collision with root package name */
    private final TrackGroup f6309h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Format> f6310i;

    /* renamed from: j  reason: collision with root package name */
    private final FullSegmentEncryptionKeyCache f6311j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: k  reason: collision with root package name */
    private final PlayerId f6312k;

    /* renamed from: l  reason: collision with root package name */
    private final long f6313l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6314m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f6315n = Util.f4719f;

    /* renamed from: o  reason: collision with root package name */
    private IOException f6316o;

    /* renamed from: p  reason: collision with root package name */
    private Uri f6317p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f6318q;

    /* renamed from: r  reason: collision with root package name */
    private ExoTrackSelection f6319r;

    /* renamed from: s  reason: collision with root package name */
    private long f6320s = -9223372036854775807L;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6321t;

    /* renamed from: u  reason: collision with root package name */
    private long f6322u = -9223372036854775807L;

    private static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: l  reason: collision with root package name */
        private byte[] f6323l;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i2, obj, bArr);
        }

        /* access modifiers changed from: protected */
        public void g(byte[] bArr, int i2) {
            this.f6323l = Arrays.copyOf(bArr, i2);
        }

        public byte[] j() {
            return this.f6323l;
        }
    }

    public static final class HlsChunkHolder {

        /* renamed from: a  reason: collision with root package name */
        public Chunk f6324a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6325b;

        /* renamed from: c  reason: collision with root package name */
        public Uri f6326c;

        public HlsChunkHolder() {
            a();
        }

        public void a() {
            this.f6324a = null;
            this.f6325b = false;
            this.f6326c = null;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final List<HlsMediaPlaylist.SegmentBase> f6327e;

        /* renamed from: f  reason: collision with root package name */
        private final long f6328f;

        /* renamed from: g  reason: collision with root package name */
        private final String f6329g;

        public HlsMediaPlaylistSegmentIterator(String str, long j2, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0, (long) (list.size() - 1));
            this.f6329g = str;
            this.f6328f = j2;
            this.f6327e = list;
        }

        public long a() {
            c();
            return this.f6328f + this.f6327e.get((int) d()).f6529f;
        }

        public long b() {
            c();
            HlsMediaPlaylist.SegmentBase segmentBase = this.f6327e.get((int) d());
            return this.f6328f + segmentBase.f6529f + segmentBase.f6527d;
        }
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {

        /* renamed from: h  reason: collision with root package name */
        private int f6330h;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f6330h = p(trackGroup.a(iArr[0]));
        }

        public int a() {
            return this.f6330h;
        }

        public Object e() {
            return null;
        }

        public int m() {
            return 0;
        }

        public void q(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (o(this.f6330h, elapsedRealtime)) {
                for (int i2 = this.f7363b - 1; i2 >= 0; i2--) {
                    if (!o(i2, elapsedRealtime)) {
                        this.f6330h = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    static final class SegmentBaseHolder {

        /* renamed from: a  reason: collision with root package name */
        public final HlsMediaPlaylist.SegmentBase f6331a;

        /* renamed from: b  reason: collision with root package name */
        public final long f6332b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6333c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f6334d;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j2, int i2) {
            boolean z2;
            this.f6331a = segmentBase;
            this.f6332b = j2;
            this.f6333c = i2;
            if (!(segmentBase instanceof HlsMediaPlaylist.Part) || !((HlsMediaPlaylist.Part) segmentBase).f6519n) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f6334d = z2;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, long j2, List<Format> list, PlayerId playerId, CmcdConfiguration cmcdConfiguration) {
        this.f6302a = hlsExtractorFactory;
        this.f6308g = hlsPlaylistTracker;
        this.f6306e = uriArr;
        this.f6307f = formatArr;
        this.f6305d = timestampAdjusterProvider;
        this.f6313l = j2;
        this.f6310i = list;
        this.f6312k = playerId;
        DataSource a2 = hlsDataSourceFactory.a(1);
        this.f6303b = a2;
        if (transferListener != null) {
            a2.n(transferListener);
        }
        this.f6304c = hlsDataSourceFactory.a(3);
        this.f6309h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            if ((formatArr[i2].f4007f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        this.f6319r = new InitializationTrackSelection(this.f6309h, Ints.n(arrayList));
    }

    private void b() {
        this.f6308g.j(this.f6306e[this.f6319r.k()]);
    }

    private static Uri e(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.f6531h) == null) {
            return null;
        }
        return UriUtil.f(hlsMediaPlaylist.f6562a, str);
    }

    private Pair<Long, Integer> g(HlsMediaChunk hlsMediaChunk, boolean z2, HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3) {
        boolean z3;
        List<HlsMediaPlaylist.Part> list;
        long j4;
        long j5;
        int i2 = -1;
        if (hlsMediaChunk == null || z2) {
            long j6 = hlsMediaPlaylist.f6516u + j2;
            if (hlsMediaChunk != null && !this.f6318q) {
                j3 = hlsMediaChunk.f7223g;
            }
            if (!hlsMediaPlaylist.f6510o && j3 >= j6) {
                return new Pair<>(Long.valueOf(hlsMediaPlaylist.f6506k + ((long) hlsMediaPlaylist.f6513r.size())), -1);
            }
            long j7 = j3 - j2;
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.f6513r;
            Long valueOf = Long.valueOf(j7);
            int i3 = 0;
            if (!this.f6308g.isLive() || hlsMediaChunk == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            int f2 = Util.f(list2, valueOf, true, z3);
            long j8 = ((long) f2) + hlsMediaPlaylist.f6506k;
            if (f2 >= 0) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f6513r.get(f2);
                if (j7 < segment.f6529f + segment.f6527d) {
                    list = segment.f6524n;
                } else {
                    list = hlsMediaPlaylist.f6514s;
                }
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    HlsMediaPlaylist.Part part = list.get(i3);
                    if (j7 >= part.f6529f + part.f6527d) {
                        i3++;
                    } else if (part.f6518m) {
                        if (list == hlsMediaPlaylist.f6514s) {
                            j4 = 1;
                        } else {
                            j4 = 0;
                        }
                        j8 += j4;
                        i2 = i3;
                    }
                }
            }
            return new Pair<>(Long.valueOf(j8), Integer.valueOf(i2));
        } else if (!hlsMediaChunk.h()) {
            return new Pair<>(Long.valueOf(hlsMediaChunk.f7268j), Integer.valueOf(hlsMediaChunk.f6342o));
        } else {
            if (hlsMediaChunk.f6342o == -1) {
                j5 = hlsMediaChunk.g();
            } else {
                j5 = hlsMediaChunk.f7268j;
            }
            Long valueOf2 = Long.valueOf(j5);
            int i4 = hlsMediaChunk.f6342o;
            if (i4 != -1) {
                i2 = i4 + 1;
            }
            return new Pair<>(valueOf2, Integer.valueOf(i2));
        }
    }

    private static SegmentBaseHolder h(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f6506k);
        if (i3 == hlsMediaPlaylist.f6513r.size()) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 < hlsMediaPlaylist.f6514s.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.f6514s.get(i2), j2, i2);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f6513r.get(i3);
        if (i2 == -1) {
            return new SegmentBaseHolder(segment, j2, -1);
        }
        if (i2 < segment.f6524n.size()) {
            return new SegmentBaseHolder(segment.f6524n.get(i2), j2, i2);
        }
        int i4 = i3 + 1;
        if (i4 < hlsMediaPlaylist.f6513r.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.f6513r.get(i4), j2 + 1, -1);
        }
        if (!hlsMediaPlaylist.f6514s.isEmpty()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.f6514s.get(0), j2 + 1, 0);
        }
        return null;
    }

    static List<HlsMediaPlaylist.SegmentBase> j(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f6506k);
        if (i3 < 0 || hlsMediaPlaylist.f6513r.size() < i3) {
            return ImmutableList.r();
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        if (i3 < hlsMediaPlaylist.f6513r.size()) {
            if (i2 != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f6513r.get(i3);
                if (i2 == 0) {
                    arrayList.add(segment);
                } else if (i2 < segment.f6524n.size()) {
                    List<HlsMediaPlaylist.Part> list = segment.f6524n;
                    arrayList.addAll(list.subList(i2, list.size()));
                }
                i3++;
            }
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.f6513r;
            arrayList.addAll(list2.subList(i3, list2.size()));
            i2 = 0;
        }
        if (hlsMediaPlaylist.f6509n != -9223372036854775807L) {
            if (i2 != -1) {
                i4 = i2;
            }
            if (i4 < hlsMediaPlaylist.f6514s.size()) {
                List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist.f6514s;
                arrayList.addAll(list3.subList(i4, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Chunk n(Uri uri, int i2, boolean z2, CmcdData.Factory factory) {
        if (uri == null) {
            return null;
        }
        byte[] c2 = this.f6311j.c(uri);
        if (c2 != null) {
            this.f6311j.b(uri, c2);
            return null;
        }
        DataSpec a2 = new DataSpec.Builder().i(uri).b(1).a();
        if (factory != null) {
            if (z2) {
                factory.f(ContextChain.TAG_INFRA);
            }
            a2 = factory.a().a(a2);
        }
        return new EncryptionKeyChunk(this.f6304c, a2, this.f6307f[i2], this.f6319r.m(), this.f6319r.e(), this.f6315n);
    }

    private long u(long j2) {
        long j3 = this.f6320s;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private void y(HlsMediaPlaylist hlsMediaPlaylist) {
        long j2;
        if (hlsMediaPlaylist.f6510o) {
            j2 = -9223372036854775807L;
        } else {
            j2 = hlsMediaPlaylist.e() - this.f6308g.b();
        }
        this.f6320s = j2;
    }

    public MediaChunkIterator[] a(HlsMediaChunk hlsMediaChunk, long j2) {
        int i2;
        int i3;
        boolean z2;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        if (hlsMediaChunk2 == null) {
            i2 = -1;
        } else {
            i2 = this.f6309h.b(hlsMediaChunk2.f7220d);
        }
        int length = this.f6319r.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z3 = false;
        int i4 = 0;
        while (i4 < length) {
            int c2 = this.f6319r.c(i4);
            Uri uri = this.f6306e[c2];
            if (!this.f6308g.e(uri)) {
                mediaChunkIteratorArr[i4] = MediaChunkIterator.f7269a;
                i3 = i4;
            } else {
                HlsMediaPlaylist h2 = this.f6308g.h(uri, z3);
                Assertions.f(h2);
                long b2 = h2.f6503h - this.f6308g.b();
                if (c2 != i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i3 = i4;
                Pair<Long, Integer> g2 = g(hlsMediaChunk, z2, h2, b2, j2);
                mediaChunkIteratorArr[i3] = new HlsMediaPlaylistSegmentIterator(h2.f6562a, b2, j(h2, ((Long) g2.first).longValue(), ((Integer) g2.second).intValue()));
            }
            i4 = i3 + 1;
            z3 = false;
        }
        return mediaChunkIteratorArr;
    }

    public long c(long j2, SeekParameters seekParameters) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long j3;
        int a2 = this.f6319r.a();
        Uri[] uriArr = this.f6306e;
        if (a2 >= uriArr.length || a2 == -1) {
            hlsMediaPlaylist = null;
        } else {
            hlsMediaPlaylist = this.f6308g.h(uriArr[this.f6319r.k()], true);
        }
        if (hlsMediaPlaylist == null || hlsMediaPlaylist.f6513r.isEmpty() || !hlsMediaPlaylist.f6564c) {
            return j2;
        }
        long b2 = hlsMediaPlaylist.f6503h - this.f6308g.b();
        long j4 = j2 - b2;
        int f2 = Util.f(hlsMediaPlaylist.f6513r, Long.valueOf(j4), true, true);
        long j5 = hlsMediaPlaylist.f6513r.get(f2).f6529f;
        if (f2 != hlsMediaPlaylist.f6513r.size() - 1) {
            j3 = hlsMediaPlaylist.f6513r.get(f2 + 1).f6529f;
        } else {
            j3 = j5;
        }
        return seekParameters.a(j4, j5, j3) + b2;
    }

    public int d(HlsMediaChunk hlsMediaChunk) {
        List<HlsMediaPlaylist.Part> list;
        if (hlsMediaChunk.f6342o == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.f(this.f6308g.h(this.f6306e[this.f6309h.b(hlsMediaChunk.f7220d)], false));
        int i2 = (int) (hlsMediaChunk.f7268j - hlsMediaPlaylist.f6506k);
        if (i2 < 0) {
            return 1;
        }
        if (i2 < hlsMediaPlaylist.f6513r.size()) {
            list = hlsMediaPlaylist.f6513r.get(i2).f6524n;
        } else {
            list = hlsMediaPlaylist.f6514s;
        }
        if (hlsMediaChunk.f6342o >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.f6342o);
        if (part.f6519n) {
            return 0;
        }
        if (Util.c(Uri.parse(UriUtil.e(hlsMediaPlaylist.f6562a, part.f6525b)), hlsMediaChunk.f7218b.f4823a)) {
            return 1;
        }
        return 2;
    }

    public void f(LoadingInfo loadingInfo, long j2, List<HlsMediaChunk> list, boolean z2, HlsChunkHolder hlsChunkHolder) {
        int i2;
        LoadingInfo loadingInfo2;
        long j3;
        Uri uri;
        HlsMediaPlaylist hlsMediaPlaylist;
        long j4 = j2;
        HlsChunkHolder hlsChunkHolder2 = hlsChunkHolder;
        HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : (HlsMediaChunk) Iterables.d(list);
        if (hlsMediaChunk == null) {
            loadingInfo2 = loadingInfo;
            i2 = -1;
        } else {
            i2 = this.f6309h.b(hlsMediaChunk.f7220d);
            loadingInfo2 = loadingInfo;
        }
        long j5 = loadingInfo2.f5395a;
        long j6 = j4 - j5;
        long u2 = u(j5);
        if (hlsMediaChunk != null && !this.f6318q) {
            long d2 = hlsMediaChunk.d();
            j6 = Math.max(0, j6 - d2);
            if (u2 != -9223372036854775807L) {
                u2 = Math.max(0, u2 - d2);
            }
        }
        this.f6319r.q(j5, j6, u2, list, a(hlsMediaChunk, j4));
        int k2 = this.f6319r.k();
        boolean z3 = i2 != k2;
        Uri uri2 = this.f6306e[k2];
        if (!this.f6308g.e(uri2)) {
            hlsChunkHolder2.f6326c = uri2;
            this.f6321t &= uri2.equals(this.f6317p);
            this.f6317p = uri2;
            return;
        }
        HlsMediaPlaylist h2 = this.f6308g.h(uri2, true);
        Assertions.f(h2);
        this.f6318q = h2.f6564c;
        y(h2);
        long b2 = h2.f6503h - this.f6308g.b();
        HlsMediaPlaylist hlsMediaPlaylist2 = h2;
        Uri uri3 = uri2;
        Pair<Long, Integer> g2 = g(hlsMediaChunk, z3, h2, b2, j2);
        long longValue = ((Long) g2.first).longValue();
        int intValue = ((Integer) g2.second).intValue();
        if (longValue >= hlsMediaPlaylist2.f6506k || hlsMediaChunk == null || !z3) {
            hlsMediaPlaylist = hlsMediaPlaylist2;
            j3 = b2;
            uri = uri3;
        } else {
            uri = this.f6306e[i2];
            HlsMediaPlaylist h3 = this.f6308g.h(uri, true);
            Assertions.f(h3);
            j3 = h3.f6503h - this.f6308g.b();
            Pair<Long, Integer> g3 = g(hlsMediaChunk, false, h3, j3, j2);
            longValue = ((Long) g3.first).longValue();
            intValue = ((Integer) g3.second).intValue();
            hlsMediaPlaylist = h3;
            k2 = i2;
        }
        if (!(k2 == i2 || i2 == -1)) {
            this.f6308g.j(this.f6306e[i2]);
        }
        if (longValue < hlsMediaPlaylist.f6506k) {
            this.f6316o = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder h4 = h(hlsMediaPlaylist, longValue, intValue);
        if (h4 == null) {
            if (!hlsMediaPlaylist.f6510o) {
                hlsChunkHolder2.f6326c = uri;
                this.f6321t &= uri.equals(this.f6317p);
                this.f6317p = uri;
                return;
            } else if (z2 || hlsMediaPlaylist.f6513r.isEmpty()) {
                hlsChunkHolder2.f6325b = true;
                return;
            } else {
                h4 = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) Iterables.d(hlsMediaPlaylist.f6513r), (hlsMediaPlaylist.f6506k + ((long) hlsMediaPlaylist.f6513r.size())) - 1, -1);
            }
        }
        this.f6321t = false;
        this.f6317p = null;
        this.f6322u = SystemClock.elapsedRealtime();
        Uri e2 = e(hlsMediaPlaylist, h4.f6331a.f6526c);
        Chunk n2 = n(e2, k2, true, (CmcdData.Factory) null);
        hlsChunkHolder2.f6324a = n2;
        if (n2 == null) {
            Uri e3 = e(hlsMediaPlaylist, h4.f6331a);
            Chunk n3 = n(e3, k2, false, (CmcdData.Factory) null);
            hlsChunkHolder2.f6324a = n3;
            if (n3 == null) {
                boolean w2 = HlsMediaChunk.w(hlsMediaChunk, uri, hlsMediaPlaylist, h4, j3);
                if (!w2 || !h4.f6334d) {
                    hlsChunkHolder2.f6324a = HlsMediaChunk.j(this.f6302a, this.f6303b, this.f6307f[k2], j3, hlsMediaPlaylist, h4, uri, this.f6310i, this.f6319r.m(), this.f6319r.e(), this.f6314m, this.f6305d, this.f6313l, hlsMediaChunk, this.f6311j.a(e3), this.f6311j.a(e2), w2, this.f6312k, (CmcdData.Factory) null);
                }
            }
        }
    }

    public int i(long j2, List<? extends MediaChunk> list) {
        if (this.f6316o != null || this.f6319r.length() < 2) {
            return list.size();
        }
        return this.f6319r.j(j2, list);
    }

    public TrackGroup k() {
        return this.f6309h;
    }

    public ExoTrackSelection l() {
        return this.f6319r;
    }

    public boolean m() {
        return this.f6318q;
    }

    public boolean o(Chunk chunk, long j2) {
        ExoTrackSelection exoTrackSelection = this.f6319r;
        return exoTrackSelection.r(exoTrackSelection.g(this.f6309h.b(chunk.f7220d)), j2);
    }

    public void p() throws IOException {
        IOException iOException = this.f6316o;
        if (iOException == null) {
            Uri uri = this.f6317p;
            if (uri != null && this.f6321t) {
                this.f6308g.a(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean q(Uri uri) {
        return Util.s(this.f6306e, uri);
    }

    public void r(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.f6315n = encryptionKeyChunk.h();
            this.f6311j.b(encryptionKeyChunk.f7218b.f4823a, (byte[]) Assertions.f(encryptionKeyChunk.j()));
        }
    }

    public boolean s(Uri uri, long j2) {
        int g2;
        int i2 = 0;
        while (true) {
            Uri[] uriArr = this.f6306e;
            if (i2 >= uriArr.length) {
                i2 = -1;
                break;
            } else if (uriArr[i2].equals(uri)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || (g2 = this.f6319r.g(i2)) == -1) {
            return true;
        }
        this.f6321t |= uri.equals(this.f6317p);
        if (j2 == -9223372036854775807L || (this.f6319r.r(g2, j2) && this.f6308g.f(uri, j2))) {
            return true;
        }
        return false;
    }

    public void t() {
        b();
        this.f6316o = null;
    }

    public void v(boolean z2) {
        this.f6314m = z2;
    }

    public void w(ExoTrackSelection exoTrackSelection) {
        b();
        this.f6319r = exoTrackSelection;
    }

    public boolean x(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f6316o != null) {
            return false;
        }
        return this.f6319r.s(j2, chunk, list);
    }
}

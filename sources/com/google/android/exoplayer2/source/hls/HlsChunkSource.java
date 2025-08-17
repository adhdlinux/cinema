package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
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
    private final HlsExtractorFactory f26393a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f26394b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f26395c;

    /* renamed from: d  reason: collision with root package name */
    private final TimestampAdjusterProvider f26396d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f26397e;

    /* renamed from: f  reason: collision with root package name */
    private final Format[] f26398f;

    /* renamed from: g  reason: collision with root package name */
    private final HlsPlaylistTracker f26399g;

    /* renamed from: h  reason: collision with root package name */
    private final TrackGroup f26400h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Format> f26401i;

    /* renamed from: j  reason: collision with root package name */
    private final FullSegmentEncryptionKeyCache f26402j = new FullSegmentEncryptionKeyCache(4);

    /* renamed from: k  reason: collision with root package name */
    private final PlayerId f26403k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f26404l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f26405m = Util.f28813f;

    /* renamed from: n  reason: collision with root package name */
    private IOException f26406n;

    /* renamed from: o  reason: collision with root package name */
    private Uri f26407o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f26408p;

    /* renamed from: q  reason: collision with root package name */
    private ExoTrackSelection f26409q;

    /* renamed from: r  reason: collision with root package name */
    private long f26410r = -9223372036854775807L;

    /* renamed from: s  reason: collision with root package name */
    private boolean f26411s;

    private static final class EncryptionKeyChunk extends DataChunk {

        /* renamed from: l  reason: collision with root package name */
        private byte[] f26412l;

        public EncryptionKeyChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i2, Object obj, byte[] bArr) {
            super(dataSource, dataSpec, 3, format, i2, obj, bArr);
        }

        /* access modifiers changed from: protected */
        public void g(byte[] bArr, int i2) {
            this.f26412l = Arrays.copyOf(bArr, i2);
        }

        public byte[] j() {
            return this.f26412l;
        }
    }

    public static final class HlsChunkHolder {

        /* renamed from: a  reason: collision with root package name */
        public Chunk f26413a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f26414b;

        /* renamed from: c  reason: collision with root package name */
        public Uri f26415c;

        public HlsChunkHolder() {
            a();
        }

        public void a() {
            this.f26413a = null;
            this.f26414b = false;
            this.f26415c = null;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final List<HlsMediaPlaylist.SegmentBase> f26416e;

        /* renamed from: f  reason: collision with root package name */
        private final long f26417f;

        /* renamed from: g  reason: collision with root package name */
        private final String f26418g;

        public HlsMediaPlaylistSegmentIterator(String str, long j2, List<HlsMediaPlaylist.SegmentBase> list) {
            super(0, (long) (list.size() - 1));
            this.f26418g = str;
            this.f26417f = j2;
            this.f26416e = list;
        }

        public long a() {
            c();
            return this.f26417f + this.f26416e.get((int) d()).f26612f;
        }

        public long b() {
            c();
            HlsMediaPlaylist.SegmentBase segmentBase = this.f26416e.get((int) d());
            return this.f26417f + segmentBase.f26612f + segmentBase.f26610d;
        }
    }

    private static final class InitializationTrackSelection extends BaseTrackSelection {

        /* renamed from: h  reason: collision with root package name */
        private int f26419h;

        public InitializationTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f26419h = r(trackGroup.c(iArr[0]));
        }

        public int a() {
            return this.f26419h;
        }

        public Object e() {
            return null;
        }

        public int m() {
            return 0;
        }

        public void s(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (p(this.f26419h, elapsedRealtime)) {
                for (int i2 = this.f27650b - 1; i2 >= 0; i2--) {
                    if (!p(i2, elapsedRealtime)) {
                        this.f26419h = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }
    }

    static final class SegmentBaseHolder {

        /* renamed from: a  reason: collision with root package name */
        public final HlsMediaPlaylist.SegmentBase f26420a;

        /* renamed from: b  reason: collision with root package name */
        public final long f26421b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26422c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f26423d;

        public SegmentBaseHolder(HlsMediaPlaylist.SegmentBase segmentBase, long j2, int i2) {
            boolean z2;
            this.f26420a = segmentBase;
            this.f26421b = j2;
            this.f26422c = i2;
            if (!(segmentBase instanceof HlsMediaPlaylist.Part) || !((HlsMediaPlaylist.Part) segmentBase).f26602n) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f26423d = z2;
        }
    }

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, HlsDataSourceFactory hlsDataSourceFactory, TransferListener transferListener, TimestampAdjusterProvider timestampAdjusterProvider, List<Format> list, PlayerId playerId) {
        this.f26393a = hlsExtractorFactory;
        this.f26399g = hlsPlaylistTracker;
        this.f26397e = uriArr;
        this.f26398f = formatArr;
        this.f26396d = timestampAdjusterProvider;
        this.f26401i = list;
        this.f26403k = playerId;
        DataSource a2 = hlsDataSourceFactory.a(1);
        this.f26394b = a2;
        if (transferListener != null) {
            a2.p(transferListener);
        }
        this.f26395c = hlsDataSourceFactory.a(3);
        this.f26400h = new TrackGroup(formatArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            if ((formatArr[i2].f23064f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        this.f26409q = new InitializationTrackSelection(this.f26400h, Ints.n(arrayList));
    }

    private static Uri d(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist.SegmentBase segmentBase) {
        String str;
        if (segmentBase == null || (str = segmentBase.f26614h) == null) {
            return null;
        }
        return UriUtil.e(hlsMediaPlaylist.f26645a, str);
    }

    private Pair<Long, Integer> f(HlsMediaChunk hlsMediaChunk, boolean z2, HlsMediaPlaylist hlsMediaPlaylist, long j2, long j3) {
        boolean z3;
        List<HlsMediaPlaylist.Part> list;
        long j4;
        long j5;
        int i2 = -1;
        if (hlsMediaChunk == null || z2) {
            long j6 = hlsMediaPlaylist.f26599u + j2;
            if (hlsMediaChunk != null && !this.f26408p) {
                j3 = hlsMediaChunk.f26084g;
            }
            if (!hlsMediaPlaylist.f26593o && j3 >= j6) {
                return new Pair<>(Long.valueOf(hlsMediaPlaylist.f26589k + ((long) hlsMediaPlaylist.f26596r.size())), -1);
            }
            long j7 = j3 - j2;
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.f26596r;
            Long valueOf = Long.valueOf(j7);
            int i3 = 0;
            if (!this.f26399g.isLive() || hlsMediaChunk == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            int g2 = Util.g(list2, valueOf, true, z3);
            long j8 = ((long) g2) + hlsMediaPlaylist.f26589k;
            if (g2 >= 0) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f26596r.get(g2);
                if (j7 < segment.f26612f + segment.f26610d) {
                    list = segment.f26607n;
                } else {
                    list = hlsMediaPlaylist.f26597s;
                }
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    HlsMediaPlaylist.Part part = list.get(i3);
                    if (j7 >= part.f26612f + part.f26610d) {
                        i3++;
                    } else if (part.f26601m) {
                        if (list == hlsMediaPlaylist.f26597s) {
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
            return new Pair<>(Long.valueOf(hlsMediaChunk.f26129j), Integer.valueOf(hlsMediaChunk.f26432o));
        } else {
            if (hlsMediaChunk.f26432o == -1) {
                j5 = hlsMediaChunk.g();
            } else {
                j5 = hlsMediaChunk.f26129j;
            }
            Long valueOf2 = Long.valueOf(j5);
            int i4 = hlsMediaChunk.f26432o;
            if (i4 != -1) {
                i2 = i4 + 1;
            }
            return new Pair<>(valueOf2, Integer.valueOf(i2));
        }
    }

    private static SegmentBaseHolder g(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f26589k);
        if (i3 == hlsMediaPlaylist.f26596r.size()) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 < hlsMediaPlaylist.f26597s.size()) {
                return new SegmentBaseHolder(hlsMediaPlaylist.f26597s.get(i2), j2, i2);
            }
            return null;
        }
        HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f26596r.get(i3);
        if (i2 == -1) {
            return new SegmentBaseHolder(segment, j2, -1);
        }
        if (i2 < segment.f26607n.size()) {
            return new SegmentBaseHolder(segment.f26607n.get(i2), j2, i2);
        }
        int i4 = i3 + 1;
        if (i4 < hlsMediaPlaylist.f26596r.size()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.f26596r.get(i4), j2 + 1, -1);
        }
        if (!hlsMediaPlaylist.f26597s.isEmpty()) {
            return new SegmentBaseHolder(hlsMediaPlaylist.f26597s.get(0), j2 + 1, 0);
        }
        return null;
    }

    static List<HlsMediaPlaylist.SegmentBase> i(HlsMediaPlaylist hlsMediaPlaylist, long j2, int i2) {
        int i3 = (int) (j2 - hlsMediaPlaylist.f26589k);
        if (i3 < 0 || hlsMediaPlaylist.f26596r.size() < i3) {
            return ImmutableList.r();
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        if (i3 < hlsMediaPlaylist.f26596r.size()) {
            if (i2 != -1) {
                HlsMediaPlaylist.Segment segment = hlsMediaPlaylist.f26596r.get(i3);
                if (i2 == 0) {
                    arrayList.add(segment);
                } else if (i2 < segment.f26607n.size()) {
                    List<HlsMediaPlaylist.Part> list = segment.f26607n;
                    arrayList.addAll(list.subList(i2, list.size()));
                }
                i3++;
            }
            List<HlsMediaPlaylist.Segment> list2 = hlsMediaPlaylist.f26596r;
            arrayList.addAll(list2.subList(i3, list2.size()));
            i2 = 0;
        }
        if (hlsMediaPlaylist.f26592n != -9223372036854775807L) {
            if (i2 != -1) {
                i4 = i2;
            }
            if (i4 < hlsMediaPlaylist.f26597s.size()) {
                List<HlsMediaPlaylist.Part> list3 = hlsMediaPlaylist.f26597s;
                arrayList.addAll(list3.subList(i4, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Chunk l(Uri uri, int i2) {
        if (uri == null) {
            return null;
        }
        byte[] c2 = this.f26402j.c(uri);
        if (c2 != null) {
            this.f26402j.b(uri, c2);
            return null;
        }
        return new EncryptionKeyChunk(this.f26395c, new DataSpec.Builder().i(uri).b(1).a(), this.f26398f[i2], this.f26409q.m(), this.f26409q.e(), this.f26405m);
    }

    private long s(long j2) {
        long j3 = this.f26410r;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private void w(HlsMediaPlaylist hlsMediaPlaylist) {
        long j2;
        if (hlsMediaPlaylist.f26593o) {
            j2 = -9223372036854775807L;
        } else {
            j2 = hlsMediaPlaylist.e() - this.f26399g.b();
        }
        this.f26410r = j2;
    }

    public MediaChunkIterator[] a(HlsMediaChunk hlsMediaChunk, long j2) {
        int i2;
        int i3;
        boolean z2;
        HlsMediaChunk hlsMediaChunk2 = hlsMediaChunk;
        if (hlsMediaChunk2 == null) {
            i2 = -1;
        } else {
            i2 = this.f26400h.d(hlsMediaChunk2.f26081d);
        }
        int length = this.f26409q.length();
        MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
        boolean z3 = false;
        int i4 = 0;
        while (i4 < length) {
            int c2 = this.f26409q.c(i4);
            Uri uri = this.f26397e[c2];
            if (!this.f26399g.e(uri)) {
                mediaChunkIteratorArr[i4] = MediaChunkIterator.f26130a;
                i3 = i4;
            } else {
                HlsMediaPlaylist h2 = this.f26399g.h(uri, z3);
                Assertions.e(h2);
                long b2 = h2.f26586h - this.f26399g.b();
                if (c2 != i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                i3 = i4;
                Pair<Long, Integer> f2 = f(hlsMediaChunk, z2, h2, b2, j2);
                mediaChunkIteratorArr[i3] = new HlsMediaPlaylistSegmentIterator(h2.f26645a, b2, i(h2, ((Long) f2.first).longValue(), ((Integer) f2.second).intValue()));
            }
            i4 = i3 + 1;
            z3 = false;
        }
        return mediaChunkIteratorArr;
    }

    public long b(long j2, SeekParameters seekParameters) {
        HlsMediaPlaylist hlsMediaPlaylist;
        long j3;
        int a2 = this.f26409q.a();
        Uri[] uriArr = this.f26397e;
        if (a2 >= uriArr.length || a2 == -1) {
            hlsMediaPlaylist = null;
        } else {
            hlsMediaPlaylist = this.f26399g.h(uriArr[this.f26409q.k()], true);
        }
        if (hlsMediaPlaylist == null || hlsMediaPlaylist.f26596r.isEmpty() || !hlsMediaPlaylist.f26647c) {
            return j2;
        }
        long b2 = hlsMediaPlaylist.f26586h - this.f26399g.b();
        long j4 = j2 - b2;
        int g2 = Util.g(hlsMediaPlaylist.f26596r, Long.valueOf(j4), true, true);
        long j5 = hlsMediaPlaylist.f26596r.get(g2).f26612f;
        if (g2 != hlsMediaPlaylist.f26596r.size() - 1) {
            j3 = hlsMediaPlaylist.f26596r.get(g2 + 1).f26612f;
        } else {
            j3 = j5;
        }
        return seekParameters.a(j4, j5, j3) + b2;
    }

    public int c(HlsMediaChunk hlsMediaChunk) {
        List<HlsMediaPlaylist.Part> list;
        if (hlsMediaChunk.f26432o == -1) {
            return 1;
        }
        HlsMediaPlaylist hlsMediaPlaylist = (HlsMediaPlaylist) Assertions.e(this.f26399g.h(this.f26397e[this.f26400h.d(hlsMediaChunk.f26081d)], false));
        int i2 = (int) (hlsMediaChunk.f26129j - hlsMediaPlaylist.f26589k);
        if (i2 < 0) {
            return 1;
        }
        if (i2 < hlsMediaPlaylist.f26596r.size()) {
            list = hlsMediaPlaylist.f26596r.get(i2).f26607n;
        } else {
            list = hlsMediaPlaylist.f26597s;
        }
        if (hlsMediaChunk.f26432o >= list.size()) {
            return 2;
        }
        HlsMediaPlaylist.Part part = list.get(hlsMediaChunk.f26432o);
        if (part.f26602n) {
            return 0;
        }
        if (Util.c(Uri.parse(UriUtil.d(hlsMediaPlaylist.f26645a, part.f26608b)), hlsMediaChunk.f26079b.f28339a)) {
            return 1;
        }
        return 2;
    }

    public void e(long j2, long j3, List<HlsMediaChunk> list, boolean z2, HlsChunkHolder hlsChunkHolder) {
        int i2;
        long j4;
        Uri uri;
        HlsMediaPlaylist hlsMediaPlaylist;
        int i3;
        long j5 = j3;
        HlsChunkHolder hlsChunkHolder2 = hlsChunkHolder;
        HlsMediaChunk hlsMediaChunk = list.isEmpty() ? null : (HlsMediaChunk) Iterables.d(list);
        if (hlsMediaChunk == null) {
            i2 = -1;
        } else {
            i2 = this.f26400h.d(hlsMediaChunk.f26081d);
        }
        long j6 = j5 - j2;
        long s2 = s(j2);
        if (hlsMediaChunk != null && !this.f26408p) {
            long d2 = hlsMediaChunk.d();
            j6 = Math.max(0, j6 - d2);
            if (s2 != -9223372036854775807L) {
                s2 = Math.max(0, s2 - d2);
            }
        }
        this.f26409q.s(j2, j6, s2, list, a(hlsMediaChunk, j5));
        int k2 = this.f26409q.k();
        boolean z3 = i2 != k2;
        Uri uri2 = this.f26397e[k2];
        if (!this.f26399g.e(uri2)) {
            hlsChunkHolder2.f26415c = uri2;
            this.f26411s &= uri2.equals(this.f26407o);
            this.f26407o = uri2;
            return;
        }
        HlsMediaPlaylist h2 = this.f26399g.h(uri2, true);
        Assertions.e(h2);
        this.f26408p = h2.f26647c;
        w(h2);
        long b2 = h2.f26586h - this.f26399g.b();
        HlsMediaPlaylist hlsMediaPlaylist2 = h2;
        Uri uri3 = uri2;
        int i4 = k2;
        Pair<Long, Integer> f2 = f(hlsMediaChunk, z3, h2, b2, j3);
        long longValue = ((Long) f2.first).longValue();
        int intValue = ((Integer) f2.second).intValue();
        if (longValue >= h2.f26589k || hlsMediaChunk == null || !z3) {
            hlsMediaPlaylist = h2;
            j4 = b2;
            uri = uri3;
            i3 = i4;
        } else {
            Uri uri4 = this.f26397e[i2];
            HlsMediaPlaylist h3 = this.f26399g.h(uri4, true);
            Assertions.e(h3);
            j4 = h3.f26586h - this.f26399g.b();
            Pair<Long, Integer> f3 = f(hlsMediaChunk, false, h3, j4, j3);
            longValue = ((Long) f3.first).longValue();
            intValue = ((Integer) f3.second).intValue();
            i3 = i2;
            uri = uri4;
            hlsMediaPlaylist = h3;
        }
        if (longValue < hlsMediaPlaylist.f26589k) {
            this.f26406n = new BehindLiveWindowException();
            return;
        }
        SegmentBaseHolder g2 = g(hlsMediaPlaylist, longValue, intValue);
        if (g2 == null) {
            if (!hlsMediaPlaylist.f26593o) {
                hlsChunkHolder2.f26415c = uri;
                this.f26411s &= uri.equals(this.f26407o);
                this.f26407o = uri;
                return;
            } else if (z2 || hlsMediaPlaylist.f26596r.isEmpty()) {
                hlsChunkHolder2.f26414b = true;
                return;
            } else {
                g2 = new SegmentBaseHolder((HlsMediaPlaylist.SegmentBase) Iterables.d(hlsMediaPlaylist.f26596r), (hlsMediaPlaylist.f26589k + ((long) hlsMediaPlaylist.f26596r.size())) - 1, -1);
            }
        }
        this.f26411s = false;
        this.f26407o = null;
        Uri d3 = d(hlsMediaPlaylist, g2.f26420a.f26609c);
        Chunk l2 = l(d3, i3);
        hlsChunkHolder2.f26413a = l2;
        if (l2 == null) {
            Uri d4 = d(hlsMediaPlaylist, g2.f26420a);
            Chunk l3 = l(d4, i3);
            hlsChunkHolder2.f26413a = l3;
            if (l3 == null) {
                boolean w2 = HlsMediaChunk.w(hlsMediaChunk, uri, hlsMediaPlaylist, g2, j4);
                if (!w2 || !g2.f26423d) {
                    hlsChunkHolder2.f26413a = HlsMediaChunk.j(this.f26393a, this.f26394b, this.f26398f[i3], j4, hlsMediaPlaylist, g2, uri, this.f26401i, this.f26409q.m(), this.f26409q.e(), this.f26404l, this.f26396d, hlsMediaChunk, this.f26402j.a(d4), this.f26402j.a(d3), w2, this.f26403k);
                }
            }
        }
    }

    public int h(long j2, List<? extends MediaChunk> list) {
        if (this.f26406n != null || this.f26409q.length() < 2) {
            return list.size();
        }
        return this.f26409q.j(j2, list);
    }

    public TrackGroup j() {
        return this.f26400h;
    }

    public ExoTrackSelection k() {
        return this.f26409q;
    }

    public boolean m(Chunk chunk, long j2) {
        ExoTrackSelection exoTrackSelection = this.f26409q;
        return exoTrackSelection.o(exoTrackSelection.g(this.f26400h.d(chunk.f26081d)), j2);
    }

    public void n() throws IOException {
        IOException iOException = this.f26406n;
        if (iOException == null) {
            Uri uri = this.f26407o;
            if (uri != null && this.f26411s) {
                this.f26399g.a(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    public boolean o(Uri uri) {
        return Util.s(this.f26397e, uri);
    }

    public void p(Chunk chunk) {
        if (chunk instanceof EncryptionKeyChunk) {
            EncryptionKeyChunk encryptionKeyChunk = (EncryptionKeyChunk) chunk;
            this.f26405m = encryptionKeyChunk.h();
            this.f26402j.b(encryptionKeyChunk.f26079b.f28339a, (byte[]) Assertions.e(encryptionKeyChunk.j()));
        }
    }

    public boolean q(Uri uri, long j2) {
        int g2;
        int i2 = 0;
        while (true) {
            Uri[] uriArr = this.f26397e;
            if (i2 >= uriArr.length) {
                i2 = -1;
                break;
            } else if (uriArr[i2].equals(uri)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || (g2 = this.f26409q.g(i2)) == -1) {
            return true;
        }
        this.f26411s |= uri.equals(this.f26407o);
        if (j2 == -9223372036854775807L || (this.f26409q.o(g2, j2) && this.f26399g.f(uri, j2))) {
            return true;
        }
        return false;
    }

    public void r() {
        this.f26406n = null;
    }

    public void t(boolean z2) {
        this.f26404l = z2;
    }

    public void u(ExoTrackSelection exoTrackSelection) {
        this.f26409q = exoTrackSelection;
    }

    public boolean v(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f26406n != null) {
            return false;
        }
        return this.f26409q.q(j2, chunk, list);
    }
}

package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Descriptor;
import com.google.android.exoplayer2.source.dash.manifest.EventStream;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f26141z = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: b  reason: collision with root package name */
    final int f26142b;

    /* renamed from: c  reason: collision with root package name */
    private final DashChunkSource.Factory f26143c;

    /* renamed from: d  reason: collision with root package name */
    private final TransferListener f26144d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionManager f26145e;

    /* renamed from: f  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f26146f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseUrlExclusionList f26147g;

    /* renamed from: h  reason: collision with root package name */
    private final long f26148h;

    /* renamed from: i  reason: collision with root package name */
    private final LoaderErrorThrower f26149i;

    /* renamed from: j  reason: collision with root package name */
    private final Allocator f26150j;

    /* renamed from: k  reason: collision with root package name */
    private final TrackGroupArray f26151k;

    /* renamed from: l  reason: collision with root package name */
    private final TrackGroupInfo[] f26152l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f26153m;

    /* renamed from: n  reason: collision with root package name */
    private final PlayerEmsgHandler f26154n;

    /* renamed from: o  reason: collision with root package name */
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> f26155o = new IdentityHashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f26156p;

    /* renamed from: q  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f26157q;

    /* renamed from: r  reason: collision with root package name */
    private final PlayerId f26158r;

    /* renamed from: s  reason: collision with root package name */
    private MediaPeriod.Callback f26159s;

    /* renamed from: t  reason: collision with root package name */
    private ChunkSampleStream<DashChunkSource>[] f26160t = F(0);

    /* renamed from: u  reason: collision with root package name */
    private EventSampleStream[] f26161u = new EventSampleStream[0];

    /* renamed from: v  reason: collision with root package name */
    private SequenceableLoader f26162v;

    /* renamed from: w  reason: collision with root package name */
    private DashManifest f26163w;

    /* renamed from: x  reason: collision with root package name */
    private int f26164x;

    /* renamed from: y  reason: collision with root package name */
    private List<EventStream> f26165y;

    private static final class TrackGroupInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f26166a;

        /* renamed from: b  reason: collision with root package name */
        public final int f26167b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26168c;

        /* renamed from: d  reason: collision with root package name */
        public final int f26169d;

        /* renamed from: e  reason: collision with root package name */
        public final int f26170e;

        /* renamed from: f  reason: collision with root package name */
        public final int f26171f;

        /* renamed from: g  reason: collision with root package name */
        public final int f26172g;

        private TrackGroupInfo(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
            this.f26167b = i2;
            this.f26166a = iArr;
            this.f26168c = i3;
            this.f26170e = i4;
            this.f26171f = i5;
            this.f26172g = i6;
            this.f26169d = i7;
        }

        public static TrackGroupInfo a(int[] iArr, int i2) {
            return new TrackGroupInfo(3, 1, iArr, i2, -1, -1, -1);
        }

        public static TrackGroupInfo b(int[] iArr, int i2) {
            return new TrackGroupInfo(5, 1, iArr, i2, -1, -1, -1);
        }

        public static TrackGroupInfo c(int i2) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i2);
        }

        public static TrackGroupInfo d(int i2, int[] iArr, int i3, int i4, int i5) {
            return new TrackGroupInfo(i2, 0, iArr, i3, i4, i5, -1);
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i3, DashChunkSource.Factory factory, TransferListener transferListener, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId) {
        Allocator allocator2 = allocator;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory2 = compositeSequenceableLoaderFactory;
        this.f26142b = i2;
        this.f26163w = dashManifest;
        this.f26147g = baseUrlExclusionList;
        this.f26164x = i3;
        this.f26143c = factory;
        this.f26144d = transferListener;
        this.f26145e = drmSessionManager;
        this.f26157q = eventDispatcher;
        this.f26146f = loadErrorHandlingPolicy;
        this.f26156p = eventDispatcher2;
        this.f26148h = j2;
        this.f26149i = loaderErrorThrower;
        this.f26150j = allocator2;
        this.f26153m = compositeSequenceableLoaderFactory2;
        this.f26158r = playerId;
        this.f26154n = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator2);
        this.f26162v = compositeSequenceableLoaderFactory2.a(this.f26160t);
        Period d2 = dashManifest.d(i3);
        List<EventStream> list = d2.f26316d;
        this.f26165y = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> v2 = v(drmSessionManager, d2.f26315c, list);
        this.f26151k = (TrackGroupArray) v2.first;
        this.f26152l = (TrackGroupInfo[]) v2.second;
    }

    private static int[][] A(List<AdaptationSet> list) {
        int i2;
        Descriptor w2;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i3 = 0; i3 < size; i3++) {
            sparseIntArray.put(list.get(i3).f26268a, i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i3));
            arrayList.add(arrayList2);
            sparseArray.put(i3, arrayList2);
        }
        for (int i4 = 0; i4 < size; i4++) {
            AdaptationSet adaptationSet = list.get(i4);
            Descriptor y2 = y(adaptationSet.f26272e);
            if (y2 == null) {
                y2 = y(adaptationSet.f26273f);
            }
            if (y2 == null || (i2 = sparseIntArray.get(Integer.parseInt(y2.f26306b), -1)) == -1) {
                i2 = i4;
            }
            if (i2 == i4 && (w2 = w(adaptationSet.f26273f)) != null) {
                for (String parseInt : Util.W0(w2.f26306b, ",")) {
                    int i5 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                    if (i5 != -1) {
                        i2 = Math.min(i2, i5);
                    }
                }
            }
            if (i2 != i4) {
                List list2 = (List) sparseArray.get(i4);
                List list3 = (List) sparseArray.get(i2);
                list3.addAll(list2);
                sparseArray.put(i4, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i6 = 0; i6 < size2; i6++) {
            int[] n2 = Ints.n((Collection) arrayList.get(i6));
            iArr[i6] = n2;
            Arrays.sort(n2);
        }
        return iArr;
    }

    private int B(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.f26152l[i3].f26170e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.f26152l[i6].f26168c == 0) {
                return i5;
            }
        }
        return -1;
    }

    private int[] C(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                iArr[i2] = this.f26151k.c(exoTrackSelection.h());
            } else {
                iArr[i2] = -1;
            }
        }
        return iArr;
    }

    private static boolean D(List<AdaptationSet> list, int[] iArr) {
        for (int i2 : iArr) {
            List<Representation> list2 = list.get(i2).f26270c;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (!list2.get(i3).f26331e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int E(int i2, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (D(list, iArr[i4])) {
                zArr[i4] = true;
                i3++;
            }
            Format[] z2 = z(list, iArr[i4]);
            formatArr[i4] = z2;
            if (z2.length != 0) {
                i3++;
            }
        }
        return i3;
    }

    private static ChunkSampleStream<DashChunkSource>[] F(int i2) {
        return new ChunkSampleStream[i2];
    }

    private static Format[] H(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.f26306b;
        if (str == null) {
            return new Format[]{format};
        }
        String[] W0 = Util.W0(str, ";");
        Format[] formatArr = new Format[W0.length];
        for (int i2 = 0; i2 < W0.length; i2++) {
            Matcher matcher = pattern.matcher(W0[i2]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            Format.Builder b2 = format.b();
            formatArr[i2] = b2.U(format.f23060b + ":" + parseInt).H(parseInt).X(matcher.group(2)).G();
        }
        return formatArr;
    }

    private void J(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (exoTrackSelectionArr[i2] == null || !zArr[i2]) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream instanceof ChunkSampleStream) {
                    chunkSampleStream.P(this);
                } else if (chunkSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) chunkSampleStream).c();
                }
                sampleStreamArr[i2] = null;
            }
        }
    }

    private void K(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z2;
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int B = B(i2, iArr);
                if (B == -1) {
                    z2 = sampleStreamArr[i2] instanceof EmptySampleStream;
                } else {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = sampleStreamArr[i2];
                    if (!(embeddedSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) || embeddedSampleStream.f26112b != sampleStreamArr[B]) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                }
                if (!z2) {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream2 = sampleStreamArr[i2];
                    if (embeddedSampleStream2 instanceof ChunkSampleStream.EmbeddedSampleStream) {
                        embeddedSampleStream2.c();
                    }
                    sampleStreamArr[i2] = null;
                }
            }
        }
    }

    private void L(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream == null) {
                    zArr[i2] = true;
                    TrackGroupInfo trackGroupInfo = this.f26152l[iArr[i2]];
                    int i3 = trackGroupInfo.f26168c;
                    if (i3 == 0) {
                        sampleStreamArr[i2] = u(trackGroupInfo, exoTrackSelection, j2);
                    } else if (i3 == 2) {
                        sampleStreamArr[i2] = new EventSampleStream(this.f26165y.get(trackGroupInfo.f26169d), exoTrackSelection.h().c(0), this.f26163w.f26281d);
                    }
                } else if (chunkSampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) chunkSampleStream.D()).b(exoTrackSelection);
                }
            }
        }
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            if (sampleStreamArr[i4] == null && exoTrackSelectionArr[i4] != null) {
                TrackGroupInfo trackGroupInfo2 = this.f26152l[iArr[i4]];
                if (trackGroupInfo2.f26168c == 1) {
                    int B = B(i4, iArr);
                    if (B == -1) {
                        sampleStreamArr[i4] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i4] = sampleStreamArr[B].S(j2, trackGroupInfo2.f26167b);
                    }
                }
            }
        }
    }

    private static void q(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i2) {
        int i3 = 0;
        while (i3 < list.size()) {
            EventStream eventStream = list.get(i3);
            Format G = new Format.Builder().U(eventStream.a()).g0("application/x-emsg").G();
            trackGroupArr[i2] = new TrackGroup(eventStream.a() + ":" + i3, G);
            trackGroupInfoArr[i2] = TrackGroupInfo.c(i3);
            i3++;
            i2++;
        }
    }

    private static int t(DrmSessionManager drmSessionManager, List<AdaptationSet> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        String str;
        int i3;
        int i4;
        List<AdaptationSet> list2 = list;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int[] iArr2 = iArr[i6];
            ArrayList arrayList = new ArrayList();
            for (int i8 : iArr2) {
                arrayList.addAll(list2.get(i8).f26270c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i9 = 0; i9 < size; i9++) {
                Format format = ((Representation) arrayList.get(i9)).f26328b;
                formatArr2[i9] = format.c(drmSessionManager.a(format));
            }
            DrmSessionManager drmSessionManager2 = drmSessionManager;
            AdaptationSet adaptationSet = list2.get(iArr2[0]);
            int i10 = adaptationSet.f26268a;
            if (i10 != -1) {
                str = Integer.toString(i10);
            } else {
                str = "unset:" + i6;
            }
            int i11 = i7 + 1;
            if (zArr[i6]) {
                i3 = i11 + 1;
            } else {
                i3 = i11;
                i11 = -1;
            }
            if (formatArr[i6].length != 0) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
                i3 = -1;
            }
            trackGroupArr[i7] = new TrackGroup(str, formatArr2);
            trackGroupInfoArr[i7] = TrackGroupInfo.d(adaptationSet.f26269b, iArr2, i7, i11, i3);
            if (i11 != -1) {
                String str2 = str + ":emsg";
                trackGroupArr[i11] = new TrackGroup(str2, new Format.Builder().U(str2).g0("application/x-emsg").G());
                trackGroupInfoArr[i11] = TrackGroupInfo.b(iArr2, i7);
            }
            if (i3 != -1) {
                trackGroupArr[i3] = new TrackGroup(str + ":cc", formatArr[i6]);
                trackGroupInfoArr[i3] = TrackGroupInfo.a(iArr2, i7);
            }
            i6++;
            i7 = i4;
        }
        return i7;
    }

    private ChunkSampleStream<DashChunkSource> u(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j2) {
        boolean z2;
        int i2;
        TrackGroup trackGroup;
        boolean z3;
        TrackGroup trackGroup2;
        int i3;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        int i4 = trackGroupInfo2.f26171f;
        if (i4 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z2) {
            trackGroup = this.f26151k.b(i4);
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        int i5 = trackGroupInfo2.f26172g;
        if (i5 != -1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            trackGroup2 = this.f26151k.b(i5);
            i2 += trackGroup2.f26002b;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i2];
        int[] iArr = new int[i2];
        if (z2) {
            formatArr[0] = trackGroup.c(0);
            iArr[0] = 5;
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            for (int i6 = 0; i6 < trackGroup2.f26002b; i6++) {
                Format c2 = trackGroup2.c(i6);
                formatArr[i3] = c2;
                iArr[i3] = 3;
                arrayList.add(c2);
                i3++;
            }
        }
        if (this.f26163w.f26281d && z2) {
            playerTrackEmsgHandler = this.f26154n.k();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.f26167b, iArr, formatArr, this.f26143c.a(this.f26149i, this.f26163w, this.f26147g, this.f26164x, trackGroupInfo2.f26166a, exoTrackSelection, trackGroupInfo2.f26167b, this.f26148h, z2, arrayList, playerTrackEmsgHandler2, this.f26144d, this.f26158r), this, this.f26150j, j2, this.f26145e, this.f26157q, this.f26146f, this.f26156p);
        synchronized (this) {
            this.f26155o.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> v(DrmSessionManager drmSessionManager, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] A2 = A(list);
        int length = A2.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int E = E(length, list, A2, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[E];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[E];
        q(list2, trackGroupArr, trackGroupInfoArr, t(drmSessionManager, list, A2, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static Descriptor w(List<Descriptor> list) {
        return x(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static Descriptor x(List<Descriptor> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (str.equals(descriptor.f26305a)) {
                return descriptor;
            }
        }
        return null;
    }

    private static Descriptor y(List<Descriptor> list) {
        return x(list, "http://dashif.org/guidelines/trickmode");
    }

    private static Format[] z(List<AdaptationSet> list, int[] iArr) {
        for (int i2 : iArr) {
            AdaptationSet adaptationSet = list.get(i2);
            List<Descriptor> list2 = list.get(i2).f26271d;
            int i3 = 0;
            while (i3 < list2.size()) {
                Descriptor descriptor = list2.get(i3);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f26305a)) {
                    return H(descriptor, f26141z, new Format.Builder().g0("application/cea-608").U(adaptationSet.f26268a + ":cea608").G());
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f26305a)) {
                    return H(descriptor, A, new Format.Builder().g0("application/cea-708").U(adaptationSet.f26268a + ":cea708").G());
                } else {
                    i3++;
                }
            }
        }
        return new Format[0];
    }

    /* renamed from: G */
    public void d(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.f26159s.d(this);
    }

    public void I() {
        this.f26154n.o();
        for (ChunkSampleStream<DashChunkSource> P : this.f26160t) {
            P.P(this);
        }
        this.f26159s = null;
    }

    public void M(DashManifest dashManifest, int i2) {
        this.f26163w = dashManifest;
        this.f26164x = i2;
        this.f26154n.q(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.f26160t;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> D : chunkSampleStreamArr) {
                D.D().i(dashManifest, i2);
            }
            this.f26159s.d(this);
        }
        this.f26165y = dashManifest.d(i2).f26316d;
        for (EventSampleStream eventSampleStream : this.f26161u) {
            Iterator<EventStream> it2 = this.f26165y.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                EventStream next = it2.next();
                if (next.a().equals(eventSampleStream.b())) {
                    boolean z2 = true;
                    int e2 = dashManifest.e() - 1;
                    if (!dashManifest.f26281d || i2 != e2) {
                        z2 = false;
                    }
                    eventSampleStream.e(next, z2);
                }
            }
        }
    }

    public long b() {
        return this.f26162v.b();
    }

    public boolean c() {
        return this.f26162v.c();
    }

    public long e() {
        return this.f26162v.e();
    }

    public void f(long j2) {
        this.f26162v.f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f26160t) {
            if (chunkSampleStream.f26089b == 2) {
                return chunkSampleStream.g(j2, seekParameters);
            }
        }
        return j2;
    }

    public boolean h(long j2) {
        return this.f26162v.h(j2);
    }

    public long i(long j2) {
        for (ChunkSampleStream<DashChunkSource> R : this.f26160t) {
            R.R(j2);
        }
        for (EventSampleStream c2 : this.f26161u) {
            c2.c(j2);
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() throws IOException {
        this.f26149i.a();
    }

    public synchronized void m(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.f26155o.remove(chunkSampleStream);
        if (remove != null) {
            remove.n();
        }
    }

    public TrackGroupArray n() {
        return this.f26151k;
    }

    public void o(long j2, boolean z2) {
        for (ChunkSampleStream<DashChunkSource> o2 : this.f26160t) {
            o2.o(j2, z2);
        }
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f26159s = callback;
        callback.p(this);
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        int[] C = C(exoTrackSelectionArr);
        J(exoTrackSelectionArr, zArr, sampleStreamArr);
        K(exoTrackSelectionArr, sampleStreamArr, C);
        L(exoTrackSelectionArr, sampleStreamArr, zArr2, j2, C);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChunkSampleStream chunkSampleStream : sampleStreamArr) {
            if (chunkSampleStream instanceof ChunkSampleStream) {
                arrayList.add(chunkSampleStream);
            } else if (chunkSampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) chunkSampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] F = F(arrayList.size());
        this.f26160t = F;
        arrayList.toArray(F);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.f26161u = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.f26162v = this.f26153m.a(this.f26160t);
        return j2;
    }
}

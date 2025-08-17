package androidx.media3.exoplayer.dash;

import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.Descriptor;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class DashMediaPeriod implements MediaPeriod, SequenceableLoader.Callback<ChunkSampleStream<DashChunkSource>>, ChunkSampleStream.ReleaseCallback<DashChunkSource> {
    private static final Pattern A = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: z  reason: collision with root package name */
    private static final Pattern f5907z = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: b  reason: collision with root package name */
    final int f5908b;

    /* renamed from: c  reason: collision with root package name */
    private final DashChunkSource.Factory f5909c;

    /* renamed from: d  reason: collision with root package name */
    private final TransferListener f5910d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionManager f5911e;

    /* renamed from: f  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f5912f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseUrlExclusionList f5913g;

    /* renamed from: h  reason: collision with root package name */
    private final long f5914h;

    /* renamed from: i  reason: collision with root package name */
    private final LoaderErrorThrower f5915i;

    /* renamed from: j  reason: collision with root package name */
    private final Allocator f5916j;

    /* renamed from: k  reason: collision with root package name */
    private final TrackGroupArray f5917k;

    /* renamed from: l  reason: collision with root package name */
    private final TrackGroupInfo[] f5918l;

    /* renamed from: m  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f5919m;

    /* renamed from: n  reason: collision with root package name */
    private final PlayerEmsgHandler f5920n;

    /* renamed from: o  reason: collision with root package name */
    private final IdentityHashMap<ChunkSampleStream<DashChunkSource>, PlayerEmsgHandler.PlayerTrackEmsgHandler> f5921o = new IdentityHashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private final MediaSourceEventListener.EventDispatcher f5922p;

    /* renamed from: q  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f5923q;

    /* renamed from: r  reason: collision with root package name */
    private final PlayerId f5924r;

    /* renamed from: s  reason: collision with root package name */
    private MediaPeriod.Callback f5925s;

    /* renamed from: t  reason: collision with root package name */
    private ChunkSampleStream<DashChunkSource>[] f5926t = I(0);

    /* renamed from: u  reason: collision with root package name */
    private EventSampleStream[] f5927u = new EventSampleStream[0];

    /* renamed from: v  reason: collision with root package name */
    private SequenceableLoader f5928v;

    /* renamed from: w  reason: collision with root package name */
    private DashManifest f5929w;

    /* renamed from: x  reason: collision with root package name */
    private int f5930x;

    /* renamed from: y  reason: collision with root package name */
    private List<EventStream> f5931y;

    private static final class TrackGroupInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f5932a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5933b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5934c;

        /* renamed from: d  reason: collision with root package name */
        public final int f5935d;

        /* renamed from: e  reason: collision with root package name */
        public final int f5936e;

        /* renamed from: f  reason: collision with root package name */
        public final int f5937f;

        /* renamed from: g  reason: collision with root package name */
        public final int f5938g;

        /* renamed from: h  reason: collision with root package name */
        public final ImmutableList<Format> f5939h;

        private TrackGroupInfo(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, ImmutableList<Format> immutableList) {
            this.f5933b = i2;
            this.f5932a = iArr;
            this.f5934c = i3;
            this.f5936e = i4;
            this.f5937f = i5;
            this.f5938g = i6;
            this.f5935d = i7;
            this.f5939h = immutableList;
        }

        public static TrackGroupInfo a(int[] iArr, int i2, ImmutableList<Format> immutableList) {
            return new TrackGroupInfo(3, 1, iArr, i2, -1, -1, -1, immutableList);
        }

        public static TrackGroupInfo b(int[] iArr, int i2) {
            return new TrackGroupInfo(5, 1, iArr, i2, -1, -1, -1, ImmutableList.r());
        }

        public static TrackGroupInfo c(int i2) {
            return new TrackGroupInfo(5, 2, new int[0], -1, -1, -1, i2, ImmutableList.r());
        }

        public static TrackGroupInfo d(int i2, int[] iArr, int i3, int i4, int i5) {
            return new TrackGroupInfo(i2, 0, iArr, i3, i4, i5, -1, ImmutableList.r());
        }
    }

    public DashMediaPeriod(int i2, DashManifest dashManifest, BaseUrlExclusionList baseUrlExclusionList, int i3, DashChunkSource.Factory factory, TransferListener transferListener, CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher, LoadErrorHandlingPolicy loadErrorHandlingPolicy, MediaSourceEventListener.EventDispatcher eventDispatcher2, long j2, LoaderErrorThrower loaderErrorThrower, Allocator allocator, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, PlayerEmsgHandler.PlayerEmsgCallback playerEmsgCallback, PlayerId playerId) {
        DrmSessionManager drmSessionManager2 = drmSessionManager;
        Allocator allocator2 = allocator;
        this.f5908b = i2;
        this.f5929w = dashManifest;
        this.f5913g = baseUrlExclusionList;
        this.f5930x = i3;
        this.f5909c = factory;
        this.f5910d = transferListener;
        this.f5911e = drmSessionManager2;
        this.f5923q = eventDispatcher;
        this.f5912f = loadErrorHandlingPolicy;
        this.f5922p = eventDispatcher2;
        this.f5914h = j2;
        this.f5915i = loaderErrorThrower;
        this.f5916j = allocator2;
        this.f5919m = compositeSequenceableLoaderFactory;
        this.f5924r = playerId;
        this.f5920n = new PlayerEmsgHandler(dashManifest, playerEmsgCallback, allocator2);
        this.f5928v = compositeSequenceableLoaderFactory.empty();
        Period d2 = dashManifest.d(i3);
        List<EventStream> list = d2.f6087d;
        this.f5931y = list;
        Pair<TrackGroupArray, TrackGroupInfo[]> w2 = w(drmSessionManager2, factory, d2.f6086c, list);
        this.f5917k = (TrackGroupArray) w2.first;
        this.f5918l = (TrackGroupInfo[]) w2.second;
    }

    private static Format[] A(List<AdaptationSet> list, int[] iArr) {
        for (int i2 : iArr) {
            AdaptationSet adaptationSet = list.get(i2);
            List<Descriptor> list2 = list.get(i2).f6042d;
            int i3 = 0;
            while (i3 < list2.size()) {
                Descriptor descriptor = list2.get(i3);
                if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f6076a)) {
                    return K(descriptor, f5907z, new Format.Builder().o0("application/cea-608").a0(adaptationSet.f6039a + ":cea608").K());
                } else if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f6076a)) {
                    return K(descriptor, A, new Format.Builder().o0("application/cea-708").a0(adaptationSet.f6039a + ":cea708").K());
                } else {
                    i3++;
                }
            }
        }
        return new Format[0];
    }

    private static int[][] B(List<AdaptationSet> list) {
        int i2;
        Descriptor x2;
        Integer num;
        int size = list.size();
        HashMap g2 = Maps.g(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i3 = 0; i3 < size; i3++) {
            g2.put(Long.valueOf(list.get(i3).f6039a), Integer.valueOf(i3));
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i3));
            arrayList.add(arrayList2);
            sparseArray.put(i3, arrayList2);
        }
        for (int i4 = 0; i4 < size; i4++) {
            AdaptationSet adaptationSet = list.get(i4);
            Descriptor z2 = z(adaptationSet.f6043e);
            if (z2 == null) {
                z2 = z(adaptationSet.f6044f);
            }
            if (z2 == null || (num = (Integer) g2.get(Long.valueOf(Long.parseLong(z2.f6077b)))) == null) {
                i2 = i4;
            } else {
                i2 = num.intValue();
            }
            if (i2 == i4 && (x2 = x(adaptationSet.f6044f)) != null) {
                for (String parseLong : Util.k1(x2.f6077b, ",")) {
                    Integer num2 = (Integer) g2.get(Long.valueOf(Long.parseLong(parseLong)));
                    if (num2 != null) {
                        i2 = Math.min(i2, num2.intValue());
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
        for (int i5 = 0; i5 < size2; i5++) {
            int[] n2 = Ints.n((Collection) arrayList.get(i5));
            iArr[i5] = n2;
            Arrays.sort(n2);
        }
        return iArr;
    }

    private int C(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.f5918l[i3].f5936e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.f5918l[i6].f5934c == 0) {
                return i5;
            }
        }
        return -1;
    }

    private int[] D(ExoTrackSelection[] exoTrackSelectionArr) {
        int[] iArr = new int[exoTrackSelectionArr.length];
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                iArr[i2] = this.f5917k.d(exoTrackSelection.h());
            } else {
                iArr[i2] = -1;
            }
        }
        return iArr;
    }

    private static boolean E(List<AdaptationSet> list, int[] iArr) {
        for (int i2 : iArr) {
            List<Representation> list2 = list.get(i2).f6041c;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (!list2.get(i3).f6102e.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int F(int i2, List<AdaptationSet> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (E(list, iArr[i4])) {
                zArr[i4] = true;
                i3++;
            }
            Format[] A2 = A(list, iArr[i4]);
            formatArr[i4] = A2;
            if (A2.length != 0) {
                i3++;
            }
        }
        return i3;
    }

    private static void H(DashChunkSource.Factory factory, Format[] formatArr) {
        for (int i2 = 0; i2 < formatArr.length; i2++) {
            formatArr[i2] = factory.c(formatArr[i2]);
        }
    }

    private static ChunkSampleStream<DashChunkSource>[] I(int i2) {
        return new ChunkSampleStream[i2];
    }

    private static Format[] K(Descriptor descriptor, Pattern pattern, Format format) {
        String str = descriptor.f6077b;
        if (str == null) {
            return new Format[]{format};
        }
        String[] k12 = Util.k1(str, ";");
        Format[] formatArr = new Format[k12.length];
        for (int i2 = 0; i2 < k12.length; i2++) {
            Matcher matcher = pattern.matcher(k12[i2]);
            if (!matcher.matches()) {
                return new Format[]{format};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            Format.Builder a2 = format.a();
            formatArr[i2] = a2.a0(format.f4002a + ":" + parseInt).L(parseInt).e0(matcher.group(2)).K();
        }
        return formatArr;
    }

    private void M(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            if (exoTrackSelectionArr[i2] == null || !zArr[i2]) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream instanceof ChunkSampleStream) {
                    chunkSampleStream.O(this);
                } else if (chunkSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) {
                    ((ChunkSampleStream.EmbeddedSampleStream) chunkSampleStream).c();
                }
                sampleStreamArr[i2] = null;
            }
        }
    }

    private void N(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, int[] iArr) {
        boolean z2;
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            SampleStream sampleStream = sampleStreamArr[i2];
            if ((sampleStream instanceof EmptySampleStream) || (sampleStream instanceof ChunkSampleStream.EmbeddedSampleStream)) {
                int C = C(i2, iArr);
                if (C == -1) {
                    z2 = sampleStreamArr[i2] instanceof EmptySampleStream;
                } else {
                    ChunkSampleStream.EmbeddedSampleStream embeddedSampleStream = sampleStreamArr[i2];
                    if (!(embeddedSampleStream instanceof ChunkSampleStream.EmbeddedSampleStream) || embeddedSampleStream.f7251b != sampleStreamArr[C]) {
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

    private void O(ExoTrackSelection[] exoTrackSelectionArr, SampleStream[] sampleStreamArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i2 = 0; i2 < exoTrackSelectionArr.length; i2++) {
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr[i2];
            if (exoTrackSelection != null) {
                ChunkSampleStream chunkSampleStream = sampleStreamArr[i2];
                if (chunkSampleStream == null) {
                    zArr[i2] = true;
                    TrackGroupInfo trackGroupInfo = this.f5918l[iArr[i2]];
                    int i3 = trackGroupInfo.f5934c;
                    if (i3 == 0) {
                        sampleStreamArr[i2] = v(trackGroupInfo, exoTrackSelection, j2);
                    } else if (i3 == 2) {
                        sampleStreamArr[i2] = new EventSampleStream(this.f5931y.get(trackGroupInfo.f5935d), exoTrackSelection.h().a(0), this.f5929w.f6052d);
                    }
                } else if (chunkSampleStream instanceof ChunkSampleStream) {
                    ((DashChunkSource) chunkSampleStream.D()).i(exoTrackSelection);
                }
            }
        }
        for (int i4 = 0; i4 < exoTrackSelectionArr.length; i4++) {
            if (sampleStreamArr[i4] == null && exoTrackSelectionArr[i4] != null) {
                TrackGroupInfo trackGroupInfo2 = this.f5918l[iArr[i4]];
                if (trackGroupInfo2.f5934c == 1) {
                    int C = C(i4, iArr);
                    if (C == -1) {
                        sampleStreamArr[i4] = new EmptySampleStream();
                    } else {
                        sampleStreamArr[i4] = sampleStreamArr[C].R(j2, trackGroupInfo2.f5933b);
                    }
                }
            }
        }
    }

    private static void t(List<EventStream> list, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr, int i2) {
        int i3 = 0;
        while (i3 < list.size()) {
            EventStream eventStream = list.get(i3);
            Format K = new Format.Builder().a0(eventStream.a()).o0("application/x-emsg").K();
            trackGroupArr[i2] = new TrackGroup(eventStream.a() + ":" + i3, K);
            trackGroupInfoArr[i2] = TrackGroupInfo.c(i3);
            i3++;
            i2++;
        }
    }

    private static int u(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, TrackGroupInfo[] trackGroupInfoArr) {
        String str;
        int i3;
        int i4;
        DashChunkSource.Factory factory2 = factory;
        List<AdaptationSet> list2 = list;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int[] iArr2 = iArr[i6];
            ArrayList arrayList = new ArrayList();
            for (int i8 : iArr2) {
                arrayList.addAll(list2.get(i8).f6041c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i9 = 0; i9 < size; i9++) {
                Format format = ((Representation) arrayList.get(i9)).f6099b;
                formatArr2[i9] = format.a().R(drmSessionManager.c(format)).K();
            }
            DrmSessionManager drmSessionManager2 = drmSessionManager;
            AdaptationSet adaptationSet = list2.get(iArr2[0]);
            long j2 = adaptationSet.f6039a;
            if (j2 != -1) {
                str = Long.toString(j2);
            } else {
                str = "unset:" + i6;
            }
            int i10 = i7 + 1;
            if (zArr[i6]) {
                i3 = i10 + 1;
            } else {
                i3 = i10;
                i10 = -1;
            }
            if (formatArr[i6].length != 0) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
                i3 = -1;
            }
            H(factory2, formatArr2);
            trackGroupArr[i7] = new TrackGroup(str, formatArr2);
            trackGroupInfoArr[i7] = TrackGroupInfo.d(adaptationSet.f6040b, iArr2, i7, i10, i3);
            if (i10 != -1) {
                String str2 = str + ":emsg";
                trackGroupArr[i10] = new TrackGroup(str2, new Format.Builder().a0(str2).o0("application/x-emsg").K());
                trackGroupInfoArr[i10] = TrackGroupInfo.b(iArr2, i7);
            }
            if (i3 != -1) {
                trackGroupInfoArr[i3] = TrackGroupInfo.a(iArr2, i7, ImmutableList.o(formatArr[i6]));
                H(factory2, formatArr[i6]);
                trackGroupArr[i3] = new TrackGroup(str + ":cc", formatArr[i6]);
            }
            i6++;
            i7 = i4;
        }
        return i7;
    }

    private ChunkSampleStream<DashChunkSource> v(TrackGroupInfo trackGroupInfo, ExoTrackSelection exoTrackSelection, long j2) {
        boolean z2;
        int i2;
        TrackGroup trackGroup;
        ImmutableList<Format> immutableList;
        int i3;
        TrackGroupInfo trackGroupInfo2 = trackGroupInfo;
        int i4 = trackGroupInfo2.f5937f;
        if (i4 != -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = null;
        if (z2) {
            trackGroup = this.f5917k.b(i4);
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        int i5 = trackGroupInfo2.f5938g;
        if (i5 != -1) {
            immutableList = this.f5918l[i5].f5939h;
        } else {
            immutableList = ImmutableList.r();
        }
        int size = i2 + immutableList.size();
        Format[] formatArr = new Format[size];
        int[] iArr = new int[size];
        if (z2) {
            formatArr[0] = trackGroup.a(0);
            iArr[0] = 5;
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < immutableList.size(); i6++) {
            Format format = immutableList.get(i6);
            formatArr[i3] = format;
            iArr[i3] = 3;
            arrayList.add(format);
            i3++;
        }
        if (this.f5929w.f6052d && z2) {
            playerTrackEmsgHandler = this.f5920n.k();
        }
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler2 = playerTrackEmsgHandler;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler3 = playerTrackEmsgHandler2;
        ChunkSampleStream chunkSampleStream = new ChunkSampleStream(trackGroupInfo2.f5933b, iArr, formatArr, this.f5909c.d(this.f5915i, this.f5929w, this.f5913g, this.f5930x, trackGroupInfo2.f5932a, exoTrackSelection, trackGroupInfo2.f5933b, this.f5914h, z2, arrayList, playerTrackEmsgHandler2, this.f5910d, this.f5924r, (CmcdConfiguration) null), this, this.f5916j, j2, this.f5911e, this.f5923q, this.f5912f, this.f5922p);
        synchronized (this) {
            this.f5921o.put(chunkSampleStream, playerTrackEmsgHandler3);
        }
        return chunkSampleStream;
    }

    private static Pair<TrackGroupArray, TrackGroupInfo[]> w(DrmSessionManager drmSessionManager, DashChunkSource.Factory factory, List<AdaptationSet> list, List<EventStream> list2) {
        int[][] B = B(list);
        int length = B.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int F = F(length, list, B, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[F];
        TrackGroupInfo[] trackGroupInfoArr = new TrackGroupInfo[F];
        t(list2, trackGroupArr, trackGroupInfoArr, u(drmSessionManager, factory, list, B, length, zArr, formatArr, trackGroupArr, trackGroupInfoArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), trackGroupInfoArr);
    }

    private static Descriptor x(List<Descriptor> list) {
        return y(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static Descriptor y(List<Descriptor> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (str.equals(descriptor.f6076a)) {
                return descriptor;
            }
        }
        return null;
    }

    private static Descriptor z(List<Descriptor> list) {
        return y(list, "http://dashif.org/guidelines/trickmode");
    }

    /* renamed from: J */
    public void p(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        this.f5925s.p(this);
    }

    public void L() {
        this.f5920n.o();
        for (ChunkSampleStream<DashChunkSource> O : this.f5926t) {
            O.O(this);
        }
        this.f5925s = null;
    }

    public void P(DashManifest dashManifest, int i2) {
        this.f5929w = dashManifest;
        this.f5930x = i2;
        this.f5920n.q(dashManifest);
        ChunkSampleStream<DashChunkSource>[] chunkSampleStreamArr = this.f5926t;
        if (chunkSampleStreamArr != null) {
            for (ChunkSampleStream<DashChunkSource> D : chunkSampleStreamArr) {
                D.D().b(dashManifest, i2);
            }
            this.f5925s.p(this);
        }
        this.f5931y = dashManifest.d(i2).f6087d;
        for (EventSampleStream eventSampleStream : this.f5927u) {
            Iterator<EventStream> it2 = this.f5931y.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                EventStream next = it2.next();
                if (next.a().equals(eventSampleStream.b())) {
                    boolean z2 = true;
                    int e2 = dashManifest.e() - 1;
                    if (!dashManifest.f6052d || i2 != e2) {
                        z2 = false;
                    }
                    eventSampleStream.e(next, z2);
                }
            }
        }
    }

    public long b() {
        return this.f5928v.b();
    }

    public boolean c() {
        return this.f5928v.c();
    }

    public synchronized void d(ChunkSampleStream<DashChunkSource> chunkSampleStream) {
        PlayerEmsgHandler.PlayerTrackEmsgHandler remove = this.f5921o.remove(chunkSampleStream);
        if (remove != null) {
            remove.n();
        }
    }

    public long e() {
        return this.f5928v.e();
    }

    public void f(long j2) {
        this.f5928v.f(j2);
    }

    public boolean g(LoadingInfo loadingInfo) {
        return this.f5928v.g(loadingInfo);
    }

    public long h(long j2, SeekParameters seekParameters) {
        for (ChunkSampleStream<DashChunkSource> chunkSampleStream : this.f5926t) {
            if (chunkSampleStream.f7228b == 2) {
                return chunkSampleStream.h(j2, seekParameters);
            }
        }
        return j2;
    }

    public long i(long j2) {
        for (ChunkSampleStream<DashChunkSource> Q : this.f5926t) {
            Q.Q(j2);
        }
        for (EventSampleStream c2 : this.f5927u) {
            c2.c(j2);
        }
        return j2;
    }

    public long j() {
        return -9223372036854775807L;
    }

    public void l() throws IOException {
        this.f5915i.a();
    }

    public TrackGroupArray n() {
        return this.f5917k;
    }

    public void o(long j2, boolean z2) {
        for (ChunkSampleStream<DashChunkSource> o2 : this.f5926t) {
            o2.o(j2, z2);
        }
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        int[] D = D(exoTrackSelectionArr);
        M(exoTrackSelectionArr, zArr, sampleStreamArr);
        N(exoTrackSelectionArr, sampleStreamArr, D);
        O(exoTrackSelectionArr, sampleStreamArr, zArr2, j2, D);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ChunkSampleStream chunkSampleStream : sampleStreamArr) {
            if (chunkSampleStream instanceof ChunkSampleStream) {
                arrayList.add(chunkSampleStream);
            } else if (chunkSampleStream instanceof EventSampleStream) {
                arrayList2.add((EventSampleStream) chunkSampleStream);
            }
        }
        ChunkSampleStream<DashChunkSource>[] I = I(arrayList.size());
        this.f5926t = I;
        arrayList.toArray(I);
        EventSampleStream[] eventSampleStreamArr = new EventSampleStream[arrayList2.size()];
        this.f5927u = eventSampleStreamArr;
        arrayList2.toArray(eventSampleStreamArr);
        this.f5928v = this.f5919m.a(arrayList, Lists.l(arrayList, new b()));
        return j2;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f5925s = callback;
        callback.m(this);
    }
}
